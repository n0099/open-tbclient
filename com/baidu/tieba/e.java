package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a gai;
    private int gaj = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void sJ(int i) {
        if (this.gaj != i) {
            if (this.gai != null) {
                this.gai.bx(this.gaj, i);
            }
            this.gaj = i;
        }
    }

    public void sK(int i) {
        this.gaj = i;
    }

    public int bJq() {
        return this.gaj;
    }

    public void a(a aVar) {
        this.gai = aVar;
    }
}
