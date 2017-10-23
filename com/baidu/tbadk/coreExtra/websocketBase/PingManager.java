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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager ayb = null;
    private long ayc = 0;
    private int ayd = 180000;
    private int aye = 900000;
    private int ayf = this.aye;
    private PingMessage ayg = null;
    private int ayh = 0;

    public static PingManager Bv() {
        if (ayb == null) {
            synchronized (PingManager.class) {
                if (ayb == null) {
                    ayb = new PingManager();
                }
            }
        }
        return ayb;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ct();
                c(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void B(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            c(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean c(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.ayc >= 180000) && BdSocketLinkService.isOpen()) {
            this.ayc = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.ayg);
            i.a("PingManager", this.ayg, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.ayf == this.aye ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void cs() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ct() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.ayf);
        this.ayc = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.n(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.o(false);
        MessageManager.getInstance().registerTask(bVar);
        this.ayg = new PingMessage();
        Bw();
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tbadk.coreExtra.websocketBase.PingManager.1
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
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.f.SE, "costtime:" + String.valueOf(System.currentTimeMillis() - this.ayc));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.ayg.getCmd(), this.ayg.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.ayc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.ayf = this.aye;
                return;
            }
            this.ayf = this.ayd;
            B("switchToForeground");
        }
    }

    public void Bw() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.ayd = socketHeartBeatStratgy[0] * 1000;
            this.aye = socketHeartBeatStratgy[1] * 1000;
            if (this.ayd < 180000) {
                this.ayd = 180000;
            }
            if (this.aye < 180000) {
                this.aye = 180000;
            }
        }
    }

    public int Bx() {
        return this.ayd;
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
