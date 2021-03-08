package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a geg;
    private int geh = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bu(int i, int i2);
    }

    public void sQ(int i) {
        if (this.geh != i) {
            if (this.geg != null) {
                this.geg.bu(this.geh, i);
            }
            this.geh = i;
        }
    }

    public void sR(int i) {
        this.geh = i;
    }

    public int bJT() {
        return this.geh;
    }

    public void a(a aVar) {
        this.geg = aVar;
    }
}
