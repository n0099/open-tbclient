package com.baidu.tieba.data;
/* loaded from: classes.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private volatile long f988a = 0;
    private volatile long b = 0;
    private volatile int c = 0;
    private volatile boolean d = false;

    public void a(int i) {
        if (i > 0) {
            this.d = true;
            this.f988a = i;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.d = true;
            this.b = i;
        }
    }

    public void c(int i) {
        if (i != 0) {
            this.d = true;
            this.c = i;
        }
    }

    public void a() {
        this.d = false;
        this.f988a = 0L;
        this.b = 0L;
        this.c = 0;
    }

    public void a(com.baidu.tieba.util.v vVar) {
        if (vVar != null) {
            if (this.f988a != 0) {
                vVar.a("ctime", String.valueOf(this.f988a));
            }
            if (this.b != 0) {
                vVar.a("data_size", String.valueOf(this.b));
            }
            if (this.c != 0) {
                vVar.a("net_error", String.valueOf(this.c));
            }
        }
    }
}
