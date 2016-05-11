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
    private static PingManager anf = null;
    private long ang = 0;
    private int anh = 180000;
    private int ani = 900000;
    private int anj = this.ani;
    private PingMessage ank = null;
    private int anl = 0;

    public static PingManager Ag() {
        if (anf == null) {
            synchronized (PingManager.class) {
                if (anf == null) {
                    anf = new PingManager();
                }
            }
        }
        return anf;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                aq();
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
        if ((z || System.currentTimeMillis() - this.ang >= 180000) && BdSocketLinkService.isOpen()) {
            this.ang = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.ank);
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.ank, 0, "send_ping", 0, String.valueOf(str) + "-" + (this.anj == this.ani ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ap() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void aq() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.anj);
        this.ang = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.i(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.j(false);
        MessageManager.getInstance().registerTask(bVar);
        this.ank = new PingMessage();
        Ah();
        f fVar = new f(this, 1003);
        MessageManager.getInstance().registerListener(new g(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.k.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.j.LS, "costtime:" + String.valueOf(System.currentTimeMillis() - this.ang));
                b(true, 0);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.k.a("PingManager", this.ank.getCmd(), this.ank.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.ang));
            b(false, error);
        }
    }

    private void b(boolean z, int i) {
        if (this.anl <= 10) {
            this.anl++;
            if (aa.EM().EN()) {
                com.baidu.adp.lib.stats.d al = com.baidu.adp.lib.stats.a.dN().al("pfmonitor");
                al.q("action", "ping");
                al.q("nettype", aa.EM().getNetType());
                al.q("ct", String.valueOf(System.currentTimeMillis() - this.ang));
                al.q("issuccess", z ? "1" : "0");
                al.q("errcode", String.valueOf(i));
                al.q("isbkgroud", this.anj == this.ani ? "1" : "0");
                com.baidu.adp.lib.stats.a.dN().a("ping", al);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.anj = this.ani;
                return;
            }
            this.anj = this.anh;
            x("switchToForeground");
        }
    }

    public void Ah() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.m11getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.anh = socketHeartBeatStratgy[0] * 1000;
            this.ani = socketHeartBeatStratgy[1] * 1000;
            if (this.anh < 180000) {
                this.anh = 180000;
            }
            if (this.ani < 180000) {
                this.ani = 180000;
            }
        }
    }

    public int Ai() {
        return this.anh;
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
