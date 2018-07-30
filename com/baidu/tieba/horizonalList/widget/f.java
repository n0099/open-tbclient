package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float ebF = 8.0f;
    private static float ebG;
    private final a ebC;
    private final a ebD;
    private final boolean ebE;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        ebG = 1.0f;
        ebG = 1.0f / am(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float am(float f) {
        float exp;
        float f2 = ebF * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * ebG;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.ebE = z;
        this.ebC = new a(context);
        this.ebD = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.ebC.setFriction(f);
        this.ebD.setFriction(f);
    }

    public final boolean isFinished() {
        return this.ebC.mFinished && this.ebD.mFinished;
    }

    public final int getCurrX() {
        return this.ebC.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.ebC.ebJ * this.ebC.ebJ) + (this.ebD.ebJ * this.ebD.ebJ));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.ebC.mStartTime;
                int i = this.ebC.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = am(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.ebC.an(interpolation);
                    this.ebD.an(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.ebC.mFinished && !this.ebC.update() && !this.ebC.aFa()) {
                    this.ebC.finish();
                }
                if (!this.ebD.mFinished && !this.ebD.update() && !this.ebD.aFa()) {
                    this.ebD.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.ebC.G(i, i3, i5);
        this.ebD.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.ebC.H(i, i3, i4) || this.ebD.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.ebE && !isFinished()) {
            float f = this.ebC.ebJ;
            float f2 = this.ebD.ebJ;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.ebC.b(i, i11, i5, i6, i9);
                this.ebD.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.ebC.b(i, i11, i5, i6, i9);
        this.ebD.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.ebC.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.ebC.finish();
        this.ebD.finish();
    }

    public boolean u(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.ebC.ebH - this.ebC.mStart)) && Math.signum(f2) == Math.signum((float) (this.ebD.ebH - this.ebD.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float ebQ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] ebR = new float[101];
        private static final float[] ebS = new float[101];
        private int ebH;
        private int ebI;
        private float ebJ;
        private float ebK;
        private int ebL;
        private int ebM;
        private int ebN;
        private float ebP;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float ebO = ViewConfiguration.getScrollFriction();
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
                ebR[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                ebS[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = ebR;
            ebS[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.ebO = f;
        }

        a(Context context) {
            this.ebP = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void an(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.ebH - this.mStart) * f);
        }

        private static float nj(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = ebS[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (ebS[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.ebH = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.ebK = 0.0f;
            this.ebI = 0;
        }

        void finish() {
            this.mCurrentPosition = this.ebH;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.ebH = i;
            this.mStart = i;
            this.ebI = 0;
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
            this.ebH = i2;
            int i4 = i - i2;
            this.ebK = nj(i4);
            this.ebI = -i4;
            this.ebN = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.ebK) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.ebN = i5;
            this.mFinished = false;
            this.ebI = i2;
            this.ebJ = i2;
            this.ebL = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                s(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int nm = nm(i2);
                this.ebL = nm;
                this.mDuration = nm;
                d = nl(i2);
            }
            this.ebM = (int) (d * Math.signum(i2));
            this.ebH = this.ebM + i;
            if (this.ebH < i3) {
                F(this.mStart, this.ebH, i3);
                this.ebH = i3;
            }
            if (this.ebH > i4) {
                F(this.mStart, this.ebH, i4);
                this.ebH = i4;
            }
        }

        private double nk(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.ebO * this.ebP));
        }

        private double nl(int i) {
            return Math.exp(nk(i) * (ebQ / (ebQ - 1.0d))) * this.ebO * this.ebP;
        }

        private int nm(int i) {
            return (int) (Math.exp(nk(i) / (ebQ - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.ebK;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.ebK)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.ebK));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.ebI = (int) ((-this.ebK) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.ebK = nj(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            aEZ();
        }

        private void s(int i, int i2, int i3, int i4) {
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
            } else if (nl(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.ebN);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.ebN = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.ebJ);
            }
        }

        private void aEZ() {
            float abs = (this.ebI * this.ebI) / (Math.abs(this.ebK) * 2.0f);
            float signum = Math.signum(this.ebI);
            if (abs > this.ebN) {
                this.ebK = (((-signum) * this.ebI) * this.ebI) / (this.ebN * 2.0f);
                abs = this.ebN;
            }
            this.ebN = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.ebI <= 0) {
                abs = -abs;
            }
            this.ebH = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.ebI) / this.ebK));
        }

        boolean aFa() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.ebL) {
                        this.mStart = this.ebH;
                        this.ebI = (int) this.ebJ;
                        this.ebK = nj(this.ebI);
                        this.mStartTime += this.mDuration;
                        aEZ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    I(this.ebH, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.ebL;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = ebR[i];
                        f3 = (ebR[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.ebJ = ((f3 * this.ebM) / this.ebL) * 1000.0f;
                    d = f2 * this.ebM;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.ebI);
                    d = this.ebN * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.ebJ = ((-f6) + f7) * signum * this.ebN * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.ebJ = this.ebI + (this.ebK * f8);
                    d = ((f8 * (this.ebK * f8)) / 2.0f) + (this.ebI * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
