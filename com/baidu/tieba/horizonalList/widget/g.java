package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float duS = 8.0f;
    private static float duT;
    private final a duP;
    private final a duQ;
    private final boolean duR;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        duT = 1.0f;
        duT = 1.0f / S(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float S(float f) {
        float exp;
        float f2 = duS * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * duT;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.duR = z;
        this.duP = new a(context);
        this.duQ = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.duP.setFriction(f);
        this.duQ.setFriction(f);
    }

    public final boolean isFinished() {
        return this.duP.dva && this.duQ.dva;
    }

    public final int getCurrX() {
        return this.duP.cUe;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.duP.duW * this.duP.duW) + (this.duQ.duW * this.duQ.duW));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.duP.mStartTime;
                int i = this.duP.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = S(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.duP.T(interpolation);
                    this.duQ.T(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.duP.dva && !this.duP.auT() && !this.duP.auS()) {
                    this.duP.finish();
                }
                if (!this.duQ.dva && !this.duQ.auT() && !this.duQ.auS()) {
                    this.duQ.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.duP.I(i, i3, i5);
        this.duQ.I(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.duP.J(i, i3, i4) || this.duQ.J(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.duR && !isFinished()) {
            float f = this.duP.duW;
            float f2 = this.duQ.duW;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.duP.b(i, i11, i5, i6, i9);
                this.duQ.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.duP.b(i, i11, i5, i6, i9);
        this.duQ.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.duP.N(i, i2, i3);
    }

    public void abortAnimation() {
        this.duP.finish();
        this.duQ.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.duP.duU - this.duP.mStart)) && Math.signum(f2) == Math.signum((float) (this.duQ.duU - this.duQ.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dve = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dvf = new float[101];
        private static final float[] dvg = new float[101];
        private int cUe;
        private int duU;
        private int duV;
        private float duW;
        private float duX;
        private int duY;
        private int duZ;
        private int dvb;
        private float dvd;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dvc = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dva = true;

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
                dvf[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dvg[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dvf;
            dvg[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dvc = f;
        }

        a(Context context) {
            this.dvd = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void T(float f) {
            this.cUe = this.mStart + Math.round((this.duU - this.mStart) * f);
        }

        private static float mt(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void H(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dvg[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dvg[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void I(int i, int i2, int i3) {
            this.dva = false;
            this.mStart = i;
            this.duU = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.duX = 0.0f;
            this.duV = 0;
        }

        void finish() {
            this.cUe = this.duU;
            this.dva = true;
        }

        boolean J(int i, int i2, int i3) {
            this.dva = true;
            this.duU = i;
            this.mStart = i;
            this.duV = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                K(i, i2, 0);
            } else if (i > i3) {
                K(i, i3, 0);
            }
            return !this.dva;
        }

        private void K(int i, int i2, int i3) {
            this.dva = false;
            this.mState = 1;
            this.mStart = i;
            this.duU = i2;
            int i4 = i - i2;
            this.duX = mt(i4);
            this.duV = -i4;
            this.dvb = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.duX) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.dvb = i5;
            this.dva = false;
            this.duV = i2;
            this.duW = i2;
            this.duY = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cUe = i;
            if (i > i4 || i < i3) {
                s(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int mw = mw(i2);
                this.duY = mw;
                this.mDuration = mw;
                d = mv(i2);
            }
            this.duZ = (int) (d * Math.signum(i2));
            this.duU = this.duZ + i;
            if (this.duU < i3) {
                H(this.mStart, this.duU, i3);
                this.duU = i3;
            }
            if (this.duU > i4) {
                H(this.mStart, this.duU, i4);
                this.duU = i4;
            }
        }

        private double mu(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dvc * this.dvd));
        }

        private double mv(int i) {
            return Math.exp(mu(i) * (dve / (dve - 1.0d))) * this.dvc * this.dvd;
        }

        private int mw(int i) {
            return (int) (Math.exp(mu(i) / (dve - 1.0d)) * 1000.0d);
        }

        private void L(int i, int i2, int i3) {
            float f = (-i3) / this.duX;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.duX)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.duX));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.duV = (int) ((-this.duX) * sqrt);
        }

        private void M(int i, int i2, int i3) {
            this.duX = mt(i3 == 0 ? i - i2 : i3);
            L(i, i2, i3);
            auR();
        }

        private void s(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dva = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                M(i, i5, i4);
            } else if (mv(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.dvb);
            } else {
                K(i, i5, i4);
            }
        }

        void N(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dvb = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.duW);
            }
        }

        private void auR() {
            float abs = (this.duV * this.duV) / (Math.abs(this.duX) * 2.0f);
            float signum = Math.signum(this.duV);
            if (abs > this.dvb) {
                this.duX = (((-signum) * this.duV) * this.duV) / (this.dvb * 2.0f);
                abs = this.dvb;
            }
            this.dvb = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.duV <= 0) {
                abs = -abs;
            }
            this.duU = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.duV) / this.duX));
        }

        boolean auS() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.duY) {
                        this.mStart = this.duU;
                        this.duV = (int) this.duW;
                        this.duX = mt(this.duV);
                        this.mStartTime += this.mDuration;
                        auR();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    K(this.duU, this.mStart, 0);
                    break;
            }
            auT();
            return true;
        }

        boolean auT() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.duY;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dvf[i];
                        f3 = (dvf[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.duW = ((f3 * this.duZ) / this.duY) * 1000.0f;
                    d = f2 * this.duZ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.duV);
                    d = this.dvb * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.duW = ((-f6) + f7) * signum * this.dvb * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.duW = this.duV + (this.duX * f8);
                    d = ((f8 * (this.duX * f8)) / 2.0f) + (this.duV * f8);
                    break;
            }
            this.cUe = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
