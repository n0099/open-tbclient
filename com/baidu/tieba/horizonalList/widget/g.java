package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float ddS = 8.0f;
    private static float ddT;
    private final a ddP;
    private final a ddQ;
    private final boolean ddR;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        ddT = 1.0f;
        ddT = 1.0f / R(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float R(float f) {
        float exp;
        float f2 = ddS * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * ddT;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.ddR = z;
        this.ddP = new a(context);
        this.ddQ = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.ddP.setFriction(f);
        this.ddQ.setFriction(f);
    }

    public final boolean isFinished() {
        return this.ddP.dea && this.ddQ.dea;
    }

    public final int getCurrX() {
        return this.ddP.cCn;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.ddP.ddW * this.ddP.ddW) + (this.ddQ.ddW * this.ddQ.ddW));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.ddP.mStartTime;
                int i = this.ddP.HV;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = R(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.ddP.S(interpolation);
                    this.ddQ.S(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.ddP.dea && !this.ddP.aqx() && !this.ddP.aqw()) {
                    this.ddP.finish();
                }
                if (!this.ddQ.dea && !this.ddQ.aqx() && !this.ddQ.aqw()) {
                    this.ddQ.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.ddP.G(i, i3, i5);
        this.ddQ.G(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.ddP.H(i, i3, i4) || this.ddQ.H(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.ddR && !isFinished()) {
            float f = this.ddP.ddW;
            float f2 = this.ddQ.ddW;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.ddP.c(i, i11, i5, i6, i9);
                this.ddQ.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.ddP.c(i, i11, i5, i6, i9);
        this.ddQ.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.ddP.L(i, i2, i3);
    }

    public void abortAnimation() {
        this.ddP.finish();
        this.ddQ.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.ddP.ddU - this.ddP.mStart)) && Math.signum(f2) == Math.signum((float) (this.ddQ.ddU - this.ddQ.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dee = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] def = new float[101];
        private static final float[] deg = new float[101];
        private int HV;
        private int cCn;
        private int ddU;
        private int ddV;
        private float ddW;
        private float ddX;
        private int ddY;
        private int ddZ;
        private int deb;
        private float ded;
        private int mStart;
        private long mStartTime;
        private float dec = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dea = true;

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
                def[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                deg[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = def;
            deg[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dec = f;
        }

        a(Context context) {
            this.ded = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void S(float f) {
            this.cCn = this.mStart + Math.round((this.ddU - this.mStart) * f);
        }

        private static float lH(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void F(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = deg[i4];
                this.HV = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (deg[i4 + 1] - f2)) + f2) * this.HV);
            }
        }

        void G(int i, int i2, int i3) {
            this.dea = false;
            this.mStart = i;
            this.ddU = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HV = i3;
            this.ddX = 0.0f;
            this.ddV = 0;
        }

        void finish() {
            this.cCn = this.ddU;
            this.dea = true;
        }

        boolean H(int i, int i2, int i3) {
            this.dea = true;
            this.ddU = i;
            this.mStart = i;
            this.ddV = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HV = 0;
            if (i < i2) {
                I(i, i2, 0);
            } else if (i > i3) {
                I(i, i3, 0);
            }
            return !this.dea;
        }

        private void I(int i, int i2, int i3) {
            this.dea = false;
            this.mState = 1;
            this.mStart = i;
            this.ddU = i2;
            int i4 = i - i2;
            this.ddX = lH(i4);
            this.ddV = -i4;
            this.deb = Math.abs(i4);
            this.HV = (int) (Math.sqrt((i4 * (-2.0d)) / this.ddX) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.deb = i5;
            this.dea = false;
            this.ddV = i2;
            this.ddW = i2;
            this.ddY = 0;
            this.HV = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cCn = i;
            if (i > i4 || i < i3) {
                q(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lK = lK(i2);
                this.ddY = lK;
                this.HV = lK;
                d = lJ(i2);
            }
            this.ddZ = (int) (d * Math.signum(i2));
            this.ddU = this.ddZ + i;
            if (this.ddU < i3) {
                F(this.mStart, this.ddU, i3);
                this.ddU = i3;
            }
            if (this.ddU > i4) {
                F(this.mStart, this.ddU, i4);
                this.ddU = i4;
            }
        }

        private double lI(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dec * this.ded));
        }

        private double lJ(int i) {
            return Math.exp(lI(i) * (dee / (dee - 1.0d))) * this.dec * this.ded;
        }

        private int lK(int i) {
            return (int) (Math.exp(lI(i) / (dee - 1.0d)) * 1000.0d);
        }

        private void J(int i, int i2, int i3) {
            float f = (-i3) / this.ddX;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.ddX)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.ddX));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.ddV = (int) ((-this.ddX) * sqrt);
        }

        private void K(int i, int i2, int i3) {
            this.ddX = lH(i3 == 0 ? i - i2 : i3);
            J(i, i2, i3);
            aqv();
        }

        private void q(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dea = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                K(i, i5, i4);
            } else if (lJ(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.deb);
            } else {
                I(i, i5, i4);
            }
        }

        void L(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.deb = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                q(i, i2, i2, (int) this.ddW);
            }
        }

        private void aqv() {
            float abs = (this.ddV * this.ddV) / (Math.abs(this.ddX) * 2.0f);
            float signum = Math.signum(this.ddV);
            if (abs > this.deb) {
                this.ddX = (((-signum) * this.ddV) * this.ddV) / (this.deb * 2.0f);
                abs = this.deb;
            }
            this.deb = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.ddV <= 0) {
                abs = -abs;
            }
            this.ddU = ((int) abs) + i;
            this.HV = -((int) ((1000.0f * this.ddV) / this.ddX));
        }

        boolean aqw() {
            switch (this.mState) {
                case 0:
                    if (this.HV < this.ddY) {
                        this.mStart = this.ddU;
                        this.ddV = (int) this.ddW;
                        this.ddX = lH(this.ddV);
                        this.mStartTime += this.HV;
                        aqv();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.HV;
                    I(this.ddU, this.mStart, 0);
                    break;
            }
            aqx();
            return true;
        }

        boolean aqx() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.HV) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.ddY;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = def[i];
                        f3 = (def[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.ddW = ((f3 * this.ddZ) / this.ddY) * 1000.0f;
                    d = f2 * this.ddZ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.HV;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.ddV);
                    d = this.deb * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.ddW = ((-f6) + f7) * signum * this.deb * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.ddW = this.ddV + (this.ddX * f8);
                    d = ((f8 * (this.ddX * f8)) / 2.0f) + (this.ddV * f8);
                    break;
            }
            this.cCn = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
