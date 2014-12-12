package com.baidu.tieba.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point aXG;
    private Point aXH;
    private Point aXI;
    private final int aXJ;
    private final int aXK;
    private e aXL;
    private int aXM;
    private float k;

    private int fG(int i) {
        return (int) (((this.k * i) + this.aXG.y) - (this.k * this.aXG.x));
    }

    @Override // com.baidu.tieba.im.floatwindow.a.c
    public boolean execute() {
        if (!this.aXI.equals(this.aXH)) {
            switch (this.aXM) {
                case 0:
                    Nq();
                    break;
                case 1:
                    Ns();
                    break;
                case 2:
                    Nr();
                    break;
                case 3:
                    Nt();
                    break;
                case 4:
                    Nu();
                    break;
                case 5:
                    Nv();
                    break;
            }
            return false;
        }
        if (this.aXL != null) {
            this.aXL.Nj();
        }
        return true;
    }

    private void Nq() {
        this.aXI.y += this.aXK;
        if (this.aXI.y > this.aXH.y) {
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nr() {
        this.aXI.x += this.aXJ;
        if (this.aXI.x > this.aXH.x) {
            this.aXI.x = this.aXH.x;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Ns() {
        this.aXI.y -= this.aXK;
        if (this.aXI.y < this.aXH.y) {
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nt() {
        this.aXI.x -= this.aXJ;
        if (this.aXI.x < this.aXH.x) {
            this.aXI.x = this.aXH.x;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nu() {
        this.aXI.x -= this.aXJ;
        this.aXI.y = fG(this.aXI.x);
        if (this.aXI.x < this.aXH.x && this.aXI.y < this.aXH.y) {
            this.aXI.x = this.aXH.x;
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nv() {
        this.aXI.x += this.aXJ;
        this.aXI.y = fG(this.aXI.x);
        if (this.aXI.x > this.aXH.x && this.aXI.y > this.aXH.y) {
            this.aXI.x = this.aXH.x;
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }
}
