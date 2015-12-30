package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class q {
    private static float bFI = 8.0f;
    private static float bFJ;
    private final a bFF;
    private final a bFG;
    private final boolean bFH;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bFJ = 1.0f;
        bFJ = 1.0f / x(1.0f);
    }

    public q(Context context) {
        this(context, null);
    }

    public static float x(float f) {
        float exp;
        float f2 = bFI * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bFJ;
    }

    public q(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public q(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bFH = z;
        this.bFF = new a(context);
        this.bFG = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bFF.setFriction(f);
        this.bFG.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bFF.bFR && this.bFG.bFR;
    }

    public final int getCurrX() {
        return this.bFF.bFK;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.bFF.bFN * this.bFF.bFN) + (this.bFG.bFN * this.bFG.bFN));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bFF.mStartTime;
                int i = this.bFF.IR;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = x(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bFF.y(interpolation);
                    this.bFG.y(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bFF.bFR && !this.bFF.Vg() && !this.bFF.Vf()) {
                    this.bFF.finish();
                }
                if (!this.bFG.bFR && !this.bFG.Vg() && !this.bFG.Vf()) {
                    this.bFG.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bFF.x(i, i3, i5);
        this.bFG.x(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bFF.y(i, i3, i4) || this.bFG.y(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bFH && !isFinished()) {
            float f = this.bFF.bFN;
            float f2 = this.bFG.bFN;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bFF.c(i, i11, i5, i6, i9);
                this.bFG.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bFF.c(i, i11, i5, i6, i9);
        this.bFG.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bFF.C(i, i2, i3);
    }

    public void abortAnimation() {
        this.bFF.finish();
        this.bFG.finish();
    }

    public boolean f(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bFF.bFL - this.bFF.mStart)) && Math.signum(f2) == Math.signum((float) (this.bFG.bFL - this.bFG.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bFV = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bFW = new float[101];
        private static final float[] bFX = new float[101];
        private int IR;
        private int bFK;
        private int bFL;
        private int bFM;
        private float bFN;
        private float bFO;
        private int bFP;
        private int bFQ;
        private int bFS;
        private float bFU;
        private int mStart;
        private long mStartTime;
        private float bFT = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean bFR = true;

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
                bFW[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bFX[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bFW;
            bFX[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bFT = f;
        }

        a(Context context) {
            this.bFU = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void y(float f) {
            this.bFK = this.mStart + Math.round((this.bFL - this.mStart) * f);
        }

        private static float hY(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void w(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bFX[i4];
                this.IR = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bFX[i4 + 1] - f2)) + f2) * this.IR);
            }
        }

        void x(int i, int i2, int i3) {
            this.bFR = false;
            this.mStart = i;
            this.bFL = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.IR = i3;
            this.bFO = 0.0f;
            this.bFM = 0;
        }

        void finish() {
            this.bFK = this.bFL;
            this.bFR = true;
        }

        boolean y(int i, int i2, int i3) {
            this.bFR = true;
            this.bFL = i;
            this.mStart = i;
            this.bFM = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.IR = 0;
            if (i < i2) {
                z(i, i2, 0);
            } else if (i > i3) {
                z(i, i3, 0);
            }
            return !this.bFR;
        }

        private void z(int i, int i2, int i3) {
            this.bFR = false;
            this.mState = 1;
            this.mStart = i;
            this.bFL = i2;
            int i4 = i - i2;
            this.bFO = hY(i4);
            this.bFM = -i4;
            this.bFS = Math.abs(i4);
            this.IR = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.bFO));
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.bFS = i5;
            this.bFR = false;
            this.bFM = i2;
            this.bFN = i2;
            this.bFP = 0;
            this.IR = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.bFK = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int ib = ib(i2);
                this.bFP = ib;
                this.IR = ib;
                d = ia(i2);
            }
            this.bFQ = (int) (d * Math.signum(i2));
            this.bFL = this.bFQ + i;
            if (this.bFL < i3) {
                w(this.mStart, this.bFL, i3);
                this.bFL = i3;
            }
            if (this.bFL > i4) {
                w(this.mStart, this.bFL, i4);
                this.bFL = i4;
            }
        }

        private double hZ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bFT * this.bFU));
        }

        private double ia(int i) {
            return Math.exp(hZ(i) * (bFV / (bFV - 1.0d))) * this.bFT * this.bFU;
        }

        private int ib(int i) {
            return (int) (Math.exp(hZ(i) / (bFV - 1.0d)) * 1000.0d);
        }

        private void A(int i, int i2, int i3) {
            float f = (-i3) / this.bFO;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bFO)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bFO));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bFM = (int) ((-this.bFO) * sqrt);
        }

        private void B(int i, int i2, int i3) {
            this.bFO = hY(i3 == 0 ? i - i2 : i3);
            A(i, i2, i3);
            Ve();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.bFR = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                B(i, i5, i4);
            } else if (ia(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.bFS);
            } else {
                z(i, i5, i4);
            }
        }

        void C(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bFS = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.bFN);
            }
        }

        private void Ve() {
            float abs = (this.bFM * this.bFM) / (Math.abs(this.bFO) * 2.0f);
            float signum = Math.signum(this.bFM);
            if (abs > this.bFS) {
                this.bFO = (((-signum) * this.bFM) * this.bFM) / (this.bFS * 2.0f);
                abs = this.bFS;
            }
            this.bFS = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bFM <= 0) {
                abs = -abs;
            }
            this.bFL = ((int) abs) + i;
            this.IR = -((int) ((1000.0f * this.bFM) / this.bFO));
        }

        boolean Vf() {
            switch (this.mState) {
                case 0:
                    if (this.IR < this.bFP) {
                        this.mStart = this.bFL;
                        this.bFM = (int) this.bFN;
                        this.bFO = hY(this.bFM);
                        this.mStartTime += this.IR;
                        Ve();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.IR;
                    z(this.bFL, this.mStart, 0);
                    break;
            }
            Vg();
            return true;
        }

        boolean Vg() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.IR) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.bFP;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bFW[i];
                        f3 = (bFW[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bFN = ((f3 * this.bFQ) / this.bFP) * 1000.0f;
                    d = f2 * this.bFQ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.IR;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bFM);
                    d = this.bFS * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bFN = ((-f6) + f7) * signum * this.bFS * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bFN = this.bFM + (this.bFO * f8);
                    d = ((f8 * (this.bFO * f8)) / 2.0f) + (this.bFM * f8);
                    break;
            }
            this.bFK = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
