package com.baidu.tieba.b;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class e {
    double iqM;
    double iqN;
    private double iqO;
    private double iqP;
    private double iqQ;
    private double iqR;
    private double iqS;
    private double iqT;
    private final b.a iqU;
    private boolean mInitialized;

    public e() {
        this.iqM = Math.sqrt(1500.0d);
        this.iqN = 0.5d;
        this.mInitialized = false;
        this.iqT = Double.MAX_VALUE;
        this.iqU = new b.a();
    }

    public e(float f) {
        this.iqM = Math.sqrt(1500.0d);
        this.iqN = 0.5d;
        this.mInitialized = false;
        this.iqT = Double.MAX_VALUE;
        this.iqU = new b.a();
        this.iqT = f;
    }

    public e aJ(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.iqM = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aK(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.iqN = f;
        this.mInitialized = false;
        return this;
    }

    public e aL(float f) {
        this.iqT = f;
        return this;
    }

    public float cqX() {
        return (float) this.iqT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean D(float f, float f2) {
        return ((double) Math.abs(f2)) < this.iqP && ((double) Math.abs(f - cqX())) < this.iqO;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.iqT == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.iqN > 1.0d) {
                this.iqQ = ((-this.iqN) * this.iqM) + (this.iqM * Math.sqrt((this.iqN * this.iqN) - 1.0d));
                this.iqR = ((-this.iqN) * this.iqM) - (this.iqM * Math.sqrt((this.iqN * this.iqN) - 1.0d));
            } else if (this.iqN >= 0.0d && this.iqN < 1.0d) {
                this.iqS = this.iqM * Math.sqrt(1.0d - (this.iqN * this.iqN));
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
        double d4 = d - this.iqT;
        if (this.iqN > 1.0d) {
            double d5 = d4 - (((this.iqR * d4) - d2) / (this.iqR - this.iqQ));
            double d6 = ((this.iqR * d4) - d2) / (this.iqR - this.iqQ);
            pow = (Math.pow(2.718281828459045d, this.iqR * d3) * d5) + (Math.pow(2.718281828459045d, this.iqQ * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.iqQ) * d6 * this.iqQ) + (d5 * this.iqR * Math.pow(2.718281828459045d, this.iqR * d3));
        } else if (this.iqN == 1.0d) {
            double d7 = d2 + (this.iqM * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.iqM) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.iqM)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.iqM) * d3) * (-this.iqM));
        } else {
            double d8 = ((this.iqN * this.iqM * d4) + d2) * (1.0d / this.iqS);
            pow = Math.pow(2.718281828459045d, (-this.iqN) * this.iqM * d3) * ((Math.cos(this.iqS * d3) * d4) + (Math.sin(this.iqS * d3) * d8));
            cos = (((Math.cos(d3 * this.iqS) * d8 * this.iqS) + (d4 * (-this.iqS) * Math.sin(this.iqS * d3))) * Math.pow(2.718281828459045d, (-this.iqN) * this.iqM * d3)) + ((-this.iqM) * pow * this.iqN);
        }
        this.iqU.mValue = (float) (pow + this.iqT);
        this.iqU.iqz = (float) cos;
        return this.iqU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(double d) {
        this.iqO = Math.abs(d);
        this.iqP = this.iqO * 62.5d;
    }
}
