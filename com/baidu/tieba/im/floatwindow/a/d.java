package com.baidu.tieba.im.floatwindow.a;

import android.graphics.Point;
/* loaded from: classes.dex */
public class d implements c {
    private Point aZc;
    private Point aZd;
    private Point aZe;
    private final int aZf;
    private final int aZg;
    private e aZh;
    private int aZi;
    private float k;

    private int fL(int i) {
        return (int) (((this.k * i) + this.aZc.y) - (this.k * this.aZc.x));
    }

    @Override // com.baidu.tieba.im.floatwindow.a.c
    public boolean execute() {
        if (!this.aZe.equals(this.aZd)) {
            switch (this.aZi) {
                case 0:
                    NM();
                    break;
                case 1:
                    NO();
                    break;
                case 2:
                    NN();
                    break;
                case 3:
                    NP();
                    break;
                case 4:
                    NQ();
                    break;
                case 5:
                    NR();
                    break;
            }
            return false;
        }
        if (this.aZh != null) {
            this.aZh.NF();
        }
        return true;
    }

    private void NM() {
        this.aZe.y += this.aZg;
        if (this.aZe.y > this.aZd.y) {
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NN() {
        this.aZe.x += this.aZf;
        if (this.aZe.x > this.aZd.x) {
            this.aZe.x = this.aZd.x;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NO() {
        this.aZe.y -= this.aZg;
        if (this.aZe.y < this.aZd.y) {
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NP() {
        this.aZe.x -= this.aZf;
        if (this.aZe.x < this.aZd.x) {
            this.aZe.x = this.aZd.x;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NQ() {
        this.aZe.x -= this.aZf;
        this.aZe.y = fL(this.aZe.x);
        if (this.aZe.x < this.aZd.x && this.aZe.y < this.aZd.y) {
            this.aZe.x = this.aZd.x;
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NR() {
        this.aZe.x += this.aZf;
        this.aZe.y = fL(this.aZe.x);
        if (this.aZe.x > this.aZd.x && this.aZe.y > this.aZd.y) {
            this.aZe.x = this.aZd.x;
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }
}
