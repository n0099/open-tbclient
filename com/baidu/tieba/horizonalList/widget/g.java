package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float dgX = 8.0f;
    private static float dgY;
    private final a dgU;
    private final a dgV;
    private final boolean dgW;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        dgY = 1.0f;
        dgY = 1.0f / O(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float O(float f) {
        float exp;
        float f2 = dgX * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * dgY;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.dgW = z;
        this.dgU = new a(context);
        this.dgV = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.dgU.setFriction(f);
        this.dgV.setFriction(f);
    }

    public final boolean isFinished() {
        return this.dgU.dhf && this.dgV.dhf;
    }

    public final int getCurrX() {
        return this.dgU.cAO;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.dgU.dhb * this.dgU.dhb) + (this.dgV.dhb * this.dgV.dhb));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.dgU.mStartTime;
                int i = this.dgU.HD;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = O(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.dgU.P(interpolation);
                    this.dgV.P(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.dgU.dhf && !this.dgU.arL() && !this.dgU.arK()) {
                    this.dgU.finish();
                }
                if (!this.dgV.dhf && !this.dgV.arL() && !this.dgV.arK()) {
                    this.dgV.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.dgU.B(i, i3, i5);
        this.dgV.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.dgU.C(i, i3, i4) || this.dgV.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.dgW && !isFinished()) {
            float f = this.dgU.dhb;
            float f2 = this.dgV.dhb;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.dgU.d(i, i11, i5, i6, i9);
                this.dgV.d(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.dgU.d(i, i11, i5, i6, i9);
        this.dgV.d(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.dgU.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.dgU.finish();
        this.dgV.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.dgU.dgZ - this.dgU.mStart)) && Math.signum(f2) == Math.signum((float) (this.dgV.dgZ - this.dgV.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float dhj = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] dhk = new float[101];
        private static final float[] dhl = new float[101];
        private int HD;
        private int cAO;
        private int dgZ;
        private int dha;
        private float dhb;
        private float dhc;
        private int dhd;
        private int dhe;
        private int dhg;
        private float dhi;
        private int mStart;
        private long mStartTime;
        private float dhh = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean dhf = true;

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
                dhk[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                dhl[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = dhk;
            dhl[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.dhh = f;
        }

        a(Context context) {
            this.dhi = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void P(float f) {
            this.cAO = this.mStart + Math.round((this.dgZ - this.mStart) * f);
        }

        private static float lL(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = dhl[i4];
                this.HD = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (dhl[i4 + 1] - f2)) + f2) * this.HD);
            }
        }

        void B(int i, int i2, int i3) {
            this.dhf = false;
            this.mStart = i;
            this.dgZ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HD = i3;
            this.dhc = 0.0f;
            this.dha = 0;
        }

        void finish() {
            this.cAO = this.dgZ;
            this.dhf = true;
        }

        boolean C(int i, int i2, int i3) {
            this.dhf = true;
            this.dgZ = i;
            this.mStart = i;
            this.dha = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.HD = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.dhf;
        }

        private void D(int i, int i2, int i3) {
            this.dhf = false;
            this.mState = 1;
            this.mStart = i;
            this.dgZ = i2;
            int i4 = i - i2;
            this.dhc = lL(i4);
            this.dha = -i4;
            this.dhg = Math.abs(i4);
            this.HD = (int) (Math.sqrt((i4 * (-2.0d)) / this.dhc) * 1000.0d);
        }

        void d(int i, int i2, int i3, int i4, int i5) {
            this.dhg = i5;
            this.dhf = false;
            this.dha = i2;
            this.dhb = i2;
            this.dhd = 0;
            this.HD = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cAO = i;
            if (i > i4 || i < i3) {
                n(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lO = lO(i2);
                this.dhd = lO;
                this.HD = lO;
                d = lN(i2);
            }
            this.dhe = (int) (d * Math.signum(i2));
            this.dgZ = this.dhe + i;
            if (this.dgZ < i3) {
                A(this.mStart, this.dgZ, i3);
                this.dgZ = i3;
            }
            if (this.dgZ > i4) {
                A(this.mStart, this.dgZ, i4);
                this.dgZ = i4;
            }
        }

        private double lM(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.dhh * this.dhi));
        }

        private double lN(int i) {
            return Math.exp(lM(i) * (dhj / (dhj - 1.0d))) * this.dhh * this.dhi;
        }

        private int lO(int i) {
            return (int) (Math.exp(lM(i) / (dhj - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.dhc;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.dhc)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.dhc));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.dha = (int) ((-this.dhc) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.dhc = lL(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            arJ();
        }

        private void n(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.dhf = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (lN(i4) > Math.abs(i6)) {
                d(i, i4, z ? i2 : i, z ? i : i3, this.dhg);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.dhg = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                n(i, i2, i2, (int) this.dhb);
            }
        }

        private void arJ() {
            float abs = (this.dha * this.dha) / (Math.abs(this.dhc) * 2.0f);
            float signum = Math.signum(this.dha);
            if (abs > this.dhg) {
                this.dhc = (((-signum) * this.dha) * this.dha) / (this.dhg * 2.0f);
                abs = this.dhg;
            }
            this.dhg = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.dha <= 0) {
                abs = -abs;
            }
            this.dgZ = ((int) abs) + i;
            this.HD = -((int) ((1000.0f * this.dha) / this.dhc));
        }

        boolean arK() {
            switch (this.mState) {
                case 0:
                    if (this.HD < this.dhd) {
                        this.mStart = this.dgZ;
                        this.dha = (int) this.dhb;
                        this.dhc = lL(this.dha);
                        this.mStartTime += this.HD;
                        arJ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.HD;
                    D(this.dgZ, this.mStart, 0);
                    break;
            }
            arL();
            return true;
        }

        boolean arL() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.HD) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.dhd;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = dhk[i];
                        f3 = (dhk[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.dhb = ((f3 * this.dhe) / this.dhd) * 1000.0f;
                    d = f2 * this.dhe;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.HD;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.dha);
                    d = this.dhg * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.dhb = ((-f6) + f7) * signum * this.dhg * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.dhb = this.dha + (this.dhc * f8);
                    d = ((f8 * (this.dhc * f8)) / 2.0f) + (this.dha * f8);
                    break;
            }
            this.cAO = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
