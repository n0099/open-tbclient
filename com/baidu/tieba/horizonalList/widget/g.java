package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float dhS = 8.0f;
    private static float dhT;
    private final a dhP;
    private final a dhQ;
    private final boolean dhR;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dhT = 1.0f;
        dhT = 1.0f / O(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float O(float f) {
        float exp;
        float f2 = dhS * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dhT;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dhR = z;
        this.dhP = new a(context);
        this.dhQ = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dhP.setFriction(f);
        this.dhQ.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dhP.dia && this.dhQ.dia;
    }

    public final int getCurrX() {
        return this.dhP.cBG;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dhP.dhW * this.dhP.dhW) + (this.dhQ.dhW * this.dhQ.dhW));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dhP.mStartTime;
                int i = this.dhP.HD;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = O(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dhP.P(interpolation);
                    this.dhQ.P(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dhP.dia && !this.dhP.arW() && !this.dhP.arV()) {
                    this.dhP.finish();
                }
                if (!this.dhQ.dia && !this.dhQ.arW() && !this.dhQ.arV()) {
                    this.dhQ.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dhP.B(i, i3, i5);
        this.dhQ.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dhP.C(i, i3, i4) || this.dhQ.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dhR && !isFinished()) {
            float f = this.dhP.dhW;
            float f2 = this.dhQ.dhW;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dhP.d(i, i11, i5, i6, i9);
                this.dhQ.d(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dhP.d(i, i11, i5, i6, i9);
        this.dhQ.d(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dhP.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.dhP.finish();
        this.dhQ.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dhP.dhU - this.dhP.mStart)) && Math.signum(f2) == Math.signum((float) (this.dhQ.dhU - this.dhQ.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float die = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dif = new float[101];
        private static final float[] dig = new float[101];
        private int HD;
        private int cBG;
        private int dhU;
        private int dhV;
        private float dhW;
        private float dhX;
        private int dhY;
        private int dhZ;
        private int dib;
        private float did;
        private int mStart;
        private long mStartTime;
        private float dic = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dia = true;

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
                dif[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dig[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dif;
            dig[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dic = f;
        }

        a(Context context) {
            this.did = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void P(float f) {
            this.cBG = this.mStart + Math.round((this.dhU - this.mStart) * f);
        }

        private static float lN(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dig[i4];
                this.HD = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dig[i4 + 1] - f2)) + f2) * this.HD);
            }
        }

        void B(int i, int i2, int i3) {
            this.dia = false;
            this.mStart = i;
            this.dhU = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HD = i3;
            this.dhX = 0.0f;
            this.dhV = 0;
        }

        void finish() {
            this.cBG = this.dhU;
            this.dia = true;
        }

        boolean C(int i, int i2, int i3) {
            this.dia = true;
            this.dhU = i;
            this.mStart = i;
            this.dhV = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HD = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.dia;
        }

        private void D(int i, int i2, int i3) {
            this.dia = false;
            this.mState = 1;
            this.mStart = i;
            this.dhU = i2;
            int i4 = i - i2;
            this.dhX = lN(i4);
            this.dhV = -i4;
            this.dib = Math.abs(i4);
            this.HD = (int) (Math.sqrt((i4 * (-2.0d)) / this.dhX) * 1000.0d);
        }

        void d(int i, int i2, int i3, int i4, int i5) {
            this.dib = i5;
            this.dia = false;
            this.dhV = i2;
            this.dhW = i2;
            this.dhY = 0;
            this.HD = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cBG = i;
            if (i > i4 || i < i3) {
                n(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lQ = lQ(i2);
                this.dhY = lQ;
                this.HD = lQ;
                d = lP(i2);
            }
            this.dhZ = (int) (d * Math.signum(i2));
            this.dhU = this.dhZ + i;
            if (this.dhU < i3) {
                A(this.mStart, this.dhU, i3);
                this.dhU = i3;
            }
            if (this.dhU > i4) {
                A(this.mStart, this.dhU, i4);
                this.dhU = i4;
            }
        }

        private double lO(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dic * this.did));
        }

        private double lP(int i) {
            return Math.exp(lO(i) * (die / (die - 1.0d))) * this.dic * this.did;
        }

        private int lQ(int i) {
            return (int) (Math.exp(lO(i) / (die - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.dhX;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dhX)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dhX));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dhV = (int) ((-this.dhX) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.dhX = lN(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            arU();
        }

        private void n(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dia = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (lP(i4) > Math.abs(i6)) {
                d(i, i4, z ? i2 : i, z ? i : i3, this.dib);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dib = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                n(i, i2, i2, (int) this.dhW);
            }
        }

        private void arU() {
            float abs = (this.dhV * this.dhV) / (Math.abs(this.dhX) * 2.0f);
            float signum = Math.signum(this.dhV);
            if (abs > this.dib) {
                this.dhX = (((-signum) * this.dhV) * this.dhV) / (this.dib * 2.0f);
                abs = this.dib;
            }
            this.dib = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dhV <= 0) {
                abs = -abs;
            }
            this.dhU = ((int) abs) + i;
            this.HD = -((int) ((1000.0f * this.dhV) / this.dhX));
        }

        boolean arV() {
            switch (this.mState) {
                case 0:
                    if (this.HD < this.dhY) {
                        this.mStart = this.dhU;
                        this.dhV = (int) this.dhW;
                        this.dhX = lN(this.dhV);
                        this.mStartTime += this.HD;
                        arU();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.HD;
                    D(this.dhU, this.mStart, 0);
                    break;
            }
            arW();
            return true;
        }

        boolean arW() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.HD) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.dhY;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dif[i];
                        f3 = (dif[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dhW = ((f3 * this.dhZ) / this.dhY) * 1000.0f;
                    d = f2 * this.dhZ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.HD;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dhV);
                    d = this.dib * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dhW = ((-f6) + f7) * signum * this.dib * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dhW = this.dhV + (this.dhX * f8);
                    d = ((f8 * (this.dhX * f8)) / 2.0f) + (this.dhV * f8);
                    break;
            }
            this.cBG = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
