package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float fSP = 8.0f;
    private static float fSQ;
    private final a fSM;
    private final a fSN;
    private final boolean fSO;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        fSQ = 1.0f;
        fSQ = 1.0f / aD(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aD(float f) {
        float exp;
        float f2 = fSP * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * fSQ;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.fSO = z;
        this.fSM = new a(context);
        this.fSN = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.fSM.setFriction(f);
        this.fSN.setFriction(f);
    }

    public final boolean isFinished() {
        return this.fSM.mFinished && this.fSN.mFinished;
    }

    public final int getCurrX() {
        return this.fSM.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.fSM.fST * this.fSM.fST) + (this.fSN.fST * this.fSN.fST));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.fSM.mStartTime;
                int i = this.fSM.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aD(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.fSM.aE(interpolation);
                    this.fSN.aE(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.fSM.mFinished && !this.fSM.update() && !this.fSM.bnO()) {
                    this.fSM.finish();
                }
                if (!this.fSN.mFinished && !this.fSN.update() && !this.fSN.bnO()) {
                    this.fSN.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.fSM.O(i, i3, i5);
        this.fSN.O(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.fSM.P(i, i3, i4) || this.fSN.P(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.fSO && !isFinished()) {
            float f = this.fSM.fST;
            float f2 = this.fSN.fST;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.fSM.e(i, i11, i5, i6, i9);
                this.fSN.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.fSM.e(i, i11, i5, i6, i9);
        this.fSN.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.fSM.T(i, i2, i3);
    }

    public void abortAnimation() {
        this.fSM.finish();
        this.fSN.finish();
    }

    public boolean A(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.fSM.fSR - this.fSM.mStart)) && Math.signum(f2) == Math.signum((float) (this.fSN.fSR - this.fSN.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float fTa = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] fTb = new float[101];
        private static final float[] fTc = new float[101];
        private int fSR;
        private int fSS;
        private float fST;
        private float fSU;
        private int fSV;
        private int fSW;
        private int fSX;
        private float fSZ;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float fSY = ViewConfiguration.getScrollFriction();
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
                fTb[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                fTc[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = fTb;
            fTc[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.fSY = f;
        }

        a(Context context) {
            this.fSZ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aE(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.fSR - this.mStart) * f);
        }

        private static float sW(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void N(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = fTc[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (fTc[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void O(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.fSR = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.fSU = 0.0f;
            this.fSS = 0;
        }

        void finish() {
            this.mCurrentPosition = this.fSR;
            this.mFinished = true;
        }

        boolean P(int i, int i2, int i3) {
            this.mFinished = true;
            this.fSR = i;
            this.mStart = i;
            this.fSS = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                Q(i, i2, 0);
            } else if (i > i3) {
                Q(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void Q(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.fSR = i2;
            int i4 = i - i2;
            this.fSU = sW(i4);
            this.fSS = -i4;
            this.fSX = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.fSU) * 1000.0d);
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.fSX = i5;
            this.mFinished = false;
            this.fSS = i2;
            this.fST = i2;
            this.fSV = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                x(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int sZ = sZ(i2);
                this.fSV = sZ;
                this.mDuration = sZ;
                d = sY(i2);
            }
            this.fSW = (int) (d * Math.signum(i2));
            this.fSR = this.fSW + i;
            if (this.fSR < i3) {
                N(this.mStart, this.fSR, i3);
                this.fSR = i3;
            }
            if (this.fSR > i4) {
                N(this.mStart, this.fSR, i4);
                this.fSR = i4;
            }
        }

        private double sX(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.fSY * this.fSZ));
        }

        private double sY(int i) {
            return Math.exp(sX(i) * (fTa / (fTa - 1.0d))) * this.fSY * this.fSZ;
        }

        private int sZ(int i) {
            return (int) (Math.exp(sX(i) / (fTa - 1.0d)) * 1000.0d);
        }

        private void R(int i, int i2, int i3) {
            float f = (-i3) / this.fSU;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.fSU)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.fSU));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.fSS = (int) ((-this.fSU) * sqrt);
        }

        private void S(int i, int i2, int i3) {
            this.fSU = sW(i3 == 0 ? i - i2 : i3);
            R(i, i2, i3);
            bnN();
        }

        private void x(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                S(i, i5, i4);
            } else if (sY(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.fSX);
            } else {
                Q(i, i5, i4);
            }
        }

        void T(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.fSX = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                x(i, i2, i2, (int) this.fST);
            }
        }

        private void bnN() {
            float abs = (this.fSS * this.fSS) / (Math.abs(this.fSU) * 2.0f);
            float signum = Math.signum(this.fSS);
            if (abs > this.fSX) {
                this.fSU = (((-signum) * this.fSS) * this.fSS) / (this.fSX * 2.0f);
                abs = this.fSX;
            }
            this.fSX = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.fSS <= 0) {
                abs = -abs;
            }
            this.fSR = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.fSS) / this.fSU));
        }

        boolean bnO() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.fSV) {
                        this.mStart = this.fSR;
                        this.fSS = (int) this.fST;
                        this.fSU = sW(this.fSS);
                        this.mStartTime += this.mDuration;
                        bnN();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    Q(this.fSR, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.fSV;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = fTb[i];
                        f3 = (fTb[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.fST = ((f3 * this.fSW) / this.fSV) * 1000.0f;
                    d = f2 * this.fSW;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.fSS);
                    d = this.fSX * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.fST = ((-f6) + f7) * signum * this.fSX * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.fST = this.fSS + (this.fSU * f8);
                    d = ((f8 * (this.fSU * f8)) / 2.0f) + (this.fSS * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
