package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cSr = 8.0f;
    private static float cSs;
    private final a cSo;
    private final a cSp;
    private final boolean cSq;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cSs = 1.0f;
        cSs = 1.0f / al(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float al(float f) {
        float exp;
        float f2 = cSr * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cSs;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cSq = z;
        this.cSo = new a(context);
        this.cSp = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cSo.setFriction(f);
        this.cSp.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cSo.cSA && this.cSp.cSA;
    }

    public final int getCurrX() {
        return this.cSo.cSt;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cSo.cSw * this.cSo.cSw) + (this.cSp.cSw * this.cSp.cSw));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cSo.mStartTime;
                int i = this.cSo.Cs;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = al(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cSo.am(interpolation);
                    this.cSp.am(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cSo.cSA && !this.cSo.aqs() && !this.cSo.aqr()) {
                    this.cSo.finish();
                }
                if (!this.cSp.cSA && !this.cSp.aqs() && !this.cSp.aqr()) {
                    this.cSp.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cSo.A(i, i3, i5);
        this.cSp.A(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cSo.B(i, i3, i4) || this.cSp.B(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cSq && !isFinished()) {
            float f = this.cSo.cSw;
            float f2 = this.cSp.cSw;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cSo.e(i, i11, i5, i6, i9);
                this.cSp.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cSo.e(i, i11, i5, i6, i9);
        this.cSp.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cSo.F(i, i2, i3);
    }

    public void abortAnimation() {
        this.cSo.finish();
        this.cSp.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cSo.cSu - this.cSo.mStart)) && Math.signum(f2) == Math.signum((float) (this.cSp.cSu - this.cSp.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cSE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cSF = new float[101];
        private static final float[] cSG = new float[101];
        private int Cs;
        private int cSB;
        private float cSD;
        private int cSt;
        private int cSu;
        private int cSv;
        private float cSw;
        private float cSx;
        private int cSy;
        private int cSz;
        private int mStart;
        private long mStartTime;
        private float cSC = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cSA = true;

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
                cSF[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cSG[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cSF;
            cSG[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cSC = f;
        }

        a(Context context) {
            this.cSD = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void am(float f) {
            this.cSt = this.mStart + Math.round((this.cSu - this.mStart) * f);
        }

        private static float la(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void z(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cSG[i4];
                this.Cs = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cSG[i4 + 1] - f2)) + f2) * this.Cs);
            }
        }

        void A(int i, int i2, int i3) {
            this.cSA = false;
            this.mStart = i;
            this.cSu = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Cs = i3;
            this.cSx = 0.0f;
            this.cSv = 0;
        }

        void finish() {
            this.cSt = this.cSu;
            this.cSA = true;
        }

        boolean B(int i, int i2, int i3) {
            this.cSA = true;
            this.cSu = i;
            this.mStart = i;
            this.cSv = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Cs = 0;
            if (i < i2) {
                C(i, i2, 0);
            } else if (i > i3) {
                C(i, i3, 0);
            }
            return !this.cSA;
        }

        private void C(int i, int i2, int i3) {
            this.cSA = false;
            this.mState = 1;
            this.mStart = i;
            this.cSu = i2;
            int i4 = i - i2;
            this.cSx = la(i4);
            this.cSv = -i4;
            this.cSB = Math.abs(i4);
            this.Cs = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cSx));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cSB = i5;
            this.cSA = false;
            this.cSv = i2;
            this.cSw = i2;
            this.cSy = 0;
            this.Cs = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cSt = i;
            if (i > i4 || i < i3) {
                m(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int ld = ld(i2);
                this.cSy = ld;
                this.Cs = ld;
                d = lc(i2);
            }
            this.cSz = (int) (d * Math.signum(i2));
            this.cSu = this.cSz + i;
            if (this.cSu < i3) {
                z(this.mStart, this.cSu, i3);
                this.cSu = i3;
            }
            if (this.cSu > i4) {
                z(this.mStart, this.cSu, i4);
                this.cSu = i4;
            }
        }

        private double lb(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cSC * this.cSD));
        }

        private double lc(int i) {
            return Math.exp(lb(i) * (cSE / (cSE - 1.0d))) * this.cSC * this.cSD;
        }

        private int ld(int i) {
            return (int) (Math.exp(lb(i) / (cSE - 1.0d)) * 1000.0d);
        }

        private void D(int i, int i2, int i3) {
            float f = (-i3) / this.cSx;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cSx)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cSx));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cSv = (int) ((-this.cSx) * sqrt);
        }

        private void E(int i, int i2, int i3) {
            this.cSx = la(i3 == 0 ? i - i2 : i3);
            D(i, i2, i3);
            aqq();
        }

        private void m(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cSA = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                E(i, i5, i4);
            } else if (lc(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cSB);
            } else {
                C(i, i5, i4);
            }
        }

        void F(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cSB = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                m(i, i2, i2, (int) this.cSw);
            }
        }

        private void aqq() {
            float abs = (this.cSv * this.cSv) / (Math.abs(this.cSx) * 2.0f);
            float signum = Math.signum(this.cSv);
            if (abs > this.cSB) {
                this.cSx = (((-signum) * this.cSv) * this.cSv) / (this.cSB * 2.0f);
                abs = this.cSB;
            }
            this.cSB = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cSv <= 0) {
                abs = -abs;
            }
            this.cSu = ((int) abs) + i;
            this.Cs = -((int) ((1000.0f * this.cSv) / this.cSx));
        }

        boolean aqr() {
            switch (this.mState) {
                case 0:
                    if (this.Cs < this.cSy) {
                        this.mStart = this.cSu;
                        this.cSv = (int) this.cSw;
                        this.cSx = la(this.cSv);
                        this.mStartTime += this.Cs;
                        aqq();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Cs;
                    C(this.cSu, this.mStart, 0);
                    break;
            }
            aqs();
            return true;
        }

        boolean aqs() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Cs) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cSy;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cSF[i];
                        f3 = (cSF[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cSw = ((f3 * this.cSz) / this.cSy) * 1000.0f;
                    d = f2 * this.cSz;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Cs;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cSv);
                    d = this.cSB * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cSw = ((-f6) + f7) * signum * this.cSB * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cSw = this.cSv + (this.cSx * f8);
                    d = ((f8 * (this.cSx * f8)) / 2.0f) + (this.cSv * f8);
                    break;
            }
            this.cSt = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
