package com.baidu.tieba.b;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class e {
    double ioP;
    double ioQ;
    private double ioR;
    private double ioS;
    private double ioT;
    private double ioU;
    private double ioV;
    private double ioW;
    private final b.a ioX;
    private boolean mInitialized;

    public e() {
        this.ioP = Math.sqrt(1500.0d);
        this.ioQ = 0.5d;
        this.mInitialized = false;
        this.ioW = Double.MAX_VALUE;
        this.ioX = new b.a();
    }

    public e(float f) {
        this.ioP = Math.sqrt(1500.0d);
        this.ioQ = 0.5d;
        this.mInitialized = false;
        this.ioW = Double.MAX_VALUE;
        this.ioX = new b.a();
        this.ioW = f;
    }

    public e aF(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.ioP = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aG(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.ioQ = f;
        this.mInitialized = false;
        return this;
    }

    public e aH(float f) {
        this.ioW = f;
        return this;
    }

    public float cqK() {
        return (float) this.ioW;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean D(float f, float f2) {
        return ((double) Math.abs(f2)) < this.ioS && ((double) Math.abs(f - cqK())) < this.ioR;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.ioW == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.ioQ > 1.0d) {
                this.ioT = ((-this.ioQ) * this.ioP) + (this.ioP * Math.sqrt((this.ioQ * this.ioQ) - 1.0d));
                this.ioU = ((-this.ioQ) * this.ioP) - (this.ioP * Math.sqrt((this.ioQ * this.ioQ) - 1.0d));
            } else if (this.ioQ >= 0.0d && this.ioQ < 1.0d) {
                this.ioV = this.ioP * Math.sqrt(1.0d - (this.ioQ * this.ioQ));
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
        double d4 = d - this.ioW;
        if (this.ioQ > 1.0d) {
            double d5 = d4 - (((this.ioU * d4) - d2) / (this.ioU - this.ioT));
            double d6 = ((this.ioU * d4) - d2) / (this.ioU - this.ioT);
            pow = (Math.pow(2.718281828459045d, this.ioU * d3) * d5) + (Math.pow(2.718281828459045d, this.ioT * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.ioT) * d6 * this.ioT) + (d5 * this.ioU * Math.pow(2.718281828459045d, this.ioU * d3));
        } else if (this.ioQ == 1.0d) {
            double d7 = d2 + (this.ioP * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.ioP) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.ioP)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.ioP) * d3) * (-this.ioP));
        } else {
            double d8 = ((this.ioQ * this.ioP * d4) + d2) * (1.0d / this.ioV);
            pow = Math.pow(2.718281828459045d, (-this.ioQ) * this.ioP * d3) * ((Math.cos(this.ioV * d3) * d4) + (Math.sin(this.ioV * d3) * d8));
            cos = (((Math.cos(d3 * this.ioV) * d8 * this.ioV) + (d4 * (-this.ioV) * Math.sin(this.ioV * d3))) * Math.pow(2.718281828459045d, (-this.ioQ) * this.ioP * d3)) + ((-this.ioP) * pow * this.ioQ);
        }
        this.ioX.mValue = (float) (pow + this.ioW);
        this.ioX.ioC = (float) cos;
        return this.ioX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(double d) {
        this.ioR = Math.abs(d);
        this.ioS = this.ioR * 62.5d;
    }
}
