package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a fnA;
    private int fnB = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void sj(int i) {
        if (this.fnB != i) {
            if (this.fnA != null) {
                this.fnA.bx(this.fnB, i);
            }
            this.fnB = i;
        }
    }

    public void sk(int i) {
        this.fnB = i;
    }

    public int bAS() {
        return this.fnB;
    }

    public void a(a aVar) {
        this.fnA = aVar;
    }
}
