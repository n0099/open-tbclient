package com.baidu.tieba.b;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class e {
    double ijh;
    double iji;
    private double ijj;
    private double ijk;
    private double ijl;
    private double ijm;
    private double ijn;
    private double ijo;
    private final b.a ijp;
    private boolean mInitialized;

    public e() {
        this.ijh = Math.sqrt(1500.0d);
        this.iji = 0.5d;
        this.mInitialized = false;
        this.ijo = Double.MAX_VALUE;
        this.ijp = new b.a();
    }

    public e(float f) {
        this.ijh = Math.sqrt(1500.0d);
        this.iji = 0.5d;
        this.mInitialized = false;
        this.ijo = Double.MAX_VALUE;
        this.ijp = new b.a();
        this.ijo = f;
    }

    public e aC(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.ijh = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public e aD(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.iji = f;
        this.mInitialized = false;
        return this;
    }

    public e aE(float f) {
        this.ijo = f;
        return this;
    }

    public float cpA() {
        return (float) this.ijo;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean D(float f, float f2) {
        return ((double) Math.abs(f2)) < this.ijk && ((double) Math.abs(f - cpA())) < this.ijj;
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.ijo == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            if (this.iji > 1.0d) {
                this.ijl = ((-this.iji) * this.ijh) + (this.ijh * Math.sqrt((this.iji * this.iji) - 1.0d));
                this.ijm = ((-this.iji) * this.ijh) - (this.ijh * Math.sqrt((this.iji * this.iji) - 1.0d));
            } else if (this.iji >= 0.0d && this.iji < 1.0d) {
                this.ijn = this.ijh * Math.sqrt(1.0d - (this.iji * this.iji));
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
        double d4 = d - this.ijo;
        if (this.iji > 1.0d) {
            double d5 = d4 - (((this.ijm * d4) - d2) / (this.ijm - this.ijl));
            double d6 = ((this.ijm * d4) - d2) / (this.ijm - this.ijl);
            pow = (Math.pow(2.718281828459045d, this.ijm * d3) * d5) + (Math.pow(2.718281828459045d, this.ijl * d3) * d6);
            cos = (Math.pow(2.718281828459045d, d3 * this.ijl) * d6 * this.ijl) + (d5 * this.ijm * Math.pow(2.718281828459045d, this.ijm * d3));
        } else if (this.iji == 1.0d) {
            double d7 = d2 + (this.ijh * d4);
            pow = ((d7 * d3) + d4) * Math.pow(2.718281828459045d, (-this.ijh) * d3);
            cos = (Math.pow(2.718281828459045d, d3 * (-this.ijh)) * d7) + ((d4 + (d7 * d3)) * Math.pow(2.718281828459045d, (-this.ijh) * d3) * (-this.ijh));
        } else {
            double d8 = ((this.iji * this.ijh * d4) + d2) * (1.0d / this.ijn);
            pow = Math.pow(2.718281828459045d, (-this.iji) * this.ijh * d3) * ((Math.cos(this.ijn * d3) * d4) + (Math.sin(this.ijn * d3) * d8));
            cos = (((Math.cos(d3 * this.ijn) * d8 * this.ijn) + (d4 * (-this.ijn) * Math.sin(this.ijn * d3))) * Math.pow(2.718281828459045d, (-this.iji) * this.ijh * d3)) + ((-this.ijh) * pow * this.iji);
        }
        this.ijp.mValue = (float) (pow + this.ijo);
        this.ijp.iiU = (float) cos;
        return this.ijp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(double d) {
        this.ijj = Math.abs(d);
        this.ijk = this.ijj * 62.5d;
    }
}
