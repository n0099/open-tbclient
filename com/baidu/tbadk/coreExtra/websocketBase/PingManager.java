package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager agh = null;
    private long agi = 0;
    private int agj = 180000;
    private int agk = 900000;
    private int agl = this.agk;
    private PingMessage agm = null;

    public static PingManager xz() {
        if (agh == null) {
            synchronized (PingManager.class) {
                if (agh == null) {
                    agh = new PingManager();
                }
            }
        }
        return agh;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                dT();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void F(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.agi >= 180000) && BdSocketLinkService.isOpen()) {
            this.agi = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.agm);
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.agm.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.agl == this.agk ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dS() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dT() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.agl);
        this.agi = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.agm = new PingMessage();
        xA();
        n nVar = new n(this, 1003);
        MessageManager.getInstance().registerListener(new o(this, 2001011));
        MessageManager.getInstance().registerListener(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.m.a("PingManager", this.agm.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.l.Op, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.agm.getCmd(), 0, "ping_err", com.baidu.tbadk.core.l.Oo, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.agl = this.agk;
                return;
            }
            this.agl = this.agj;
            F("switchToForeground");
        }
    }

    public void xA() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.agj = socketHeartBeatStratgy[0] * 1000;
            this.agk = socketHeartBeatStratgy[1] * 1000;
            if (this.agj < 180000) {
                this.agj = 180000;
            }
            if (this.agk < 180000) {
                this.agk = 180000;
            }
        }
    }

    public int xB() {
        return this.agj;
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
