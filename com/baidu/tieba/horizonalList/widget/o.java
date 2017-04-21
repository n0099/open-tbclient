package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cGO = 8.0f;
    private static float cGP;
    private final a cGL;
    private final a cGM;
    private final boolean cGN;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cGP = 1.0f;
        cGP = 1.0f / V(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float V(float f) {
        float exp;
        float f2 = cGO * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cGP;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cGN = z;
        this.cGL = new a(context);
        this.cGM = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cGL.setFriction(f);
        this.cGM.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cGL.cGX && this.cGM.cGX;
    }

    public final int getCurrX() {
        return this.cGL.cGQ;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cGL.cGT * this.cGL.cGT) + (this.cGM.cGT * this.cGM.cGT));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cGL.mStartTime;
                int i = this.cGL.Iv;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = V(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cGL.W(interpolation);
                    this.cGM.W(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cGL.cGX && !this.cGL.ami() && !this.cGL.amh()) {
                    this.cGL.finish();
                }
                if (!this.cGM.cGX && !this.cGM.ami() && !this.cGM.amh()) {
                    this.cGM.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cGL.B(i, i3, i5);
        this.cGM.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cGL.C(i, i3, i4) || this.cGM.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cGN && !isFinished()) {
            float f = this.cGL.cGT;
            float f2 = this.cGM.cGT;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cGL.e(i, i11, i5, i6, i9);
                this.cGM.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cGL.e(i, i11, i5, i6, i9);
        this.cGM.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cGL.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cGL.finish();
        this.cGM.finish();
    }

    public boolean h(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cGL.cGR - this.cGL.mStart)) && Math.signum(f2) == Math.signum((float) (this.cGM.cGR - this.cGM.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cHb = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cHc = new float[101];
        private static final float[] cHd = new float[101];
        private int Iv;
        private int cGQ;
        private int cGR;
        private int cGS;
        private float cGT;
        private float cGU;
        private int cGV;
        private int cGW;
        private int cGY;
        private float cHa;
        private int mStart;
        private long mStartTime;
        private float cGZ = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cGX = true;

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
                cHc[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cHd[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cHc;
            cHd[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cGZ = f;
        }

        a(Context context) {
            this.cHa = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void W(float f) {
            this.cGQ = this.mStart + Math.round((this.cGR - this.mStart) * f);
        }

        private static float kI(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cHd[i4];
                this.Iv = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cHd[i4 + 1] - f2)) + f2) * this.Iv);
            }
        }

        void B(int i, int i2, int i3) {
            this.cGX = false;
            this.mStart = i;
            this.cGR = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Iv = i3;
            this.cGU = 0.0f;
            this.cGS = 0;
        }

        void finish() {
            this.cGQ = this.cGR;
            this.cGX = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cGX = true;
            this.cGR = i;
            this.mStart = i;
            this.cGS = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Iv = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cGX;
        }

        private void D(int i, int i2, int i3) {
            this.cGX = false;
            this.mState = 1;
            this.mStart = i;
            this.cGR = i2;
            int i4 = i - i2;
            this.cGU = kI(i4);
            this.cGS = -i4;
            this.cGY = Math.abs(i4);
            this.Iv = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cGU));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cGY = i5;
            this.cGX = false;
            this.cGS = i2;
            this.cGT = i2;
            this.cGV = 0;
            this.Iv = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cGQ = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kL = kL(i2);
                this.cGV = kL;
                this.Iv = kL;
                d = kK(i2);
            }
            this.cGW = (int) (d * Math.signum(i2));
            this.cGR = this.cGW + i;
            if (this.cGR < i3) {
                A(this.mStart, this.cGR, i3);
                this.cGR = i3;
            }
            if (this.cGR > i4) {
                A(this.mStart, this.cGR, i4);
                this.cGR = i4;
            }
        }

        private double kJ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cGZ * this.cHa));
        }

        private double kK(int i) {
            return Math.exp(kJ(i) * (cHb / (cHb - 1.0d))) * this.cGZ * this.cHa;
        }

        private int kL(int i) {
            return (int) (Math.exp(kJ(i) / (cHb - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cGU;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cGU)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cGU));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cGS = (int) ((-this.cGU) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cGU = kI(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            amg();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cGX = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kK(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cGY);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cGY = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.cGT);
            }
        }

        private void amg() {
            float abs = (this.cGS * this.cGS) / (Math.abs(this.cGU) * 2.0f);
            float signum = Math.signum(this.cGS);
            if (abs > this.cGY) {
                this.cGU = (((-signum) * this.cGS) * this.cGS) / (this.cGY * 2.0f);
                abs = this.cGY;
            }
            this.cGY = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cGS <= 0) {
                abs = -abs;
            }
            this.cGR = ((int) abs) + i;
            this.Iv = -((int) ((1000.0f * this.cGS) / this.cGU));
        }

        boolean amh() {
            switch (this.mState) {
                case 0:
                    if (this.Iv < this.cGV) {
                        this.mStart = this.cGR;
                        this.cGS = (int) this.cGT;
                        this.cGU = kI(this.cGS);
                        this.mStartTime += this.Iv;
                        amg();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Iv;
                    D(this.cGR, this.mStart, 0);
                    break;
            }
            ami();
            return true;
        }

        boolean ami() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Iv) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cGV;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cHc[i];
                        f3 = (cHc[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cGT = ((f3 * this.cGW) / this.cGV) * 1000.0f;
                    d = f2 * this.cGW;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Iv;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cGS);
                    d = this.cGY * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cGT = ((-f6) + f7) * signum * this.cGY * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cGT = this.cGS + (this.cGU * f8);
                    d = ((f8 * (this.cGU * f8)) / 2.0f) + (this.cGS * f8);
                    break;
            }
            this.cGQ = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
