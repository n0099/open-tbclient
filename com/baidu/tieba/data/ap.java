package com.baidu.tieba.data;
/* loaded from: classes.dex */
public class ap {
    private volatile long a = 0;
    private volatile long b = 0;
    private volatile int c = 0;
    private volatile boolean d = false;

    public void a(int i) {
        if (i > 0) {
            this.d = true;
            this.a = i;
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
        this.a = 0L;
        this.b = 0L;
        this.c = 0;
    }

    public void a(com.baidu.tieba.util.ax axVar) {
        if (axVar != null) {
            if (this.a != 0) {
                axVar.a("ctime", String.valueOf(this.a));
            }
            if (this.b != 0) {
                axVar.a("data_size", String.valueOf(this.b));
            }
            if (this.c != 0) {
                axVar.a("net_error", String.valueOf(this.c));
            }
        }
    }
}
