package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.t;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* loaded from: classes.dex */
public class PingManager extends Handler {
    private static PingManager a = null;
    private long b = 0;
    private int c = 180000;
    private int d = 900000;
    private int e = this.d;
    private t f = null;
    private g g = null;

    public static PingManager a() {
        if (a == null) {
            synchronized (PingManager.class) {
                if (a == null) {
                    a = new PingManager();
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
        if (TiebaSocketLinkService.b()) {
            TiebaSocketLinkService.a(false, str);
        } else if (TiebaSocketLinkService.c()) {
            a(false, str);
        }
    }

    public boolean a(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.b >= 180000) && TiebaSocketLinkService.c()) {
            com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(1003, 0, str, "send ping", null, 0, null));
            this.b = System.currentTimeMillis();
            e.a().a(this.f, -3, 0, false);
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
        this.f = new t();
        e();
        this.g = new n(this);
        e.a().a(-11, this.g);
        e.a().a(1003, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cc ccVar) {
        if (ccVar != null && ccVar.j() != 0) {
            TiebaSocketLinkService.a(7, "ping error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.a aVar) {
        if (aVar != null) {
            if (aVar.a()) {
                this.e = this.d;
            } else {
                this.e = this.c;
                a("switchToForeground");
            }
            com.baidu.adp.lib.h.e.d("pingManager mCurrentInterval = " + this.e);
        }
    }

    public void e() {
        int[] aZ = TiebaApplication.g().aZ();
        if (aZ.length == 2) {
            this.c = aZ[0] * LocationClientOption.MIN_SCAN_SPAN;
            this.d = aZ[1] * LocationClientOption.MIN_SCAN_SPAN;
            if (this.c < 180000) {
                this.c = 180000;
            }
            if (this.d < 180000) {
                this.d = 180000;
            }
        }
    }
}
