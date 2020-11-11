package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a fNZ;
    private int fOa = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void tc(int i) {
        if (this.fOa != i) {
            if (this.fNZ != null) {
                this.fNZ.bx(this.fOa, i);
            }
            this.fOa = i;
        }
    }

    public void td(int i) {
        this.fOa = i;
    }

    public int bHW() {
        return this.fOa;
    }

    public void a(a aVar) {
        this.fNZ = aVar;
    }
}
