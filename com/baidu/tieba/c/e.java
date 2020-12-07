package com.baidu.tieba.c;

import android.support.annotation.FloatRange;
import android.support.annotation.RestrictTo;
import com.baidu.tieba.c.b;
/* loaded from: classes.dex */
public final class e {
    double ibo;
    double ibp;
    private double ibq;
    private double ibr;
    private double ibs;
    private double ibt;
    private double ibu;
    private double ibv;
    private final b.a ibw;
    private boolean mInitialized;

    public e() {
        this.ibo = Math.sqrt(1500.0d);
        this.ibp = 0.5d;
        this.mInitialized = false;
        this.ibv = Double.MAX_VALUE;
        this.ibw = new b.a();
    }

    public e(float f) {
        this.ibo = Math.sqrt(1500.0d);
        this.ibp = 0.5d;
        this.mInitialized = false;
        this.ibv = Double.MAX_VALUE;
        this.ibw = new b.a();
        this.ibv = f;
    }

    public e aA(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.ibo = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aB(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.ibp = f;
        this.mInitialized = false;
        return this;
    }

    public e aC(float f) {
        this.ibv = f;
        return this;
    }

    public float cqx() {
        return (float) this.ibv;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean C(float f, float f2) {
        return ((double) Math.abs(f2)) < this.ibr && ((double) Math.abs(f - cqx())) < this.ibq;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.ibv == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.ibp > 1.0d) {
                this.ibs = ((-this.ibp) * this.ibo) + (this.ibo * Math.sqrt((this.ibp * this.ibp) - 1.0d));
                this.ibt = ((-this.ibp) * this.ibo) - (this.ibo * Math.sqrt((this.ibp * this.ibp) - 1.0d));
            } else if (this.ibp >= 0.0d && this.ibp < 1.0d) {
                this.ibu = this.ibo * Math.sqrt(1.0d - (this.ibp * this.ibp));
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
        double d4 = d - this.ibv;
        if (this.ibp > 1.0d) {
            double d5 = d4 - (((this.ibt * d4) - d2) / (this.ibt - this.ibs));
            double d6 = ((this.ibt * d4) - d2) / (this.ibt - this.ibs);
            pow = (Math.pow(2.718281828459045d, this.ibt * d3) * d5) + (Math.pow(2.718281828459045d, this.ibs * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.ibs) * d6 * this.ibs) + (d5 * this.ibt * Math.pow(2.718281828459045d, this.ibt * d3));
        } else if (this.ibp == 1.0d) {
            double d7 = d2 + (this.ibo * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.ibo) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.ibo)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.ibo) * d3) * (-this.ibo));
        } else {
            double d8 = ((this.ibp * this.ibo * d4) + d2) * (1.0d / this.ibu);
            pow = Math.pow(2.718281828459045d, (-this.ibp) * this.ibo * d3) * ((Math.cos(this.ibu * d3) * d4) + (Math.sin(this.ibu * d3) * d8));
            cos = (((Math.cos(d3 * this.ibu) * d8 * this.ibu) + (d4 * (-this.ibu) * Math.sin(this.ibu * d3))) * Math.pow(2.718281828459045d, (-this.ibp) * this.ibo * d3)) + ((-this.ibo) * pow * this.ibp);
        }
        this.ibw.mValue = (float) (pow + this.ibv);
        this.ibw.ibb = (float) cos;
        return this.ibw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(double d) {
        this.ibq = Math.abs(d);
        this.ibr = this.ibq * 62.5d;
    }
}
