package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float fSO = 8.0f;
    private static float fSP;
    private final a fSL;
    private final a fSM;
    private final boolean fSN;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        fSP = 1.0f;
        fSP = 1.0f / aD(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aD(float f) {
        float exp;
        float f2 = fSO * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * fSP;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.fSN = z;
        this.fSL = new a(context);
        this.fSM = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.fSL.setFriction(f);
        this.fSM.setFriction(f);
    }

    public final boolean isFinished() {
        return this.fSL.mFinished && this.fSM.mFinished;
    }

    public final int getCurrX() {
        return this.fSL.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.fSL.fSS * this.fSL.fSS) + (this.fSM.fSS * this.fSM.fSS));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.fSL.mStartTime;
                int i = this.fSL.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aD(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.fSL.aE(interpolation);
                    this.fSM.aE(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.fSL.mFinished && !this.fSL.update() && !this.fSL.bnN()) {
                    this.fSL.finish();
                }
                if (!this.fSM.mFinished && !this.fSM.update() && !this.fSM.bnN()) {
                    this.fSM.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.fSL.O(i, i3, i5);
        this.fSM.O(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.fSL.P(i, i3, i4) || this.fSM.P(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.fSN && !isFinished()) {
            float f = this.fSL.fSS;
            float f2 = this.fSM.fSS;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.fSL.e(i, i11, i5, i6, i9);
                this.fSM.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.fSL.e(i, i11, i5, i6, i9);
        this.fSM.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.fSL.T(i, i2, i3);
    }

    public void abortAnimation() {
        this.fSL.finish();
        this.fSM.finish();
    }

    public boolean A(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.fSL.fSQ - this.fSL.mStart)) && Math.signum(f2) == Math.signum((float) (this.fSM.fSQ - this.fSM.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float fSZ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] fTa = new float[101];
        private static final float[] fTb = new float[101];
        private int fSQ;
        private int fSR;
        private float fSS;
        private float fST;
        private int fSU;
        private int fSV;
        private int fSW;
        private float fSY;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float fSX = ViewConfiguration.getScrollFriction();
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
                fTa[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                fTb[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = fTa;
            fTb[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.fSX = f;
        }

        a(Context context) {
            this.fSY = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aE(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.fSQ - this.mStart) * f);
        }

        private static float sW(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void N(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = fTb[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (fTb[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void O(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.fSQ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.fST = 0.0f;
            this.fSR = 0;
        }

        void finish() {
            this.mCurrentPosition = this.fSQ;
            this.mFinished = true;
        }

        boolean P(int i, int i2, int i3) {
            this.mFinished = true;
            this.fSQ = i;
            this.mStart = i;
            this.fSR = 0;
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
            this.fSQ = i2;
            int i4 = i - i2;
            this.fST = sW(i4);
            this.fSR = -i4;
            this.fSW = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.fST) * 1000.0d);
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.fSW = i5;
            this.mFinished = false;
            this.fSR = i2;
            this.fSS = i2;
            this.fSU = 0;
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
                this.fSU = sZ;
                this.mDuration = sZ;
                d = sY(i2);
            }
            this.fSV = (int) (d * Math.signum(i2));
            this.fSQ = this.fSV + i;
            if (this.fSQ < i3) {
                N(this.mStart, this.fSQ, i3);
                this.fSQ = i3;
            }
            if (this.fSQ > i4) {
                N(this.mStart, this.fSQ, i4);
                this.fSQ = i4;
            }
        }

        private double sX(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.fSX * this.fSY));
        }

        private double sY(int i) {
            return Math.exp(sX(i) * (fSZ / (fSZ - 1.0d))) * this.fSX * this.fSY;
        }

        private int sZ(int i) {
            return (int) (Math.exp(sX(i) / (fSZ - 1.0d)) * 1000.0d);
        }

        private void R(int i, int i2, int i3) {
            float f = (-i3) / this.fST;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.fST)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.fST));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.fSR = (int) ((-this.fST) * sqrt);
        }

        private void S(int i, int i2, int i3) {
            this.fST = sW(i3 == 0 ? i - i2 : i3);
            R(i, i2, i3);
            bnM();
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
                e(i, i4, z ? i2 : i, z ? i : i3, this.fSW);
            } else {
                Q(i, i5, i4);
            }
        }

        void T(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.fSW = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                x(i, i2, i2, (int) this.fSS);
            }
        }

        private void bnM() {
            float abs = (this.fSR * this.fSR) / (Math.abs(this.fST) * 2.0f);
            float signum = Math.signum(this.fSR);
            if (abs > this.fSW) {
                this.fST = (((-signum) * this.fSR) * this.fSR) / (this.fSW * 2.0f);
                abs = this.fSW;
            }
            this.fSW = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.fSR <= 0) {
                abs = -abs;
            }
            this.fSQ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.fSR) / this.fST));
        }

        boolean bnN() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.fSU) {
                        this.mStart = this.fSQ;
                        this.fSR = (int) this.fSS;
                        this.fST = sW(this.fSR);
                        this.mStartTime += this.mDuration;
                        bnM();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    Q(this.fSQ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.fSU;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = fTa[i];
                        f3 = (fTa[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.fSS = ((f3 * this.fSV) / this.fSU) * 1000.0f;
                    d = f2 * this.fSV;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.fSR);
                    d = this.fSW * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.fSS = ((-f6) + f7) * signum * this.fSW * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.fSS = this.fSR + (this.fST * f8);
                    d = ((f8 * (this.fST * f8)) / 2.0f) + (this.fSR * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
