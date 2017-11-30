package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float dtN = 8.0f;
    private static float dtO;
    private final a dtK;
    private final a dtL;
    private final boolean dtM;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dtO = 1.0f;
        dtO = 1.0f / S(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float S(float f) {
        float exp;
        float f2 = dtN * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dtO;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dtM = z;
        this.dtK = new a(context);
        this.dtL = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dtK.setFriction(f);
        this.dtL.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dtK.dtV && this.dtL.dtV;
    }

    public final int getCurrX() {
        return this.dtK.cTT;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dtK.dtR * this.dtK.dtR) + (this.dtL.dtR * this.dtL.dtR));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dtK.mStartTime;
                int i = this.dtK.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = S(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dtK.T(interpolation);
                    this.dtL.T(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dtK.dtV && !this.dtK.auK() && !this.dtK.auJ()) {
                    this.dtK.finish();
                }
                if (!this.dtL.dtV && !this.dtL.auK() && !this.dtL.auJ()) {
                    this.dtL.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dtK.I(i, i3, i5);
        this.dtL.I(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dtK.J(i, i3, i4) || this.dtL.J(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dtM && !isFinished()) {
            float f = this.dtK.dtR;
            float f2 = this.dtL.dtR;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dtK.b(i, i11, i5, i6, i9);
                this.dtL.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dtK.b(i, i11, i5, i6, i9);
        this.dtL.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dtK.N(i, i2, i3);
    }

    public void abortAnimation() {
        this.dtK.finish();
        this.dtL.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dtK.dtP - this.dtK.mStart)) && Math.signum(f2) == Math.signum((float) (this.dtL.dtP - this.dtL.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dtZ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dua = new float[101];
        private static final float[] dub = new float[101];
        private int cTT;
        private int dtP;
        private int dtQ;
        private float dtR;
        private float dtS;
        private int dtT;
        private int dtU;
        private int dtW;
        private float dtY;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dtX = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dtV = true;

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
                dua[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dub[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dua;
            dub[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dtX = f;
        }

        a(Context context) {
            this.dtY = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void T(float f) {
            this.cTT = this.mStart + Math.round((this.dtP - this.mStart) * f);
        }

        private static float mm(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void H(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dub[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dub[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void I(int i, int i2, int i3) {
            this.dtV = false;
            this.mStart = i;
            this.dtP = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dtS = 0.0f;
            this.dtQ = 0;
        }

        void finish() {
            this.cTT = this.dtP;
            this.dtV = true;
        }

        boolean J(int i, int i2, int i3) {
            this.dtV = true;
            this.dtP = i;
            this.mStart = i;
            this.dtQ = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                K(i, i2, 0);
            } else if (i > i3) {
                K(i, i3, 0);
            }
            return !this.dtV;
        }

        private void K(int i, int i2, int i3) {
            this.dtV = false;
            this.mState = 1;
            this.mStart = i;
            this.dtP = i2;
            int i4 = i - i2;
            this.dtS = mm(i4);
            this.dtQ = -i4;
            this.dtW = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dtS) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.dtW = i5;
            this.dtV = false;
            this.dtQ = i2;
            this.dtR = i2;
            this.dtT = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cTT = i;
            if (i > i4 || i < i3) {
                s(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int mp = mp(i2);
                this.dtT = mp;
                this.mDuration = mp;
                d = mo(i2);
            }
            this.dtU = (int) (d * Math.signum(i2));
            this.dtP = this.dtU + i;
            if (this.dtP < i3) {
                H(this.mStart, this.dtP, i3);
                this.dtP = i3;
            }
            if (this.dtP > i4) {
                H(this.mStart, this.dtP, i4);
                this.dtP = i4;
            }
        }

        private double mn(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dtX * this.dtY));
        }

        private double mo(int i) {
            return Math.exp(mn(i) * (dtZ / (dtZ - 1.0d))) * this.dtX * this.dtY;
        }

        private int mp(int i) {
            return (int) (Math.exp(mn(i) / (dtZ - 1.0d)) * 1000.0d);
        }

        private void L(int i, int i2, int i3) {
            float f = (-i3) / this.dtS;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dtS)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dtS));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dtQ = (int) ((-this.dtS) * sqrt);
        }

        private void M(int i, int i2, int i3) {
            this.dtS = mm(i3 == 0 ? i - i2 : i3);
            L(i, i2, i3);
            auI();
        }

        private void s(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dtV = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                M(i, i5, i4);
            } else if (mo(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.dtW);
            } else {
                K(i, i5, i4);
            }
        }

        void N(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dtW = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.dtR);
            }
        }

        private void auI() {
            float abs = (this.dtQ * this.dtQ) / (Math.abs(this.dtS) * 2.0f);
            float signum = Math.signum(this.dtQ);
            if (abs > this.dtW) {
                this.dtS = (((-signum) * this.dtQ) * this.dtQ) / (this.dtW * 2.0f);
                abs = this.dtW;
            }
            this.dtW = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dtQ <= 0) {
                abs = -abs;
            }
            this.dtP = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.dtQ) / this.dtS));
        }

        boolean auJ() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dtT) {
                        this.mStart = this.dtP;
                        this.dtQ = (int) this.dtR;
                        this.dtS = mm(this.dtQ);
                        this.mStartTime += this.mDuration;
                        auI();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    K(this.dtP, this.mStart, 0);
                    break;
            }
            auK();
            return true;
        }

        boolean auK() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.dtT;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dua[i];
                        f3 = (dua[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dtR = ((f3 * this.dtU) / this.dtT) * 1000.0f;
                    d = f2 * this.dtU;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dtQ);
                    d = this.dtW * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dtR = ((-f6) + f7) * signum * this.dtW * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dtR = this.dtQ + (this.dtS * f8);
                    d = ((f8 * (this.dtS * f8)) / 2.0f) + (this.dtQ * f8);
                    break;
            }
            this.cTT = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
