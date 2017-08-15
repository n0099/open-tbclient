package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float dap = 8.0f;
    private static float daq;
    private final a dam;
    private final a dan;
    private final boolean dao;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        daq = 1.0f;
        daq = 1.0f / Z(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float Z(float f) {
        float exp;
        float f2 = dap * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * daq;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dao = z;
        this.dam = new a(context);
        this.dan = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dam.setFriction(f);
        this.dan.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dam.lh && this.dan.lh;
    }

    public final int getCurrX() {
        return this.dam.cuk;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dam.dau * this.dam.dau) + (this.dan.dau * this.dan.dau));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dam.mStartTime;
                int i = this.dam.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = Z(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dam.aa(interpolation);
                    this.dan.aa(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dam.lh && !this.dam.aqh() && !this.dam.aqg()) {
                    this.dam.finish();
                }
                if (!this.dan.lh && !this.dan.aqh() && !this.dan.aqg()) {
                    this.dan.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dam.B(i, i3, i5);
        this.dan.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dam.C(i, i3, i4) || this.dan.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dao && !isFinished()) {
            float f = this.dam.dau;
            float f2 = this.dan.dau;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dam.f(i, i11, i5, i6, i9);
                this.dan.f(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dam.f(i, i11, i5, i6, i9);
        this.dan.f(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dam.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.dam.finish();
        this.dan.finish();
    }

    public boolean k(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dam.dar - this.dam.mStart)) && Math.signum(f2) == Math.signum((float) (this.dan.dar - this.dan.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float daC = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] daD = new float[101];
        private static final float[] daE = new float[101];
        private int cuk;
        private float daB;
        private int dar;
        private int das;
        private float dau;
        private float dav;
        private int daw;
        private int dax;
        private int daz;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float daA = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean lh = true;

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
                daD[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                daE[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = daD;
            daE[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.daA = f;
        }

        a(Context context) {
            this.daB = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aa(float f) {
            this.cuk = this.mStart + Math.round((this.dar - this.mStart) * f);
        }

        private static float lt(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = daE[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (daE[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void B(int i, int i2, int i3) {
            this.lh = false;
            this.mStart = i;
            this.dar = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dav = 0.0f;
            this.das = 0;
        }

        void finish() {
            this.cuk = this.dar;
            this.lh = true;
        }

        boolean C(int i, int i2, int i3) {
            this.lh = true;
            this.dar = i;
            this.mStart = i;
            this.das = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.lh;
        }

        private void D(int i, int i2, int i3) {
            this.lh = false;
            this.mState = 1;
            this.mStart = i;
            this.dar = i2;
            int i4 = i - i2;
            this.dav = lt(i4);
            this.das = -i4;
            this.daz = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dav) * 1000.0d);
        }

        void f(int i, int i2, int i3, int i4, int i5) {
            this.daz = i5;
            this.lh = false;
            this.das = i2;
            this.dau = i2;
            this.daw = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cuk = i;
            if (i > i4 || i < i3) {
                p(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lw = lw(i2);
                this.daw = lw;
                this.mDuration = lw;
                d = lv(i2);
            }
            this.dax = (int) (d * Math.signum(i2));
            this.dar = this.dax + i;
            if (this.dar < i3) {
                A(this.mStart, this.dar, i3);
                this.dar = i3;
            }
            if (this.dar > i4) {
                A(this.mStart, this.dar, i4);
                this.dar = i4;
            }
        }

        private double lu(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.daA * this.daB));
        }

        private double lv(int i) {
            return Math.exp(lu(i) * (daC / (daC - 1.0d))) * this.daA * this.daB;
        }

        private int lw(int i) {
            return (int) (Math.exp(lu(i) / (daC - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.dav;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dav)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dav));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.das = (int) ((-this.dav) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.dav = lt(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            aqf();
        }

        private void p(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.lh = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (lv(i4) > Math.abs(i6)) {
                f(i, i4, z ? i2 : i, z ? i : i3, this.daz);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.daz = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                p(i, i2, i2, (int) this.dau);
            }
        }

        private void aqf() {
            float abs = (this.das * this.das) / (Math.abs(this.dav) * 2.0f);
            float signum = Math.signum(this.das);
            if (abs > this.daz) {
                this.dav = (((-signum) * this.das) * this.das) / (this.daz * 2.0f);
                abs = this.daz;
            }
            this.daz = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.das <= 0) {
                abs = -abs;
            }
            this.dar = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.das) / this.dav));
        }

        boolean aqg() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.daw) {
                        this.mStart = this.dar;
                        this.das = (int) this.dau;
                        this.dav = lt(this.das);
                        this.mStartTime += this.mDuration;
                        aqf();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    D(this.dar, this.mStart, 0);
                    break;
            }
            aqh();
            return true;
        }

        boolean aqh() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.daw;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = daD[i];
                        f3 = (daD[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dau = ((f3 * this.dax) / this.daw) * 1000.0f;
                    d = f2 * this.dax;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.das);
                    d = this.daz * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dau = ((-f6) + f7) * signum * this.daz * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dau = this.das + (this.dav * f8);
                    d = ((f8 * (this.dav * f8)) / 2.0f) + (this.das * f8);
                    break;
            }
            this.cuk = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
