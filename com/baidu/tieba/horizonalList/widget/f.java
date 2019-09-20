package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float gsO = 8.0f;
    private static float gsP;
    private final a gsL;
    private final a gsM;
    private final boolean gsN;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        gsP = 1.0f;
        gsP = 1.0f / aJ(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aJ(float f) {
        float exp;
        float f2 = gsO * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * gsP;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.gsN = z;
        this.gsL = new a(context);
        this.gsM = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.gsL.setFriction(f);
        this.gsM.setFriction(f);
    }

    public final boolean isFinished() {
        return this.gsL.mFinished && this.gsM.mFinished;
    }

    public final int getCurrX() {
        return this.gsL.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.gsL.gsS * this.gsL.gsS) + (this.gsM.gsS * this.gsM.gsS));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.gsL.mStartTime;
                int i = this.gsL.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aJ(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.gsL.aK(interpolation);
                    this.gsM.aK(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.gsL.mFinished && !this.gsL.update() && !this.gsL.byY()) {
                    this.gsL.finish();
                }
                if (!this.gsM.mFinished && !this.gsM.update() && !this.gsM.byY()) {
                    this.gsM.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.gsL.R(i, i3, i5);
        this.gsM.R(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.gsL.S(i, i3, i4) || this.gsM.S(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.gsN && !isFinished()) {
            float f = this.gsL.gsS;
            float f2 = this.gsM.gsS;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.gsL.e(i, i11, i5, i6, i9);
                this.gsM.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.gsL.e(i, i11, i5, i6, i9);
        this.gsM.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.gsL.W(i, i2, i3);
    }

    public void abortAnimation() {
        this.gsL.finish();
        this.gsM.finish();
    }

    public boolean C(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.gsL.gsQ - this.gsL.mStart)) && Math.signum(f2) == Math.signum((float) (this.gsM.gsQ - this.gsM.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float gsZ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] gta = new float[101];
        private static final float[] gtb = new float[101];
        private int gsQ;
        private int gsR;
        private float gsS;
        private float gsT;
        private int gsU;
        private int gsV;
        private int gsW;
        private float gsY;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float gsX = ViewConfiguration.getScrollFriction();
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
                gta[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                gtb[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = gta;
            gtb[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.gsX = f;
        }

        a(Context context) {
            this.gsY = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aK(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.gsQ - this.mStart) * f);
        }

        private static float uH(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void Q(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = gtb[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (gtb[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void R(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.gsQ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.gsT = 0.0f;
            this.gsR = 0;
        }

        void finish() {
            this.mCurrentPosition = this.gsQ;
            this.mFinished = true;
        }

        boolean S(int i, int i2, int i3) {
            this.mFinished = true;
            this.gsQ = i;
            this.mStart = i;
            this.gsR = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                T(i, i2, 0);
            } else if (i > i3) {
                T(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void T(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.gsQ = i2;
            int i4 = i - i2;
            this.gsT = uH(i4);
            this.gsR = -i4;
            this.gsW = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.gsT) * 1000.0d);
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.gsW = i5;
            this.mFinished = false;
            this.gsR = i2;
            this.gsS = i2;
            this.gsU = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                B(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int uK = uK(i2);
                this.gsU = uK;
                this.mDuration = uK;
                d = uJ(i2);
            }
            this.gsV = (int) (d * Math.signum(i2));
            this.gsQ = this.gsV + i;
            if (this.gsQ < i3) {
                Q(this.mStart, this.gsQ, i3);
                this.gsQ = i3;
            }
            if (this.gsQ > i4) {
                Q(this.mStart, this.gsQ, i4);
                this.gsQ = i4;
            }
        }

        private double uI(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.gsX * this.gsY));
        }

        private double uJ(int i) {
            return Math.exp(uI(i) * (gsZ / (gsZ - 1.0d))) * this.gsX * this.gsY;
        }

        private int uK(int i) {
            return (int) (Math.exp(uI(i) / (gsZ - 1.0d)) * 1000.0d);
        }

        private void U(int i, int i2, int i3) {
            float f = (-i3) / this.gsT;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.gsT)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.gsT));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.gsR = (int) ((-this.gsT) * sqrt);
        }

        private void V(int i, int i2, int i3) {
            this.gsT = uH(i3 == 0 ? i - i2 : i3);
            U(i, i2, i3);
            byX();
        }

        private void B(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                V(i, i5, i4);
            } else if (uJ(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.gsW);
            } else {
                T(i, i5, i4);
            }
        }

        void W(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.gsW = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                B(i, i2, i2, (int) this.gsS);
            }
        }

        private void byX() {
            float abs = (this.gsR * this.gsR) / (Math.abs(this.gsT) * 2.0f);
            float signum = Math.signum(this.gsR);
            if (abs > this.gsW) {
                this.gsT = (((-signum) * this.gsR) * this.gsR) / (this.gsW * 2.0f);
                abs = this.gsW;
            }
            this.gsW = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.gsR <= 0) {
                abs = -abs;
            }
            this.gsQ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.gsR) / this.gsT));
        }

        boolean byY() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.gsU) {
                        this.mStart = this.gsQ;
                        this.gsR = (int) this.gsS;
                        this.gsT = uH(this.gsR);
                        this.mStartTime += this.mDuration;
                        byX();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    T(this.gsQ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.gsU;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = gta[i];
                        f3 = (gta[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.gsS = ((f3 * this.gsV) / this.gsU) * 1000.0f;
                    d = f2 * this.gsV;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.gsR);
                    d = this.gsW * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.gsS = ((-f6) + f7) * signum * this.gsW * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.gsS = this.gsR + (this.gsT * f8);
                    d = ((f8 * (this.gsT * f8)) / 2.0f) + (this.gsR * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
