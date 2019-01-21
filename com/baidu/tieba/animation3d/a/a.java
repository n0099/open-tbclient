package com.baidu.tieba.animation3d.a;
/* loaded from: classes.dex */
public abstract class a {
    private int cTN = -1;

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
        return this.cTN;
    }

    public void kB(int i) {
        this.cTN = i;
    }
}
