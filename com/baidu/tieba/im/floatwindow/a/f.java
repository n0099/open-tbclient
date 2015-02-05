package com.baidu.tieba.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e aZg;
    private int aZh;
    private float aZi;
    private float aZj;
    private final long aZk;
    private float k;
    private long startTime;
    private Point aZb = new Point();
    private Point aZd = new Point();
    private Point aZc = new Point();

    public f(long j) {
        this.aZk = j;
    }

    public void a(e eVar) {
        this.aZg = eVar;
    }

    public void a(Point point, Point point2) {
        this.aZb.x = point.x;
        this.aZb.y = point.y;
        this.aZd.x = point.x;
        this.aZd.y = point.y;
        this.aZc.x = point2.x;
        this.aZc.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.aZj = Math.abs(point2.y - point.y) / ((float) this.aZk);
            if (point2.y > point.y) {
                this.aZh = 0;
            } else {
                this.aZh = 1;
            }
        } else if (point.y == point2.y) {
            this.aZi = Math.abs(point2.x - point.x) / ((float) this.aZk);
            if (point2.x > point.x) {
                this.aZh = 2;
            } else {
                this.aZh = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.aZi = Math.abs(f) / ((float) this.aZk);
            if (f > 0.0f) {
                this.aZh = 5;
            } else {
                this.aZh = 4;
            }
        }
    }

    private int fL(int i) {
        return (int) (((this.k * i) + this.aZb.y) - (this.k * this.aZb.x));
    }

    private long NN() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.aZd.y = (int) (this.aZb.y + (this.aZj * ((float) NN())));
        if (this.aZd.y > this.aZc.y) {
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NI() {
        this.aZd.x = (int) (this.aZb.x + (this.aZi * ((float) NN())));
        if (this.aZd.x > this.aZc.x) {
            this.aZd.x = this.aZc.x;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NJ() {
        this.aZd.y = (int) (this.aZb.y - (this.aZj * ((float) NN())));
        if (this.aZd.y < this.aZc.y) {
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NK() {
        this.aZd.x = (int) (this.aZb.x - (this.aZi * ((float) NN())));
        if (this.aZd.x < this.aZc.x) {
            this.aZd.x = this.aZc.x;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NL() {
        boolean z = true;
        this.aZd.x = (int) (this.aZb.x - (this.aZi * ((float) NN())));
        this.aZd.y = fL(this.aZd.x);
        if (this.aZb.y <= this.aZc.y ? this.aZd.y <= this.aZc.y : this.aZd.y >= this.aZc.y) {
            z = false;
        }
        if (this.aZd.x < this.aZc.x || z) {
            this.aZd.x = this.aZc.x;
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }

    private void NM() {
        boolean z = true;
        this.aZd.x = (int) (this.aZb.x + (this.aZi * ((float) NN())));
        this.aZd.y = fL(this.aZd.x);
        if (this.aZb.y <= this.aZc.y ? this.aZd.y <= this.aZc.y : this.aZd.y >= this.aZc.y) {
            z = false;
        }
        if (this.aZd.x > this.aZc.x || z) {
            this.aZd.x = this.aZc.x;
            this.aZd.y = this.aZc.y;
        }
        if (this.aZg != null) {
            this.aZg.a(this.aZd);
        }
    }
}
