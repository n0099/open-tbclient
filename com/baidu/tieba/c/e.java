package com.baidu.tieba.c;

import android.support.annotation.FloatRange;
import android.support.annotation.RestrictTo;
import com.baidu.tieba.c.b;
/* loaded from: classes.dex */
public final class e {
    private double hQA;
    private double hQB;
    private final b.a hQC;
    double hQu;
    double hQv;
    private double hQw;
    private double hQx;
    private double hQy;
    private double hQz;
    private boolean mInitialized;

    public e() {
        this.hQu = Math.sqrt(1500.0d);
        this.hQv = 0.5d;
        this.mInitialized = false;
        this.hQB = Double.MAX_VALUE;
        this.hQC = new b.a();
    }

    public e(float f) {
        this.hQu = Math.sqrt(1500.0d);
        this.hQv = 0.5d;
        this.mInitialized = false;
        this.hQB = Double.MAX_VALUE;
        this.hQC = new b.a();
        this.hQB = f;
    }

    public e az(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.hQu = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aA(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.hQv = f;
        this.mInitialized = false;
        return this;
    }

    public e aB(float f) {
        this.hQB = f;
        return this;
    }

    public float cmk() {
        return (float) this.hQB;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean C(float f, float f2) {
        return ((double) Math.abs(f2)) < this.hQx && ((double) Math.abs(f - cmk())) < this.hQw;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.hQB == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.hQv > 1.0d) {
                this.hQy = ((-this.hQv) * this.hQu) + (this.hQu * Math.sqrt((this.hQv * this.hQv) - 1.0d));
                this.hQz = ((-this.hQv) * this.hQu) - (this.hQu * Math.sqrt((this.hQv * this.hQv) - 1.0d));
            } else if (this.hQv >= 0.0d && this.hQv < 1.0d) {
                this.hQA = this.hQu * Math.sqrt(1.0d - (this.hQv * this.hQv));
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
        double d4 = d - this.hQB;
        if (this.hQv > 1.0d) {
            double d5 = d4 - (((this.hQz * d4) - d2) / (this.hQz - this.hQy));
            double d6 = ((this.hQz * d4) - d2) / (this.hQz - this.hQy);
            pow = (Math.pow(2.718281828459045d, this.hQz * d3) * d5) + (Math.pow(2.718281828459045d, this.hQy * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.hQy) * d6 * this.hQy) + (d5 * this.hQz * Math.pow(2.718281828459045d, this.hQz * d3));
        } else if (this.hQv == 1.0d) {
            double d7 = d2 + (this.hQu * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.hQu) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.hQu)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.hQu) * d3) * (-this.hQu));
        } else {
            double d8 = ((this.hQv * this.hQu * d4) + d2) * (1.0d / this.hQA);
            pow = Math.pow(2.718281828459045d, (-this.hQv) * this.hQu * d3) * ((Math.cos(this.hQA * d3) * d4) + (Math.sin(this.hQA * d3) * d8));
            cos = (((Math.cos(d3 * this.hQA) * d8 * this.hQA) + (d4 * (-this.hQA) * Math.sin(this.hQA * d3))) * Math.pow(2.718281828459045d, (-this.hQv) * this.hQu * d3)) + ((-this.hQu) * pow * this.hQv);
        }
        this.hQC.mValue = (float) (pow + this.hQB);
        this.hQC.hQk = (float) cos;
        return this.hQC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(double d) {
        this.hQw = Math.abs(d);
        this.hQx = this.hQw * 62.5d;
    }
}
