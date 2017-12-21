package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float duW = 8.0f;
    private static float duX;
    private final a duT;
    private final a duU;
    private final boolean duV;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        duX = 1.0f;
        duX = 1.0f / S(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float S(float f) {
        float exp;
        float f2 = duW * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * duX;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.duV = z;
        this.duT = new a(context);
        this.duU = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.duT.setFriction(f);
        this.duU.setFriction(f);
    }

    public final boolean isFinished() {
        return this.duT.dve && this.duU.dve;
    }

    public final int getCurrX() {
        return this.duT.cUi;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.duT.dva * this.duT.dva) + (this.duU.dva * this.duU.dva));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.duT.mStartTime;
                int i = this.duT.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = S(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.duT.T(interpolation);
                    this.duU.T(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.duT.dve && !this.duT.auT() && !this.duT.auS()) {
                    this.duT.finish();
                }
                if (!this.duU.dve && !this.duU.auT() && !this.duU.auS()) {
                    this.duU.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.duT.I(i, i3, i5);
        this.duU.I(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.duT.J(i, i3, i4) || this.duU.J(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.duV && !isFinished()) {
            float f = this.duT.dva;
            float f2 = this.duU.dva;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.duT.b(i, i11, i5, i6, i9);
                this.duU.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.duT.b(i, i11, i5, i6, i9);
        this.duU.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.duT.N(i, i2, i3);
    }

    public void abortAnimation() {
        this.duT.finish();
        this.duU.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.duT.duY - this.duT.mStart)) && Math.signum(f2) == Math.signum((float) (this.duU.duY - this.duU.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dvi = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dvj = new float[101];
        private static final float[] dvk = new float[101];
        private int cUi;
        private int duY;
        private int duZ;
        private float dva;
        private float dvb;
        private int dvc;
        private int dvd;
        private int dvf;
        private float dvh;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float dvg = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dve = true;

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
                dvj[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dvk[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dvj;
            dvk[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dvg = f;
        }

        a(Context context) {
            this.dvh = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void T(float f) {
            this.cUi = this.mStart + Math.round((this.duY - this.mStart) * f);
        }

        private static float mt(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void H(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dvk[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dvk[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void I(int i, int i2, int i3) {
            this.dve = false;
            this.mStart = i;
            this.duY = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.dvb = 0.0f;
            this.duZ = 0;
        }

        void finish() {
            this.cUi = this.duY;
            this.dve = true;
        }

        boolean J(int i, int i2, int i3) {
            this.dve = true;
            this.duY = i;
            this.mStart = i;
            this.duZ = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                K(i, i2, 0);
            } else if (i > i3) {
                K(i, i3, 0);
            }
            return !this.dve;
        }

        private void K(int i, int i2, int i3) {
            this.dve = false;
            this.mState = 1;
            this.mStart = i;
            this.duY = i2;
            int i4 = i - i2;
            this.dvb = mt(i4);
            this.duZ = -i4;
            this.dvf = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.dvb) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.dvf = i5;
            this.dve = false;
            this.duZ = i2;
            this.dva = i2;
            this.dvc = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cUi = i;
            if (i > i4 || i < i3) {
                s(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int mw = mw(i2);
                this.dvc = mw;
                this.mDuration = mw;
                d = mv(i2);
            }
            this.dvd = (int) (d * Math.signum(i2));
            this.duY = this.dvd + i;
            if (this.duY < i3) {
                H(this.mStart, this.duY, i3);
                this.duY = i3;
            }
            if (this.duY > i4) {
                H(this.mStart, this.duY, i4);
                this.duY = i4;
            }
        }

        private double mu(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dvg * this.dvh));
        }

        private double mv(int i) {
            return Math.exp(mu(i) * (dvi / (dvi - 1.0d))) * this.dvg * this.dvh;
        }

        private int mw(int i) {
            return (int) (Math.exp(mu(i) / (dvi - 1.0d)) * 1000.0d);
        }

        private void L(int i, int i2, int i3) {
            float f = (-i3) / this.dvb;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dvb)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dvb));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.duZ = (int) ((-this.dvb) * sqrt);
        }

        private void M(int i, int i2, int i3) {
            this.dvb = mt(i3 == 0 ? i - i2 : i3);
            L(i, i2, i3);
            auR();
        }

        private void s(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dve = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                M(i, i5, i4);
            } else if (mv(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.dvf);
            } else {
                K(i, i5, i4);
            }
        }

        void N(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dvf = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                s(i, i2, i2, (int) this.dva);
            }
        }

        private void auR() {
            float abs = (this.duZ * this.duZ) / (Math.abs(this.dvb) * 2.0f);
            float signum = Math.signum(this.duZ);
            if (abs > this.dvf) {
                this.dvb = (((-signum) * this.duZ) * this.duZ) / (this.dvf * 2.0f);
                abs = this.dvf;
            }
            this.dvf = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.duZ <= 0) {
                abs = -abs;
            }
            this.duY = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.duZ) / this.dvb));
        }

        boolean auS() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.dvc) {
                        this.mStart = this.duY;
                        this.duZ = (int) this.dva;
                        this.dvb = mt(this.duZ);
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
                    K(this.duY, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.dvc;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dvj[i];
                        f3 = (dvj[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dva = ((f3 * this.dvd) / this.dvc) * 1000.0f;
                    d = f2 * this.dvd;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.duZ);
                    d = this.dvf * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dva = ((-f6) + f7) * signum * this.dvf * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dva = this.duZ + (this.dvb * f8);
                    d = ((f8 * (this.dvb * f8)) / 2.0f) + (this.duZ * f8);
                    break;
            }
            this.cUi = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
