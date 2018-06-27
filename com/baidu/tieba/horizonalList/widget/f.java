package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float dXN = 8.0f;
    private static float dXO;
    private final a dXK;
    private final a dXL;
    private final boolean dXM;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dXO = 1.0f;
        dXO = 1.0f / al(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float al(float f) {
        float exp;
        float f2 = dXN * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dXO;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dXM = z;
        this.dXK = new a(context);
        this.dXL = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dXK.setFriction(f);
        this.dXL.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dXK.mFinished && this.dXL.mFinished;
    }

    public final int getCurrX() {
        return this.dXK.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.dXK.dXR * this.dXK.dXR) + (this.dXL.dXR * this.dXL.dXR));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dXK.mStartTime;
                int i = this.dXK.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = al(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dXK.am(interpolation);
                    this.dXL.am(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dXK.mFinished && !this.dXK.update() && !this.dXK.aEa()) {
                    this.dXK.finish();
                }
                if (!this.dXL.mFinished && !this.dXL.update() && !this.dXL.aEa()) {
                    this.dXL.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dXK.G(i, i3, i5);
        this.dXL.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dXK.H(i, i3, i4) || this.dXL.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dXM && !isFinished()) {
            float f = this.dXK.dXR;
            float f2 = this.dXL.dXR;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dXK.b(i, i11, i5, i6, i9);
                this.dXL.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dXK.b(i, i11, i5, i6, i9);
        this.dXL.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dXK.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.dXK.finish();
        this.dXL.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dXK.dXP - this.dXK.mStart)) && Math.signum(f2) == Math.signum((float) (this.dXL.dXP - this.dXL.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dXY = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dXZ = new float[101];
        private static final float[] dYa = new float[101];
        private int dXP;
        private int dXQ;
        private float dXR;
        private float dXS;
        private int dXT;
        private int dXU;
        private int dXV;
        private float dXX;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dXW = ViewConfiguration.getScrollFriction();
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
                dXZ[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dYa[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dXZ;
            dYa[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dXW = f;
        }

        a(Context context) {
            this.dXX = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void am(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.dXP - this.mStart) * f);
        }

        private static float mV(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dYa[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dYa[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.dXP = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dXS = 0.0f;
            this.dXQ = 0;
        }

        void finish() {
            this.mCurrentPosition = this.dXP;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.dXP = i;
            this.mStart = i;
            this.dXQ = 0;
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
            this.dXP = i2;
            int i4 = i - i2;
            this.dXS = mV(i4);
            this.dXQ = -i4;
            this.dXV = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dXS) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.dXV = i5;
            this.mFinished = false;
            this.dXQ = i2;
            this.dXR = i2;
            this.dXT = 0;
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
                int mY = mY(i2);
                this.dXT = mY;
                this.mDuration = mY;
                d = mX(i2);
            }
            this.dXU = (int) (d * Math.signum(i2));
            this.dXP = this.dXU + i;
            if (this.dXP < i3) {
                F(this.mStart, this.dXP, i3);
                this.dXP = i3;
            }
            if (this.dXP > i4) {
                F(this.mStart, this.dXP, i4);
                this.dXP = i4;
            }
        }

        private double mW(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dXW * this.dXX));
        }

        private double mX(int i) {
            return Math.exp(mW(i) * (dXY / (dXY - 1.0d))) * this.dXW * this.dXX;
        }

        private int mY(int i) {
            return (int) (Math.exp(mW(i) / (dXY - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.dXS;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dXS)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dXS));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dXQ = (int) ((-this.dXS) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.dXS = mV(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            aDZ();
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
            } else if (mX(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.dXV);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dXV = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.dXR);
            }
        }

        private void aDZ() {
            float abs = (this.dXQ * this.dXQ) / (Math.abs(this.dXS) * 2.0f);
            float signum = Math.signum(this.dXQ);
            if (abs > this.dXV) {
                this.dXS = (((-signum) * this.dXQ) * this.dXQ) / (this.dXV * 2.0f);
                abs = this.dXV;
            }
            this.dXV = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dXQ <= 0) {
                abs = -abs;
            }
            this.dXP = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dXQ) / this.dXS));
        }

        boolean aEa() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dXT) {
                        this.mStart = this.dXP;
                        this.dXQ = (int) this.dXR;
                        this.dXS = mV(this.dXQ);
                        this.mStartTime += this.mDuration;
                        aDZ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    I(this.dXP, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.dXT;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dXZ[i];
                        f3 = (dXZ[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dXR = ((f3 * this.dXU) / this.dXT) * 1000.0f;
                    d = f2 * this.dXU;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dXQ);
                    d = this.dXV * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dXR = ((-f6) + f7) * signum * this.dXV * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dXR = this.dXQ + (this.dXS * f8);
                    d = ((f8 * (this.dXS * f8)) / 2.0f) + (this.dXQ * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
