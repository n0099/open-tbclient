package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a gcB;
    private int gcC = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bu(int i, int i2);
    }

    public void sO(int i) {
        if (this.gcC != i) {
            if (this.gcB != null) {
                this.gcB.bu(this.gcC, i);
            }
            this.gcC = i;
        }
    }

    public void sP(int i) {
        this.gcC = i;
    }

    public int bJK() {
        return this.gcC;
    }

    public void a(a aVar) {
        this.gcB = aVar;
    }
}
