package com.baidu.tieba.c;

import android.content.Context;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.c {
    private long g;
    private long h;
    private long i;
    private String j;
    private com.baidu.tieba.d.a n;
    private bh o = null;
    private bg p = null;
    private boolean e = true;
    private String f = null;
    private com.baidu.tieba.a.bd m = null;
    private boolean k = false;
    private boolean l = false;

    public bf(Context context) {
        a(0L);
        b(0L);
        c(0L);
        this.n = new com.baidu.tieba.d.a(context);
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

    public void a(com.baidu.tieba.a.bd bdVar) {
        this.m = bdVar;
    }

    public com.baidu.tieba.a.bd f() {
        return this.m;
    }

    public void a(com.baidu.tieba.a.an anVar) {
        f().b(anVar.b());
        f().b(anVar.c());
        f().f(anVar.a());
    }

    public void a(boolean z, boolean z2) {
        if (this.o == null) {
            this.o = new bh(this, null);
            this.o.setPriority(3);
            this.o.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void g() {
        if (f() != null && this.p == null) {
            this.p = new bg(this, null);
            this.p.setPriority(2);
            if (f().l() == 1) {
                this.p.execute(1);
            } else {
                this.p.execute(0);
            }
        }
    }

    public com.baidu.tieba.d.a h() {
        return this.n;
    }

    public void c(String str) {
        this.j = str;
    }

    public String i() {
        return this.j;
    }

    public void a(long j) {
        this.g = j;
    }

    public long j() {
        return this.g;
    }

    public void b(long j) {
        this.h = j;
    }

    public long k() {
        return this.h;
    }

    public long l() {
        return this.h + this.i;
    }

    public void c(long j) {
        this.i = j;
    }

    public long m() {
        return this.i;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public boolean n() {
        return this.k;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public boolean o() {
        return this.l;
    }

    public void p() {
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.p != null) {
            this.p.cancel();
        }
        if (this.n != null) {
            this.n.b();
        }
    }
}
