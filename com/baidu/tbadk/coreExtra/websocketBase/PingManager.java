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
import com.baidu.tbadk.performanceLog.aa;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager ara = null;
    private long arb = 0;
    private int arc = 180000;
    private int ard = 900000;
    private int are = this.ard;
    private PingMessage arf = null;
    private int arg = 0;

    public static PingManager BJ() {
        if (ara == null) {
            synchronized (PingManager.class) {
                if (ara == null) {
                    ara = new PingManager();
                }
            }
        }
        return ara;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ea();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void G(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.arb >= 180000) && BdSocketLinkService.isOpen()) {
            this.arb = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.arf);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.arf, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.are == this.ard ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void dZ() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ea() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.are);
        this.arb = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.j(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.k(false);
        MessageManager.getInstance().registerTask(bVar);
        this.arf = new PingMessage();
        BK();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.j.TF, "costtime:" + String.valueOf(System.currentTimeMillis() - this.arb));
                b(true, 0);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.arf.getCmd(), this.arf.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.arb));
            b(false, error);
        }
    }

    private void b(boolean z, int i) {
        if (this.arg <= 10) {
            this.arg++;
            if (aa.FY().FZ()) {
                com.baidu.adp.lib.stats.d aq = com.baidu.adp.lib.stats.a.ht().aq("pfmonitor");
                aq.r("action", "ping");
                aq.r("nettype", aa.FY().getNetType());
                aq.r("ct", String.valueOf(System.currentTimeMillis() - this.arb));
                aq.r("issuccess", z ? "1" : "0");
                aq.r("errcode", String.valueOf(i));
                aq.r("isbkgroud", this.are == this.ard ? "1" : "0");
                com.baidu.adp.lib.stats.a.ht().a("ping", aq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.are = this.ard;
                return;
            }
            this.are = this.arc;
            G("switchToForeground");
        }
    }

    public void BK() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.arc = socketHeartBeatStratgy[0] * 1000;
            this.ard = socketHeartBeatStratgy[1] * 1000;
            if (this.arc < 180000) {
                this.arc = 180000;
            }
            if (this.ard < 180000) {
                this.ard = 180000;
            }
        }
    }

    public int BL() {
        return this.arc;
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
