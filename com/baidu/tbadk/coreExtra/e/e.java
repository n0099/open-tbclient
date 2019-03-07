package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import com.baidu.adp.framework.MessageManager;
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
public class e extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static e cgk = null;
    private long cgl = 0;
    private int cgm = 180000;
    private int cgn = 900000;
    private int cgo = this.cgn;
    private PingMessage cgp = null;

    public static e akY() {
        if (cgk == null) {
            synchronized (e.class) {
                if (cgk == null) {
                    cgk = new e();
                }
            }
        }
        return cgk;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                gn();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void ai(String str) {
        if (BdSocketLinkService.isClose()) {
            com.baidu.tbadk.lcs.a.c(0, 0, 0, 1, 10);
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.cgl >= 180000) && BdSocketLinkService.isOpen()) {
            this.cgl = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.cgp);
            com.baidu.adp.framework.client.socket.i.a("PingManager", this.cgp, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.cgo == this.cgn ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void gm() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void gn() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.cgo);
        this.cgl = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(PointerIconCompat.TYPE_HELP);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.M(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.N(false);
        MessageManager.getInstance().registerTask(bVar);
        this.cgp = new PingMessage();
        akZ();
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(PointerIconCompat.TYPE_HELP) { // from class: com.baidu.tbadk.coreExtra.e.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    e.this.d(socketResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.coreExtra.e.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    e.this.a((BackgroundSwitchMessage) customResponsedMessage);
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
                com.baidu.adp.framework.client.socket.i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.bvo, "costtime:" + String.valueOf(System.currentTimeMillis() - this.cgl));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.i.a("PingManager", this.cgp.getCmd(), this.cgp.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.cgl));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.cgo = this.cgn;
                return;
            }
            this.cgo = this.cgm;
            ai("switchToForeground");
        }
    }

    public void akZ() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.cgm = socketHeartBeatStratgy[0] * 1000;
            this.cgn = socketHeartBeatStratgy[1] * 1000;
            if (this.cgm < 180000) {
                this.cgm = 180000;
            }
            if (this.cgn < 180000) {
                this.cgn = 180000;
            }
        }
    }

    public int ala() {
        return this.cgm;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int getCmd() {
        return PointerIconCompat.TYPE_HELP;
    }
}
