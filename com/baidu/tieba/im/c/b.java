package com.baidu.tieba.im.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.d.q;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.message.v;
/* loaded from: classes.dex */
public final class b {
    private static b a;
    private boolean n;
    private int b = 900000;
    private int c = 360000;
    private int d = this.c;
    private boolean e = false;
    private long f = 0;
    private int g = 0;
    private long h = 0;
    private int i = 0;
    private long j = 0;
    private final int k = com.baidu.adp.framework.f.a().b();
    private final Handler l = new j((byte) 0);
    private final com.baidu.adp.lib.network.websocket.c m = new d(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.db.e> o = new e(this);
    private final com.baidu.adp.framework.c.g p = new f(this, 0);
    private final com.baidu.adp.framework.c.a q = new i(this, 2001011);

    static {
        com.baidu.adp.framework.c.a().a(new c(2008017));
        a = null;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public final void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        com.baidu.adp.framework.c.a().a(this.q);
        q.a().a(this.m);
        com.baidu.adp.framework.c.a().a(1003, this.p);
        com.baidu.adp.framework.c.a().a(1001, this.p);
        com.baidu.adp.framework.c.a().a(202101, this.p);
        b();
    }

    public final void b() {
        TbadkApplication.j();
        int[] aa = TbadkApplication.aa();
        if (aa.length == 2) {
            int i = aa[0] * LocationClientOption.MIN_SCAN_SPAN;
            if (i > 0) {
                this.c = i;
            }
            int i2 = aa[1] * LocationClientOption.MIN_SCAN_SPAN;
            if (i2 > 0) {
                this.b = i2;
            }
        }
    }

    public final void c() {
        this.e = false;
        com.baidu.adp.lib.stats.g.a().a("lc_con", null, null, com.baidu.adp.lib.webSocket.l.a().l(), 0, null, "dns", Long.valueOf(com.baidu.adp.lib.webSocket.l.a().j()), "ip", com.baidu.adp.lib.webSocket.l.a().k(), com.baidu.loginshare.e.e, com.baidu.adp.lib.stats.g.a().b());
    }

    public final void d() {
        this.e = false;
        com.baidu.adp.lib.util.f.d("----msg sync stop");
        this.l.removeMessages(3);
        this.l.removeMessages(2);
    }

    public final void e() {
        com.baidu.adp.lib.util.f.d("----switchToForeground");
        this.d = this.c;
        if (this.g > 0) {
            g();
        }
    }

    public final void f() {
        com.baidu.adp.lib.util.f.d("----switchToBackground");
        this.h = System.currentTimeMillis();
        a().d = a().b;
    }

    public synchronized void i() {
        if (System.currentTimeMillis() - this.j >= 180000) {
            v vVar = new v();
            vVar.e(this.i);
            vVar.b(com.baidu.adp.lib.webSocket.l.a().g());
            vVar.c(com.baidu.adp.lib.webSocket.l.a().i());
            vVar.d(TbadkApplication.j().s());
            com.baidu.adp.framework.c.a().a(vVar);
            this.j = System.currentTimeMillis();
            this.i = 0;
            com.baidu.adp.lib.webSocket.l.a().h();
            com.baidu.adp.lib.webSocket.l.a().f();
            TbadkApplication.j().t();
        }
    }

    public static /* synthetic */ s f(b bVar) {
        s sVar = new s();
        sVar.a(com.baidu.tbadk.coreExtra.messageCenter.d.a().b());
        sVar.a(bVar.n);
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        if (d != null) {
            sVar.d(d.width);
            sVar.e(d.height);
        }
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        if (c != null) {
            sVar.h(c.height);
            sVar.f(c.width);
        }
        return sVar;
    }

    public final synchronized void a(long j, long j2, long j3) {
        this.i++;
        a(false);
    }

    public final synchronized void g() {
        a(true);
    }

    public final void h() {
        this.f = System.currentTimeMillis();
        if (this.e) {
            g();
            this.e = false;
        }
    }

    private synchronized void a(boolean z) {
        this.n = z;
        if (!z) {
            this.l.removeMessages(3);
            a().l.sendMessageDelayed(a().l.obtainMessage(3), a().d);
        }
        com.baidu.adp.lib.util.f.d("----begin pullMessageForNewRemind");
        this.o.a(null);
    }
}
