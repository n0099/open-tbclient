package com.baidu.tieba.im.floatwindow.a;
/* loaded from: classes.dex */
public class g implements c {
    private int aXQ;
    private int aXR;
    private h aXS;
    private final int speed;
    private int start;

    public g(int i) {
        this.speed = i;
    }

    public void setStart(int i) {
        this.start = i;
        this.aXR = i;
    }

    public void fH(int i) {
        this.aXQ = i;
    }

    public void a(h hVar) {
        this.aXS = hVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.a.c
    public boolean execute() {
        if (this.aXR != this.aXQ) {
            if (this.aXQ > this.start) {
                this.aXR += this.speed;
                if (this.aXR > this.aXQ) {
                    this.aXR = this.aXQ;
                }
            } else {
                this.aXR -= this.speed;
                if (this.aXR < this.aXQ) {
                    this.aXR = this.aXQ;
                }
            }
            if (this.aXS != null) {
                this.aXS.dO(this.aXR);
            }
            return false;
        }
        return true;
    }
}
