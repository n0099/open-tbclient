package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
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
    private static e cpI = null;
    private long cpJ = 0;
    private int cpK = 180000;
    private int cpL = 900000;
    private int cpM = this.cpL;
    private PingMessage cpN = null;

    public static e arc() {
        if (cpI == null) {
            synchronized (e.class) {
                if (cpI == null) {
                    cpI = new e();
                }
            }
        }
        return cpI;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                fm();
                b(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void R(String str) {
        if (BdSocketLinkService.isClose()) {
            com.baidu.tbadk.lcs.a.c(0, 0, 0, 1, 10);
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            b(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean b(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.cpJ >= 180000) && BdSocketLinkService.isOpen()) {
            this.cpJ = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.cpN);
            com.baidu.adp.framework.client.socket.i.a("PingManager", this.cpN, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.cpM == this.cpL ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void fl() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void fm() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.cpM);
        this.cpJ = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.E(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.F(false);
        MessageManager.getInstance().registerTask(bVar);
        this.cpN = new PingMessage();
        ard();
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tbadk.coreExtra.e.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    e.this.e(socketResponsedMessage);
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
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            int error = responsedMessage.getError();
            if (error == 0) {
                com.baidu.adp.framework.client.socket.i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.g.bDv, "costtime:" + String.valueOf(System.currentTimeMillis() - this.cpJ));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.i.a("PingManager", this.cpN.getCmd(), this.cpN.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.cpJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.cpM = this.cpL;
                return;
            }
            this.cpM = this.cpK;
            R("switchToForeground");
        }
    }

    public void ard() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.cpK = socketHeartBeatStratgy[0] * 1000;
            this.cpL = socketHeartBeatStratgy[1] * 1000;
            if (this.cpK < 180000) {
                this.cpK = 180000;
            }
            if (this.cpL < 180000) {
                this.cpL = 180000;
            }
        }
    }

    public int are() {
        return this.cpK;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int getCmd() {
        return 1003;
    }
}
