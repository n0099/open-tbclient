package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float dTT = 8.0f;
    private static float dTU;
    private final a dTQ;
    private final a dTR;
    private final boolean dTS;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dTU = 1.0f;
        dTU = 1.0f / al(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float al(float f) {
        float exp;
        float f2 = dTT * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dTU;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dTS = z;
        this.dTQ = new a(context);
        this.dTR = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dTQ.setFriction(f);
        this.dTR.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dTQ.mFinished && this.dTR.mFinished;
    }

    public final int getCurrX() {
        return this.dTQ.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.dTQ.dTX * this.dTQ.dTX) + (this.dTR.dTX * this.dTR.dTX));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dTQ.mStartTime;
                int i = this.dTQ.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = al(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dTQ.am(interpolation);
                    this.dTR.am(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dTQ.mFinished && !this.dTQ.update() && !this.dTQ.aDq()) {
                    this.dTQ.finish();
                }
                if (!this.dTR.mFinished && !this.dTR.update() && !this.dTR.aDq()) {
                    this.dTR.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dTQ.G(i, i3, i5);
        this.dTR.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dTQ.H(i, i3, i4) || this.dTR.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dTS && !isFinished()) {
            float f = this.dTQ.dTX;
            float f2 = this.dTR.dTX;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dTQ.b(i, i11, i5, i6, i9);
                this.dTR.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dTQ.b(i, i11, i5, i6, i9);
        this.dTR.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dTQ.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.dTQ.finish();
        this.dTR.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dTQ.dTV - this.dTQ.mStart)) && Math.signum(f2) == Math.signum((float) (this.dTR.dTV - this.dTR.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dUe = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dUf = new float[101];
        private static final float[] dUg = new float[101];
        private int dTV;
        private int dTW;
        private float dTX;
        private float dTY;
        private int dTZ;
        private int dUa;
        private int dUb;
        private float dUd;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dUc = ViewConfiguration.getScrollFriction();
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
                dUf[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dUg[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dUf;
            dUg[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dUc = f;
        }

        a(Context context) {
            this.dUd = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void am(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.dTV - this.mStart) * f);
        }

        private static float mO(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dUg[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dUg[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.dTV = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dTY = 0.0f;
            this.dTW = 0;
        }

        void finish() {
            this.mCurrentPosition = this.dTV;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.dTV = i;
            this.mStart = i;
            this.dTW = 0;
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
            this.dTV = i2;
            int i4 = i - i2;
            this.dTY = mO(i4);
            this.dTW = -i4;
            this.dUb = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dTY) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.dUb = i5;
            this.mFinished = false;
            this.dTW = i2;
            this.dTX = i2;
            this.dTZ = 0;
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
                int mR = mR(i2);
                this.dTZ = mR;
                this.mDuration = mR;
                d = mQ(i2);
            }
            this.dUa = (int) (d * Math.signum(i2));
            this.dTV = this.dUa + i;
            if (this.dTV < i3) {
                F(this.mStart, this.dTV, i3);
                this.dTV = i3;
            }
            if (this.dTV > i4) {
                F(this.mStart, this.dTV, i4);
                this.dTV = i4;
            }
        }

        private double mP(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dUc * this.dUd));
        }

        private double mQ(int i) {
            return Math.exp(mP(i) * (dUe / (dUe - 1.0d))) * this.dUc * this.dUd;
        }

        private int mR(int i) {
            return (int) (Math.exp(mP(i) / (dUe - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.dTY;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dTY)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dTY));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dTW = (int) ((-this.dTY) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.dTY = mO(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            aDp();
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
            } else if (mQ(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.dUb);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dUb = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.dTX);
            }
        }

        private void aDp() {
            float abs = (this.dTW * this.dTW) / (Math.abs(this.dTY) * 2.0f);
            float signum = Math.signum(this.dTW);
            if (abs > this.dUb) {
                this.dTY = (((-signum) * this.dTW) * this.dTW) / (this.dUb * 2.0f);
                abs = this.dUb;
            }
            this.dUb = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dTW <= 0) {
                abs = -abs;
            }
            this.dTV = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dTW) / this.dTY));
        }

        boolean aDq() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dTZ) {
                        this.mStart = this.dTV;
                        this.dTW = (int) this.dTX;
                        this.dTY = mO(this.dTW);
                        this.mStartTime += this.mDuration;
                        aDp();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    I(this.dTV, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.dTZ;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dUf[i];
                        f3 = (dUf[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dTX = ((f3 * this.dUa) / this.dTZ) * 1000.0f;
                    d = f2 * this.dUa;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dTW);
                    d = this.dUb * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dTX = ((-f6) + f7) * signum * this.dUb * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dTX = this.dTW + (this.dTY * f8);
                    d = ((f8 * (this.dTY * f8)) / 2.0f) + (this.dTW * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
