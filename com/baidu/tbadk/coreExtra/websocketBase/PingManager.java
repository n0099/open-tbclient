package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager aSH = null;
    private long aSI = 0;
    private int aSJ = 180000;
    private int aSK = 900000;
    private int aSL = this.aSK;
    private PingMessage aSM = null;

    public static PingManager Kc() {
        if (aSH == null) {
            synchronized (PingManager.class) {
                if (aSH == null) {
                    aSH = new PingManager();
                }
            }
        }
        return aSH;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                gq();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ai(String str) {
        if (BdSocketLinkService.isClose()) {
            com.baidu.tbadk.lcs.a.b(0, 0, 0, 1, 10);
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.aSI >= 180000) && BdSocketLinkService.isOpen()) {
            this.aSI = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.aSM);
            i.a("PingManager", this.aSM, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.aSL == this.aSK ? AiAppsUBCStatistic.VALUE_BACK : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void gp() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void gq() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.aSL);
        this.aSI = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.M(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.N(false);
        MessageManager.getInstance().registerTask(bVar);
        this.aSM = new PingMessage();
        Kd();
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tbadk.coreExtra.websocketBase.PingManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    PingManager.this.d(socketResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.coreExtra.websocketBase.PingManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    PingManager.this.a((BackgroundSwitchMessage) customResponsedMessage);
                }
            }
        });
        MessageManager.getInstance().registerListener(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.akA, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aSI));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.aSM.getCmd(), this.aSM.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aSI));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.aSL = this.aSK;
                return;
            }
            this.aSL = this.aSJ;
            ai("switchToForeground");
        }
    }

    public void Kd() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.aSJ = socketHeartBeatStratgy[0] * 1000;
            this.aSK = socketHeartBeatStratgy[1] * 1000;
            if (this.aSJ < 180000) {
                this.aSJ = 180000;
            }
            if (this.aSK < 180000) {
                this.aSK = 180000;
            }
        }
    }

    public int Ke() {
        return this.aSJ;
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
