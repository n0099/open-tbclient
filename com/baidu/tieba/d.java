package com.baidu.tieba;
/* loaded from: classes.dex */
public class d {
    public a eIE;
    private int eIF = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bh(int i, int i2);
    }

    public void oQ(int i) {
        if (this.eIF != i) {
            if (this.eIE != null) {
                this.eIE.bh(this.eIF, i);
            }
            this.eIF = i;
        }
    }

    public void oR(int i) {
        this.eIF = i;
    }

    public int bkq() {
        return this.eIF;
    }

    public void a(a aVar) {
        this.eIE = aVar;
    }
}
