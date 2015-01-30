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
    private static PingManager We = null;
    private long Wf = 0;
    private int Wg = 180000;
    private int Wh = 900000;
    private int Wi = this.Wh;
    private PingMessage Wj = null;

    public static PingManager uo() {
        if (We == null) {
            synchronized (PingManager.class) {
                if (We == null) {
                    We = new PingManager();
                }
            }
        }
        return We;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                aw();
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
        if ((z || System.currentTimeMillis() - this.Wf >= 180000) && BdSocketLinkService.isOpen()) {
            this.Wf = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.Wj);
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.Wj.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.Wi == this.Wh ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void av() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void aw() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.Wi);
        this.Wf = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.Wj = new PingMessage();
        up();
        n nVar = new n(this, 1003);
        MessageManager.getInstance().registerListener(new o(this, 2001011));
        MessageManager.getInstance().registerListener(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.m.a("PingManager", this.Wj.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.j.CI, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.Wj.getCmd(), 0, "ping_err", com.baidu.tbadk.core.j.CH, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.Wi = this.Wh;
                return;
            }
            this.Wi = this.Wg;
            x("switchToForeground");
        }
    }

    public void up() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m255getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.Wg = socketHeartBeatStratgy[0] * 1000;
            this.Wh = socketHeartBeatStratgy[1] * 1000;
            if (this.Wg < 180000) {
                this.Wg = 180000;
            }
            if (this.Wh < 180000) {
                this.Wh = 180000;
            }
        }
    }

    public int uq() {
        return this.Wg;
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
