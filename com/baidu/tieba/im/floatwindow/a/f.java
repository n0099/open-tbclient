package com.baidu.tieba.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e aZh;
    private int aZi;
    private float aZj;
    private float aZk;
    private final long aZl;
    private float k;
    private long startTime;
    private Point aZc = new Point();
    private Point aZe = new Point();
    private Point aZd = new Point();

    public f(long j) {
        this.aZl = j;
    }

    public void a(e eVar) {
        this.aZh = eVar;
    }

    public void a(Point point, Point point2) {
        this.aZc.x = point.x;
        this.aZc.y = point.y;
        this.aZe.x = point.x;
        this.aZe.y = point.y;
        this.aZd.x = point2.x;
        this.aZd.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.aZk = Math.abs(point2.y - point.y) / ((float) this.aZl);
            if (point2.y > point.y) {
                this.aZi = 0;
            } else {
                this.aZi = 1;
            }
        } else if (point.y == point2.y) {
            this.aZj = Math.abs(point2.x - point.x) / ((float) this.aZl);
            if (point2.x > point.x) {
                this.aZi = 2;
            } else {
                this.aZi = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.aZj = Math.abs(f) / ((float) this.aZl);
            if (f > 0.0f) {
                this.aZi = 5;
            } else {
                this.aZi = 4;
            }
        }
    }

    private int fL(int i) {
        return (int) (((this.k * i) + this.aZc.y) - (this.k * this.aZc.x));
    }

    private long NS() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.aZe.y = (int) (this.aZc.y + (this.aZk * ((float) NS())));
        if (this.aZe.y > this.aZd.y) {
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NN() {
        this.aZe.x = (int) (this.aZc.x + (this.aZj * ((float) NS())));
        if (this.aZe.x > this.aZd.x) {
            this.aZe.x = this.aZd.x;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NO() {
        this.aZe.y = (int) (this.aZc.y - (this.aZk * ((float) NS())));
        if (this.aZe.y < this.aZd.y) {
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NP() {
        this.aZe.x = (int) (this.aZc.x - (this.aZj * ((float) NS())));
        if (this.aZe.x < this.aZd.x) {
            this.aZe.x = this.aZd.x;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NQ() {
        boolean z = true;
        this.aZe.x = (int) (this.aZc.x - (this.aZj * ((float) NS())));
        this.aZe.y = fL(this.aZe.x);
        if (this.aZc.y <= this.aZd.y ? this.aZe.y <= this.aZd.y : this.aZe.y >= this.aZd.y) {
            z = false;
        }
        if (this.aZe.x < this.aZd.x || z) {
            this.aZe.x = this.aZd.x;
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }

    private void NR() {
        boolean z = true;
        this.aZe.x = (int) (this.aZc.x + (this.aZj * ((float) NS())));
        this.aZe.y = fL(this.aZe.x);
        if (this.aZc.y <= this.aZd.y ? this.aZe.y <= this.aZd.y : this.aZe.y >= this.aZd.y) {
            z = false;
        }
        if (this.aZe.x > this.aZd.x || z) {
            this.aZe.x = this.aZd.x;
            this.aZe.y = this.aZd.y;
        }
        if (this.aZh != null) {
            this.aZh.a(this.aZe);
        }
    }
}
