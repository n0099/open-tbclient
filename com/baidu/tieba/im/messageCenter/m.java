package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.x;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
public class m extends Handler {
    private static m a = null;
    private long b = 0;
    private int c = 180000;
    private int d = 900000;
    private int e = this.d;
    private x f = null;
    private g g = null;

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

    public final boolean a(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.b >= 180000) && TiebaSocketLinkService.c()) {
            cb.a(1003, 0, str, "send ping", null, 0, null);
            this.b = System.currentTimeMillis();
            d.a().a(this.f, -3, 0, false);
            return true;
        }
        return false;
    }

    public final void b() {
        removeMessages(1);
    }

    public final void c() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.e);
        this.b = System.currentTimeMillis();
    }

    public final void d() {
        this.f = new x();
        e();
        this.g = new n(this);
        d.a().a(-11, this.g);
        d.a().a(1003, this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(m mVar, da daVar) {
        if (daVar == null || daVar.m() == 0) {
            return;
        }
        TiebaSocketLinkService.a(7, "ping error");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(m mVar, com.baidu.tieba.im.message.a aVar) {
        if (aVar != null) {
            if (aVar.a()) {
                mVar.e = mVar.d;
            } else {
                mVar.e = mVar.c;
                if (TiebaSocketLinkService.b()) {
                    TiebaSocketLinkService.a(false, "switchToForeground");
                } else if (TiebaSocketLinkService.c()) {
                    mVar.a(false, "switchToForeground");
                }
            }
            com.baidu.adp.lib.util.e.e("pingManager mCurrentInterval = " + mVar.e);
        }
    }

    public final void e() {
        int[] aN = TiebaApplication.g().aN();
        if (aN.length == 2) {
            this.c = aN[0] * LocationClientOption.MIN_SCAN_SPAN;
            this.d = aN[1] * LocationClientOption.MIN_SCAN_SPAN;
            if (this.c < 180000) {
                this.c = 180000;
            }
            if (this.d < 180000) {
                this.d = 180000;
            }
        }
    }
}
