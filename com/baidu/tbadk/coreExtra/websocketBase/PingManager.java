package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager bnR = null;
    private long bnS = 0;
    private int bnT = 180000;
    private int bnU = 900000;
    private int bnV = this.bnU;
    private PingMessage bnW = null;

    public static PingManager Jx() {
        if (bnR == null) {
            synchronized (PingManager.class) {
                if (bnR == null) {
                    bnR = new PingManager();
                }
            }
        }
        return bnR;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                jY();
                c(true, "regular time send");
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
            c(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean c(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.bnS >= 180000) && BdSocketLinkService.isOpen()) {
            this.bnS = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.bnW);
            i.a("PingManager", this.bnW, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.bnV == this.bnU ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void jX() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void jY() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.bnV);
        this.bnS = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(PointerIconCompat.TYPE_HELP);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.U(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.V(false);
        MessageManager.getInstance().registerTask(bVar);
        this.bnW = new PingMessage();
        Jy();
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(PointerIconCompat.TYPE_HELP) { // from class: com.baidu.tbadk.coreExtra.websocketBase.PingManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    PingManager.this.c(socketResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.coreExtra.websocketBase.PingManager.2
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
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.aIc, "costtime:" + String.valueOf(System.currentTimeMillis() - this.bnS));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.bnW.getCmd(), this.bnW.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.bnS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.bnV = this.bnU;
                return;
            }
            this.bnV = this.bnT;
            I("switchToForeground");
        }
    }

    public void Jy() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.bnT = socketHeartBeatStratgy[0] * 1000;
            this.bnU = socketHeartBeatStratgy[1] * 1000;
            if (this.bnT < 180000) {
                this.bnT = 180000;
            }
            if (this.bnU < 180000) {
                this.bnU = 180000;
            }
        }
    }

    public int Jz() {
        return this.bnT;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int getCmd() {
        return PointerIconCompat.TYPE_HELP;
    }

    /* loaded from: classes.dex */
    private static class PingResponsedMessage extends SocketResponsedMessage {
        public PingResponsedMessage() {
            super(PointerIconCompat.TYPE_HELP);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}
