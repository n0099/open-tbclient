package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.lib.webSocket.d {
    private static Handler a = new Handler();
    private int b;
    private CoderException c;
    private boolean d;
    private s e;
    private int g;
    private boolean h;
    private i j;
    private boolean n;
    private volatile int f = 0;
    private Runnable i = null;
    private boolean k = true;
    private int l = 0;
    private int m = 0;

    public p(s sVar, boolean z, int i, boolean z2, i iVar, int i2, boolean z3) {
        this.b = 0;
        this.d = false;
        this.e = null;
        this.g = 0;
        this.h = false;
        this.j = null;
        this.n = true;
        if (sVar == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.e = sVar;
        this.g = i;
        this.h = z2;
        this.d = z;
        this.b = i2;
        this.j = iVar;
        this.n = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(p pVar) {
        if (pVar.j == null || !pVar.k) {
            return;
        }
        pVar.j.a(pVar);
    }

    private Runnable r() {
        if (this.i == null) {
            this.i = new q(this);
        }
        return this.i;
    }

    public final void a() {
        a.removeCallbacks(r());
    }

    public final void d() {
        a();
        this.k = false;
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void b() {
        cb.a(this.e.v(), this.f, "socket", "SenderData: start send", null, 0, null, 0L, k() != null ? k().length : 0, null);
        a.removeCallbacks(r());
        if (this.b > 0) {
            a.postDelayed(r(), this.b);
        } else {
            a.postDelayed(r(), com.baidu.tieba.im.net.p.a().d());
        }
        if (this.j == null || !this.k) {
            return;
        }
        this.j.b(this);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void a(int i) {
        a.removeCallbacks(r());
        if (this.j == null || !this.k) {
            return;
        }
        this.j.a(i, this);
    }

    @Override // com.baidu.adp.lib.webSocket.ao
    public final void c() {
        cb.a(this.e.v(), this.f, "socket", "SenderData: finish send", null, 0, null, 0L, k() != null ? k().length : 0, null);
        if (!this.d) {
            a.removeCallbacks(r());
        }
        if (this.j == null || !this.k) {
            return;
        }
        i iVar = this.j;
    }

    public final CoderException e() {
        return this.c;
    }

    public final boolean f() {
        return this.d;
    }

    public final int h() {
        return this.g;
    }

    public final s i() {
        return this.e;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected final byte[] g() {
        this.c = null;
        com.baidu.tieba.im.coder.c a2 = com.baidu.tieba.im.coder.c.a();
        this.f = r.a().b();
        try {
            return a2.a(this.e, this.f, this.h);
        } catch (CoderException e) {
            this.c = e;
            return null;
        }
    }

    public final int j() {
        if (this.e != null) {
            return this.e.v();
        }
        return 0;
    }

    public final int l() {
        return this.f;
    }

    public final boolean m() {
        return this.n;
    }

    public final int n() {
        return this.m;
    }

    public final int o() {
        int i = this.m + 1;
        this.m = i;
        return i;
    }

    public final int p() {
        return this.l;
    }

    public final int q() {
        int i = this.l + 1;
        this.l = i;
        return i;
    }
}
