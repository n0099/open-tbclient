package com.baidu.tieba.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point aZb;
    private Point aZc;
    private Point aZd;
    private final int aZe;
    private final int aZf;
    private e aZg;
    private int aZh;
    private float k;

    private int fL(int i) {
        return (int) (((this.k * i) + this.aZb.y) - (this.k * this.aZb.x));
    }

    @Override // com.baidu.tieba.im.floatwindow.a.c
    public boolean execute() {
        if (!this.aZd.equals(this.aZc)) {
            switch (this.aZh) {
                case 0:
                    NH();
                    break;
                case 1:
                    NJ();
                    break;
                case 2:
                    NI();
                    break;
                case 3:
                    NK();
                    break;
                case 4:
                    NL();
                    break;
                case 5:
                    NM();
                    break;
            }
            return false;
        }
        if (this.aZg != null) {
            this.aZg.NA();
        }
        return true;
    }

    private void NH() {
        this.aZd.y += this.aZf;
        if (this.aZd.y > this.aZc.y) {
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NI() {
        this.aZd.x += this.aZe;
        if (this.aZd.x > this.aZc.x) {
            this.aZd.x = this.aZc.x;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NJ() {
        this.aZd.y -= this.aZf;
        if (this.aZd.y < this.aZc.y) {
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NK() {
        this.aZd.x -= this.aZe;
        if (this.aZd.x < this.aZc.x) {
            this.aZd.x = this.aZc.x;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NL() {
        this.aZd.x -= this.aZe;
        this.aZd.y = fL(this.aZd.x);
        if (this.aZd.x < this.aZc.x && this.aZd.y < this.aZc.y) {
            this.aZd.x = this.aZc.x;
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NM() {
        this.aZd.x += this.aZe;
        this.aZd.y = fL(this.aZd.x);
        if (this.aZd.x > this.aZc.x && this.aZd.y > this.aZc.y) {
            this.aZd.x = this.aZc.x;
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }
}
