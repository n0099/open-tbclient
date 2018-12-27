package com.baidu.tieba.animation3d.a;
/* loaded from: classes.dex */
public abstract class a {
    private int cTb = -1;

    public abstract boolean c(float f, float f2, float f3, int i);

    public abstract void e(float f, float f2, float f3, int i);

    public boolean apm() {
        return true;
    }

    public void b(float f, float f2, float f3, int i) {
    }

    public void d(float f, float f2, float f3, int i) {
    }

    public int apn() {
        return this.cTb;
    }

    public void kB(int i) {
        this.cTb = i;
    }
}
