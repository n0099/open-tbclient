package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float dII = 8.0f;
    private static float dIJ;
    private final a dIF;
    private final a dIG;
    private final boolean dIH;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dIJ = 1.0f;
        dIJ = 1.0f / ab(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float ab(float f) {
        float exp;
        float f2 = dII * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dIJ;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dIH = z;
        this.dIF = new a(context);
        this.dIG = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dIF.setFriction(f);
        this.dIG.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dIF.mFinished && this.dIG.mFinished;
    }

    public final int getCurrX() {
        return this.dIF.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.dIF.dIM * this.dIF.dIM) + (this.dIG.dIM * this.dIG.dIM));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dIF.mStartTime;
                int i = this.dIF.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ab(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dIF.ac(interpolation);
                    this.dIG.ac(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dIF.mFinished && !this.dIF.update() && !this.dIF.ayv()) {
                    this.dIF.finish();
                }
                if (!this.dIG.mFinished && !this.dIG.update() && !this.dIG.ayv()) {
                    this.dIG.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dIF.G(i, i3, i5);
        this.dIG.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dIF.H(i, i3, i4) || this.dIG.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dIH && !isFinished()) {
            float f = this.dIF.dIM;
            float f2 = this.dIG.dIM;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dIF.a(i, i11, i5, i6, i9);
                this.dIG.a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dIF.a(i, i11, i5, i6, i9);
        this.dIG.a(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dIF.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.dIF.finish();
        this.dIG.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dIF.dIK - this.dIF.mStart)) && Math.signum(f2) == Math.signum((float) (this.dIG.dIK - this.dIG.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dIT = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dIU = new float[101];
        private static final float[] dIV = new float[101];
        private int dIK;
        private int dIL;
        private float dIM;
        private float dIN;
        private int dIO;
        private int dIP;
        private int dIQ;
        private float dIS;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dIR = ViewConfiguration.getScrollFriction();
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
                dIU[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dIV[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dIU;
            dIV[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dIR = f;
        }

        a(Context context) {
            this.dIS = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ac(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.dIK - this.mStart) * f);
        }

        private static float mC(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dIV[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dIV[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.dIK = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dIN = 0.0f;
            this.dIL = 0;
        }

        void finish() {
            this.mCurrentPosition = this.dIK;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.dIK = i;
            this.mStart = i;
            this.dIL = 0;
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
            this.dIK = i2;
            int i4 = i - i2;
            this.dIN = mC(i4);
            this.dIL = -i4;
            this.dIQ = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dIN) * 1000.0d);
        }

        void a(int i, int i2, int i3, int i4, int i5) {
            this.dIQ = i5;
            this.mFinished = false;
            this.dIL = i2;
            this.dIM = i2;
            this.dIO = 0;
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
                int mF = mF(i2);
                this.dIO = mF;
                this.mDuration = mF;
                d = mE(i2);
            }
            this.dIP = (int) (d * Math.signum(i2));
            this.dIK = this.dIP + i;
            if (this.dIK < i3) {
                F(this.mStart, this.dIK, i3);
                this.dIK = i3;
            }
            if (this.dIK > i4) {
                F(this.mStart, this.dIK, i4);
                this.dIK = i4;
            }
        }

        private double mD(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dIR * this.dIS));
        }

        private double mE(int i) {
            return Math.exp(mD(i) * (dIT / (dIT - 1.0d))) * this.dIR * this.dIS;
        }

        private int mF(int i) {
            return (int) (Math.exp(mD(i) / (dIT - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.dIN;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dIN)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dIN));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dIL = (int) ((-this.dIN) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.dIN = mC(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            ayu();
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
            } else if (mE(i4) > Math.abs(i6)) {
                a(i, i4, z ? i2 : i, z ? i : i3, this.dIQ);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dIQ = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.dIM);
            }
        }

        private void ayu() {
            float abs = (this.dIL * this.dIL) / (Math.abs(this.dIN) * 2.0f);
            float signum = Math.signum(this.dIL);
            if (abs > this.dIQ) {
                this.dIN = (((-signum) * this.dIL) * this.dIL) / (this.dIQ * 2.0f);
                abs = this.dIQ;
            }
            this.dIQ = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dIL <= 0) {
                abs = -abs;
            }
            this.dIK = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dIL) / this.dIN));
        }

        boolean ayv() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dIO) {
                        this.mStart = this.dIK;
                        this.dIL = (int) this.dIM;
                        this.dIN = mC(this.dIL);
                        this.mStartTime += this.mDuration;
                        ayu();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    I(this.dIK, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.dIO;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dIU[i];
                        f3 = (dIU[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dIM = ((f3 * this.dIP) / this.dIO) * 1000.0f;
                    d = f2 * this.dIP;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dIL);
                    d = this.dIQ * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dIM = ((-f6) + f7) * signum * this.dIQ * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dIM = this.dIL + (this.dIN * f8);
                    d = ((f8 * (this.dIN * f8)) / 2.0f) + (this.dIL * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
