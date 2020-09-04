package com.baidu.tieba;
/* loaded from: classes.dex */
public class d {
    public a fkH;
    private int fkI = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void rS(int i) {
        if (this.fkI != i) {
            if (this.fkH != null) {
                this.fkH.bx(this.fkI, i);
            }
            this.fkI = i;
        }
    }

    public void rT(int i) {
        this.fkI = i;
    }

    public int bzJ() {
        return this.fkI;
    }

    public void a(a aVar) {
        this.fkH = aVar;
    }
}
