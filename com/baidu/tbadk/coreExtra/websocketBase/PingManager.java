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
    private static PingManager aqU = null;
    private long aqV = 0;
    private int aqW = 180000;
    private int aqX = 900000;
    private int aqY = this.aqX;
    private PingMessage aqZ = null;
    private int ara = 0;

    public static PingManager Bu() {
        if (aqU == null) {
            synchronized (PingManager.class) {
                if (aqU == null) {
                    aqU = new PingManager();
                }
            }
        }
        return aqU;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                bl();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void A(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.aqV >= 180000) && BdSocketLinkService.isOpen()) {
            this.aqV = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.aqZ);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.aqZ, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.aqY == this.aqX ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void bk() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void bl() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.aqY);
        this.aqV = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.m(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.n(false);
        MessageManager.getInstance().registerTask(bVar);
        this.aqZ = new PingMessage();
        Bv();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.j.Np, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aqV));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.aqZ.getCmd(), this.aqZ.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aqV));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.aqY = this.aqX;
                return;
            }
            this.aqY = this.aqW;
            A("switchToForeground");
        }
    }

    public void Bv() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m9getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.aqW = socketHeartBeatStratgy[0] * 1000;
            this.aqX = socketHeartBeatStratgy[1] * 1000;
            if (this.aqW < 180000) {
                this.aqW = 180000;
            }
            if (this.aqX < 180000) {
                this.aqX = 180000;
            }
        }
    }

    public int Bw() {
        return this.aqW;
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
