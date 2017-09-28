package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float def = 8.0f;
    private static float deg;
    private final a dec;
    private final a ded;
    private final boolean dee;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        deg = 1.0f;
        deg = 1.0f / R(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float R(float f) {
        float exp;
        float f2 = def * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * deg;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dee = z;
        this.dec = new a(context);
        this.ded = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dec.setFriction(f);
        this.ded.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dec.den && this.ded.den;
    }

    public final int getCurrX() {
        return this.dec.cCz;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dec.dej * this.dec.dej) + (this.ded.dej * this.ded.dej));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dec.mStartTime;
                int i = this.dec.HU;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = R(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dec.S(interpolation);
                    this.ded.S(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dec.den && !this.dec.aqC() && !this.dec.aqB()) {
                    this.dec.finish();
                }
                if (!this.ded.den && !this.ded.aqC() && !this.ded.aqB()) {
                    this.ded.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dec.G(i, i3, i5);
        this.ded.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dec.H(i, i3, i4) || this.ded.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dee && !isFinished()) {
            float f = this.dec.dej;
            float f2 = this.ded.dej;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dec.c(i, i11, i5, i6, i9);
                this.ded.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dec.c(i, i11, i5, i6, i9);
        this.ded.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dec.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.dec.finish();
        this.ded.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dec.deh - this.dec.mStart)) && Math.signum(f2) == Math.signum((float) (this.ded.deh - this.ded.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float der = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] det = new float[101];
        private static final float[] deu = new float[101];
        private int HU;
        private int cCz;
        private int deh;
        private int dei;
        private float dej;
        private float dek;
        private int del;
        private int dem;
        private int deo;
        private float deq;
        private int mStart;
        private long mStartTime;
        private float dep = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean den = true;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5 = 0.0f;
            int i = 0;
            float f6 = 0.0f;
            while (i < 100) {
                float f7 = i / 100.0f;
                float f8 = 1.0f;
                float f9 = f6;
                while (true) {
                    f = ((f8 - f9) / 2.0f) + f9;
                    f2 = 3.0f * f * (1.0f - f);
                    float f10 = ((((1.0f - f) * 0.175f) + (0.35000002f * f)) * f2) + (f * f * f);
                    if (Math.abs(f10 - f7) < 1.0E-5d) {
                        break;
                    } else if (f10 > f7) {
                        f8 = f;
                    } else {
                        f9 = f;
                    }
                }
                det[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
                float f11 = 1.0f;
                while (true) {
                    f3 = ((f11 - f5) / 2.0f) + f5;
                    f4 = 3.0f * f3 * (1.0f - f3);
                    float f12 = ((((1.0f - f3) * 0.5f) + f3) * f4) + (f3 * f3 * f3);
                    if (Math.abs(f12 - f7) < 1.0E-5d) {
                        break;
                    } else if (f12 > f7) {
                        f11 = f3;
                    } else {
                        f5 = f3;
                    }
                }
                deu[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = det;
            deu[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dep = f;
        }

        a(Context context) {
            this.deq = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void S(float f) {
            this.cCz = this.mStart + Math.round((this.deh - this.mStart) * f);
        }

        private static float lI(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = deu[i4];
                this.HU = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (deu[i4 + 1] - f2)) + f2) * this.HU);
            }
        }

        void G(int i, int i2, int i3) {
            this.den = false;
            this.mStart = i;
            this.deh = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HU = i3;
            this.dek = 0.0f;
            this.dei = 0;
        }

        void finish() {
            this.cCz = this.deh;
            this.den = true;
        }

        boolean H(int i, int i2, int i3) {
            this.den = true;
            this.deh = i;
            this.mStart = i;
            this.dei = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HU = 0;
            if (i < i2) {
                I(i, i2, 0);
            } else if (i > i3) {
                I(i, i3, 0);
            }
            return !this.den;
        }

        private void I(int i, int i2, int i3) {
            this.den = false;
            this.mState = 1;
            this.mStart = i;
            this.deh = i2;
            int i4 = i - i2;
            this.dek = lI(i4);
            this.dei = -i4;
            this.deo = Math.abs(i4);
            this.HU = (int) (Math.sqrt((i4 * (-2.0d)) / this.dek) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.deo = i5;
            this.den = false;
            this.dei = i2;
            this.dej = i2;
            this.del = 0;
            this.HU = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cCz = i;
            if (i > i4 || i < i3) {
                q(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lL = lL(i2);
                this.del = lL;
                this.HU = lL;
                d = lK(i2);
            }
            this.dem = (int) (d * Math.signum(i2));
            this.deh = this.dem + i;
            if (this.deh < i3) {
                F(this.mStart, this.deh, i3);
                this.deh = i3;
            }
            if (this.deh > i4) {
                F(this.mStart, this.deh, i4);
                this.deh = i4;
            }
        }

        private double lJ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dep * this.deq));
        }

        private double lK(int i) {
            return Math.exp(lJ(i) * (der / (der - 1.0d))) * this.dep * this.deq;
        }

        private int lL(int i) {
            return (int) (Math.exp(lJ(i) / (der - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.dek;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dek)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dek));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dei = (int) ((-this.dek) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.dek = lI(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            aqA();
        }

        private void q(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.den = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                K(i, i5, i4);
            } else if (lK(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.deo);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.deo = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                q(i, i2, i2, (int) this.dej);
            }
        }

        private void aqA() {
            float abs = (this.dei * this.dei) / (Math.abs(this.dek) * 2.0f);
            float signum = Math.signum(this.dei);
            if (abs > this.deo) {
                this.dek = (((-signum) * this.dei) * this.dei) / (this.deo * 2.0f);
                abs = this.deo;
            }
            this.deo = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dei <= 0) {
                abs = -abs;
            }
            this.deh = ((int) abs) + i;
            this.HU = -((int) ((1000.0f * this.dei) / this.dek));
        }

        boolean aqB() {
            switch (this.mState) {
                case 0:
                    if (this.HU < this.del) {
                        this.mStart = this.deh;
                        this.dei = (int) this.dej;
                        this.dek = lI(this.dei);
                        this.mStartTime += this.HU;
                        aqA();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.HU;
                    I(this.deh, this.mStart, 0);
                    break;
            }
            aqC();
            return true;
        }

        boolean aqC() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.HU) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.del;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = det[i];
                        f3 = (det[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dej = ((f3 * this.dem) / this.del) * 1000.0f;
                    d = f2 * this.dem;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.HU;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dei);
                    d = this.deo * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dej = ((-f6) + f7) * signum * this.deo * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dej = this.dei + (this.dek * f8);
                    d = ((f8 * (this.dek * f8)) / 2.0f) + (this.dei * f8);
                    break;
            }
            this.cCz = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
