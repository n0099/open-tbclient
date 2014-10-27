package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager PK = null;
    private long PL = 0;
    private int PM = 180000;
    private int PN = 900000;
    private int PO = this.PN;
    private PingMessage PP = null;

    public static PingManager qC() {
        if (PK == null) {
            synchronized (PingManager.class) {
                if (PK == null) {
                    PK = new PingManager();
                }
            }
        }
        return PK;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                W();
                a(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void h(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            a(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean a(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.PL >= 180000) && BdSocketLinkService.isOpen()) {
            this.PL = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.PP);
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.PP.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.PO == this.PN ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void V() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void W() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.PO);
        this.PL = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.f(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.g(false);
        MessageManager.getInstance().registerTask(bVar);
        this.PP = new PingMessage();
        qD();
        n nVar = new n(this, 1003);
        MessageManager.getInstance().registerListener(new o(this, 2001011));
        MessageManager.getInstance().registerListener(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.m.a("PingManager", this.PP.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.j.yN, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.PP.getCmd(), 0, "ping_err", com.baidu.tbadk.core.j.yM, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.PO = this.PN;
                return;
            }
            this.PO = this.PM;
            h("switchToForeground");
        }
    }

    public void qD() {
        int[] socketHeartBeatStratgy = TbadkApplication.m251getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.PM = socketHeartBeatStratgy[0] * 1000;
            this.PN = socketHeartBeatStratgy[1] * 1000;
            if (this.PM < 180000) {
                this.PM = 180000;
            }
            if (this.PN < 180000) {
                this.PN = 180000;
            }
        }
    }

    public int qE() {
        return this.PM;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int getCmd() {
        return 1003;
    }

    /* loaded from: classes.dex */
    class PingResponsedMessage extends SocketResponsedMessage {
        public PingResponsedMessage() {
            super(1003);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.b
        public void decodeInBackGround(int i, byte[] bArr) {
        }
    }
}
