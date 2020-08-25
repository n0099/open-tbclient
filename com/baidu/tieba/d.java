package com.baidu.tieba;
/* loaded from: classes2.dex */
public class d {
    public a fkD;
    private int fkE = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void rS(int i) {
        if (this.fkE != i) {
            if (this.fkD != null) {
                this.fkD.bx(this.fkE, i);
            }
            this.fkE = i;
        }
    }

    public void rT(int i) {
        this.fkE = i;
    }

    public int bzI() {
        return this.fkE;
    }

    public void a(a aVar) {
        this.fkD = aVar;
    }
}
