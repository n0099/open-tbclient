package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.network.websocket.BdSocketLinkService;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class m extends Handler {
    private static m a = null;
    private long b = 0;
    private int c = 180000;
    private int d = 900000;
    private int e = this.d;
    private com.baidu.tbadk.coreExtra.message.a f = null;

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
                b();
                a(true, "regular time send");
                return;
            default:
                return;
        }
    }

    private boolean a(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.b >= 180000) && BdSocketLinkService.b()) {
            TiebaStatic.a(1003, 0, str, "send ping", null, 0, null);
            this.b = System.currentTimeMillis();
            com.baidu.adp.framework.c.a().a(this.f);
            return true;
        }
        return false;
    }

    public final void b() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.e);
        this.b = System.currentTimeMillis();
    }

    public final void c() {
        this.f = new com.baidu.tbadk.coreExtra.message.a();
        d();
        n nVar = new n(this, 1003);
        com.baidu.adp.framework.c.a().a(new o(this, 2001011));
        com.baidu.adp.framework.c.a().a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(m mVar, com.baidu.adp.framework.message.f fVar) {
        if (fVar == null || fVar.e() == 0) {
            return;
        }
        BdSocketLinkService.a(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(m mVar, BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.a().booleanValue()) {
                mVar.e = mVar.d;
            } else {
                mVar.e = mVar.c;
                if (BdSocketLinkService.a()) {
                    BdSocketLinkService.a(false, "switchToForeground");
                } else if (BdSocketLinkService.b()) {
                    mVar.a(false, "switchToForeground");
                }
            }
            com.baidu.adp.lib.util.f.e("pingManager mCurrentInterval = " + mVar.e);
        }
    }

    public final void d() {
        TbadkApplication.j();
        int[] Z = TbadkApplication.Z();
        if (Z.length == 2) {
            this.c = Z[0] * LocationClientOption.MIN_SCAN_SPAN;
            this.d = Z[1] * LocationClientOption.MIN_SCAN_SPAN;
            if (this.c < 180000) {
                this.c = 180000;
            }
            if (this.d < 180000) {
                this.d = 180000;
            }
        }
    }
}
