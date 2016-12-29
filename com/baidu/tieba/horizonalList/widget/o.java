package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cxy = 8.0f;
    private static float cxz;
    private final a cxv;
    private final a cxw;
    private final boolean cxx;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cxz = 1.0f;
        cxz = 1.0f / ag(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float ag(float f) {
        float exp;
        float f2 = cxy * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cxz;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cxx = z;
        this.cxv = new a(context);
        this.cxw = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cxv.setFriction(f);
        this.cxw.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cxv.cxH && this.cxw.cxH;
    }

    public final int getCurrX() {
        return this.cxv.cxA;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cxv.cxD * this.cxv.cxD) + (this.cxw.cxD * this.cxw.cxD));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cxv.mStartTime;
                int i = this.cxv.Ct;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ag(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cxv.ah(interpolation);
                    this.cxw.ah(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cxv.cxH && !this.cxv.akU() && !this.cxv.akT()) {
                    this.cxv.finish();
                }
                if (!this.cxw.cxH && !this.cxw.akU() && !this.cxw.akT()) {
                    this.cxw.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cxv.A(i, i3, i5);
        this.cxw.A(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cxv.B(i, i3, i4) || this.cxw.B(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cxx && !isFinished()) {
            float f = this.cxv.cxD;
            float f2 = this.cxw.cxD;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cxv.e(i, i11, i5, i6, i9);
                this.cxw.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cxv.e(i, i11, i5, i6, i9);
        this.cxw.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cxv.F(i, i2, i3);
    }

    public void abortAnimation() {
        this.cxv.finish();
        this.cxw.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cxv.cxB - this.cxv.mStart)) && Math.signum(f2) == Math.signum((float) (this.cxw.cxB - this.cxw.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cxL = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cxM = new float[101];
        private static final float[] cxN = new float[101];
        private int Ct;
        private int cxA;
        private int cxB;
        private int cxC;
        private float cxD;
        private float cxE;
        private int cxF;
        private int cxG;
        private int cxI;
        private float cxK;
        private int mStart;
        private long mStartTime;
        private float cxJ = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cxH = true;

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
                cxM[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cxN[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cxM;
            cxN[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cxJ = f;
        }

        a(Context context) {
            this.cxK = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ah(float f) {
            this.cxA = this.mStart + Math.round((this.cxB - this.mStart) * f);
        }

        private static float kk(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void z(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cxN[i4];
                this.Ct = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cxN[i4 + 1] - f2)) + f2) * this.Ct);
            }
        }

        void A(int i, int i2, int i3) {
            this.cxH = false;
            this.mStart = i;
            this.cxB = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ct = i3;
            this.cxE = 0.0f;
            this.cxC = 0;
        }

        void finish() {
            this.cxA = this.cxB;
            this.cxH = true;
        }

        boolean B(int i, int i2, int i3) {
            this.cxH = true;
            this.cxB = i;
            this.mStart = i;
            this.cxC = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ct = 0;
            if (i < i2) {
                C(i, i2, 0);
            } else if (i > i3) {
                C(i, i3, 0);
            }
            return !this.cxH;
        }

        private void C(int i, int i2, int i3) {
            this.cxH = false;
            this.mState = 1;
            this.mStart = i;
            this.cxB = i2;
            int i4 = i - i2;
            this.cxE = kk(i4);
            this.cxC = -i4;
            this.cxI = Math.abs(i4);
            this.Ct = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cxE));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cxI = i5;
            this.cxH = false;
            this.cxC = i2;
            this.cxD = i2;
            this.cxF = 0;
            this.Ct = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cxA = i;
            if (i > i4 || i < i3) {
                m(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kn = kn(i2);
                this.cxF = kn;
                this.Ct = kn;
                d = km(i2);
            }
            this.cxG = (int) (d * Math.signum(i2));
            this.cxB = this.cxG + i;
            if (this.cxB < i3) {
                z(this.mStart, this.cxB, i3);
                this.cxB = i3;
            }
            if (this.cxB > i4) {
                z(this.mStart, this.cxB, i4);
                this.cxB = i4;
            }
        }

        private double kl(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cxJ * this.cxK));
        }

        private double km(int i) {
            return Math.exp(kl(i) * (cxL / (cxL - 1.0d))) * this.cxJ * this.cxK;
        }

        private int kn(int i) {
            return (int) (Math.exp(kl(i) / (cxL - 1.0d)) * 1000.0d);
        }

        private void D(int i, int i2, int i3) {
            float f = (-i3) / this.cxE;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cxE)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cxE));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cxC = (int) ((-this.cxE) * sqrt);
        }

        private void E(int i, int i2, int i3) {
            this.cxE = kk(i3 == 0 ? i - i2 : i3);
            D(i, i2, i3);
            akS();
        }

        private void m(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cxH = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                E(i, i5, i4);
            } else if (km(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cxI);
            } else {
                C(i, i5, i4);
            }
        }

        void F(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cxI = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                m(i, i2, i2, (int) this.cxD);
            }
        }

        private void akS() {
            float abs = (this.cxC * this.cxC) / (Math.abs(this.cxE) * 2.0f);
            float signum = Math.signum(this.cxC);
            if (abs > this.cxI) {
                this.cxE = (((-signum) * this.cxC) * this.cxC) / (this.cxI * 2.0f);
                abs = this.cxI;
            }
            this.cxI = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cxC <= 0) {
                abs = -abs;
            }
            this.cxB = ((int) abs) + i;
            this.Ct = -((int) ((1000.0f * this.cxC) / this.cxE));
        }

        boolean akT() {
            switch (this.mState) {
                case 0:
                    if (this.Ct < this.cxF) {
                        this.mStart = this.cxB;
                        this.cxC = (int) this.cxD;
                        this.cxE = kk(this.cxC);
                        this.mStartTime += this.Ct;
                        akS();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Ct;
                    C(this.cxB, this.mStart, 0);
                    break;
            }
            akU();
            return true;
        }

        boolean akU() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Ct) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cxF;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cxM[i];
                        f3 = (cxM[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cxD = ((f3 * this.cxG) / this.cxF) * 1000.0f;
                    d = f2 * this.cxG;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Ct;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cxC);
                    d = this.cxI * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cxD = ((-f6) + f7) * signum * this.cxI * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cxD = this.cxC + (this.cxE * f8);
                    d = ((f8 * (this.cxE * f8)) / 2.0f) + (this.cxC * f8);
                    break;
            }
            this.cxA = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
