package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float dlF = 8.0f;
    private static float dlG;
    private final a dlC;
    private final a dlD;
    private final boolean dlE;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dlG = 1.0f;
        dlG = 1.0f / R(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float R(float f) {
        float exp;
        float f2 = dlF * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dlG;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dlE = z;
        this.dlC = new a(context);
        this.dlD = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dlC.setFriction(f);
        this.dlD.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dlC.dlN && this.dlD.dlN;
    }

    public final int getCurrX() {
        return this.dlC.cKd;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dlC.dlJ * this.dlC.dlJ) + (this.dlD.dlJ * this.dlD.dlJ));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dlC.mStartTime;
                int i = this.dlC.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = R(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dlC.S(interpolation);
                    this.dlD.S(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dlC.dlN && !this.dlC.asT() && !this.dlC.asS()) {
                    this.dlC.finish();
                }
                if (!this.dlD.dlN && !this.dlD.asT() && !this.dlD.asS()) {
                    this.dlD.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dlC.J(i, i3, i5);
        this.dlD.J(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dlC.K(i, i3, i4) || this.dlD.K(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dlE && !isFinished()) {
            float f = this.dlC.dlJ;
            float f2 = this.dlD.dlJ;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dlC.c(i, i11, i5, i6, i9);
                this.dlD.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dlC.c(i, i11, i5, i6, i9);
        this.dlD.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dlC.O(i, i2, i3);
    }

    public void abortAnimation() {
        this.dlC.finish();
        this.dlD.finish();
    }

    public boolean k(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dlC.dlH - this.dlC.mStart)) && Math.signum(f2) == Math.signum((float) (this.dlD.dlH - this.dlD.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dlR = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dlS = new float[101];
        private static final float[] dlT = new float[101];
        private int cKd;
        private int dlH;
        private int dlI;
        private float dlJ;
        private float dlK;
        private int dlL;
        private int dlM;
        private int dlO;
        private float dlQ;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dlP = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dlN = true;

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
                dlS[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dlT[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dlS;
            dlT[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dlP = f;
        }

        a(Context context) {
            this.dlQ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void S(float f) {
            this.cKd = this.mStart + Math.round((this.dlH - this.mStart) * f);
        }

        private static float lY(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void I(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dlT[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dlT[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void J(int i, int i2, int i3) {
            this.dlN = false;
            this.mStart = i;
            this.dlH = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dlK = 0.0f;
            this.dlI = 0;
        }

        void finish() {
            this.cKd = this.dlH;
            this.dlN = true;
        }

        boolean K(int i, int i2, int i3) {
            this.dlN = true;
            this.dlH = i;
            this.mStart = i;
            this.dlI = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                L(i, i2, 0);
            } else if (i > i3) {
                L(i, i3, 0);
            }
            return !this.dlN;
        }

        private void L(int i, int i2, int i3) {
            this.dlN = false;
            this.mState = 1;
            this.mStart = i;
            this.dlH = i2;
            int i4 = i - i2;
            this.dlK = lY(i4);
            this.dlI = -i4;
            this.dlO = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dlK) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.dlO = i5;
            this.dlN = false;
            this.dlI = i2;
            this.dlJ = i2;
            this.dlL = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cKd = i;
            if (i > i4 || i < i3) {
                s(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int mb = mb(i2);
                this.dlL = mb;
                this.mDuration = mb;
                d = ma(i2);
            }
            this.dlM = (int) (d * Math.signum(i2));
            this.dlH = this.dlM + i;
            if (this.dlH < i3) {
                I(this.mStart, this.dlH, i3);
                this.dlH = i3;
            }
            if (this.dlH > i4) {
                I(this.mStart, this.dlH, i4);
                this.dlH = i4;
            }
        }

        private double lZ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dlP * this.dlQ));
        }

        private double ma(int i) {
            return Math.exp(lZ(i) * (dlR / (dlR - 1.0d))) * this.dlP * this.dlQ;
        }

        private int mb(int i) {
            return (int) (Math.exp(lZ(i) / (dlR - 1.0d)) * 1000.0d);
        }

        private void M(int i, int i2, int i3) {
            float f = (-i3) / this.dlK;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dlK)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dlK));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dlI = (int) ((-this.dlK) * sqrt);
        }

        private void N(int i, int i2, int i3) {
            this.dlK = lY(i3 == 0 ? i - i2 : i3);
            M(i, i2, i3);
            asR();
        }

        private void s(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dlN = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                N(i, i5, i4);
            } else if (ma(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.dlO);
            } else {
                L(i, i5, i4);
            }
        }

        void O(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dlO = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.dlJ);
            }
        }

        private void asR() {
            float abs = (this.dlI * this.dlI) / (Math.abs(this.dlK) * 2.0f);
            float signum = Math.signum(this.dlI);
            if (abs > this.dlO) {
                this.dlK = (((-signum) * this.dlI) * this.dlI) / (this.dlO * 2.0f);
                abs = this.dlO;
            }
            this.dlO = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dlI <= 0) {
                abs = -abs;
            }
            this.dlH = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dlI) / this.dlK));
        }

        boolean asS() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dlL) {
                        this.mStart = this.dlH;
                        this.dlI = (int) this.dlJ;
                        this.dlK = lY(this.dlI);
                        this.mStartTime += this.mDuration;
                        asR();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    L(this.dlH, this.mStart, 0);
                    break;
            }
            asT();
            return true;
        }

        boolean asT() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.dlL;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dlS[i];
                        f3 = (dlS[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dlJ = ((f3 * this.dlM) / this.dlL) * 1000.0f;
                    d = f2 * this.dlM;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dlI);
                    d = this.dlO * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dlJ = ((-f6) + f7) * signum * this.dlO * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dlJ = this.dlI + (this.dlK * f8);
                    d = ((f8 * (this.dlK * f8)) / 2.0f) + (this.dlI * f8);
                    break;
            }
            this.cKd = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
