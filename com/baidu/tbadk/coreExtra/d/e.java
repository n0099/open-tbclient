package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class e extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static e fsb = null;
    private long mLastPingTime = 0;
    private int mForegroundInterval = 180000;
    private int mBackgroundInterval = 900000;
    private int mCurrentInterval = this.mBackgroundInterval;
    private PingMessage fsc = null;

    public static e bBo() {
        if (fsb == null) {
            synchronized (e.class) {
                if (fsb == null) {
                    fsb = new e();
                }
            }
        }
        return fsb;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                resetPing();
                sendPing(true, "regular time send");
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void Ping(String str) {
        if (BdSocketLinkService.isClose()) {
            com.baidu.tbadk.lcs.a.d(0, 0, 0, 1, 10);
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            sendPing(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean sendPing(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.mLastPingTime >= 180000) && BdSocketLinkService.isOpen()) {
            this.mLastPingTime = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.fsc);
            com.baidu.adp.framework.client.socket.i.a("PingManager", this.fsc, 0, "send_ping", 0, str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mCurrentInterval == this.mBackgroundInterval ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void stopPing() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void resetPing() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.mCurrentInterval);
        this.mLastPingTime = System.currentTimeMillis();
    }

    public void initial() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.setResponsedClass(ResponsedPingMessage.class);
        bVar.setNeedCompress(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.setCanRetry(false);
        MessageManager.getInstance().registerTask(bVar);
        this.fsc = new PingMessage();
        setInterval();
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(1003) { // from class: com.baidu.tbadk.coreExtra.d.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    e.this.e(socketResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.coreExtra.d.e.2
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
                com.baidu.adp.framework.client.socket.i.a("PingManager", responsedMessage.getOrginalMessage(), 0, "ping_succ", com.baidu.tbadk.core.h.PING_SUCC, "costtime:" + String.valueOf(System.currentTimeMillis() - this.mLastPingTime));
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.i.debug("PingManager", this.fsc.getCmd(), this.fsc.getClientLogID(), 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.mLastPingTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.mCurrentInterval = this.mBackgroundInterval;
                return;
            }
            this.mCurrentInterval = this.mForegroundInterval;
            Ping("switchToForeground");
        }
    }

    public void setInterval() {
        int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.mForegroundInterval = socketHeartBeatStratgy[0] * 1000;
            this.mBackgroundInterval = socketHeartBeatStratgy[1] * 1000;
            if (this.mForegroundInterval < 180000) {
                this.mForegroundInterval = 180000;
            }
            if (this.mBackgroundInterval < 180000) {
                this.mBackgroundInterval = 180000;
            }
        }
    }

    public int getForegroundInterval() {
        return this.mForegroundInterval;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int getCmd() {
        return 1003;
    }
}
