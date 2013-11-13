package com.baidu.tieba.data;
/* loaded from: classes.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private volatile long f1170a = 0;
    private volatile long b = 0;
    private volatile int c = 0;
    private volatile boolean d = false;

    public void a(int i) {
        if (i > 0) {
            this.d = true;
            this.f1170a = i;
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
        this.f1170a = 0L;
        this.b = 0L;
        this.c = 0;
    }

    public void a(com.baidu.tieba.util.ap apVar) {
        if (apVar != null) {
            if (this.f1170a != 0) {
                apVar.a("ctime", String.valueOf(this.f1170a));
            }
            if (this.b != 0) {
                apVar.a("data_size", String.valueOf(this.b));
            }
            if (this.c != 0) {
                apVar.a("net_error", String.valueOf(this.c));
            }
        }
    }
}
