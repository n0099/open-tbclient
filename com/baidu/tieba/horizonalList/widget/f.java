package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float eCH = 8.0f;
    private static float eCI;
    private final a eCE;
    private final a eCF;
    private final boolean eCG;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eCI = 1.0f;
        eCI = 1.0f / aq(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aq(float f) {
        float exp;
        float f2 = eCH * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eCI;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eCG = z;
        this.eCE = new a(context);
        this.eCF = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eCE.setFriction(f);
        this.eCF.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eCE.mFinished && this.eCF.mFinished;
    }

    public final int getCurrX() {
        return this.eCE.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eCE.eCL * this.eCE.eCL) + (this.eCF.eCL * this.eCF.eCL));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eCE.mStartTime;
                int i = this.eCE.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aq(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eCE.ar(interpolation);
                    this.eCF.ar(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eCE.mFinished && !this.eCE.update() && !this.eCE.aNh()) {
                    this.eCE.finish();
                }
                if (!this.eCF.mFinished && !this.eCF.update() && !this.eCF.aNh()) {
                    this.eCF.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eCE.L(i, i3, i5);
        this.eCF.L(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eCE.M(i, i3, i4) || this.eCF.M(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eCG && !isFinished()) {
            float f = this.eCE.eCL;
            float f2 = this.eCF.eCL;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eCE.d(i, i11, i5, i6, i9);
                this.eCF.d(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eCE.d(i, i11, i5, i6, i9);
        this.eCF.d(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eCE.Q(i, i2, i3);
    }

    public void abortAnimation() {
        this.eCE.finish();
        this.eCF.finish();
    }

    public boolean x(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eCE.eCJ - this.eCE.mStart)) && Math.signum(f2) == Math.signum((float) (this.eCF.eCJ - this.eCF.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float eCS = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] eCT = new float[101];
        private static final float[] eCU = new float[101];
        private int eCJ;
        private int eCK;
        private float eCL;
        private float eCM;
        private int eCN;
        private int eCO;
        private int eCP;
        private float eCR;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float eCQ = ViewConfiguration.getScrollFriction();
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
                eCT[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                eCU[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = eCT;
            eCU[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.eCQ = f;
        }

        a(Context context) {
            this.eCR = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ar(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.eCJ - this.mStart) * f);
        }

        private static float pl(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void K(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = eCU[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (eCU[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void L(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eCJ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eCM = 0.0f;
            this.eCK = 0;
        }

        void finish() {
            this.mCurrentPosition = this.eCJ;
            this.mFinished = true;
        }

        boolean M(int i, int i2, int i3) {
            this.mFinished = true;
            this.eCJ = i;
            this.mStart = i;
            this.eCK = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                N(i, i2, 0);
            } else if (i > i3) {
                N(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void N(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.eCJ = i2;
            int i4 = i - i2;
            this.eCM = pl(i4);
            this.eCK = -i4;
            this.eCP = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eCM) * 1000.0d);
        }

        void d(int i, int i2, int i3, int i4, int i5) {
            this.eCP = i5;
            this.mFinished = false;
            this.eCK = i2;
            this.eCL = i2;
            this.eCN = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                u(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int pp = pp(i2);
                this.eCN = pp;
                this.mDuration = pp;
                d = po(i2);
            }
            this.eCO = (int) (d * Math.signum(i2));
            this.eCJ = this.eCO + i;
            if (this.eCJ < i3) {
                K(this.mStart, this.eCJ, i3);
                this.eCJ = i3;
            }
            if (this.eCJ > i4) {
                K(this.mStart, this.eCJ, i4);
                this.eCJ = i4;
            }
        }

        private double pm(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.eCQ * this.eCR));
        }

        private double po(int i) {
            return Math.exp(pm(i) * (eCS / (eCS - 1.0d))) * this.eCQ * this.eCR;
        }

        private int pp(int i) {
            return (int) (Math.exp(pm(i) / (eCS - 1.0d)) * 1000.0d);
        }

        private void O(int i, int i2, int i3) {
            float f = (-i3) / this.eCM;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eCM)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eCM));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eCK = (int) ((-this.eCM) * sqrt);
        }

        private void P(int i, int i2, int i3) {
            this.eCM = pl(i3 == 0 ? i - i2 : i3);
            O(i, i2, i3);
            aNg();
        }

        private void u(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                P(i, i5, i4);
            } else if (po(i4) > Math.abs(i6)) {
                d(i, i4, z ? i2 : i, z ? i : i3, this.eCP);
            } else {
                N(i, i5, i4);
            }
        }

        void Q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eCP = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                u(i, i2, i2, (int) this.eCL);
            }
        }

        private void aNg() {
            float abs = (this.eCK * this.eCK) / (Math.abs(this.eCM) * 2.0f);
            float signum = Math.signum(this.eCK);
            if (abs > this.eCP) {
                this.eCM = (((-signum) * this.eCK) * this.eCK) / (this.eCP * 2.0f);
                abs = this.eCP;
            }
            this.eCP = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eCK <= 0) {
                abs = -abs;
            }
            this.eCJ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eCK) / this.eCM));
        }

        boolean aNh() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eCN) {
                        this.mStart = this.eCJ;
                        this.eCK = (int) this.eCL;
                        this.eCM = pl(this.eCK);
                        this.mStartTime += this.mDuration;
                        aNg();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    N(this.eCJ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.eCN;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = eCT[i];
                        f3 = (eCT[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eCL = ((f3 * this.eCO) / this.eCN) * 1000.0f;
                    d = f2 * this.eCO;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eCK);
                    d = this.eCP * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eCL = ((-f6) + f7) * signum * this.eCP * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eCL = this.eCK + (this.eCM * f8);
                    d = ((f8 * (this.eCM * f8)) / 2.0f) + (this.eCK * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
