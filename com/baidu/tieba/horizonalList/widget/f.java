package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float gjP = 8.0f;
    private static float gjQ;
    private final a gjM;
    private final a gjN;
    private final boolean gjO;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        gjQ = 1.0f;
        gjQ = 1.0f / aH(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aH(float f) {
        float exp;
        float f2 = gjP * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * gjQ;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.gjO = z;
        this.gjM = new a(context);
        this.gjN = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.gjM.setFriction(f);
        this.gjN.setFriction(f);
    }

    public final boolean isFinished() {
        return this.gjM.mFinished && this.gjN.mFinished;
    }

    public final int getCurrX() {
        return this.gjM.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.gjM.gjT * this.gjM.gjT) + (this.gjN.gjT * this.gjN.gjT));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.gjM.mStartTime;
                int i = this.gjM.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aH(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.gjM.aI(interpolation);
                    this.gjN.aI(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.gjM.mFinished && !this.gjM.update() && !this.gjM.bvn()) {
                    this.gjM.finish();
                }
                if (!this.gjN.mFinished && !this.gjN.update() && !this.gjN.bvn()) {
                    this.gjN.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.gjM.P(i, i3, i5);
        this.gjN.P(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.gjM.Q(i, i3, i4) || this.gjN.Q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.gjO && !isFinished()) {
            float f = this.gjM.gjT;
            float f2 = this.gjN.gjT;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.gjM.e(i, i11, i5, i6, i9);
                this.gjN.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.gjM.e(i, i11, i5, i6, i9);
        this.gjN.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.gjM.U(i, i2, i3);
    }

    public void abortAnimation() {
        this.gjM.finish();
        this.gjN.finish();
    }

    public boolean A(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.gjM.gjR - this.gjM.mStart)) && Math.signum(f2) == Math.signum((float) (this.gjN.gjR - this.gjN.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float gka = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] gkb = new float[101];
        private static final float[] gkc = new float[101];
        private int gjR;
        private int gjS;
        private float gjT;
        private float gjU;
        private int gjV;
        private int gjW;
        private int gjX;
        private float gjZ;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float gjY = ViewConfiguration.getScrollFriction();
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
                gkb[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                gkc[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = gkb;
            gkc[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.gjY = f;
        }

        a(Context context) {
            this.gjZ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aI(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.gjR - this.mStart) * f);
        }

        private static float tZ(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void O(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = gkc[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (gkc[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void P(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.gjR = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.gjU = 0.0f;
            this.gjS = 0;
        }

        void finish() {
            this.mCurrentPosition = this.gjR;
            this.mFinished = true;
        }

        boolean Q(int i, int i2, int i3) {
            this.mFinished = true;
            this.gjR = i;
            this.mStart = i;
            this.gjS = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                R(i, i2, 0);
            } else if (i > i3) {
                R(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void R(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.gjR = i2;
            int i4 = i - i2;
            this.gjU = tZ(i4);
            this.gjS = -i4;
            this.gjX = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.gjU) * 1000.0d);
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.gjX = i5;
            this.mFinished = false;
            this.gjS = i2;
            this.gjT = i2;
            this.gjV = 0;
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
                int uc = uc(i2);
                this.gjV = uc;
                this.mDuration = uc;
                d = ub(i2);
            }
            this.gjW = (int) (d * Math.signum(i2));
            this.gjR = this.gjW + i;
            if (this.gjR < i3) {
                O(this.mStart, this.gjR, i3);
                this.gjR = i3;
            }
            if (this.gjR > i4) {
                O(this.mStart, this.gjR, i4);
                this.gjR = i4;
            }
        }

        private double ua(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.gjY * this.gjZ));
        }

        private double ub(int i) {
            return Math.exp(ua(i) * (gka / (gka - 1.0d))) * this.gjY * this.gjZ;
        }

        private int uc(int i) {
            return (int) (Math.exp(ua(i) / (gka - 1.0d)) * 1000.0d);
        }

        private void S(int i, int i2, int i3) {
            float f = (-i3) / this.gjU;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.gjU)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.gjU));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.gjS = (int) ((-this.gjU) * sqrt);
        }

        private void T(int i, int i2, int i3) {
            this.gjU = tZ(i3 == 0 ? i - i2 : i3);
            S(i, i2, i3);
            bvm();
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
                T(i, i5, i4);
            } else if (ub(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.gjX);
            } else {
                R(i, i5, i4);
            }
        }

        void U(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.gjX = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                x(i, i2, i2, (int) this.gjT);
            }
        }

        private void bvm() {
            float abs = (this.gjS * this.gjS) / (Math.abs(this.gjU) * 2.0f);
            float signum = Math.signum(this.gjS);
            if (abs > this.gjX) {
                this.gjU = (((-signum) * this.gjS) * this.gjS) / (this.gjX * 2.0f);
                abs = this.gjX;
            }
            this.gjX = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.gjS <= 0) {
                abs = -abs;
            }
            this.gjR = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.gjS) / this.gjU));
        }

        boolean bvn() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.gjV) {
                        this.mStart = this.gjR;
                        this.gjS = (int) this.gjT;
                        this.gjU = tZ(this.gjS);
                        this.mStartTime += this.mDuration;
                        bvm();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    R(this.gjR, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.gjV;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = gkb[i];
                        f3 = (gkb[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.gjT = ((f3 * this.gjW) / this.gjV) * 1000.0f;
                    d = f2 * this.gjW;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.gjS);
                    d = this.gjX * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.gjT = ((-f6) + f7) * signum * this.gjX * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.gjT = this.gjS + (this.gjU * f8);
                    d = ((f8 * (this.gjU * f8)) / 2.0f) + (this.gjS * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
