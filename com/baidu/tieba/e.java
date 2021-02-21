package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a gcG;
    private int gcH = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bu(int i, int i2);
    }

    public void sO(int i) {
        if (this.gcH != i) {
            if (this.gcG != null) {
                this.gcG.bu(this.gcH, i);
            }
            this.gcH = i;
        }
    }

    public void sP(int i) {
        this.gcH = i;
    }

    public int bJP() {
        return this.gcH;
    }

    public void a(a aVar) {
        this.gcG = aVar;
    }
}
