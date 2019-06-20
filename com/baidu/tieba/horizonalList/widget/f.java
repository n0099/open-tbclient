package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float gjS = 8.0f;
    private static float gjT;
    private final a gjP;
    private final a gjQ;
    private final boolean gjR;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        gjT = 1.0f;
        gjT = 1.0f / aH(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aH(float f) {
        float exp;
        float f2 = gjS * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * gjT;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.gjR = z;
        this.gjP = new a(context);
        this.gjQ = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.gjP.setFriction(f);
        this.gjQ.setFriction(f);
    }

    public final boolean isFinished() {
        return this.gjP.mFinished && this.gjQ.mFinished;
    }

    public final int getCurrX() {
        return this.gjP.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.gjP.gjW * this.gjP.gjW) + (this.gjQ.gjW * this.gjQ.gjW));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.gjP.mStartTime;
                int i = this.gjP.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aH(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.gjP.aI(interpolation);
                    this.gjQ.aI(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.gjP.mFinished && !this.gjP.update() && !this.gjP.bvr()) {
                    this.gjP.finish();
                }
                if (!this.gjQ.mFinished && !this.gjQ.update() && !this.gjQ.bvr()) {
                    this.gjQ.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.gjP.P(i, i3, i5);
        this.gjQ.P(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.gjP.Q(i, i3, i4) || this.gjQ.Q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.gjR && !isFinished()) {
            float f = this.gjP.gjW;
            float f2 = this.gjQ.gjW;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.gjP.e(i, i11, i5, i6, i9);
                this.gjQ.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.gjP.e(i, i11, i5, i6, i9);
        this.gjQ.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.gjP.U(i, i2, i3);
    }

    public void abortAnimation() {
        this.gjP.finish();
        this.gjQ.finish();
    }

    public boolean A(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.gjP.gjU - this.gjP.mStart)) && Math.signum(f2) == Math.signum((float) (this.gjQ.gjU - this.gjQ.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float gkd = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] gke = new float[101];
        private static final float[] gkf = new float[101];
        private int gjU;
        private int gjV;
        private float gjW;
        private float gjX;
        private int gjY;
        private int gjZ;
        private int gka;
        private float gkc;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float gkb = ViewConfiguration.getScrollFriction();
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
                gke[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                gkf[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = gke;
            gkf[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.gkb = f;
        }

        a(Context context) {
            this.gkc = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aI(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.gjU - this.mStart) * f);
        }

        private static float tZ(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void O(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = gkf[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (gkf[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void P(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.gjU = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.gjX = 0.0f;
            this.gjV = 0;
        }

        void finish() {
            this.mCurrentPosition = this.gjU;
            this.mFinished = true;
        }

        boolean Q(int i, int i2, int i3) {
            this.mFinished = true;
            this.gjU = i;
            this.mStart = i;
            this.gjV = 0;
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
            this.gjU = i2;
            int i4 = i - i2;
            this.gjX = tZ(i4);
            this.gjV = -i4;
            this.gka = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.gjX) * 1000.0d);
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.gka = i5;
            this.mFinished = false;
            this.gjV = i2;
            this.gjW = i2;
            this.gjY = 0;
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
                this.gjY = uc;
                this.mDuration = uc;
                d = ub(i2);
            }
            this.gjZ = (int) (d * Math.signum(i2));
            this.gjU = this.gjZ + i;
            if (this.gjU < i3) {
                O(this.mStart, this.gjU, i3);
                this.gjU = i3;
            }
            if (this.gjU > i4) {
                O(this.mStart, this.gjU, i4);
                this.gjU = i4;
            }
        }

        private double ua(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.gkb * this.gkc));
        }

        private double ub(int i) {
            return Math.exp(ua(i) * (gkd / (gkd - 1.0d))) * this.gkb * this.gkc;
        }

        private int uc(int i) {
            return (int) (Math.exp(ua(i) / (gkd - 1.0d)) * 1000.0d);
        }

        private void S(int i, int i2, int i3) {
            float f = (-i3) / this.gjX;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.gjX)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.gjX));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.gjV = (int) ((-this.gjX) * sqrt);
        }

        private void T(int i, int i2, int i3) {
            this.gjX = tZ(i3 == 0 ? i - i2 : i3);
            S(i, i2, i3);
            bvq();
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
                e(i, i4, z ? i2 : i, z ? i : i3, this.gka);
            } else {
                R(i, i5, i4);
            }
        }

        void U(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.gka = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                x(i, i2, i2, (int) this.gjW);
            }
        }

        private void bvq() {
            float abs = (this.gjV * this.gjV) / (Math.abs(this.gjX) * 2.0f);
            float signum = Math.signum(this.gjV);
            if (abs > this.gka) {
                this.gjX = (((-signum) * this.gjV) * this.gjV) / (this.gka * 2.0f);
                abs = this.gka;
            }
            this.gka = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.gjV <= 0) {
                abs = -abs;
            }
            this.gjU = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.gjV) / this.gjX));
        }

        boolean bvr() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.gjY) {
                        this.mStart = this.gjU;
                        this.gjV = (int) this.gjW;
                        this.gjX = tZ(this.gjV);
                        this.mStartTime += this.mDuration;
                        bvq();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    R(this.gjU, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.gjY;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = gke[i];
                        f3 = (gke[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.gjW = ((f3 * this.gjZ) / this.gjY) * 1000.0f;
                    d = f2 * this.gjZ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.gjV);
                    d = this.gka * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.gjW = ((-f6) + f7) * signum * this.gka * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.gjW = this.gjV + (this.gjX * f8);
                    d = ((f8 * (this.gjX * f8)) / 2.0f) + (this.gjV * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
