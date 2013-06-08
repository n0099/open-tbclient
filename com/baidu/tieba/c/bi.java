package com.baidu.tieba.c;

import android.content.Context;
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.a.c {
    private long g;
    private long h;
    private long i;
    private long j;
    private String k;
    private com.baidu.tieba.d.a o;
    private bk p = null;
    private bj q = null;
    private boolean e = true;
    private String f = null;
    private com.baidu.tieba.a.be n = null;
    private boolean l = false;
    private boolean m = false;

    public bi(Context context) {
        a(0L);
        c(0L);
        d(0L);
        b(0L);
        this.o = new com.baidu.tieba.d.a(context);
    }

    public String d() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean e() {
        return this.e;
    }

    public void a(com.baidu.tieba.a.be beVar) {
        this.n = beVar;
    }

    public com.baidu.tieba.a.be f() {
        return this.n;
    }

    public void a(com.baidu.tieba.a.ao aoVar) {
        f().b(aoVar.b());
        f().b(aoVar.c());
        f().f(aoVar.a());
    }

    public void a(boolean z, boolean z2) {
        if (this.p == null) {
            this.p = new bk(this, null);
            this.p.setPriority(3);
            this.p.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void g() {
        if (f() != null && this.q == null) {
            this.q = new bj(this, null);
            this.q.setPriority(2);
            if (f().o() == 1) {
                this.q.execute(1);
            } else {
                this.q.execute(0);
            }
        }
    }

    public com.baidu.tieba.d.a h() {
        return this.o;
    }

    public void c(String str) {
        this.k = str;
    }

    public String i() {
        return this.k;
    }

    public void a(long j) {
        this.g = j;
    }

    public long j() {
        return this.g;
    }

    public void b(long j) {
        this.j = j;
    }

    public long k() {
        return this.j;
    }

    public void c(long j) {
        this.h = j;
    }

    public long l() {
        return this.h;
    }

    public long m() {
        return this.h + this.i;
    }

    public void d(long j) {
        this.i = j;
    }

    public long n() {
        return this.i;
    }

    public void b(boolean z) {
        this.l = z;
    }

    public boolean o() {
        return this.l;
    }

    public void c(boolean z) {
        this.m = z;
    }

    public boolean p() {
        return this.m;
    }

    public void q() {
        if (this.p != null) {
            this.p.cancel();
        }
        if (this.q != null) {
            this.q.cancel();
        }
        if (this.o != null) {
            this.o.b();
        }
    }
}
