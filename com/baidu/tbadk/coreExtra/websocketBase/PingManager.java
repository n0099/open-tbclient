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
    private static PingManager boa = null;
    private long bob = 0;
    private int boc = 180000;
    private int bod = 900000;
    private int boe = this.bod;
    private PingMessage bof = null;

    public static PingManager Jz() {
        if (boa == null) {
            synchronized (PingManager.class) {
                if (boa == null) {
                    boa = new PingManager();
                }
            }
        }
        return boa;
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
        if ((z || System.currentTimeMillis() - this.bob >= 180000) && BdSocketLinkService.isOpen()) {
            this.bob = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.bof);
            i.a("PingManager", this.bof, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.boe == this.bod ? "back" : "fore"));
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
        sendMessageDelayed(obtainMessage(1), this.boe);
        this.bob = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(PointerIconCompat.TYPE_HELP);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.U(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.V(false);
        MessageManager.getInstance().registerTask(bVar);
        this.bof = new PingMessage();
        JA();
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
                i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.aIf, "costtime:" + String.valueOf(System.currentTimeMillis() - this.bob));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            i.a("PingManager", this.bof.getCmd(), this.bof.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.bob));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.boe = this.bod;
                return;
            }
            this.boe = this.boc;
            I("switchToForeground");
        }
    }

    public void JA() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.boc = socketHeartBeatStratgy[0] * 1000;
            this.bod = socketHeartBeatStratgy[1] * 1000;
            if (this.boc < 180000) {
                this.boc = 180000;
            }
            if (this.bod < 180000) {
                this.bod = 180000;
            }
        }
    }

    public int JB() {
        return this.boc;
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
