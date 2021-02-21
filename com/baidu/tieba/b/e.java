package com.baidu.tieba.b;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class e {
    double ipd;
    double ipe;
    private double ipf;
    private double ipg;
    private double iph;
    private double ipi;
    private double ipj;
    private double ipk;
    private final b.a ipl;
    private boolean mInitialized;

    public e() {
        this.ipd = Math.sqrt(1500.0d);
        this.ipe = 0.5d;
        this.mInitialized = false;
        this.ipk = Double.MAX_VALUE;
        this.ipl = new b.a();
    }

    public e(float f) {
        this.ipd = Math.sqrt(1500.0d);
        this.ipe = 0.5d;
        this.mInitialized = false;
        this.ipk = Double.MAX_VALUE;
        this.ipl = new b.a();
        this.ipk = f;
    }

    public e aF(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.ipd = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aG(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.ipe = f;
        this.mInitialized = false;
        return this;
    }

    public e aH(float f) {
        this.ipk = f;
        return this;
    }

    public float cqR() {
        return (float) this.ipk;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean D(float f, float f2) {
        return ((double) Math.abs(f2)) < this.ipg && ((double) Math.abs(f - cqR())) < this.ipf;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.ipk == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.ipe > 1.0d) {
                this.iph = ((-this.ipe) * this.ipd) + (this.ipd * Math.sqrt((this.ipe * this.ipe) - 1.0d));
                this.ipi = ((-this.ipe) * this.ipd) - (this.ipd * Math.sqrt((this.ipe * this.ipe) - 1.0d));
            } else if (this.ipe >= 0.0d && this.ipe < 1.0d) {
                this.ipj = this.ipd * Math.sqrt(1.0d - (this.ipe * this.ipe));
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
        double d4 = d - this.ipk;
        if (this.ipe > 1.0d) {
            double d5 = d4 - (((this.ipi * d4) - d2) / (this.ipi - this.iph));
            double d6 = ((this.ipi * d4) - d2) / (this.ipi - this.iph);
            pow = (Math.pow(2.718281828459045d, this.ipi * d3) * d5) + (Math.pow(2.718281828459045d, this.iph * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.iph) * d6 * this.iph) + (d5 * this.ipi * Math.pow(2.718281828459045d, this.ipi * d3));
        } else if (this.ipe == 1.0d) {
            double d7 = d2 + (this.ipd * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.ipd) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.ipd)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.ipd) * d3) * (-this.ipd));
        } else {
            double d8 = ((this.ipe * this.ipd * d4) + d2) * (1.0d / this.ipj);
            pow = Math.pow(2.718281828459045d, (-this.ipe) * this.ipd * d3) * ((Math.cos(this.ipj * d3) * d4) + (Math.sin(this.ipj * d3) * d8));
            cos = (((Math.cos(d3 * this.ipj) * d8 * this.ipj) + (d4 * (-this.ipj) * Math.sin(this.ipj * d3))) * Math.pow(2.718281828459045d, (-this.ipe) * this.ipd * d3)) + ((-this.ipd) * pow * this.ipe);
        }
        this.ipl.mValue = (float) (pow + this.ipk);
        this.ipl.ioQ = (float) cos;
        return this.ipl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(double d) {
        this.ipf = Math.abs(d);
        this.ipg = this.ipf * 62.5d;
    }
}
