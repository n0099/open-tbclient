package com.baidu.tieba.data;
/* loaded from: classes.dex */
public final class af {
    private volatile long a = 0;
    private volatile long b = 0;
    private volatile int c = 0;
    private volatile boolean d = false;

    public final void a(int i) {
        if (i > 0) {
            this.d = true;
            this.a = i;
        }
    }

    public final void b(int i) {
        if (i > 0) {
            this.d = true;
            this.b = i;
        }
    }

    public final void c(int i) {
        this.d = true;
        this.c = 1;
    }

    public final void a() {
        this.d = false;
        this.a = 0L;
        this.b = 0L;
        this.c = 0;
    }

    public final void a(com.baidu.tbadk.core.util.ak akVar) {
        if (akVar != null) {
            if (this.a != 0) {
                akVar.a("ctime", String.valueOf(this.a));
            }
            if (this.b != 0) {
                akVar.a("data_size", String.valueOf(this.b));
            }
            if (this.c != 0) {
                akVar.a("net_error", String.valueOf(this.c));
            }
        }
    }
}
