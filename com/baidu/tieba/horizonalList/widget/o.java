package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cEx = 8.0f;
    private static float cEy;
    private final a cEu;
    private final a cEv;
    private final boolean cEw;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cEy = 1.0f;
        cEy = 1.0f / V(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float V(float f) {
        float exp;
        float f2 = cEx * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cEy;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cEw = z;
        this.cEu = new a(context);
        this.cEv = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cEu.setFriction(f);
        this.cEv.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cEu.cEG && this.cEv.cEG;
    }

    public final int getCurrX() {
        return this.cEu.cEz;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cEu.cEC * this.cEu.cEC) + (this.cEv.cEC * this.cEv.cEC));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cEu.mStartTime;
                int i = this.cEu.It;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = V(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cEu.W(interpolation);
                    this.cEv.W(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cEu.cEG && !this.cEu.alh() && !this.cEu.alg()) {
                    this.cEu.finish();
                }
                if (!this.cEv.cEG && !this.cEv.alh() && !this.cEv.alg()) {
                    this.cEv.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cEu.B(i, i3, i5);
        this.cEv.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cEu.C(i, i3, i4) || this.cEv.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cEw && !isFinished()) {
            float f = this.cEu.cEC;
            float f2 = this.cEv.cEC;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cEu.e(i, i11, i5, i6, i9);
                this.cEv.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cEu.e(i, i11, i5, i6, i9);
        this.cEv.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cEu.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cEu.finish();
        this.cEv.finish();
    }

    public boolean h(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cEu.cEA - this.cEu.mStart)) && Math.signum(f2) == Math.signum((float) (this.cEv.cEA - this.cEv.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cEK = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cEL = new float[101];
        private static final float[] cEM = new float[101];
        private int It;
        private int cEA;
        private int cEB;
        private float cEC;
        private float cED;
        private int cEE;
        private int cEF;
        private int cEH;
        private float cEJ;
        private int cEz;
        private int mStart;
        private long mStartTime;
        private float cEI = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cEG = true;

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
                cEL[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cEM[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cEL;
            cEM[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cEI = f;
        }

        a(Context context) {
            this.cEJ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void W(float f) {
            this.cEz = this.mStart + Math.round((this.cEA - this.mStart) * f);
        }

        private static float kC(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cEM[i4];
                this.It = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cEM[i4 + 1] - f2)) + f2) * this.It);
            }
        }

        void B(int i, int i2, int i3) {
            this.cEG = false;
            this.mStart = i;
            this.cEA = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.It = i3;
            this.cED = 0.0f;
            this.cEB = 0;
        }

        void finish() {
            this.cEz = this.cEA;
            this.cEG = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cEG = true;
            this.cEA = i;
            this.mStart = i;
            this.cEB = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.It = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cEG;
        }

        private void D(int i, int i2, int i3) {
            this.cEG = false;
            this.mState = 1;
            this.mStart = i;
            this.cEA = i2;
            int i4 = i - i2;
            this.cED = kC(i4);
            this.cEB = -i4;
            this.cEH = Math.abs(i4);
            this.It = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cED));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cEH = i5;
            this.cEG = false;
            this.cEB = i2;
            this.cEC = i2;
            this.cEE = 0;
            this.It = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cEz = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kF = kF(i2);
                this.cEE = kF;
                this.It = kF;
                d = kE(i2);
            }
            this.cEF = (int) (d * Math.signum(i2));
            this.cEA = this.cEF + i;
            if (this.cEA < i3) {
                A(this.mStart, this.cEA, i3);
                this.cEA = i3;
            }
            if (this.cEA > i4) {
                A(this.mStart, this.cEA, i4);
                this.cEA = i4;
            }
        }

        private double kD(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cEI * this.cEJ));
        }

        private double kE(int i) {
            return Math.exp(kD(i) * (cEK / (cEK - 1.0d))) * this.cEI * this.cEJ;
        }

        private int kF(int i) {
            return (int) (Math.exp(kD(i) / (cEK - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cED;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cED)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cED));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cEB = (int) ((-this.cED) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cED = kC(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            alf();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cEG = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kE(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cEH);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cEH = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.cEC);
            }
        }

        private void alf() {
            float abs = (this.cEB * this.cEB) / (Math.abs(this.cED) * 2.0f);
            float signum = Math.signum(this.cEB);
            if (abs > this.cEH) {
                this.cED = (((-signum) * this.cEB) * this.cEB) / (this.cEH * 2.0f);
                abs = this.cEH;
            }
            this.cEH = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cEB <= 0) {
                abs = -abs;
            }
            this.cEA = ((int) abs) + i;
            this.It = -((int) ((1000.0f * this.cEB) / this.cED));
        }

        boolean alg() {
            switch (this.mState) {
                case 0:
                    if (this.It < this.cEE) {
                        this.mStart = this.cEA;
                        this.cEB = (int) this.cEC;
                        this.cED = kC(this.cEB);
                        this.mStartTime += this.It;
                        alf();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.It;
                    D(this.cEA, this.mStart, 0);
                    break;
            }
            alh();
            return true;
        }

        boolean alh() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.It) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cEE;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cEL[i];
                        f3 = (cEL[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cEC = ((f3 * this.cEF) / this.cEE) * 1000.0f;
                    d = f2 * this.cEF;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.It;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cEB);
                    d = this.cEH * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cEC = ((-f6) + f7) * signum * this.cEH * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cEC = this.cEB + (this.cED * f8);
                    d = ((f8 * (this.cED * f8)) / 2.0f) + (this.cEB * f8);
                    break;
            }
            this.cEz = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
