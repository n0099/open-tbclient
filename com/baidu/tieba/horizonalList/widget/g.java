package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float emZ = 8.0f;
    private static float ena;
    private final a emW;
    private final a emX;
    private final boolean emY;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        ena = 1.0f;
        ena = 1.0f / an(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float an(float f) {
        float exp;
        float f2 = emZ * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * ena;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.emY = z;
        this.emW = new a(context);
        this.emX = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.emW.setFriction(f);
        this.emX.setFriction(f);
    }

    public final boolean isFinished() {
        return this.emW.mFinished && this.emX.mFinished;
    }

    public final int getCurrX() {
        return this.emW.Po;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.emW.ene * this.emW.ene) + (this.emX.ene * this.emX.ene));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.emW.mStartTime;
                int i = this.emW.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = an(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.emW.ao(interpolation);
                    this.emX.ao(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.emW.mFinished && !this.emW.dB() && !this.emW.aDz()) {
                    this.emW.finish();
                }
                if (!this.emX.mFinished && !this.emX.dB() && !this.emX.aDz()) {
                    this.emX.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.emW.S(i, i3, i5);
        this.emX.S(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.emW.T(i, i3, i4) || this.emX.T(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.emY && !isFinished()) {
            float f = this.emW.ene;
            float f2 = this.emX.ene;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.emW.b(i, i11, i5, i6, i9);
                this.emX.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.emW.b(i, i11, i5, i6, i9);
        this.emX.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.emW.X(i, i2, i3);
    }

    public void abortAnimation() {
        this.emW.finish();
        this.emX.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.emW.enb - this.emW.mStart)) && Math.signum(f2) == Math.signum((float) (this.emX.enb - this.emX.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float enl = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] enm = new float[101];
        private static final float[] enn = new float[101];
        private int Po;
        private int enb;
        private int enc;
        private float ene;
        private float enf;
        private int eng;
        private int enh;
        private int eni;
        private float enk;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float enj = ViewConfiguration.getScrollFriction();
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
                enm[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                enn[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = enm;
            enn[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.enj = f;
        }

        a(Context context) {
            this.enk = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ao(float f) {
            this.Po = this.mStart + Math.round((this.enb - this.mStart) * f);
        }

        private static float pe(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void R(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = enn[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (enn[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void S(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.enb = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.enf = 0.0f;
            this.enc = 0;
        }

        void finish() {
            this.Po = this.enb;
            this.mFinished = true;
        }

        boolean T(int i, int i2, int i3) {
            this.mFinished = true;
            this.enb = i;
            this.mStart = i;
            this.enc = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                U(i, i2, 0);
            } else if (i > i3) {
                U(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void U(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.enb = i2;
            int i4 = i - i2;
            this.enf = pe(i4);
            this.enc = -i4;
            this.eni = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.enf) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.eni = i5;
            this.mFinished = false;
            this.enc = i2;
            this.ene = i2;
            this.eng = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.Po = i;
            if (i > i4 || i < i3) {
                A(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int ph = ph(i2);
                this.eng = ph;
                this.mDuration = ph;
                d = pg(i2);
            }
            this.enh = (int) (d * Math.signum(i2));
            this.enb = this.enh + i;
            if (this.enb < i3) {
                R(this.mStart, this.enb, i3);
                this.enb = i3;
            }
            if (this.enb > i4) {
                R(this.mStart, this.enb, i4);
                this.enb = i4;
            }
        }

        private double pf(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.enj * this.enk));
        }

        private double pg(int i) {
            return Math.exp(pf(i) * (enl / (enl - 1.0d))) * this.enj * this.enk;
        }

        private int ph(int i) {
            return (int) (Math.exp(pf(i) / (enl - 1.0d)) * 1000.0d);
        }

        private void V(int i, int i2, int i3) {
            float f = (-i3) / this.enf;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.enf)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.enf));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.enc = (int) ((-this.enf) * sqrt);
        }

        private void W(int i, int i2, int i3) {
            this.enf = pe(i3 == 0 ? i - i2 : i3);
            V(i, i2, i3);
            aDy();
        }

        private void A(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                W(i, i5, i4);
            } else if (pg(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.eni);
            } else {
                U(i, i5, i4);
            }
        }

        void X(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eni = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                A(i, i2, i2, (int) this.ene);
            }
        }

        private void aDy() {
            float abs = (this.enc * this.enc) / (Math.abs(this.enf) * 2.0f);
            float signum = Math.signum(this.enc);
            if (abs > this.eni) {
                this.enf = (((-signum) * this.enc) * this.enc) / (this.eni * 2.0f);
                abs = this.eni;
            }
            this.eni = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.enc <= 0) {
                abs = -abs;
            }
            this.enb = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.enc) / this.enf));
        }

        boolean aDz() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eng) {
                        this.mStart = this.enb;
                        this.enc = (int) this.ene;
                        this.enf = pe(this.enc);
                        this.mStartTime += this.mDuration;
                        aDy();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    U(this.enb, this.mStart, 0);
                    break;
            }
            dB();
            return true;
        }

        boolean dB() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.eng;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = enm[i];
                        f3 = (enm[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.ene = ((f3 * this.enh) / this.eng) * 1000.0f;
                    d = f2 * this.enh;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.enc);
                    d = this.eni * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.ene = ((-f6) + f7) * signum * this.eni * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.ene = this.enc + (this.enf * f8);
                    d = ((f8 * (this.enf * f8)) / 2.0f) + (this.enc * f8);
                    break;
            }
            this.Po = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
