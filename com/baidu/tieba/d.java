package com.baidu.tieba;
/* loaded from: classes.dex */
public class d {
    public a eZl;
    private int eZm = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bo(int i, int i2);
    }

    public void pG(int i) {
        if (this.eZm != i) {
            if (this.eZl != null) {
                this.eZl.bo(this.eZm, i);
            }
            this.eZm = i;
        }
    }

    public void pH(int i) {
        this.eZm = i;
    }

    public int bqK() {
        return this.eZm;
    }

    public void a(a aVar) {
        this.eZl = aVar;
    }
}
