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
    private static PingManager bnI = null;
    private long bnJ = 0;
    private int bnK = 180000;
    private int bnL = 900000;
    private int bnM = this.bnL;
    private PingMessage bnN = null;

    public static PingManager JI() {
        if (bnI == null) {
            synchronized (PingManager.class) {
                if (bnI == null) {
                    bnI = new PingManager();
                }
            }
        }
        return bnI;
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
        if ((z || System.currentTimeMillis() - this.bnJ >= 180000) && BdSocketLinkService.isOpen()) {
            this.bnJ = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.bnN);
            i.a("PingManager", this.bnN, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.bnM == this.bnL ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.bnM);
        this.bnJ = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(PointerIconCompat.TYPE_HELP);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.U(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.V(false);
        MessageManager.getInstance().registerTask(bVar);
        this.bnN = new PingMessage();
        JJ();
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
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.aIe, "costtime:" + String.valueOf(System.currentTimeMillis() - this.bnJ));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.bnN.getCmd(), this.bnN.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.bnJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.bnM = this.bnL;
                return;
            }
            this.bnM = this.bnK;
            I("switchToForeground");
        }
    }

    public void JJ() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.bnK = socketHeartBeatStratgy[0] * 1000;
            this.bnL = socketHeartBeatStratgy[1] * 1000;
            if (this.bnK < 180000) {
                this.bnK = 180000;
            }
            if (this.bnL < 180000) {
                this.bnL = 180000;
            }
        }
    }

    public int JK() {
        return this.bnK;
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
