package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float dHC = 8.0f;
    private static float dHD;
    private final a dHA;
    private final boolean dHB;
    private final a dHz;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dHD = 1.0f;
        dHD = 1.0f / ab(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float ab(float f) {
        float exp;
        float f2 = dHC * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dHD;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dHB = z;
        this.dHz = new a(context);
        this.dHA = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dHz.setFriction(f);
        this.dHA.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dHz.mFinished && this.dHA.mFinished;
    }

    public final int getCurrX() {
        return this.dHz.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.dHz.dHG * this.dHz.dHG) + (this.dHA.dHG * this.dHA.dHG));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dHz.mStartTime;
                int i = this.dHz.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ab(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dHz.ac(interpolation);
                    this.dHA.ac(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dHz.mFinished && !this.dHz.update() && !this.dHz.ayx()) {
                    this.dHz.finish();
                }
                if (!this.dHA.mFinished && !this.dHA.update() && !this.dHA.ayx()) {
                    this.dHA.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dHz.G(i, i3, i5);
        this.dHA.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dHz.H(i, i3, i4) || this.dHA.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dHB && !isFinished()) {
            float f = this.dHz.dHG;
            float f2 = this.dHA.dHG;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dHz.a(i, i11, i5, i6, i9);
                this.dHA.a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dHz.a(i, i11, i5, i6, i9);
        this.dHA.a(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dHz.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.dHz.finish();
        this.dHA.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dHz.dHE - this.dHz.mStart)) && Math.signum(f2) == Math.signum((float) (this.dHA.dHE - this.dHA.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dHN = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dHO = new float[101];
        private static final float[] dHP = new float[101];
        private int dHE;
        private int dHF;
        private float dHG;
        private float dHH;
        private int dHI;
        private int dHJ;
        private int dHK;
        private float dHM;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dHL = ViewConfiguration.getScrollFriction();
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
                dHO[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dHP[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dHO;
            dHP[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dHL = f;
        }

        a(Context context) {
            this.dHM = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ac(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.dHE - this.mStart) * f);
        }

        private static float mD(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dHP[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dHP[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.dHE = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dHH = 0.0f;
            this.dHF = 0;
        }

        void finish() {
            this.mCurrentPosition = this.dHE;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.dHE = i;
            this.mStart = i;
            this.dHF = 0;
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
            this.dHE = i2;
            int i4 = i - i2;
            this.dHH = mD(i4);
            this.dHF = -i4;
            this.dHK = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dHH) * 1000.0d);
        }

        void a(int i, int i2, int i3, int i4, int i5) {
            this.dHK = i5;
            this.mFinished = false;
            this.dHF = i2;
            this.dHG = i2;
            this.dHI = 0;
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
                int mG = mG(i2);
                this.dHI = mG;
                this.mDuration = mG;
                d = mF(i2);
            }
            this.dHJ = (int) (d * Math.signum(i2));
            this.dHE = this.dHJ + i;
            if (this.dHE < i3) {
                F(this.mStart, this.dHE, i3);
                this.dHE = i3;
            }
            if (this.dHE > i4) {
                F(this.mStart, this.dHE, i4);
                this.dHE = i4;
            }
        }

        private double mE(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dHL * this.dHM));
        }

        private double mF(int i) {
            return Math.exp(mE(i) * (dHN / (dHN - 1.0d))) * this.dHL * this.dHM;
        }

        private int mG(int i) {
            return (int) (Math.exp(mE(i) / (dHN - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.dHH;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dHH)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dHH));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dHF = (int) ((-this.dHH) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.dHH = mD(i3 == 0 ? i - i2 : i3);
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
            } else if (mF(i4) > Math.abs(i6)) {
                a(i, i4, z ? i2 : i, z ? i : i3, this.dHK);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dHK = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.dHG);
            }
        }

        private void ayw() {
            float abs = (this.dHF * this.dHF) / (Math.abs(this.dHH) * 2.0f);
            float signum = Math.signum(this.dHF);
            if (abs > this.dHK) {
                this.dHH = (((-signum) * this.dHF) * this.dHF) / (this.dHK * 2.0f);
                abs = this.dHK;
            }
            this.dHK = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dHF <= 0) {
                abs = -abs;
            }
            this.dHE = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dHF) / this.dHH));
        }

        boolean ayx() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dHI) {
                        this.mStart = this.dHE;
                        this.dHF = (int) this.dHG;
                        this.dHH = mD(this.dHF);
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
                    I(this.dHE, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.dHI;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dHO[i];
                        f3 = (dHO[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dHG = ((f3 * this.dHJ) / this.dHI) * 1000.0f;
                    d = f2 * this.dHJ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dHF);
                    d = this.dHK * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dHG = ((-f6) + f7) * signum * this.dHK * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dHG = this.dHF + (this.dHH * f8);
                    d = ((f8 * (this.dHH * f8)) / 2.0f) + (this.dHF * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
