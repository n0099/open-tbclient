package com.baidu.tieba.data;
/* loaded from: classes.dex */
public class ak {
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

    public void a(com.baidu.tbadk.core.util.aq aqVar) {
        if (aqVar != null) {
            if (this.a != 0) {
                aqVar.a("ctime", String.valueOf(this.a));
            }
            if (this.b != 0) {
                aqVar.a("data_size", String.valueOf(this.b));
            }
            if (this.c != 0) {
                aqVar.a("net_error", String.valueOf(this.c));
            }
        }
    }
}
