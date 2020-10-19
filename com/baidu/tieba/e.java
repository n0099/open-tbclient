package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a fzO;
    private int fzP = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bw(int i, int i2);
    }

    public void sH(int i) {
        if (this.fzP != i) {
            if (this.fzO != null) {
                this.fzO.bw(this.fzP, i);
            }
            this.fzP = i;
        }
    }

    public void sI(int i) {
        this.fzP = i;
    }

    public int bDE() {
        return this.fzP;
    }

    public void a(a aVar) {
        this.fzO = aVar;
    }
}
