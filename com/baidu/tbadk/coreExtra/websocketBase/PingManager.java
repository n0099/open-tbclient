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
    private static PingManager amQ = null;
    private long amR = 0;
    private int amS = 180000;
    private int amT = 900000;
    private int amU = this.amT;
    private PingMessage amV = null;

    public static PingManager zG() {
        if (amQ == null) {
            synchronized (PingManager.class) {
                if (amQ == null) {
                    amQ = new PingManager();
                }
            }
        }
        return amQ;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                dX();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void H(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.amR >= 180000) && BdSocketLinkService.isOpen()) {
            this.amR = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.amV);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.amV.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.amU == this.amT ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dW() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dX() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.amU);
        this.amR = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.amV = new PingMessage();
        zH();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", this.amV.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.k.Tq, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.amV.getCmd(), 0, "ping_err", com.baidu.tbadk.core.k.Tp, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.amU = this.amT;
                return;
            }
            this.amU = this.amS;
            H("switchToForeground");
        }
    }

    public void zH() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.amS = socketHeartBeatStratgy[0] * 1000;
            this.amT = socketHeartBeatStratgy[1] * 1000;
            if (this.amS < 180000) {
                this.amS = 180000;
            }
            if (this.amT < 180000) {
                this.amT = 180000;
            }
        }
    }

    public int zI() {
        return this.amS;
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
