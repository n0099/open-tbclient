package com.baidu.tieba.b;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class e {
    double inQ;
    double inR;
    private double inS;
    private double inT;
    private double inU;
    private double inV;
    private double inW;
    private double inX;
    private final b.a inY;
    private boolean mInitialized;

    public e() {
        this.inQ = Math.sqrt(1500.0d);
        this.inR = 0.5d;
        this.mInitialized = false;
        this.inX = Double.MAX_VALUE;
        this.inY = new b.a();
    }

    public e(float f) {
        this.inQ = Math.sqrt(1500.0d);
        this.inR = 0.5d;
        this.mInitialized = false;
        this.inX = Double.MAX_VALUE;
        this.inY = new b.a();
        this.inX = f;
    }

    public e aC(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.inQ = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aD(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.inR = f;
        this.mInitialized = false;
        return this;
    }

    public e aE(float f) {
        this.inX = f;
        return this;
    }

    public float cts() {
        return (float) this.inX;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean C(float f, float f2) {
        return ((double) Math.abs(f2)) < this.inT && ((double) Math.abs(f - cts())) < this.inS;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.inX == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.inR > 1.0d) {
                this.inU = ((-this.inR) * this.inQ) + (this.inQ * Math.sqrt((this.inR * this.inR) - 1.0d));
                this.inV = ((-this.inR) * this.inQ) - (this.inQ * Math.sqrt((this.inR * this.inR) - 1.0d));
            } else if (this.inR >= 0.0d && this.inR < 1.0d) {
                this.inW = this.inQ * Math.sqrt(1.0d - (this.inR * this.inR));
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
        double d4 = d - this.inX;
        if (this.inR > 1.0d) {
            double d5 = d4 - (((this.inV * d4) - d2) / (this.inV - this.inU));
            double d6 = ((this.inV * d4) - d2) / (this.inV - this.inU);
            pow = (Math.pow(2.718281828459045d, this.inV * d3) * d5) + (Math.pow(2.718281828459045d, this.inU * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.inU) * d6 * this.inU) + (d5 * this.inV * Math.pow(2.718281828459045d, this.inV * d3));
        } else if (this.inR == 1.0d) {
            double d7 = d2 + (this.inQ * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.inQ) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.inQ)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.inQ) * d3) * (-this.inQ));
        } else {
            double d8 = ((this.inR * this.inQ * d4) + d2) * (1.0d / this.inW);
            pow = Math.pow(2.718281828459045d, (-this.inR) * this.inQ * d3) * ((Math.cos(this.inW * d3) * d4) + (Math.sin(this.inW * d3) * d8));
            cos = (((Math.cos(d3 * this.inW) * d8 * this.inW) + (d4 * (-this.inW) * Math.sin(this.inW * d3))) * Math.pow(2.718281828459045d, (-this.inR) * this.inQ * d3)) + ((-this.inQ) * pow * this.inR);
        }
        this.inY.mValue = (float) (pow + this.inX);
        this.inY.inD = (float) cos;
        return this.inY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(double d) {
        this.inS = Math.abs(d);
        this.inT = this.inS * 62.5d;
    }
}
