package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cFY = 8.0f;
    private static float cFZ;
    private final a cFV;
    private final a cFW;
    private final boolean cFX;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cFZ = 1.0f;
        cFZ = 1.0f / V(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float V(float f) {
        float exp;
        float f2 = cFY * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cFZ;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cFX = z;
        this.cFV = new a(context);
        this.cFW = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cFV.setFriction(f);
        this.cFW.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cFV.cGh && this.cFW.cGh;
    }

    public final int getCurrX() {
        return this.cFV.cGa;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cFV.cGd * this.cFV.cGd) + (this.cFW.cGd * this.cFW.cGd));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cFV.mStartTime;
                int i = this.cFV.IT;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = V(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cFV.W(interpolation);
                    this.cFW.W(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cFV.cGh && !this.cFV.aln() && !this.cFV.alm()) {
                    this.cFV.finish();
                }
                if (!this.cFW.cGh && !this.cFW.aln() && !this.cFW.alm()) {
                    this.cFW.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cFV.B(i, i3, i5);
        this.cFW.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cFV.C(i, i3, i4) || this.cFW.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cFX && !isFinished()) {
            float f = this.cFV.cGd;
            float f2 = this.cFW.cGd;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cFV.e(i, i11, i5, i6, i9);
                this.cFW.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cFV.e(i, i11, i5, i6, i9);
        this.cFW.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cFV.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cFV.finish();
        this.cFW.finish();
    }

    public boolean h(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cFV.cGb - this.cFV.mStart)) && Math.signum(f2) == Math.signum((float) (this.cFW.cGb - this.cFW.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cGl = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cGm = new float[101];
        private static final float[] cGn = new float[101];
        private int IT;
        private int cGa;
        private int cGb;
        private int cGc;
        private float cGd;
        private float cGe;
        private int cGf;
        private int cGg;
        private int cGi;
        private float cGk;
        private int mStart;
        private long mStartTime;
        private float cGj = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cGh = true;

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
                cGm[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cGn[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cGm;
            cGn[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cGj = f;
        }

        a(Context context) {
            this.cGk = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void W(float f) {
            this.cGa = this.mStart + Math.round((this.cGb - this.mStart) * f);
        }

        private static float kB(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cGn[i4];
                this.IT = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cGn[i4 + 1] - f2)) + f2) * this.IT);
            }
        }

        void B(int i, int i2, int i3) {
            this.cGh = false;
            this.mStart = i;
            this.cGb = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.IT = i3;
            this.cGe = 0.0f;
            this.cGc = 0;
        }

        void finish() {
            this.cGa = this.cGb;
            this.cGh = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cGh = true;
            this.cGb = i;
            this.mStart = i;
            this.cGc = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.IT = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cGh;
        }

        private void D(int i, int i2, int i3) {
            this.cGh = false;
            this.mState = 1;
            this.mStart = i;
            this.cGb = i2;
            int i4 = i - i2;
            this.cGe = kB(i4);
            this.cGc = -i4;
            this.cGi = Math.abs(i4);
            this.IT = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cGe));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cGi = i5;
            this.cGh = false;
            this.cGc = i2;
            this.cGd = i2;
            this.cGf = 0;
            this.IT = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cGa = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kE = kE(i2);
                this.cGf = kE;
                this.IT = kE;
                d = kD(i2);
            }
            this.cGg = (int) (d * Math.signum(i2));
            this.cGb = this.cGg + i;
            if (this.cGb < i3) {
                A(this.mStart, this.cGb, i3);
                this.cGb = i3;
            }
            if (this.cGb > i4) {
                A(this.mStart, this.cGb, i4);
                this.cGb = i4;
            }
        }

        private double kC(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cGj * this.cGk));
        }

        private double kD(int i) {
            return Math.exp(kC(i) * (cGl / (cGl - 1.0d))) * this.cGj * this.cGk;
        }

        private int kE(int i) {
            return (int) (Math.exp(kC(i) / (cGl - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cGe;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cGe)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cGe));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cGc = (int) ((-this.cGe) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cGe = kB(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            all();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cGh = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kD(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cGi);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cGi = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.cGd);
            }
        }

        private void all() {
            float abs = (this.cGc * this.cGc) / (Math.abs(this.cGe) * 2.0f);
            float signum = Math.signum(this.cGc);
            if (abs > this.cGi) {
                this.cGe = (((-signum) * this.cGc) * this.cGc) / (this.cGi * 2.0f);
                abs = this.cGi;
            }
            this.cGi = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cGc <= 0) {
                abs = -abs;
            }
            this.cGb = ((int) abs) + i;
            this.IT = -((int) ((1000.0f * this.cGc) / this.cGe));
        }

        boolean alm() {
            switch (this.mState) {
                case 0:
                    if (this.IT < this.cGf) {
                        this.mStart = this.cGb;
                        this.cGc = (int) this.cGd;
                        this.cGe = kB(this.cGc);
                        this.mStartTime += this.IT;
                        all();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.IT;
                    D(this.cGb, this.mStart, 0);
                    break;
            }
            aln();
            return true;
        }

        boolean aln() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.IT) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cGf;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cGm[i];
                        f3 = (cGm[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cGd = ((f3 * this.cGg) / this.cGf) * 1000.0f;
                    d = f2 * this.cGg;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.IT;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cGc);
                    d = this.cGi * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cGd = ((-f6) + f7) * signum * this.cGi * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cGd = this.cGc + (this.cGe * f8);
                    d = ((f8 * (this.cGe * f8)) / 2.0f) + (this.cGc * f8);
                    break;
            }
            this.cGa = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
