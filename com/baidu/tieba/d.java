package com.baidu.tieba;
/* loaded from: classes.dex */
public class d {
    public a eSQ;
    private int eSR = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bl(int i, int i2);
    }

    public void pp(int i) {
        if (this.eSR != i) {
            if (this.eSQ != null) {
                this.eSQ.bl(this.eSR, i);
            }
            this.eSR = i;
        }
    }

    public void pq(int i) {
        this.eSR = i;
    }

    public int bmP() {
        return this.eSR;
    }

    public void a(a aVar) {
        this.eSQ = aVar;
    }
}
