package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float bhk = 8.0f;
    private static float bhl;
    private final boolean bhj;
    private final a iHV;
    private final a iHW;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bhl = 1.0f;
        bhl = 1.0f / s(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float s(float f) {
        float exp;
        float f2 = bhk * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bhl;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bhj = z;
        this.iHV = new a(context);
        this.iHW = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.iHV.setFriction(f);
        this.iHW.setFriction(f);
    }

    public final boolean isFinished() {
        return this.iHV.mFinished && this.iHW.mFinished;
    }

    public final int getCurrX() {
        return this.iHV.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.iHV.bho * this.iHV.bho) + (this.iHW.bho * this.iHW.bho));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.iHV.mStartTime;
                int i = this.iHV.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = s(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.iHV.t(interpolation);
                    this.iHW.t(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.iHV.mFinished && !this.iHV.update() && !this.iHV.Ik()) {
                    this.iHV.finish();
                }
                if (!this.iHW.mFinished && !this.iHW.update() && !this.iHW.Ik()) {
                    this.iHW.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.iHV.o(i, i3, i5);
        this.iHW.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.iHV.p(i, i3, i4) || this.iHW.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bhj && !isFinished()) {
            float f = this.iHV.bho;
            float f2 = this.iHW.bho;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.iHV.b(i, i11, i5, i6, i9);
                this.iHW.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.iHV.b(i, i11, i5, i6, i9);
        this.iHW.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.iHV.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.iHV.finish();
        this.iHW.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.iHV.bhm - this.iHV.mStart)) && Math.signum(f2) == Math.signum((float) (this.iHW.bhm - this.iHW.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bhv = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bhw = new float[101];
        private static final float[] bhx = new float[101];
        private int bhm;
        private int bhn;
        private float bho;
        private float bhp;
        private int bhq;
        private int bhr;
        private int bhs;
        private float bhu;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bht = ViewConfiguration.getScrollFriction();
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
                bhw[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bhx[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bhw;
            bhx[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bht = f;
        }

        a(Context context) {
            this.bhu = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void t(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bhm - this.mStart) * f);
        }

        private static float dn(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bhx[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bhx[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bhm = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bhp = 0.0f;
            this.bhn = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bhm;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.bhm = i;
            this.mStart = i;
            this.bhn = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                q(i, i2, 0);
            } else if (i > i3) {
                q(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void q(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.bhm = i2;
            int i4 = i - i2;
            this.bhp = dn(i4);
            this.bhn = -i4;
            this.bhs = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bhp) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bhs = i5;
            this.mFinished = false;
            this.bhn = i2;
            this.bho = i2;
            this.bhq = 0;
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
                int dq = dq(i2);
                this.bhq = dq;
                this.mDuration = dq;
                d = dp(i2);
            }
            this.bhr = (int) (d * Math.signum(i2));
            this.bhm = this.bhr + i;
            if (this.bhm < i3) {
                n(this.mStart, this.bhm, i3);
                this.bhm = i3;
            }
            if (this.bhm > i4) {
                n(this.mStart, this.bhm, i4);
                this.bhm = i4;
            }
        }

        /* renamed from: do  reason: not valid java name */
        private double m35do(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bht * this.bhu));
        }

        private double dp(int i) {
            return Math.exp(m35do(i) * (bhv / (bhv - 1.0d))) * this.bht * this.bhu;
        }

        private int dq(int i) {
            return (int) (Math.exp(m35do(i) / (bhv - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.bhp;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bhp)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bhp));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bhn = (int) ((-this.bhp) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.bhp = dn(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            Ij();
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
                s(i, i5, i4);
            } else if (dp(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bhs);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bhs = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.bho);
            }
        }

        private void Ij() {
            float abs = (this.bhn * this.bhn) / (Math.abs(this.bhp) * 2.0f);
            float signum = Math.signum(this.bhn);
            if (abs > this.bhs) {
                this.bhp = (((-signum) * this.bhn) * this.bhn) / (this.bhs * 2.0f);
                abs = this.bhs;
            }
            this.bhs = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bhn <= 0) {
                abs = -abs;
            }
            this.bhm = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bhn) / this.bhp));
        }

        boolean Ik() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bhq) {
                        this.mStart = this.bhm;
                        this.bhn = (int) this.bho;
                        this.bhp = dn(this.bhn);
                        this.mStartTime += this.mDuration;
                        Ij();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.bhm, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bhq;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bhw[i];
                        f3 = (bhw[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bho = ((f3 * this.bhr) / this.bhq) * 1000.0f;
                    d = f2 * this.bhr;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bhn);
                    d = this.bhs * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bho = ((-f6) + f7) * signum * this.bhs * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bho = this.bhn + (this.bhp * f8);
                    d = ((f8 * (this.bhp * f8)) / 2.0f) + (this.bhn * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
