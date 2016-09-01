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
    private static PingManager arH = null;
    private long arI = 0;
    private int arJ = 180000;
    private int arK = 900000;
    private int arL = this.arK;
    private PingMessage arM = null;
    private int arN = 0;

    public static PingManager BB() {
        if (arH == null) {
            synchronized (PingManager.class) {
                if (arH == null) {
                    arH = new PingManager();
                }
            }
        }
        return arH;
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
        if ((z || System.currentTimeMillis() - this.arI >= 180000) && BdSocketLinkService.isOpen()) {
            this.arI = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.arM);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.arM, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.arL == this.arK ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.arL);
        this.arI = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.m(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.n(false);
        MessageManager.getInstance().registerTask(bVar);
        this.arM = new PingMessage();
        BC();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.j.Oe, "costtime:" + String.valueOf(System.currentTimeMillis() - this.arI));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.arM.getCmd(), this.arM.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.arI));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.arL = this.arK;
                return;
            }
            this.arL = this.arJ;
            A("switchToForeground");
        }
    }

    public void BC() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m9getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.arJ = socketHeartBeatStratgy[0] * 1000;
            this.arK = socketHeartBeatStratgy[1] * 1000;
            if (this.arJ < 180000) {
                this.arJ = 180000;
            }
            if (this.arK < 180000) {
                this.arK = 180000;
            }
        }
    }

    public int BD() {
        return this.arJ;
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
