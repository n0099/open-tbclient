package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float eiu = 8.0f;
    private static float eiv;
    private final a eir;
    private final a eis;
    private final boolean eit;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eiv = 1.0f;
        eiv = 1.0f / ah(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float ah(float f) {
        float exp;
        float f2 = eiu * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eiv;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eit = z;
        this.eir = new a(context);
        this.eis = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eir.setFriction(f);
        this.eis.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eir.mFinished && this.eis.mFinished;
    }

    public final int getCurrX() {
        return this.eir.Pp;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eir.eiy * this.eir.eiy) + (this.eis.eiy * this.eis.eiy));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eir.mStartTime;
                int i = this.eir.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ah(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eir.ai(interpolation);
                    this.eis.ai(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eir.mFinished && !this.eir.dB() && !this.eir.aCa()) {
                    this.eir.finish();
                }
                if (!this.eis.mFinished && !this.eis.dB() && !this.eis.aCa()) {
                    this.eis.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eir.R(i, i3, i5);
        this.eis.R(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eir.S(i, i3, i4) || this.eis.S(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eit && !isFinished()) {
            float f = this.eir.eiy;
            float f2 = this.eis.eiy;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eir.c(i, i11, i5, i6, i9);
                this.eis.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eir.c(i, i11, i5, i6, i9);
        this.eis.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eir.W(i, i2, i3);
    }

    public void abortAnimation() {
        this.eir.finish();
        this.eis.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eir.eiw - this.eir.mStart)) && Math.signum(f2) == Math.signum((float) (this.eis.eiw - this.eis.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float eiF = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] eiG = new float[101];
        private static final float[] eiH = new float[101];
        private int Pp;
        private int eiA;
        private int eiB;
        private int eiC;
        private float eiE;
        private int eiw;
        private int eix;
        private float eiy;
        private float eiz;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float eiD = ViewConfiguration.getScrollFriction();
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
                eiG[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                eiH[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = eiG;
            eiH[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.eiD = f;
        }

        a(Context context) {
            this.eiE = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ai(float f) {
            this.Pp = this.mStart + Math.round((this.eiw - this.mStart) * f);
        }

        private static float pd(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void Q(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = eiH[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (eiH[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void R(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eiw = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eiz = 0.0f;
            this.eix = 0;
        }

        void finish() {
            this.Pp = this.eiw;
            this.mFinished = true;
        }

        boolean S(int i, int i2, int i3) {
            this.mFinished = true;
            this.eiw = i;
            this.mStart = i;
            this.eix = 0;
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
            this.eiw = i2;
            int i4 = i - i2;
            this.eiz = pd(i4);
            this.eix = -i4;
            this.eiC = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eiz) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.eiC = i5;
            this.mFinished = false;
            this.eix = i2;
            this.eiy = i2;
            this.eiA = 0;
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
                int pg = pg(i2);
                this.eiA = pg;
                this.mDuration = pg;
                d = pf(i2);
            }
            this.eiB = (int) (d * Math.signum(i2));
            this.eiw = this.eiB + i;
            if (this.eiw < i3) {
                Q(this.mStart, this.eiw, i3);
                this.eiw = i3;
            }
            if (this.eiw > i4) {
                Q(this.mStart, this.eiw, i4);
                this.eiw = i4;
            }
        }

        private double pe(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.eiD * this.eiE));
        }

        private double pf(int i) {
            return Math.exp(pe(i) * (eiF / (eiF - 1.0d))) * this.eiD * this.eiE;
        }

        private int pg(int i) {
            return (int) (Math.exp(pe(i) / (eiF - 1.0d)) * 1000.0d);
        }

        private void U(int i, int i2, int i3) {
            float f = (-i3) / this.eiz;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eiz)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eiz));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eix = (int) ((-this.eiz) * sqrt);
        }

        private void V(int i, int i2, int i3) {
            this.eiz = pd(i3 == 0 ? i - i2 : i3);
            U(i, i2, i3);
            aBZ();
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
            } else if (pf(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.eiC);
            } else {
                T(i, i5, i4);
            }
        }

        void W(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eiC = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                A(i, i2, i2, (int) this.eiy);
            }
        }

        private void aBZ() {
            float abs = (this.eix * this.eix) / (Math.abs(this.eiz) * 2.0f);
            float signum = Math.signum(this.eix);
            if (abs > this.eiC) {
                this.eiz = (((-signum) * this.eix) * this.eix) / (this.eiC * 2.0f);
                abs = this.eiC;
            }
            this.eiC = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eix <= 0) {
                abs = -abs;
            }
            this.eiw = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eix) / this.eiz));
        }

        boolean aCa() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eiA) {
                        this.mStart = this.eiw;
                        this.eix = (int) this.eiy;
                        this.eiz = pd(this.eix);
                        this.mStartTime += this.mDuration;
                        aBZ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    T(this.eiw, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.eiA;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = eiG[i];
                        f3 = (eiG[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eiy = ((f3 * this.eiB) / this.eiA) * 1000.0f;
                    d = f2 * this.eiB;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eix);
                    d = this.eiC * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eiy = ((-f6) + f7) * signum * this.eiC * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eiy = this.eix + (this.eiz * f8);
                    d = ((f8 * (this.eiz * f8)) / 2.0f) + (this.eix * f8);
                    break;
            }
            this.Pp = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
