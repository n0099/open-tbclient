package com.baidu.tieba.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int aZl;
    private int aZm;
    private h aZn;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.aZm = i;
    }

    public void fM(int i) {
        this.aZl = i;
    }

    public void a(h hVar) {
        this.aZn = hVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.a.c
    public boolean execute() {
        if (this.aZm != this.aZl) {
            if (this.aZl > this.start) {
                this.aZm += this.speed;
                if (this.aZm > this.aZl) {
                    this.aZm = this.aZl;
                }
            } else {
                this.aZm -= this.speed;
                if (this.aZm < this.aZl) {
                    this.aZm = this.aZl;
                }
            }
            if (this.aZn != null) {
                this.aZn.dU(this.aZm);
            }
            return false;
        }
        return true;
    }
}
