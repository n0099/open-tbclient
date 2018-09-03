package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float ebC = 8.0f;
    private static float ebD;
    private final a ebA;
    private final boolean ebB;
    private final a ebz;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        ebD = 1.0f;
        ebD = 1.0f / al(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float al(float f) {
        float exp;
        float f2 = ebC * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * ebD;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.ebB = z;
        this.ebz = new a(context);
        this.ebA = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.ebz.setFriction(f);
        this.ebA.setFriction(f);
    }

    public final boolean isFinished() {
        return this.ebz.mFinished && this.ebA.mFinished;
    }

    public final int getCurrX() {
        return this.ebz.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.ebz.ebG * this.ebz.ebG) + (this.ebA.ebG * this.ebA.ebG));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.ebz.mStartTime;
                int i = this.ebz.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = al(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.ebz.am(interpolation);
                    this.ebA.am(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.ebz.mFinished && !this.ebz.update() && !this.ebz.aEX()) {
                    this.ebz.finish();
                }
                if (!this.ebA.mFinished && !this.ebA.update() && !this.ebA.aEX()) {
                    this.ebA.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.ebz.G(i, i3, i5);
        this.ebA.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.ebz.H(i, i3, i4) || this.ebA.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.ebB && !isFinished()) {
            float f = this.ebz.ebG;
            float f2 = this.ebA.ebG;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.ebz.b(i, i11, i5, i6, i9);
                this.ebA.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.ebz.b(i, i11, i5, i6, i9);
        this.ebA.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.ebz.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.ebz.finish();
        this.ebA.finish();
    }

    public boolean u(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.ebz.ebE - this.ebz.mStart)) && Math.signum(f2) == Math.signum((float) (this.ebA.ebE - this.ebA.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float ebN = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] ebO = new float[101];
        private static final float[] ebP = new float[101];
        private int ebE;
        private int ebF;
        private float ebG;
        private float ebH;
        private int ebI;
        private int ebJ;
        private int ebK;
        private float ebM;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float ebL = ViewConfiguration.getScrollFriction();
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
                ebO[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                ebP[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = ebO;
            ebP[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.ebL = f;
        }

        a(Context context) {
            this.ebM = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void am(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.ebE - this.mStart) * f);
        }

        private static float nj(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = ebP[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (ebP[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void G(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.ebE = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.ebH = 0.0f;
            this.ebF = 0;
        }

        void finish() {
            this.mCurrentPosition = this.ebE;
            this.mFinished = true;
        }

        boolean H(int i, int i2, int i3) {
            this.mFinished = true;
            this.ebE = i;
            this.mStart = i;
            this.ebF = 0;
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
            this.ebE = i2;
            int i4 = i - i2;
            this.ebH = nj(i4);
            this.ebF = -i4;
            this.ebK = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.ebH) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.ebK = i5;
            this.mFinished = false;
            this.ebF = i2;
            this.ebG = i2;
            this.ebI = 0;
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
                this.ebI = nm;
                this.mDuration = nm;
                d = nl(i2);
            }
            this.ebJ = (int) (d * Math.signum(i2));
            this.ebE = this.ebJ + i;
            if (this.ebE < i3) {
                F(this.mStart, this.ebE, i3);
                this.ebE = i3;
            }
            if (this.ebE > i4) {
                F(this.mStart, this.ebE, i4);
                this.ebE = i4;
            }
        }

        private double nk(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.ebL * this.ebM));
        }

        private double nl(int i) {
            return Math.exp(nk(i) * (ebN / (ebN - 1.0d))) * this.ebL * this.ebM;
        }

        private int nm(int i) {
            return (int) (Math.exp(nk(i) / (ebN - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.ebH;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.ebH)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.ebH));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.ebF = (int) ((-this.ebH) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.ebH = nj(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            aEW();
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
                b(i, i4, z ? i2 : i, z ? i : i3, this.ebK);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.ebK = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.ebG);
            }
        }

        private void aEW() {
            float abs = (this.ebF * this.ebF) / (Math.abs(this.ebH) * 2.0f);
            float signum = Math.signum(this.ebF);
            if (abs > this.ebK) {
                this.ebH = (((-signum) * this.ebF) * this.ebF) / (this.ebK * 2.0f);
                abs = this.ebK;
            }
            this.ebK = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.ebF <= 0) {
                abs = -abs;
            }
            this.ebE = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.ebF) / this.ebH));
        }

        boolean aEX() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.ebI) {
                        this.mStart = this.ebE;
                        this.ebF = (int) this.ebG;
                        this.ebH = nj(this.ebF);
                        this.mStartTime += this.mDuration;
                        aEW();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    I(this.ebE, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.ebI;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = ebO[i];
                        f3 = (ebO[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.ebG = ((f3 * this.ebJ) / this.ebI) * 1000.0f;
                    d = f2 * this.ebJ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.ebF);
                    d = this.ebK * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.ebG = ((-f6) + f7) * signum * this.ebK * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.ebG = this.ebF + (this.ebH * f8);
                    d = ((f8 * (this.ebH * f8)) / 2.0f) + (this.ebF * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
