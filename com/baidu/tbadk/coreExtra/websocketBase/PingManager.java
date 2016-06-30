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
    private static PingManager anL = null;
    private long anM = 0;
    private int anN = 180000;
    private int anO = 900000;
    private int anP = this.anO;
    private PingMessage anQ = null;
    private int anR = 0;

    public static PingManager Am() {
        if (anL == null) {
            synchronized (PingManager.class) {
                if (anL == null) {
                    anL = new PingManager();
                }
            }
        }
        return anL;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                aq();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void x(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.anM >= 180000) && BdSocketLinkService.isOpen()) {
            this.anM = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.anQ);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.anQ, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.anP == this.anO ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ap() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void aq() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.anP);
        this.anM = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.i(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
        this.anQ = new PingMessage();
        An();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.j.LS, "costtime:" + String.valueOf(System.currentTimeMillis() - this.anM));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.anQ.getCmd(), this.anQ.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.anM));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.anP = this.anO;
                return;
            }
            this.anP = this.anN;
            x("switchToForeground");
        }
    }

    public void An() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m9getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.anN = socketHeartBeatStratgy[0] * 1000;
            this.anO = socketHeartBeatStratgy[1] * 1000;
            if (this.anN < 180000) {
                this.anN = 180000;
            }
            if (this.anO < 180000) {
                this.anO = 180000;
            }
        }
    }

    public int Ao() {
        return this.anN;
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
        public void decodeInBackGround(int i, byte[] bArr) {
        }
    }
}
