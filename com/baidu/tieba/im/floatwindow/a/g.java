package com.baidu.tieba.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int aZm;
    private int aZn;
    private h aZo;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.aZn = i;
    }

    public void fM(int i) {
        this.aZm = i;
    }

    public void a(h hVar) {
        this.aZo = hVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.a.c
    public boolean execute() {
        if (this.aZn != this.aZm) {
            if (this.aZm > this.start) {
                this.aZn += this.speed;
                if (this.aZn > this.aZm) {
                    this.aZn = this.aZm;
                }
            } else {
                this.aZn -= this.speed;
                if (this.aZn < this.aZm) {
                    this.aZn = this.aZm;
                }
            }
            if (this.aZo != null) {
                this.aZo.dU(this.aZn);
            }
            return false;
        }
        return true;
    }
}
