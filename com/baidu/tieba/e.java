package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a fNC;
    private int fND = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void tA(int i) {
        if (this.fND != i) {
            if (this.fNC != null) {
                this.fNC.bx(this.fND, i);
            }
            this.fND = i;
        }
    }

    public void tB(int i) {
        this.fND = i;
    }

    public int bHp() {
        return this.fND;
    }

    public void a(a aVar) {
        this.fNC = aVar;
    }
}
