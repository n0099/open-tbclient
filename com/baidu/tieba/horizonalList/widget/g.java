package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float dlZ = 8.0f;
    private static float dma;
    private final a dlW;
    private final a dlX;
    private final boolean dlY;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dma = 1.0f;
        dma = 1.0f / R(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float R(float f) {
        float exp;
        float f2 = dlZ * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dma;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dlY = z;
        this.dlW = new a(context);
        this.dlX = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dlW.setFriction(f);
        this.dlX.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dlW.dmh && this.dlX.dmh;
    }

    public final int getCurrX() {
        return this.dlW.cKw;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dlW.dmd * this.dlW.dmd) + (this.dlX.dmd * this.dlX.dmd));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dlW.mStartTime;
                int i = this.dlW.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = R(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dlW.S(interpolation);
                    this.dlX.S(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dlW.dmh && !this.dlW.atk() && !this.dlW.atj()) {
                    this.dlW.finish();
                }
                if (!this.dlX.dmh && !this.dlX.atk() && !this.dlX.atj()) {
                    this.dlX.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dlW.J(i, i3, i5);
        this.dlX.J(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dlW.K(i, i3, i4) || this.dlX.K(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dlY && !isFinished()) {
            float f = this.dlW.dmd;
            float f2 = this.dlX.dmd;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dlW.c(i, i11, i5, i6, i9);
                this.dlX.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dlW.c(i, i11, i5, i6, i9);
        this.dlX.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dlW.O(i, i2, i3);
    }

    public void abortAnimation() {
        this.dlW.finish();
        this.dlX.finish();
    }

    public boolean k(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dlW.dmb - this.dlW.mStart)) && Math.signum(f2) == Math.signum((float) (this.dlX.dmb - this.dlX.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dml = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dmm = new float[101];
        private static final float[] dmn = new float[101];
        private int cKw;
        private int dmb;
        private int dmc;
        private float dmd;
        private float dme;
        private int dmf;
        private int dmg;
        private int dmi;
        private float dmk;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dmj = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dmh = true;

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
                dmm[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dmn[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dmm;
            dmn[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dmj = f;
        }

        a(Context context) {
            this.dmk = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void S(float f) {
            this.cKw = this.mStart + Math.round((this.dmb - this.mStart) * f);
        }

        private static float lY(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void I(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dmn[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dmn[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void J(int i, int i2, int i3) {
            this.dmh = false;
            this.mStart = i;
            this.dmb = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dme = 0.0f;
            this.dmc = 0;
        }

        void finish() {
            this.cKw = this.dmb;
            this.dmh = true;
        }

        boolean K(int i, int i2, int i3) {
            this.dmh = true;
            this.dmb = i;
            this.mStart = i;
            this.dmc = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                L(i, i2, 0);
            } else if (i > i3) {
                L(i, i3, 0);
            }
            return !this.dmh;
        }

        private void L(int i, int i2, int i3) {
            this.dmh = false;
            this.mState = 1;
            this.mStart = i;
            this.dmb = i2;
            int i4 = i - i2;
            this.dme = lY(i4);
            this.dmc = -i4;
            this.dmi = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dme) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.dmi = i5;
            this.dmh = false;
            this.dmc = i2;
            this.dmd = i2;
            this.dmf = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cKw = i;
            if (i > i4 || i < i3) {
                s(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int mb = mb(i2);
                this.dmf = mb;
                this.mDuration = mb;
                d = ma(i2);
            }
            this.dmg = (int) (d * Math.signum(i2));
            this.dmb = this.dmg + i;
            if (this.dmb < i3) {
                I(this.mStart, this.dmb, i3);
                this.dmb = i3;
            }
            if (this.dmb > i4) {
                I(this.mStart, this.dmb, i4);
                this.dmb = i4;
            }
        }

        private double lZ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dmj * this.dmk));
        }

        private double ma(int i) {
            return Math.exp(lZ(i) * (dml / (dml - 1.0d))) * this.dmj * this.dmk;
        }

        private int mb(int i) {
            return (int) (Math.exp(lZ(i) / (dml - 1.0d)) * 1000.0d);
        }

        private void M(int i, int i2, int i3) {
            float f = (-i3) / this.dme;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dme)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dme));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dmc = (int) ((-this.dme) * sqrt);
        }

        private void N(int i, int i2, int i3) {
            this.dme = lY(i3 == 0 ? i - i2 : i3);
            M(i, i2, i3);
            ati();
        }

        private void s(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dmh = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                N(i, i5, i4);
            } else if (ma(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.dmi);
            } else {
                L(i, i5, i4);
            }
        }

        void O(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dmi = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.dmd);
            }
        }

        private void ati() {
            float abs = (this.dmc * this.dmc) / (Math.abs(this.dme) * 2.0f);
            float signum = Math.signum(this.dmc);
            if (abs > this.dmi) {
                this.dme = (((-signum) * this.dmc) * this.dmc) / (this.dmi * 2.0f);
                abs = this.dmi;
            }
            this.dmi = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dmc <= 0) {
                abs = -abs;
            }
            this.dmb = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dmc) / this.dme));
        }

        boolean atj() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dmf) {
                        this.mStart = this.dmb;
                        this.dmc = (int) this.dmd;
                        this.dme = lY(this.dmc);
                        this.mStartTime += this.mDuration;
                        ati();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    L(this.dmb, this.mStart, 0);
                    break;
            }
            atk();
            return true;
        }

        boolean atk() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.dmf;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dmm[i];
                        f3 = (dmm[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dmd = ((f3 * this.dmg) / this.dmf) * 1000.0f;
                    d = f2 * this.dmg;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dmc);
                    d = this.dmi * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dmd = ((-f6) + f7) * signum * this.dmi * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dmd = this.dmc + (this.dme * f8);
                    d = ((f8 * (this.dme * f8)) / 2.0f) + (this.dmc * f8);
                    break;
            }
            this.cKw = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
