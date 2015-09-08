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
    private static PingManager aoi = null;
    private long aoj = 0;
    private int aok = 180000;
    private int aol = 900000;
    private int aom = this.aol;
    private PingMessage aon = null;

    public static PingManager zP() {
        if (aoi == null) {
            synchronized (PingManager.class) {
                if (aoi == null) {
                    aoi = new PingManager();
                }
            }
        }
        return aoi;
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
        if ((z || System.currentTimeMillis() - this.aoj >= 180000) && BdSocketLinkService.isOpen()) {
            this.aoj = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.aon);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.aon.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.aom == this.aol ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.aom);
        this.aoj = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.aon = new PingMessage();
        zQ();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", this.aon.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.k.TC, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.aon.getCmd(), 0, "ping_err", com.baidu.tbadk.core.k.TB, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.aom = this.aol;
                return;
            }
            this.aom = this.aok;
            H("switchToForeground");
        }
    }

    public void zQ() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.aok = socketHeartBeatStratgy[0] * 1000;
            this.aol = socketHeartBeatStratgy[1] * 1000;
            if (this.aok < 180000) {
                this.aok = 180000;
            }
            if (this.aol < 180000) {
                this.aol = 180000;
            }
        }
    }

    public int zR() {
        return this.aok;
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
