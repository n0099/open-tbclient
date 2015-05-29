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
    private static PingManager ahq = null;
    private long ahr = 0;
    private int ahs = 180000;
    private int aht = 900000;
    private int ahu = this.aht;
    private PingMessage ahv = null;

    public static PingManager ys() {
        if (ahq == null) {
            synchronized (PingManager.class) {
                if (ahq == null) {
                    ahq = new PingManager();
                }
            }
        }
        return ahq;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                dW();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void I(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.ahr >= 180000) && BdSocketLinkService.isOpen()) {
            this.ahr = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.ahv);
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.ahv.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.ahu == this.aht ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dV() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dW() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.ahu);
        this.ahr = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.ahv = new PingMessage();
        yt();
        n nVar = new n(this, 1003);
        MessageManager.getInstance().registerListener(new o(this, 2001011));
        MessageManager.getInstance().registerListener(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.m.a("PingManager", this.ahv.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.l.OM, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.ahv.getCmd(), 0, "ping_err", com.baidu.tbadk.core.l.OL, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.ahu = this.aht;
                return;
            }
            this.ahu = this.ahs;
            I("switchToForeground");
        }
    }

    public void yt() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.ahs = socketHeartBeatStratgy[0] * 1000;
            this.aht = socketHeartBeatStratgy[1] * 1000;
            if (this.ahs < 180000) {
                this.ahs = 180000;
            }
            if (this.aht < 180000) {
                this.aht = 180000;
            }
        }
    }

    public int yu() {
        return this.ahs;
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
