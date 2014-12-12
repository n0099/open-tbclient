package com.baidu.tieba.im.floatwindow.a;

import android.graphics.Point;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class f implements c {
    private e aXL;
    private int aXM;
    private float aXN;
    private float aXO;
    private final long aXP;
    private float k;
    private long startTime;
    private Point aXG = new Point();
    private Point aXI = new Point();
    private Point aXH = new Point();

    public f(long j) {
        this.aXP = j;
    }

    public void a(e eVar) {
        this.aXL = eVar;
    }

    public void a(Point point, Point point2) {
        this.aXG.x = point.x;
        this.aXG.y = point.y;
        this.aXI.x = point.x;
        this.aXI.y = point.y;
        this.aXH.x = point2.x;
        this.aXH.y = point2.y;
        b(point, point2);
        this.startTime = SystemClock.elapsedRealtime();
    }

    private void b(Point point, Point point2) {
        if (point.x == point2.x) {
            this.aXO = Math.abs(point2.y - point.y) / ((float) this.aXP);
            if (point2.y > point.y) {
                this.aXM = 0;
            } else {
                this.aXM = 1;
            }
        } else if (point.y == point2.y) {
            this.aXN = Math.abs(point2.x - point.x) / ((float) this.aXP);
            if (point2.x > point.x) {
                this.aXM = 2;
            } else {
                this.aXM = 3;
            }
        } else {
            float f = point2.x - point.x;
            this.k = (point2.y - point.y) / f;
            this.aXN = Math.abs(f) / ((float) this.aXP);
            if (f > 0.0f) {
                this.aXM = 5;
            } else {
                this.aXM = 4;
            }
        }
    }

    private int fG(int i) {
        return (int) (((this.k * i) + this.aXG.y) - (this.k * this.aXG.x));
    }

    private long Nw() {
        return SystemClock.elapsedRealtime() - this.startTime;
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
        this.aXI.y = (int) (this.aXG.y + (this.aXO * ((float) Nw())));
        if (this.aXI.y > this.aXH.y) {
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nr() {
        this.aXI.x = (int) (this.aXG.x + (this.aXN * ((float) Nw())));
        if (this.aXI.x > this.aXH.x) {
            this.aXI.x = this.aXH.x;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Ns() {
        this.aXI.y = (int) (this.aXG.y - (this.aXO * ((float) Nw())));
        if (this.aXI.y < this.aXH.y) {
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nt() {
        this.aXI.x = (int) (this.aXG.x - (this.aXN * ((float) Nw())));
        if (this.aXI.x < this.aXH.x) {
            this.aXI.x = this.aXH.x;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nu() {
        boolean z = true;
        this.aXI.x = (int) (this.aXG.x - (this.aXN * ((float) Nw())));
        this.aXI.y = fG(this.aXI.x);
        if (this.aXG.y <= this.aXH.y ? this.aXI.y <= this.aXH.y : this.aXI.y >= this.aXH.y) {
            z = false;
        }
        if (this.aXI.x < this.aXH.x || z) {
            this.aXI.x = this.aXH.x;
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }

    private void Nv() {
        boolean z = true;
        this.aXI.x = (int) (this.aXG.x + (this.aXN * ((float) Nw())));
        this.aXI.y = fG(this.aXI.x);
        if (this.aXG.y <= this.aXH.y ? this.aXI.y <= this.aXH.y : this.aXI.y >= this.aXH.y) {
            z = false;
        }
        if (this.aXI.x > this.aXH.x || z) {
            this.aXI.x = this.aXH.x;
            this.aXI.y = this.aXH.y;
        }
        if (this.aXL != null) {
            this.aXL.a(this.aXI);
        }
    }
}
