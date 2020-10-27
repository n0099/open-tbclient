package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a fIj;
    private int fIk = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void sS(int i) {
        if (this.fIk != i) {
            if (this.fIj != null) {
                this.fIj.bx(this.fIk, i);
            }
            this.fIk = i;
        }
    }

    public void sT(int i) {
        this.fIk = i;
    }

    public int bFx() {
        return this.fIk;
    }

    public void a(a aVar) {
        this.fIj = aVar;
    }
}
