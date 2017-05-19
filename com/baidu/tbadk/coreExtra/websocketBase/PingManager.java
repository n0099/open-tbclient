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
    private static PingManager awM = null;
    private long awN = 0;
    private int awO = 180000;
    private int awP = 900000;
    private int awQ = this.awP;
    private PingMessage awR = null;
    private int awS = 0;

    public static PingManager Bw() {
        if (awM == null) {
            synchronized (PingManager.class) {
                if (awM == null) {
                    awM = new PingManager();
                }
            }
        }
        return awM;
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
        if ((z || System.currentTimeMillis() - this.awN >= 180000) && BdSocketLinkService.isOpen()) {
            this.awN = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.awR);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.awR, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.awQ == this.awP ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.awQ);
        this.awN = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.n(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.o(false);
        MessageManager.getInstance().registerTask(bVar);
        this.awR = new PingMessage();
        Bx();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.o.Sg, "costtime:" + String.valueOf(System.currentTimeMillis() - this.awN));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.awR.getCmd(), this.awR.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.awN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.awQ = this.awP;
                return;
            }
            this.awQ = this.awO;
            u("switchToForeground");
        }
    }

    public void Bx() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m9getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.awO = socketHeartBeatStratgy[0] * 1000;
            this.awP = socketHeartBeatStratgy[1] * 1000;
            if (this.awO < 180000) {
                this.awO = 180000;
            }
            if (this.awP < 180000) {
                this.awP = 180000;
            }
        }
    }

    public int By() {
        return this.awO;
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
