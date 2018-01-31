package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float eiP = 8.0f;
    private static float eiQ;
    private final a eiM;
    private final a eiN;
    private final boolean eiO;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eiQ = 1.0f;
        eiQ = 1.0f / ah(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float ah(float f) {
        float exp;
        float f2 = eiP * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eiQ;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eiO = z;
        this.eiM = new a(context);
        this.eiN = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eiM.setFriction(f);
        this.eiN.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eiM.mFinished && this.eiN.mFinished;
    }

    public final int getCurrX() {
        return this.eiM.Pp;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eiM.eiT * this.eiM.eiT) + (this.eiN.eiT * this.eiN.eiT));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eiM.mStartTime;
                int i = this.eiM.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ah(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eiM.ai(interpolation);
                    this.eiN.ai(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eiM.mFinished && !this.eiM.dB() && !this.eiM.aCf()) {
                    this.eiM.finish();
                }
                if (!this.eiN.mFinished && !this.eiN.dB() && !this.eiN.aCf()) {
                    this.eiN.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eiM.R(i, i3, i5);
        this.eiN.R(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eiM.S(i, i3, i4) || this.eiN.S(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eiO && !isFinished()) {
            float f = this.eiM.eiT;
            float f2 = this.eiN.eiT;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eiM.c(i, i11, i5, i6, i9);
                this.eiN.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eiM.c(i, i11, i5, i6, i9);
        this.eiN.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eiM.W(i, i2, i3);
    }

    public void abortAnimation() {
        this.eiM.finish();
        this.eiN.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eiM.eiR - this.eiM.mStart)) && Math.signum(f2) == Math.signum((float) (this.eiN.eiR - this.eiN.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float eja = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] ejb = new float[101];
        private static final float[] ejc = new float[101];
        private int Pp;
        private int eiR;
        private int eiS;
        private float eiT;
        private float eiU;
        private int eiV;
        private int eiW;
        private int eiX;
        private float eiZ;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float eiY = ViewConfiguration.getScrollFriction();
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
                ejb[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                ejc[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = ejb;
            ejc[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.eiY = f;
        }

        a(Context context) {
            this.eiZ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ai(float f) {
            this.Pp = this.mStart + Math.round((this.eiR - this.mStart) * f);
        }

        private static float pd(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void Q(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = ejc[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (ejc[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void R(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eiR = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eiU = 0.0f;
            this.eiS = 0;
        }

        void finish() {
            this.Pp = this.eiR;
            this.mFinished = true;
        }

        boolean S(int i, int i2, int i3) {
            this.mFinished = true;
            this.eiR = i;
            this.mStart = i;
            this.eiS = 0;
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
            this.eiR = i2;
            int i4 = i - i2;
            this.eiU = pd(i4);
            this.eiS = -i4;
            this.eiX = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eiU) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.eiX = i5;
            this.mFinished = false;
            this.eiS = i2;
            this.eiT = i2;
            this.eiV = 0;
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
                this.eiV = pg;
                this.mDuration = pg;
                d = pf(i2);
            }
            this.eiW = (int) (d * Math.signum(i2));
            this.eiR = this.eiW + i;
            if (this.eiR < i3) {
                Q(this.mStart, this.eiR, i3);
                this.eiR = i3;
            }
            if (this.eiR > i4) {
                Q(this.mStart, this.eiR, i4);
                this.eiR = i4;
            }
        }

        private double pe(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.eiY * this.eiZ));
        }

        private double pf(int i) {
            return Math.exp(pe(i) * (eja / (eja - 1.0d))) * this.eiY * this.eiZ;
        }

        private int pg(int i) {
            return (int) (Math.exp(pe(i) / (eja - 1.0d)) * 1000.0d);
        }

        private void U(int i, int i2, int i3) {
            float f = (-i3) / this.eiU;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eiU)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eiU));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eiS = (int) ((-this.eiU) * sqrt);
        }

        private void V(int i, int i2, int i3) {
            this.eiU = pd(i3 == 0 ? i - i2 : i3);
            U(i, i2, i3);
            aCe();
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
                c(i, i4, z ? i2 : i, z ? i : i3, this.eiX);
            } else {
                T(i, i5, i4);
            }
        }

        void W(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eiX = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                A(i, i2, i2, (int) this.eiT);
            }
        }

        private void aCe() {
            float abs = (this.eiS * this.eiS) / (Math.abs(this.eiU) * 2.0f);
            float signum = Math.signum(this.eiS);
            if (abs > this.eiX) {
                this.eiU = (((-signum) * this.eiS) * this.eiS) / (this.eiX * 2.0f);
                abs = this.eiX;
            }
            this.eiX = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eiS <= 0) {
                abs = -abs;
            }
            this.eiR = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eiS) / this.eiU));
        }

        boolean aCf() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eiV) {
                        this.mStart = this.eiR;
                        this.eiS = (int) this.eiT;
                        this.eiU = pd(this.eiS);
                        this.mStartTime += this.mDuration;
                        aCe();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    T(this.eiR, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.eiV;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = ejb[i];
                        f3 = (ejb[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eiT = ((f3 * this.eiW) / this.eiV) * 1000.0f;
                    d = f2 * this.eiW;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eiS);
                    d = this.eiX * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eiT = ((-f6) + f7) * signum * this.eiX * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eiT = this.eiS + (this.eiU * f8);
                    d = ((f8 * (this.eiU * f8)) / 2.0f) + (this.eiS * f8);
                    break;
            }
            this.Pp = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
