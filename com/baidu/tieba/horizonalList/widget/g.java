package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float emN = 8.0f;
    private static float emO;
    private final a emK;
    private final a emL;
    private final boolean emM;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        emO = 1.0f;
        emO = 1.0f / an(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float an(float f) {
        float exp;
        float f2 = emN * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * emO;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.emM = z;
        this.emK = new a(context);
        this.emL = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.emK.setFriction(f);
        this.emL.setFriction(f);
    }

    public final boolean isFinished() {
        return this.emK.mFinished && this.emL.mFinished;
    }

    public final int getCurrX() {
        return this.emK.Pj;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.emK.emR * this.emK.emR) + (this.emL.emR * this.emL.emR));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.emK.mStartTime;
                int i = this.emK.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = an(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.emK.ao(interpolation);
                    this.emL.ao(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.emK.mFinished && !this.emK.dB() && !this.emK.aDy()) {
                    this.emK.finish();
                }
                if (!this.emL.mFinished && !this.emL.dB() && !this.emL.aDy()) {
                    this.emL.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.emK.S(i, i3, i5);
        this.emL.S(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.emK.T(i, i3, i4) || this.emL.T(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.emM && !isFinished()) {
            float f = this.emK.emR;
            float f2 = this.emL.emR;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.emK.b(i, i11, i5, i6, i9);
                this.emL.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.emK.b(i, i11, i5, i6, i9);
        this.emL.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.emK.X(i, i2, i3);
    }

    public void abortAnimation() {
        this.emK.finish();
        this.emL.finish();
    }

    public boolean t(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.emK.emP - this.emK.mStart)) && Math.signum(f2) == Math.signum((float) (this.emL.emP - this.emL.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float emY = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] emZ = new float[101];
        private static final float[] ena = new float[101];
        private int Pj;
        private int emP;
        private int emQ;
        private float emR;
        private float emS;
        private int emT;
        private int emU;
        private int emV;
        private float emX;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float emW = ViewConfiguration.getScrollFriction();
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
                emZ[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                ena[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = emZ;
            ena[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.emW = f;
        }

        a(Context context) {
            this.emX = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ao(float f) {
            this.Pj = this.mStart + Math.round((this.emP - this.mStart) * f);
        }

        private static float pe(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void R(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = ena[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (ena[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void S(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.emP = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.emS = 0.0f;
            this.emQ = 0;
        }

        void finish() {
            this.Pj = this.emP;
            this.mFinished = true;
        }

        boolean T(int i, int i2, int i3) {
            this.mFinished = true;
            this.emP = i;
            this.mStart = i;
            this.emQ = 0;
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
            this.emP = i2;
            int i4 = i - i2;
            this.emS = pe(i4);
            this.emQ = -i4;
            this.emV = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.emS) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.emV = i5;
            this.mFinished = false;
            this.emQ = i2;
            this.emR = i2;
            this.emT = 0;
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
                int ph = ph(i2);
                this.emT = ph;
                this.mDuration = ph;
                d = pg(i2);
            }
            this.emU = (int) (d * Math.signum(i2));
            this.emP = this.emU + i;
            if (this.emP < i3) {
                R(this.mStart, this.emP, i3);
                this.emP = i3;
            }
            if (this.emP > i4) {
                R(this.mStart, this.emP, i4);
                this.emP = i4;
            }
        }

        private double pf(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.emW * this.emX));
        }

        private double pg(int i) {
            return Math.exp(pf(i) * (emY / (emY - 1.0d))) * this.emW * this.emX;
        }

        private int ph(int i) {
            return (int) (Math.exp(pf(i) / (emY - 1.0d)) * 1000.0d);
        }

        private void V(int i, int i2, int i3) {
            float f = (-i3) / this.emS;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.emS)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.emS));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.emQ = (int) ((-this.emS) * sqrt);
        }

        private void W(int i, int i2, int i3) {
            this.emS = pe(i3 == 0 ? i - i2 : i3);
            V(i, i2, i3);
            aDx();
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
                b(i, i4, z ? i2 : i, z ? i : i3, this.emV);
            } else {
                U(i, i5, i4);
            }
        }

        void X(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.emV = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                A(i, i2, i2, (int) this.emR);
            }
        }

        private void aDx() {
            float abs = (this.emQ * this.emQ) / (Math.abs(this.emS) * 2.0f);
            float signum = Math.signum(this.emQ);
            if (abs > this.emV) {
                this.emS = (((-signum) * this.emQ) * this.emQ) / (this.emV * 2.0f);
                abs = this.emV;
            }
            this.emV = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.emQ <= 0) {
                abs = -abs;
            }
            this.emP = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.emQ) / this.emS));
        }

        boolean aDy() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.emT) {
                        this.mStart = this.emP;
                        this.emQ = (int) this.emR;
                        this.emS = pe(this.emQ);
                        this.mStartTime += this.mDuration;
                        aDx();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    U(this.emP, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.emT;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = emZ[i];
                        f3 = (emZ[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.emR = ((f3 * this.emU) / this.emT) * 1000.0f;
                    d = f2 * this.emU;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.emQ);
                    d = this.emV * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.emR = ((-f6) + f7) * signum * this.emV * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.emR = this.emQ + (this.emS * f8);
                    d = ((f8 * (this.emS * f8)) / 2.0f) + (this.emQ * f8);
                    break;
            }
            this.Pj = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
