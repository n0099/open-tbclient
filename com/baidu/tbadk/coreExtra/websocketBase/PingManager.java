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
    private static PingManager aKc = null;
    private long aKd = 0;
    private int aKe = 180000;
    private int aKf = 900000;
    private int aKg = this.aKf;
    private PingMessage aKh = null;

    public static PingManager GB() {
        if (aKc == null) {
            synchronized (PingManager.class) {
                if (aKc == null) {
                    aKc = new PingManager();
                }
            }
        }
        return aKc;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                eP();
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
        if ((z || System.currentTimeMillis() - this.aKd >= 180000) && BdSocketLinkService.isOpen()) {
            this.aKd = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.aKh);
            i.a("PingManager", this.aKh, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.aKg == this.aKf ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void eO() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void eP() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.aKg);
        this.aKd = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.o(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.p(false);
        MessageManager.getInstance().registerTask(bVar);
        this.aKh = new PingMessage();
        GC();
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
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.acn, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aKd));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.aKh.getCmd(), this.aKh.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.aKd));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.aKg = this.aKf;
                return;
            }
            this.aKg = this.aKe;
            R("switchToForeground");
        }
    }

    public void GC() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.aKe = socketHeartBeatStratgy[0] * 1000;
            this.aKf = socketHeartBeatStratgy[1] * 1000;
            if (this.aKe < 180000) {
                this.aKe = 180000;
            }
            if (this.aKf < 180000) {
                this.aKf = 180000;
            }
        }
    }

    public int GD() {
        return this.aKe;
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
