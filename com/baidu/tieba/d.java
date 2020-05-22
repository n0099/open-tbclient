package com.baidu.tieba;
/* loaded from: classes.dex */
public class d {
    public a eIt;
    private int eIu = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bh(int i, int i2);
    }

    public void oO(int i) {
        if (this.eIu != i) {
            if (this.eIt != null) {
                this.eIt.bh(this.eIu, i);
            }
            this.eIu = i;
        }
    }

    public void oP(int i) {
        this.eIu = i;
    }

    public int bko() {
        return this.eIu;
    }

    public void a(a aVar) {
        this.eIt = aVar;
    }
}
