package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cEC = 8.0f;
    private static float cED;
    private final a cEA;
    private final boolean cEB;
    private final a cEz;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cED = 1.0f;
        cED = 1.0f / Z(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float Z(float f) {
        float exp;
        float f2 = cEC * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cED;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cEB = z;
        this.cEz = new a(context);
        this.cEA = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cEz.setFriction(f);
        this.cEA.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cEz.cEL && this.cEA.cEL;
    }

    public final int getCurrX() {
        return this.cEz.cEE;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cEz.cEH * this.cEz.cEH) + (this.cEA.cEH * this.cEA.cEH));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cEz.mStartTime;
                int i = this.cEz.BF;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = Z(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cEz.aa(interpolation);
                    this.cEA.aa(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cEz.cEL && !this.cEz.amb() && !this.cEz.ama()) {
                    this.cEz.finish();
                }
                if (!this.cEA.cEL && !this.cEA.amb() && !this.cEA.ama()) {
                    this.cEA.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cEz.B(i, i3, i5);
        this.cEA.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cEz.C(i, i3, i4) || this.cEA.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cEB && !isFinished()) {
            float f = this.cEz.cEH;
            float f2 = this.cEA.cEH;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cEz.e(i, i11, i5, i6, i9);
                this.cEA.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cEz.e(i, i11, i5, i6, i9);
        this.cEA.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cEz.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cEz.finish();
        this.cEA.finish();
    }

    public boolean h(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cEz.cEF - this.cEz.mStart)) && Math.signum(f2) == Math.signum((float) (this.cEA.cEF - this.cEA.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cEP = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cEQ = new float[101];
        private static final float[] cER = new float[101];
        private int BF;
        private int cEE;
        private int cEF;
        private int cEG;
        private float cEH;
        private float cEI;
        private int cEJ;
        private int cEK;
        private int cEM;
        private float cEO;
        private int mStart;
        private long mStartTime;
        private float cEN = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cEL = true;

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
                cEQ[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cER[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cEQ;
            cER[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cEN = f;
        }

        a(Context context) {
            this.cEO = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aa(float f) {
            this.cEE = this.mStart + Math.round((this.cEF - this.mStart) * f);
        }

        private static float kX(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cER[i4];
                this.BF = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cER[i4 + 1] - f2)) + f2) * this.BF);
            }
        }

        void B(int i, int i2, int i3) {
            this.cEL = false;
            this.mStart = i;
            this.cEF = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.BF = i3;
            this.cEI = 0.0f;
            this.cEG = 0;
        }

        void finish() {
            this.cEE = this.cEF;
            this.cEL = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cEL = true;
            this.cEF = i;
            this.mStart = i;
            this.cEG = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.BF = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cEL;
        }

        private void D(int i, int i2, int i3) {
            this.cEL = false;
            this.mState = 1;
            this.mStart = i;
            this.cEF = i2;
            int i4 = i - i2;
            this.cEI = kX(i4);
            this.cEG = -i4;
            this.cEM = Math.abs(i4);
            this.BF = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cEI));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cEM = i5;
            this.cEL = false;
            this.cEG = i2;
            this.cEH = i2;
            this.cEJ = 0;
            this.BF = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cEE = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int la = la(i2);
                this.cEJ = la;
                this.BF = la;
                d = kZ(i2);
            }
            this.cEK = (int) (d * Math.signum(i2));
            this.cEF = this.cEK + i;
            if (this.cEF < i3) {
                A(this.mStart, this.cEF, i3);
                this.cEF = i3;
            }
            if (this.cEF > i4) {
                A(this.mStart, this.cEF, i4);
                this.cEF = i4;
            }
        }

        private double kY(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cEN * this.cEO));
        }

        private double kZ(int i) {
            return Math.exp(kY(i) * (cEP / (cEP - 1.0d))) * this.cEN * this.cEO;
        }

        private int la(int i) {
            return (int) (Math.exp(kY(i) / (cEP - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cEI;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cEI)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cEI));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cEG = (int) ((-this.cEI) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cEI = kX(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            alZ();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cEL = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kZ(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cEM);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cEM = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.cEH);
            }
        }

        private void alZ() {
            float abs = (this.cEG * this.cEG) / (Math.abs(this.cEI) * 2.0f);
            float signum = Math.signum(this.cEG);
            if (abs > this.cEM) {
                this.cEI = (((-signum) * this.cEG) * this.cEG) / (this.cEM * 2.0f);
                abs = this.cEM;
            }
            this.cEM = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cEG <= 0) {
                abs = -abs;
            }
            this.cEF = ((int) abs) + i;
            this.BF = -((int) ((1000.0f * this.cEG) / this.cEI));
        }

        boolean ama() {
            switch (this.mState) {
                case 0:
                    if (this.BF < this.cEJ) {
                        this.mStart = this.cEF;
                        this.cEG = (int) this.cEH;
                        this.cEI = kX(this.cEG);
                        this.mStartTime += this.BF;
                        alZ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.BF;
                    D(this.cEF, this.mStart, 0);
                    break;
            }
            amb();
            return true;
        }

        boolean amb() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.BF) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cEJ;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cEQ[i];
                        f3 = (cEQ[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cEH = ((f3 * this.cEK) / this.cEJ) * 1000.0f;
                    d = f2 * this.cEK;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.BF;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cEG);
                    d = this.cEM * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cEH = ((-f6) + f7) * signum * this.cEM * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cEH = this.cEG + (this.cEI * f8);
                    d = ((f8 * (this.cEI * f8)) / 2.0f) + (this.cEG * f8);
                    break;
            }
            this.cEE = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
