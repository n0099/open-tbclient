package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cAF = 8.0f;
    private static float cAG;
    private final a cAC;
    private final a cAD;
    private final boolean cAE;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cAG = 1.0f;
        cAG = 1.0f / Q(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float Q(float f) {
        float exp;
        float f2 = cAF * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cAG;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cAE = z;
        this.cAC = new a(context);
        this.cAD = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cAC.setFriction(f);
        this.cAD.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cAC.cAO && this.cAD.cAO;
    }

    public final int getCurrX() {
        return this.cAC.cAH;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cAC.cAK * this.cAC.cAK) + (this.cAD.cAK * this.cAD.cAK));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cAC.mStartTime;
                int i = this.cAC.Ae;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = Q(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cAC.R(interpolation);
                    this.cAD.R(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cAC.cAO && !this.cAC.ajw() && !this.cAC.ajv()) {
                    this.cAC.finish();
                }
                if (!this.cAD.cAO && !this.cAD.ajw() && !this.cAD.ajv()) {
                    this.cAD.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cAC.y(i, i3, i5);
        this.cAD.y(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cAC.z(i, i3, i4) || this.cAD.z(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cAE && !isFinished()) {
            float f = this.cAC.cAK;
            float f2 = this.cAD.cAK;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cAC.e(i, i11, i5, i6, i9);
                this.cAD.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cAC.e(i, i11, i5, i6, i9);
        this.cAD.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cAC.D(i, i2, i3);
    }

    public void abortAnimation() {
        this.cAC.finish();
        this.cAD.finish();
    }

    public boolean f(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cAC.cAI - this.cAC.mStart)) && Math.signum(f2) == Math.signum((float) (this.cAD.cAI - this.cAD.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cAS = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cAT = new float[101];
        private static final float[] cAU = new float[101];
        private int Ae;
        private int cAH;
        private int cAI;
        private int cAJ;
        private float cAK;
        private float cAL;
        private int cAM;
        private int cAN;
        private int cAP;
        private float cAR;
        private int mStart;
        private long mStartTime;
        private float cAQ = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cAO = true;

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
                cAT[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cAU[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cAT;
            cAU[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cAQ = f;
        }

        a(Context context) {
            this.cAR = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void R(float f) {
            this.cAH = this.mStart + Math.round((this.cAI - this.mStart) * f);
        }

        private static float kk(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void x(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cAU[i4];
                this.Ae = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cAU[i4 + 1] - f2)) + f2) * this.Ae);
            }
        }

        void y(int i, int i2, int i3) {
            this.cAO = false;
            this.mStart = i;
            this.cAI = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ae = i3;
            this.cAL = 0.0f;
            this.cAJ = 0;
        }

        void finish() {
            this.cAH = this.cAI;
            this.cAO = true;
        }

        boolean z(int i, int i2, int i3) {
            this.cAO = true;
            this.cAI = i;
            this.mStart = i;
            this.cAJ = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ae = 0;
            if (i < i2) {
                A(i, i2, 0);
            } else if (i > i3) {
                A(i, i3, 0);
            }
            return !this.cAO;
        }

        private void A(int i, int i2, int i3) {
            this.cAO = false;
            this.mState = 1;
            this.mStart = i;
            this.cAI = i2;
            int i4 = i - i2;
            this.cAL = kk(i4);
            this.cAJ = -i4;
            this.cAP = Math.abs(i4);
            this.Ae = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cAL));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cAP = i5;
            this.cAO = false;
            this.cAJ = i2;
            this.cAK = i2;
            this.cAM = 0;
            this.Ae = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cAH = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kn = kn(i2);
                this.cAM = kn;
                this.Ae = kn;
                d = km(i2);
            }
            this.cAN = (int) (d * Math.signum(i2));
            this.cAI = this.cAN + i;
            if (this.cAI < i3) {
                x(this.mStart, this.cAI, i3);
                this.cAI = i3;
            }
            if (this.cAI > i4) {
                x(this.mStart, this.cAI, i4);
                this.cAI = i4;
            }
        }

        private double kl(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cAQ * this.cAR));
        }

        private double km(int i) {
            return Math.exp(kl(i) * (cAS / (cAS - 1.0d))) * this.cAQ * this.cAR;
        }

        private int kn(int i) {
            return (int) (Math.exp(kl(i) / (cAS - 1.0d)) * 1000.0d);
        }

        private void B(int i, int i2, int i3) {
            float f = (-i3) / this.cAL;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cAL)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cAL));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cAJ = (int) ((-this.cAL) * sqrt);
        }

        private void C(int i, int i2, int i3) {
            this.cAL = kk(i3 == 0 ? i - i2 : i3);
            B(i, i2, i3);
            aju();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cAO = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                C(i, i5, i4);
            } else if (km(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cAP);
            } else {
                A(i, i5, i4);
            }
        }

        void D(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cAP = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.cAK);
            }
        }

        private void aju() {
            float abs = (this.cAJ * this.cAJ) / (Math.abs(this.cAL) * 2.0f);
            float signum = Math.signum(this.cAJ);
            if (abs > this.cAP) {
                this.cAL = (((-signum) * this.cAJ) * this.cAJ) / (this.cAP * 2.0f);
                abs = this.cAP;
            }
            this.cAP = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cAJ <= 0) {
                abs = -abs;
            }
            this.cAI = ((int) abs) + i;
            this.Ae = -((int) ((1000.0f * this.cAJ) / this.cAL));
        }

        boolean ajv() {
            switch (this.mState) {
                case 0:
                    if (this.Ae < this.cAM) {
                        this.mStart = this.cAI;
                        this.cAJ = (int) this.cAK;
                        this.cAL = kk(this.cAJ);
                        this.mStartTime += this.Ae;
                        aju();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Ae;
                    A(this.cAI, this.mStart, 0);
                    break;
            }
            ajw();
            return true;
        }

        boolean ajw() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Ae) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cAM;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cAT[i];
                        f3 = (cAT[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cAK = ((f3 * this.cAN) / this.cAM) * 1000.0f;
                    d = f2 * this.cAN;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Ae;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cAJ);
                    d = this.cAP * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cAK = ((-f6) + f7) * signum * this.cAP * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cAK = this.cAJ + (this.cAL * f8);
                    d = ((f8 * (this.cAL * f8)) / 2.0f) + (this.cAJ * f8);
                    break;
            }
            this.cAH = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
