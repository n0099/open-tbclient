package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a fVm;
    private int fVn = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bz(int i, int i2);
    }

    public void ud(int i) {
        if (this.fVn != i) {
            if (this.fVm != null) {
                this.fVm.bz(this.fVn, i);
            }
            this.fVn = i;
        }
    }

    public void ue(int i) {
        this.fVn = i;
    }

    public int bKP() {
        return this.fVn;
    }

    public void a(a aVar) {
        this.fVm = aVar;
    }
}
