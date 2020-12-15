package com.baidu.tieba.c;

import android.support.annotation.FloatRange;
import android.support.annotation.RestrictTo;
import com.baidu.tieba.c.b;
/* loaded from: classes.dex */
public final class e {
    double ibq;
    double ibr;
    private double ibs;
    private double ibt;
    private double ibu;
    private double ibv;
    private double ibw;
    private double ibx;
    private final b.a iby;
    private boolean mInitialized;

    public e() {
        this.ibq = Math.sqrt(1500.0d);
        this.ibr = 0.5d;
        this.mInitialized = false;
        this.ibx = Double.MAX_VALUE;
        this.iby = new b.a();
    }

    public e(float f) {
        this.ibq = Math.sqrt(1500.0d);
        this.ibr = 0.5d;
        this.mInitialized = false;
        this.ibx = Double.MAX_VALUE;
        this.iby = new b.a();
        this.ibx = f;
    }

    public e aA(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.ibq = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aB(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.ibr = f;
        this.mInitialized = false;
        return this;
    }

    public e aC(float f) {
        this.ibx = f;
        return this;
    }

    public float cqy() {
        return (float) this.ibx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean C(float f, float f2) {
        return ((double) Math.abs(f2)) < this.ibt && ((double) Math.abs(f - cqy())) < this.ibs;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.ibx == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.ibr > 1.0d) {
                this.ibu = ((-this.ibr) * this.ibq) + (this.ibq * Math.sqrt((this.ibr * this.ibr) - 1.0d));
                this.ibv = ((-this.ibr) * this.ibq) - (this.ibq * Math.sqrt((this.ibr * this.ibr) - 1.0d));
            } else if (this.ibr >= 0.0d && this.ibr < 1.0d) {
                this.ibw = this.ibq * Math.sqrt(1.0d - (this.ibr * this.ibr));
            }
            this.mInitialized = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.a a(double d, double d2, long j) {
        double pow;
        double cos;
        init();
        double d3 = j / 1000.0d;
        double d4 = d - this.ibx;
        if (this.ibr > 1.0d) {
            double d5 = d4 - (((this.ibv * d4) - d2) / (this.ibv - this.ibu));
            double d6 = ((this.ibv * d4) - d2) / (this.ibv - this.ibu);
            pow = (Math.pow(2.718281828459045d, this.ibv * d3) * d5) + (Math.pow(2.718281828459045d, this.ibu * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.ibu) * d6 * this.ibu) + (d5 * this.ibv * Math.pow(2.718281828459045d, this.ibv * d3));
        } else if (this.ibr == 1.0d) {
            double d7 = d2 + (this.ibq * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.ibq) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.ibq)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.ibq) * d3) * (-this.ibq));
        } else {
            double d8 = ((this.ibr * this.ibq * d4) + d2) * (1.0d / this.ibw);
            pow = Math.pow(2.718281828459045d, (-this.ibr) * this.ibq * d3) * ((Math.cos(this.ibw * d3) * d4) + (Math.sin(this.ibw * d3) * d8));
            cos = (((Math.cos(d3 * this.ibw) * d8 * this.ibw) + (d4 * (-this.ibw) * Math.sin(this.ibw * d3))) * Math.pow(2.718281828459045d, (-this.ibr) * this.ibq * d3)) + ((-this.ibq) * pow * this.ibr);
        }
        this.iby.mValue = (float) (pow + this.ibx);
        this.iby.ibd = (float) cos;
        return this.iby;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(double d) {
        this.ibs = Math.abs(d);
        this.ibt = this.ibs * 62.5d;
    }
}
