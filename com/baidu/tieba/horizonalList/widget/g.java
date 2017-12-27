package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float egZ = 8.0f;
    private static float eha;
    private final a egW;
    private final a egX;
    private final boolean egY;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eha = 1.0f;
        eha = 1.0f / ai(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float ai(float f) {
        float exp;
        float f2 = egZ * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eha;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.egY = z;
        this.egW = new a(context);
        this.egX = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.egW.setFriction(f);
        this.egX.setFriction(f);
    }

    public final boolean isFinished() {
        return this.egW.mFinished && this.egX.mFinished;
    }

    public final int getCurrX() {
        return this.egW.Pp;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.egW.ehd * this.egW.ehd) + (this.egX.ehd * this.egX.ehd));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.egW.mStartTime;
                int i = this.egW.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ai(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.egW.aj(interpolation);
                    this.egX.aj(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.egW.mFinished && !this.egW.dB() && !this.egW.aBV()) {
                    this.egW.finish();
                }
                if (!this.egX.mFinished && !this.egX.dB() && !this.egX.aBV()) {
                    this.egX.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.egW.R(i, i3, i5);
        this.egX.R(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.egW.S(i, i3, i4) || this.egX.S(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.egY && !isFinished()) {
            float f = this.egW.ehd;
            float f2 = this.egX.ehd;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.egW.c(i, i11, i5, i6, i9);
                this.egX.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.egW.c(i, i11, i5, i6, i9);
        this.egX.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.egW.W(i, i2, i3);
    }

    public void abortAnimation() {
        this.egW.finish();
        this.egX.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.egW.ehb - this.egW.mStart)) && Math.signum(f2) == Math.signum((float) (this.egX.ehb - this.egX.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float ehk = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] ehl = new float[101];
        private static final float[] ehm = new float[101];
        private int Pp;
        private int ehb;
        private int ehc;
        private float ehd;
        private float ehe;
        private int ehf;
        private int ehg;
        private int ehh;
        private float ehj;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float ehi = ViewConfiguration.getScrollFriction();
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
                ehl[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                ehm[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = ehl;
            ehm[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.ehi = f;
        }

        a(Context context) {
            this.ehj = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aj(float f) {
            this.Pp = this.mStart + Math.round((this.ehb - this.mStart) * f);
        }

        private static float pk(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void Q(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = ehm[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (ehm[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void R(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.ehb = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.ehe = 0.0f;
            this.ehc = 0;
        }

        void finish() {
            this.Pp = this.ehb;
            this.mFinished = true;
        }

        boolean S(int i, int i2, int i3) {
            this.mFinished = true;
            this.ehb = i;
            this.mStart = i;
            this.ehc = 0;
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
            this.ehb = i2;
            int i4 = i - i2;
            this.ehe = pk(i4);
            this.ehc = -i4;
            this.ehh = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.ehe) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.ehh = i5;
            this.mFinished = false;
            this.ehc = i2;
            this.ehd = i2;
            this.ehf = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.Pp = i;
            if (i > i4 || i < i3) {
                A(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int pn = pn(i2);
                this.ehf = pn;
                this.mDuration = pn;
                d = pm(i2);
            }
            this.ehg = (int) (d * Math.signum(i2));
            this.ehb = this.ehg + i;
            if (this.ehb < i3) {
                Q(this.mStart, this.ehb, i3);
                this.ehb = i3;
            }
            if (this.ehb > i4) {
                Q(this.mStart, this.ehb, i4);
                this.ehb = i4;
            }
        }

        private double pl(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.ehi * this.ehj));
        }

        private double pm(int i) {
            return Math.exp(pl(i) * (ehk / (ehk - 1.0d))) * this.ehi * this.ehj;
        }

        private int pn(int i) {
            return (int) (Math.exp(pl(i) / (ehk - 1.0d)) * 1000.0d);
        }

        private void U(int i, int i2, int i3) {
            float f = (-i3) / this.ehe;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.ehe)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.ehe));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.ehc = (int) ((-this.ehe) * sqrt);
        }

        private void V(int i, int i2, int i3) {
            this.ehe = pk(i3 == 0 ? i - i2 : i3);
            U(i, i2, i3);
            aBU();
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
                V(i, i5, i4);
            } else if (pm(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.ehh);
            } else {
                T(i, i5, i4);
            }
        }

        void W(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.ehh = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                A(i, i2, i2, (int) this.ehd);
            }
        }

        private void aBU() {
            float abs = (this.ehc * this.ehc) / (Math.abs(this.ehe) * 2.0f);
            float signum = Math.signum(this.ehc);
            if (abs > this.ehh) {
                this.ehe = (((-signum) * this.ehc) * this.ehc) / (this.ehh * 2.0f);
                abs = this.ehh;
            }
            this.ehh = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.ehc <= 0) {
                abs = -abs;
            }
            this.ehb = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.ehc) / this.ehe));
        }

        boolean aBV() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.ehf) {
                        this.mStart = this.ehb;
                        this.ehc = (int) this.ehd;
                        this.ehe = pk(this.ehc);
                        this.mStartTime += this.mDuration;
                        aBU();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    T(this.ehb, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.ehf;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = ehl[i];
                        f3 = (ehl[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.ehd = ((f3 * this.ehg) / this.ehf) * 1000.0f;
                    d = f2 * this.ehg;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.ehc);
                    d = this.ehh * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.ehd = ((-f6) + f7) * signum * this.ehh * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.ehd = this.ehc + (this.ehe * f8);
                    d = ((f8 * (this.ehe * f8)) / 2.0f) + (this.ehc * f8);
                    break;
            }
            this.Pp = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
