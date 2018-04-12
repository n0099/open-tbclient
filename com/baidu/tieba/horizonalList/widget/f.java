package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float dHF = 8.0f;
    private static float dHG;
    private final a dHC;
    private final a dHD;
    private final boolean dHE;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dHG = 1.0f;
        dHG = 1.0f / ab(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float ab(float f) {
        float exp;
        float f2 = dHF * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dHG;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dHE = z;
        this.dHC = new a(context);
        this.dHD = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dHC.setFriction(f);
        this.dHD.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dHC.mFinished && this.dHD.mFinished;
    }

    public final int getCurrX() {
        return this.dHC.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.dHC.dHJ * this.dHC.dHJ) + (this.dHD.dHJ * this.dHD.dHJ));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dHC.mStartTime;
                int i = this.dHC.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ab(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dHC.ac(interpolation);
                    this.dHD.ac(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dHC.mFinished && !this.dHC.update() && !this.dHC.ayx()) {
                    this.dHC.finish();
                }
                if (!this.dHD.mFinished && !this.dHD.update() && !this.dHD.ayx()) {
                    this.dHD.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dHC.G(i, i3, i5);
        this.dHD.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dHC.H(i, i3, i4) || this.dHD.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dHE && !isFinished()) {
            float f = this.dHC.dHJ;
            float f2 = this.dHD.dHJ;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dHC.a(i, i11, i5, i6, i9);
                this.dHD.a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dHC.a(i, i11, i5, i6, i9);
        this.dHD.a(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dHC.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.dHC.finish();
        this.dHD.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dHC.dHH - this.dHC.mStart)) && Math.signum(f2) == Math.signum((float) (this.dHD.dHH - this.dHD.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dHQ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dHR = new float[101];
        private static final float[] dHS = new float[101];
        private int dHH;
        private int dHI;
        private float dHJ;
        private float dHK;
        private int dHL;
        private int dHM;
        private int dHN;
        private float dHP;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dHO = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

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
                dHR[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dHS[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dHR;
            dHS[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dHO = f;
        }

        a(Context context) {
            this.dHP = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ac(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.dHH - this.mStart) * f);
        }

        private static float mE(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dHS[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dHS[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.dHH = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dHK = 0.0f;
            this.dHI = 0;
        }

        void finish() {
            this.mCurrentPosition = this.dHH;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.dHH = i;
            this.mStart = i;
            this.dHI = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                I(i, i2, 0);
            } else if (i > i3) {
                I(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void I(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.dHH = i2;
            int i4 = i - i2;
            this.dHK = mE(i4);
            this.dHI = -i4;
            this.dHN = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dHK) * 1000.0d);
        }

        void a(int i, int i2, int i3, int i4, int i5) {
            this.dHN = i5;
            this.mFinished = false;
            this.dHI = i2;
            this.dHJ = i2;
            this.dHL = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                t(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int mH = mH(i2);
                this.dHL = mH;
                this.mDuration = mH;
                d = mG(i2);
            }
            this.dHM = (int) (d * Math.signum(i2));
            this.dHH = this.dHM + i;
            if (this.dHH < i3) {
                F(this.mStart, this.dHH, i3);
                this.dHH = i3;
            }
            if (this.dHH > i4) {
                F(this.mStart, this.dHH, i4);
                this.dHH = i4;
            }
        }

        private double mF(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dHO * this.dHP));
        }

        private double mG(int i) {
            return Math.exp(mF(i) * (dHQ / (dHQ - 1.0d))) * this.dHO * this.dHP;
        }

        private int mH(int i) {
            return (int) (Math.exp(mF(i) / (dHQ - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.dHK;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dHK)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dHK));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dHI = (int) ((-this.dHK) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.dHK = mE(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            ayw();
        }

        private void t(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                K(i, i5, i4);
            } else if (mG(i4) > Math.abs(i6)) {
                a(i, i4, z ? i2 : i, z ? i : i3, this.dHN);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dHN = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.dHJ);
            }
        }

        private void ayw() {
            float abs = (this.dHI * this.dHI) / (Math.abs(this.dHK) * 2.0f);
            float signum = Math.signum(this.dHI);
            if (abs > this.dHN) {
                this.dHK = (((-signum) * this.dHI) * this.dHI) / (this.dHN * 2.0f);
                abs = this.dHN;
            }
            this.dHN = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dHI <= 0) {
                abs = -abs;
            }
            this.dHH = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dHI) / this.dHK));
        }

        boolean ayx() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dHL) {
                        this.mStart = this.dHH;
                        this.dHI = (int) this.dHJ;
                        this.dHK = mE(this.dHI);
                        this.mStartTime += this.mDuration;
                        ayw();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    I(this.dHH, this.mStart, 0);
                    break;
            }
            update();
            return true;
        }

        boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.dHL;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dHR[i];
                        f3 = (dHR[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dHJ = ((f3 * this.dHM) / this.dHL) * 1000.0f;
                    d = f2 * this.dHM;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dHI);
                    d = this.dHN * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dHJ = ((-f6) + f7) * signum * this.dHN * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dHJ = this.dHI + (this.dHK * f8);
                    d = ((f8 * (this.dHK * f8)) / 2.0f) + (this.dHI * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
