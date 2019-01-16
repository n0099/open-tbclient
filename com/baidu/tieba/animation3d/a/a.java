package com.baidu.tieba.animation3d.a;
/* loaded from: classes.dex */
public abstract class a {
    private int cTM = -1;

    public abstract boolean c(float f, float f2, float f3, int i);

    public abstract void e(float f, float f2, float f3, int i);

    public boolean apJ() {
        return true;
    }

    public void b(float f, float f2, float f3, int i) {
    }

    public void d(float f, float f2, float f3, int i) {
    }

    public int apK() {
        return this.cTM;
    }

    public void kB(int i) {
        this.cTM = i;
    }
}
