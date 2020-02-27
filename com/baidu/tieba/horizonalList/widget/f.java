package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float aAr = 8.0f;
    private static float aAs;
    private final boolean aAq;
    private final a hjO;
    private final a hjP;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        aAs = 1.0f;
        aAs = 1.0f / J(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float J(float f) {
        float exp;
        float f2 = aAr * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * aAs;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.aAq = z;
        this.hjO = new a(context);
        this.hjP = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.hjO.setFriction(f);
        this.hjP.setFriction(f);
    }

    public final boolean isFinished() {
        return this.hjO.mFinished && this.hjP.mFinished;
    }

    public final int getCurrX() {
        return this.hjO.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.hjO.aAv * this.hjO.aAv) + (this.hjP.aAv * this.hjP.aAv));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.hjO.mStartTime;
                int i = this.hjO.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = J(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.hjO.K(interpolation);
                    this.hjP.K(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.hjO.mFinished && !this.hjO.update() && !this.hjO.zU()) {
                    this.hjO.finish();
                }
                if (!this.hjP.mFinished && !this.hjP.update() && !this.hjP.zU()) {
                    this.hjP.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.hjO.m(i, i3, i5);
        this.hjP.m(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.hjO.n(i, i3, i4) || this.hjP.n(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.aAq && !isFinished()) {
            float f = this.hjO.aAv;
            float f2 = this.hjP.aAv;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.hjO.b(i, i11, i5, i6, i9);
                this.hjP.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.hjO.b(i, i11, i5, i6, i9);
        this.hjP.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.hjO.r(i, i2, i3);
    }

    public void abortAnimation() {
        this.hjO.finish();
        this.hjP.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.hjO.aAt - this.hjO.mStart)) && Math.signum(f2) == Math.signum((float) (this.hjP.aAt - this.hjP.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float aAC = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] aAD = new float[101];
        private static final float[] aAE = new float[101];
        private float aAB;
        private int aAt;
        private int aAu;
        private float aAv;
        private float aAw;
        private int aAx;
        private int aAy;
        private int aAz;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float aAA = ViewConfiguration.getScrollFriction();
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
                aAD[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                aAE[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = aAD;
            aAE[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.aAA = f;
        }

        a(Context context) {
            this.aAB = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void K(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.aAt - this.mStart) * f);
        }

        private static float cF(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void l(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = aAE[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (aAE[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void m(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.aAt = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.aAw = 0.0f;
            this.aAu = 0;
        }

        void finish() {
            this.mCurrentPosition = this.aAt;
            this.mFinished = true;
        }

        boolean n(int i, int i2, int i3) {
            this.mFinished = true;
            this.aAt = i;
            this.mStart = i;
            this.aAu = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                o(i, i2, 0);
            } else if (i > i3) {
                o(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.aAt = i2;
            int i4 = i - i2;
            this.aAw = cF(i4);
            this.aAu = -i4;
            this.aAz = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.aAw) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.aAz = i5;
            this.mFinished = false;
            this.aAu = i2;
            this.aAv = i2;
            this.aAx = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                h(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int cI = cI(i2);
                this.aAx = cI;
                this.mDuration = cI;
                d = cH(i2);
            }
            this.aAy = (int) (d * Math.signum(i2));
            this.aAt = this.aAy + i;
            if (this.aAt < i3) {
                l(this.mStart, this.aAt, i3);
                this.aAt = i3;
            }
            if (this.aAt > i4) {
                l(this.mStart, this.aAt, i4);
                this.aAt = i4;
            }
        }

        private double cG(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.aAA * this.aAB));
        }

        private double cH(int i) {
            return Math.exp(cG(i) * (aAC / (aAC - 1.0d))) * this.aAA * this.aAB;
        }

        private int cI(int i) {
            return (int) (Math.exp(cG(i) / (aAC - 1.0d)) * 1000.0d);
        }

        private void p(int i, int i2, int i3) {
            float f = (-i3) / this.aAw;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.aAw)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.aAw));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.aAu = (int) ((-this.aAw) * sqrt);
        }

        private void q(int i, int i2, int i3) {
            this.aAw = cF(i3 == 0 ? i - i2 : i3);
            p(i, i2, i3);
            zT();
        }

        private void h(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                q(i, i5, i4);
            } else if (cH(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.aAz);
            } else {
                o(i, i5, i4);
            }
        }

        void r(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.aAz = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.aAv);
            }
        }

        private void zT() {
            float abs = (this.aAu * this.aAu) / (Math.abs(this.aAw) * 2.0f);
            float signum = Math.signum(this.aAu);
            if (abs > this.aAz) {
                this.aAw = (((-signum) * this.aAu) * this.aAu) / (this.aAz * 2.0f);
                abs = this.aAz;
            }
            this.aAz = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.aAu <= 0) {
                abs = -abs;
            }
            this.aAt = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.aAu) / this.aAw));
        }

        boolean zU() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.aAx) {
                        this.mStart = this.aAt;
                        this.aAu = (int) this.aAv;
                        this.aAw = cF(this.aAu);
                        this.mStartTime += this.mDuration;
                        zT();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    o(this.aAt, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.aAx;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = aAD[i];
                        f3 = (aAD[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.aAv = ((f3 * this.aAy) / this.aAx) * 1000.0f;
                    d = f2 * this.aAy;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.aAu);
                    d = this.aAz * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.aAv = ((-f6) + f7) * signum * this.aAz * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.aAv = this.aAu + (this.aAw * f8);
                    d = ((f8 * (this.aAw * f8)) / 2.0f) + (this.aAu * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
