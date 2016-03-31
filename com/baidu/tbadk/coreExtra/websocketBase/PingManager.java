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
    private static PingManager arr = null;
    private long ars = 0;
    private int art = 180000;
    private int aru = 900000;
    private int arv = this.aru;
    private PingMessage arw = null;
    private int arx = 0;

    public static PingManager Cm() {
        if (arr == null) {
            synchronized (PingManager.class) {
                if (arr == null) {
                    arr = new PingManager();
                }
            }
        }
        return arr;
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
        if ((z || System.currentTimeMillis() - this.ars >= 180000) && BdSocketLinkService.isOpen()) {
            this.ars = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.arw);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.arw, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.arv == this.aru ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.arv);
        this.ars = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.i(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
        this.arw = new PingMessage();
        Cn();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.j.Rc, "costtime:" + String.valueOf(System.currentTimeMillis() - this.ars));
                b(true, 0);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.arw.getCmd(), this.arw.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.ars));
            b(false, error);
        }
    }

    private void b(boolean z, int i) {
        if (this.arx <= 10) {
            this.arx++;
            if (aa.GU().GV()) {
                com.baidu.adp.lib.stats.d as = com.baidu.adp.lib.stats.a.hz().as("pfmonitor");
                as.r("action", "ping");
                as.r("nettype", aa.GU().getNetType());
                as.r("ct", String.valueOf(System.currentTimeMillis() - this.ars));
                as.r("issuccess", z ? "1" : "0");
                as.r("errcode", String.valueOf(i));
                as.r("isbkgroud", this.arv == this.aru ? "1" : "0");
                com.baidu.adp.lib.stats.a.hz().a("ping", as);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.arv = this.aru;
                return;
            }
            this.arv = this.art;
            G("switchToForeground");
        }
    }

    public void Cn() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m411getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.art = socketHeartBeatStratgy[0] * 1000;
            this.aru = socketHeartBeatStratgy[1] * 1000;
            if (this.art < 180000) {
                this.art = 180000;
            }
            if (this.aru < 180000) {
                this.aru = 180000;
            }
        }
    }

    public int Co() {
        return this.art;
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
