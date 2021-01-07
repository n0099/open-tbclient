package com.baidu.tieba;
/* loaded from: classes.dex */
public class e {
    public a geS;
    private int geT = 0;

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public void up(int i) {
        if (this.geT != i) {
            if (this.geS != null) {
                this.geS.bx(this.geT, i);
            }
            this.geT = i;
        }
    }

    public void uq(int i) {
        this.geT = i;
    }

    public int bNi() {
        return this.geT;
    }

    public void a(a aVar) {
        this.geS = aVar;
    }
}
