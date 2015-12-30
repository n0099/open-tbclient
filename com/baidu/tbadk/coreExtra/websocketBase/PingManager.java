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
    private static PingManager aqi = null;
    private long aqj = 0;
    private int aqk = 180000;
    private int aql = 900000;
    private int aqm = this.aql;
    private PingMessage aqn = null;

    public static PingManager At() {
        if (aqi == null) {
            synchronized (PingManager.class) {
                if (aqi == null) {
                    aqi = new PingManager();
                }
            }
        }
        return aqi;
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
        if ((z || System.currentTimeMillis() - this.aqj >= 180000) && BdSocketLinkService.isOpen()) {
            this.aqj = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.aqn);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.aqn.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.aqm == this.aql ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.aqm);
        this.aqj = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.aqn = new PingMessage();
        Au();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", this.aqn.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.k.Uh, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.aqn.getCmd(), 0, "ping_err", com.baidu.tbadk.core.k.Ug, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.aqm = this.aql;
                return;
            }
            this.aqm = this.aqk;
            H("switchToForeground");
        }
    }

    public void Au() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.aqk = socketHeartBeatStratgy[0] * 1000;
            this.aql = socketHeartBeatStratgy[1] * 1000;
            if (this.aqk < 180000) {
                this.aqk = 180000;
            }
            if (this.aql < 180000) {
                this.aql = 180000;
            }
        }
    }

    public int Av() {
        return this.aqk;
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
