package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float bTQ = 8.0f;
    private static float bTR;
    private final a bTN;
    private final a bTO;
    private final boolean bTP;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bTR = 1.0f;
        bTR = 1.0f / A(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float A(float f) {
        float exp;
        float f2 = bTQ * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bTR;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bTP = z;
        this.bTN = new a(context);
        this.bTO = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bTN.setFriction(f);
        this.bTO.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bTN.bTZ && this.bTO.bTZ;
    }

    public final int getCurrX() {
        return this.bTN.bTS;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.bTN.bTV * this.bTN.bTV) + (this.bTO.bTV * this.bTO.bTV));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bTN.mStartTime;
                int i = this.bTN.zD;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = A(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bTN.B(interpolation);
                    this.bTO.B(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bTN.bTZ && !this.bTN.aaR() && !this.bTN.aaQ()) {
                    this.bTN.finish();
                }
                if (!this.bTO.bTZ && !this.bTO.aaR() && !this.bTO.aaQ()) {
                    this.bTO.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bTN.v(i, i3, i5);
        this.bTO.v(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bTN.w(i, i3, i4) || this.bTO.w(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bTP && !isFinished()) {
            float f = this.bTN.bTV;
            float f2 = this.bTO.bTV;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bTN.c(i, i11, i5, i6, i9);
                this.bTO.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bTN.c(i, i11, i5, i6, i9);
        this.bTO.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bTN.A(i, i2, i3);
    }

    public void abortAnimation() {
        this.bTN.finish();
        this.bTO.finish();
    }

    public boolean d(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bTN.bTT - this.bTN.mStart)) && Math.signum(f2) == Math.signum((float) (this.bTO.bTT - this.bTO.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bUd = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bUe = new float[101];
        private static final float[] bUf = new float[101];
        private int bTS;
        private int bTT;
        private int bTU;
        private float bTV;
        private float bTW;
        private int bTX;
        private int bTY;
        private int bUa;
        private float bUc;
        private int mStart;
        private long mStartTime;
        private int zD;
        private float bUb = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean bTZ = true;

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
                bUe[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bUf[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bUe;
            bUf[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bUb = f;
        }

        a(Context context) {
            this.bUc = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void B(float f) {
            this.bTS = this.mStart + Math.round((this.bTT - this.mStart) * f);
        }

        private static float iF(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void u(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bUf[i4];
                this.zD = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bUf[i4 + 1] - f2)) + f2) * this.zD);
            }
        }

        void v(int i, int i2, int i3) {
            this.bTZ = false;
            this.mStart = i;
            this.bTT = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.zD = i3;
            this.bTW = 0.0f;
            this.bTU = 0;
        }

        void finish() {
            this.bTS = this.bTT;
            this.bTZ = true;
        }

        boolean w(int i, int i2, int i3) {
            this.bTZ = true;
            this.bTT = i;
            this.mStart = i;
            this.bTU = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.zD = 0;
            if (i < i2) {
                x(i, i2, 0);
            } else if (i > i3) {
                x(i, i3, 0);
            }
            return !this.bTZ;
        }

        private void x(int i, int i2, int i3) {
            this.bTZ = false;
            this.mState = 1;
            this.mStart = i;
            this.bTT = i2;
            int i4 = i - i2;
            this.bTW = iF(i4);
            this.bTU = -i4;
            this.bUa = Math.abs(i4);
            this.zD = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.bTW));
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.bUa = i5;
            this.bTZ = false;
            this.bTU = i2;
            this.bTV = i2;
            this.bTX = 0;
            this.zD = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.bTS = i;
            if (i > i4 || i < i3) {
                j(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int iI = iI(i2);
                this.bTX = iI;
                this.zD = iI;
                d = iH(i2);
            }
            this.bTY = (int) (d * Math.signum(i2));
            this.bTT = this.bTY + i;
            if (this.bTT < i3) {
                u(this.mStart, this.bTT, i3);
                this.bTT = i3;
            }
            if (this.bTT > i4) {
                u(this.mStart, this.bTT, i4);
                this.bTT = i4;
            }
        }

        private double iG(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bUb * this.bUc));
        }

        private double iH(int i) {
            return Math.exp(iG(i) * (bUd / (bUd - 1.0d))) * this.bUb * this.bUc;
        }

        private int iI(int i) {
            return (int) (Math.exp(iG(i) / (bUd - 1.0d)) * 1000.0d);
        }

        private void y(int i, int i2, int i3) {
            float f = (-i3) / this.bTW;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bTW)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bTW));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bTU = (int) ((-this.bTW) * sqrt);
        }

        private void z(int i, int i2, int i3) {
            this.bTW = iF(i3 == 0 ? i - i2 : i3);
            y(i, i2, i3);
            aaP();
        }

        private void j(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.bTZ = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                z(i, i5, i4);
            } else if (iH(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.bUa);
            } else {
                x(i, i5, i4);
            }
        }

        void A(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bUa = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                j(i, i2, i2, (int) this.bTV);
            }
        }

        private void aaP() {
            float abs = (this.bTU * this.bTU) / (Math.abs(this.bTW) * 2.0f);
            float signum = Math.signum(this.bTU);
            if (abs > this.bUa) {
                this.bTW = (((-signum) * this.bTU) * this.bTU) / (this.bUa * 2.0f);
                abs = this.bUa;
            }
            this.bUa = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bTU <= 0) {
                abs = -abs;
            }
            this.bTT = ((int) abs) + i;
            this.zD = -((int) ((1000.0f * this.bTU) / this.bTW));
        }

        boolean aaQ() {
            switch (this.mState) {
                case 0:
                    if (this.zD < this.bTX) {
                        this.mStart = this.bTT;
                        this.bTU = (int) this.bTV;
                        this.bTW = iF(this.bTU);
                        this.mStartTime += this.zD;
                        aaP();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.zD;
                    x(this.bTT, this.mStart, 0);
                    break;
            }
            aaR();
            return true;
        }

        boolean aaR() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.zD) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.bTX;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bUe[i];
                        f3 = (bUe[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bTV = ((f3 * this.bTY) / this.bTX) * 1000.0f;
                    d = f2 * this.bTY;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.zD;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bTU);
                    d = this.bUa * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bTV = ((-f6) + f7) * signum * this.bUa * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bTV = this.bTU + (this.bTW * f8);
                    d = ((f8 * (this.bTW * f8)) / 2.0f) + (this.bTU * f8);
                    break;
            }
            this.bTS = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
