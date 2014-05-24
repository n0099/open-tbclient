package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.network.websocket.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.PingMessage;
/* loaded from: classes.dex */
public class m extends Handler {
    private static m a = null;
    private long b = 0;
    private int c = 180000;
    private int d = 900000;
    private int e = this.d;
    private PingMessage f = null;

    public static m a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                c();
                a(true, "regular time send");
                return;
            default:
                return;
        }
    }

    private void a(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            a(false, str);
        }
    }

    public boolean a(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.b >= 180000) && BdSocketLinkService.isOpen()) {
            TiebaStatic.imLog((int) MessageTypes.CMD_PING, 0, str, "send ping", (String) null, 0, (String) null);
            this.b = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.f);
            return true;
        }
        return false;
    }

    public void b() {
        removeMessages(1);
    }

    public void c() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.e);
        this.b = System.currentTimeMillis();
    }

    public void d() {
        this.f = new PingMessage();
        e();
        n nVar = new n(this, MessageTypes.CMD_PING);
        MessageManager.getInstance().registerListener(new o(this, MessageTypes.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && responsedMessage.getError() != 0) {
            BdSocketLinkService.close(7, "ping error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.e = this.d;
            } else {
                this.e = this.c;
                a("switchToForeground");
            }
            BdLog.d("pingManager mCurrentInterval = " + this.e);
        }
    }

    public void e() {
        int[] socketHeartBeatStratgy = TbadkApplication.m252getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.c = socketHeartBeatStratgy[0] * LocationClientOption.MIN_SCAN_SPAN;
            this.d = socketHeartBeatStratgy[1] * LocationClientOption.MIN_SCAN_SPAN;
            if (this.c < 180000) {
                this.c = 180000;
            }
            if (this.d < 180000) {
                this.d = 180000;
            }
        }
    }
}
