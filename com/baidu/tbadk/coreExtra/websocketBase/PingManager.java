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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager aIZ = null;
    private long aJa = 0;
    private int aJb = 180000;
    private int aJc = 900000;
    private int aJd = this.aJc;
    private PingMessage aJe = null;

    public static PingManager Gn() {
        if (aIZ == null) {
            synchronized (PingManager.class) {
                if (aIZ == null) {
                    aIZ = new PingManager();
                }
            }
        }
        return aIZ;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                eQ();
                c(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void R(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            c(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean c(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.aJa >= 180000) && BdSocketLinkService.isOpen()) {
            this.aJa = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.aJe);
            i.a("PingManager", this.aJe, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.aJd == this.aJc ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void eP() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void eQ() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.aJd);
        this.aJa = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.q(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.s(false);
        MessageManager.getInstance().registerTask(bVar);
        this.aJe = new PingMessage();
        Go();
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
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.acG, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aJa));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.aJe.getCmd(), this.aJe.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aJa));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.aJd = this.aJc;
                return;
            }
            this.aJd = this.aJb;
            R("switchToForeground");
        }
    }

    public void Go() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.aJb = socketHeartBeatStratgy[0] * 1000;
            this.aJc = socketHeartBeatStratgy[1] * 1000;
            if (this.aJb < 180000) {
                this.aJb = 180000;
            }
            if (this.aJc < 180000) {
                this.aJc = 180000;
            }
        }
    }

    public int Gp() {
        return this.aJb;
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
