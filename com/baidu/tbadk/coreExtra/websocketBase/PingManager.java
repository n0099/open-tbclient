package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager aww = null;
    private long awx = 0;
    private int awy = 180000;
    private int awz = 900000;
    private int awA = this.awz;
    private PingMessage awB = null;
    private int awC = 0;

    public static PingManager Bp() {
        if (aww == null) {
            synchronized (PingManager.class) {
                if (aww == null) {
                    aww = new PingManager();
                }
            }
        }
        return aww;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ct();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void u(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.awx >= 180000) && BdSocketLinkService.isOpen()) {
            this.awx = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.awB);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.awB, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.awA == this.awz ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void cs() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ct() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.awA);
        this.awx = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.n(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.o(false);
        MessageManager.getInstance().registerTask(bVar);
        this.awB = new PingMessage();
        Bq();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.o.RT, "costtime:" + String.valueOf(System.currentTimeMillis() - this.awx));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.awB.getCmd(), this.awB.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.awx));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.awA = this.awz;
                return;
            }
            this.awA = this.awy;
            u("switchToForeground");
        }
    }

    public void Bq() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m9getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.awy = socketHeartBeatStratgy[0] * 1000;
            this.awz = socketHeartBeatStratgy[1] * 1000;
            if (this.awy < 180000) {
                this.awy = 180000;
            }
            if (this.awz < 180000) {
                this.awz = 180000;
            }
        }
    }

    public int Br() {
        return this.awy;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int getCmd() {
        return 1003;
    }

    /* loaded from: classes.dex */
    private static class PingResponsedMessage extends SocketResponsedMessage {
        public PingResponsedMessage() {
            super(1003);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}
