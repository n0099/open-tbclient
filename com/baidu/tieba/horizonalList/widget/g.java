package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float ene = 8.0f;
    private static float enf;
    private final a ena;
    private final a enb;
    private final boolean enc;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        enf = 1.0f;
        enf = 1.0f / an(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float an(float f) {
        float exp;
        float f2 = ene * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * enf;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.enc = z;
        this.ena = new a(context);
        this.enb = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.ena.setFriction(f);
        this.enb.setFriction(f);
    }

    public final boolean isFinished() {
        return this.ena.mFinished && this.enb.mFinished;
    }

    public final int getCurrX() {
        return this.ena.Pj;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.ena.eni * this.ena.eni) + (this.enb.eni * this.enb.eni));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.ena.mStartTime;
                int i = this.ena.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = an(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.ena.ao(interpolation);
                    this.enb.ao(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.ena.mFinished && !this.ena.dB() && !this.ena.aDz()) {
                    this.ena.finish();
                }
                if (!this.enb.mFinished && !this.enb.dB() && !this.enb.aDz()) {
                    this.enb.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.ena.S(i, i3, i5);
        this.enb.S(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.ena.T(i, i3, i4) || this.enb.T(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.enc && !isFinished()) {
            float f = this.ena.eni;
            float f2 = this.enb.eni;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.ena.b(i, i11, i5, i6, i9);
                this.enb.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.ena.b(i, i11, i5, i6, i9);
        this.enb.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.ena.X(i, i2, i3);
    }

    public void abortAnimation() {
        this.ena.finish();
        this.enb.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.ena.eng - this.ena.mStart)) && Math.signum(f2) == Math.signum((float) (this.enb.eng - this.enb.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float enp = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] enq = new float[101];
        private static final float[] enr = new float[101];
        private int Pj;
        private int eng;
        private int enh;
        private float eni;
        private float enj;
        private int enk;
        private int enl;
        private int enm;
        private float eno;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float enn = ViewConfiguration.getScrollFriction();
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
                enq[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                enr[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = enq;
            enr[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.enn = f;
        }

        a(Context context) {
            this.eno = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ao(float f) {
            this.Pj = this.mStart + Math.round((this.eng - this.mStart) * f);
        }

        private static float pf(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void R(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = enr[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (enr[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void S(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eng = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.enj = 0.0f;
            this.enh = 0;
        }

        void finish() {
            this.Pj = this.eng;
            this.mFinished = true;
        }

        boolean T(int i, int i2, int i3) {
            this.mFinished = true;
            this.eng = i;
            this.mStart = i;
            this.enh = 0;
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
            this.eng = i2;
            int i4 = i - i2;
            this.enj = pf(i4);
            this.enh = -i4;
            this.enm = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.enj) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.enm = i5;
            this.mFinished = false;
            this.enh = i2;
            this.eni = i2;
            this.enk = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.Pj = i;
            if (i > i4 || i < i3) {
                A(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int pi = pi(i2);
                this.enk = pi;
                this.mDuration = pi;
                d = ph(i2);
            }
            this.enl = (int) (d * Math.signum(i2));
            this.eng = this.enl + i;
            if (this.eng < i3) {
                R(this.mStart, this.eng, i3);
                this.eng = i3;
            }
            if (this.eng > i4) {
                R(this.mStart, this.eng, i4);
                this.eng = i4;
            }
        }

        private double pg(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.enn * this.eno));
        }

        private double ph(int i) {
            return Math.exp(pg(i) * (enp / (enp - 1.0d))) * this.enn * this.eno;
        }

        private int pi(int i) {
            return (int) (Math.exp(pg(i) / (enp - 1.0d)) * 1000.0d);
        }

        private void V(int i, int i2, int i3) {
            float f = (-i3) / this.enj;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.enj)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.enj));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.enh = (int) ((-this.enj) * sqrt);
        }

        private void W(int i, int i2, int i3) {
            this.enj = pf(i3 == 0 ? i - i2 : i3);
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
            } else if (ph(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.enm);
            } else {
                U(i, i5, i4);
            }
        }

        void X(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.enm = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                A(i, i2, i2, (int) this.eni);
            }
        }

        private void aDy() {
            float abs = (this.enh * this.enh) / (Math.abs(this.enj) * 2.0f);
            float signum = Math.signum(this.enh);
            if (abs > this.enm) {
                this.enj = (((-signum) * this.enh) * this.enh) / (this.enm * 2.0f);
                abs = this.enm;
            }
            this.enm = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.enh <= 0) {
                abs = -abs;
            }
            this.eng = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.enh) / this.enj));
        }

        boolean aDz() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.enk) {
                        this.mStart = this.eng;
                        this.enh = (int) this.eni;
                        this.enj = pf(this.enh);
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
                    U(this.eng, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.enk;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = enq[i];
                        f3 = (enq[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eni = ((f3 * this.enl) / this.enk) * 1000.0f;
                    d = f2 * this.enl;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.enh);
                    d = this.enm * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eni = ((-f6) + f7) * signum * this.enm * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eni = this.enh + (this.enj * f8);
                    d = ((f8 * (this.enj * f8)) / 2.0f) + (this.enh * f8);
                    break;
            }
            this.Pj = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
