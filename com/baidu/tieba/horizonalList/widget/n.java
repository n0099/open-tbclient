package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class n {
    private static float cGx = 8.0f;
    private static float cGy;
    private final a cGu;
    private final a cGv;
    private final boolean cGw;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cGy = 1.0f;
        cGy = 1.0f / T(1.0f);
    }

    public n(Context context) {
        this(context, null);
    }

    public static float T(float f) {
        float exp;
        float f2 = cGx * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cGy;
    }

    public n(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public n(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cGw = z;
        this.cGu = new a(context);
        this.cGv = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cGu.setFriction(f);
        this.cGv.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cGu.cGG && this.cGv.cGG;
    }

    public final int getCurrX() {
        return this.cGu.cGz;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cGu.cGC * this.cGu.cGC) + (this.cGv.cGC * this.cGv.cGC));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cGu.mStartTime;
                int i = this.cGu.Ij;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = T(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cGu.U(interpolation);
                    this.cGv.U(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cGu.cGG && !this.cGu.ajX() && !this.cGu.ajW()) {
                    this.cGu.finish();
                }
                if (!this.cGv.cGG && !this.cGv.ajX() && !this.cGv.ajW()) {
                    this.cGv.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cGu.B(i, i3, i5);
        this.cGv.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cGu.C(i, i3, i4) || this.cGv.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cGw && !isFinished()) {
            float f = this.cGu.cGC;
            float f2 = this.cGv.cGC;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cGu.f(i, i11, i5, i6, i9);
                this.cGv.f(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cGu.f(i, i11, i5, i6, i9);
        this.cGv.f(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cGu.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cGu.finish();
        this.cGv.finish();
    }

    public boolean h(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cGu.cGA - this.cGu.mStart)) && Math.signum(f2) == Math.signum((float) (this.cGv.cGA - this.cGv.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cGK = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cGL = new float[101];
        private static final float[] cGM = new float[101];
        private int Ij;
        private int cGA;
        private int cGB;
        private float cGC;
        private float cGD;
        private int cGE;
        private int cGF;
        private int cGH;
        private float cGJ;
        private int cGz;
        private int mStart;
        private long mStartTime;
        private float cGI = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cGG = true;

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
                cGL[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cGM[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cGL;
            cGM[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cGI = f;
        }

        a(Context context) {
            this.cGJ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void U(float f) {
            this.cGz = this.mStart + Math.round((this.cGA - this.mStart) * f);
        }

        private static float kP(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cGM[i4];
                this.Ij = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cGM[i4 + 1] - f2)) + f2) * this.Ij);
            }
        }

        void B(int i, int i2, int i3) {
            this.cGG = false;
            this.mStart = i;
            this.cGA = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ij = i3;
            this.cGD = 0.0f;
            this.cGB = 0;
        }

        void finish() {
            this.cGz = this.cGA;
            this.cGG = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cGG = true;
            this.cGA = i;
            this.mStart = i;
            this.cGB = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ij = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cGG;
        }

        private void D(int i, int i2, int i3) {
            this.cGG = false;
            this.mState = 1;
            this.mStart = i;
            this.cGA = i2;
            int i4 = i - i2;
            this.cGD = kP(i4);
            this.cGB = -i4;
            this.cGH = Math.abs(i4);
            this.Ij = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cGD));
        }

        void f(int i, int i2, int i3, int i4, int i5) {
            this.cGH = i5;
            this.cGG = false;
            this.cGB = i2;
            this.cGC = i2;
            this.cGE = 0;
            this.Ij = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cGz = i;
            if (i > i4 || i < i3) {
                j(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kS = kS(i2);
                this.cGE = kS;
                this.Ij = kS;
                d = kR(i2);
            }
            this.cGF = (int) (d * Math.signum(i2));
            this.cGA = this.cGF + i;
            if (this.cGA < i3) {
                A(this.mStart, this.cGA, i3);
                this.cGA = i3;
            }
            if (this.cGA > i4) {
                A(this.mStart, this.cGA, i4);
                this.cGA = i4;
            }
        }

        private double kQ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cGI * this.cGJ));
        }

        private double kR(int i) {
            return Math.exp(kQ(i) * (cGK / (cGK - 1.0d))) * this.cGI * this.cGJ;
        }

        private int kS(int i) {
            return (int) (Math.exp(kQ(i) / (cGK - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cGD;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cGD)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cGD));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cGB = (int) ((-this.cGD) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cGD = kP(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            ajV();
        }

        private void j(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cGG = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kR(i4) > Math.abs(i6)) {
                f(i, i4, z ? i2 : i, z ? i : i3, this.cGH);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cGH = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                j(i, i2, i2, (int) this.cGC);
            }
        }

        private void ajV() {
            float abs = (this.cGB * this.cGB) / (Math.abs(this.cGD) * 2.0f);
            float signum = Math.signum(this.cGB);
            if (abs > this.cGH) {
                this.cGD = (((-signum) * this.cGB) * this.cGB) / (this.cGH * 2.0f);
                abs = this.cGH;
            }
            this.cGH = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cGB <= 0) {
                abs = -abs;
            }
            this.cGA = ((int) abs) + i;
            this.Ij = -((int) ((1000.0f * this.cGB) / this.cGD));
        }

        boolean ajW() {
            switch (this.mState) {
                case 0:
                    if (this.Ij < this.cGE) {
                        this.mStart = this.cGA;
                        this.cGB = (int) this.cGC;
                        this.cGD = kP(this.cGB);
                        this.mStartTime += this.Ij;
                        ajV();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Ij;
                    D(this.cGA, this.mStart, 0);
                    break;
            }
            ajX();
            return true;
        }

        boolean ajX() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Ij) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cGE;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cGL[i];
                        f3 = (cGL[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cGC = ((f3 * this.cGF) / this.cGE) * 1000.0f;
                    d = f2 * this.cGF;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Ij;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cGB);
                    d = this.cGH * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cGC = ((-f6) + f7) * signum * this.cGH * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cGC = this.cGB + (this.cGD * f8);
                    d = ((f8 * (this.cGD * f8)) / 2.0f) + (this.cGB * f8);
                    break;
            }
            this.cGz = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
