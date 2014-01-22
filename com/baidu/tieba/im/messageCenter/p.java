package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.util.by;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private int b;
    private CoderException c;
    private boolean d;
    private com.baidu.tieba.im.message.q e;
    private int g;
    private boolean h;
    private i j;
    private boolean n;
    private volatile int f = 0;
    private Runnable i = null;
    private boolean k = true;
    private int l = 0;
    private int m = 0;

    public p(com.baidu.tieba.im.message.q qVar, boolean z, int i, boolean z2, i iVar, int i2, boolean z3) {
        this.b = 0;
        this.d = false;
        this.e = null;
        this.g = 0;
        this.h = false;
        this.j = null;
        this.n = true;
        if (qVar == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.e = qVar;
        this.g = i;
        this.h = z2;
        this.d = z;
        this.b = i2;
        this.j = iVar;
        this.n = z3;
    }

    private void b(int i) {
        if (this.j != null && this.k) {
            this.j.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.j != null && this.k) {
            this.j.a(this);
        }
    }

    private void s() {
        if (this.j != null && this.k) {
            this.j.b(this);
        }
    }

    private void t() {
        if (this.j != null && this.k) {
            this.j.c(this);
        }
    }

    private Runnable u() {
        if (this.i == null) {
            this.i = new q(this);
        }
        return this.i;
    }

    public void e() {
        a.removeCallbacks(u());
    }

    public void f() {
        e();
        this.k = false;
    }

    @Override // com.baidu.adp.lib.webSocket.aq
    public void c() {
        by.a(this.e.w(), this.f, "socket", "SenderData: start send", null, 0, null, 0L, b() != null ? b().length : 0, null);
        a.removeCallbacks(u());
        if (this.b > 0) {
            a.postDelayed(u(), this.b);
        } else {
            a.postDelayed(u(), com.baidu.tieba.im.net.f.a().d());
        }
        t();
    }

    @Override // com.baidu.adp.lib.webSocket.aq
    public void a(int i) {
        a.removeCallbacks(u());
        b(i);
    }

    @Override // com.baidu.adp.lib.webSocket.aq
    public void d() {
        by.a(this.e.w(), this.f, "socket", "SenderData: finish send", null, 0, null, 0L, b() != null ? b().length : 0, null);
        if (!this.d) {
            a.removeCallbacks(u());
        }
        s();
    }

    public CoderException g() {
        return this.c;
    }

    public boolean h() {
        return this.d;
    }

    public int i() {
        return this.g;
    }

    public com.baidu.tieba.im.message.q j() {
        return this.e;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] a() {
        this.c = null;
        com.baidu.tieba.im.coder.c a2 = com.baidu.tieba.im.coder.c.a();
        this.f = this.e.v();
        try {
            return a2.a(this.e, this.f, this.h);
        } catch (CoderException e) {
            this.c = e;
            return null;
        }
    }

    public int k() {
        if (this.e != null) {
            return this.e.w();
        }
        return 0;
    }

    public int l() {
        return this.f;
    }

    public boolean m() {
        return this.n;
    }

    public int n() {
        return this.m;
    }

    public int o() {
        int i = this.m + 1;
        this.m = i;
        return i;
    }

    public int p() {
        return this.l;
    }

    public int q() {
        int i = this.l + 1;
        this.l = i;
        return i;
    }
}
