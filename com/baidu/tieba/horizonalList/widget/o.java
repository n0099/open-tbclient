package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cxQ = 8.0f;
    private static float cxR;
    private final a cxN;
    private final a cxO;
    private final boolean cxP;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cxR = 1.0f;
        cxR = 1.0f / G(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float G(float f) {
        float exp;
        float f2 = cxQ * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cxR;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cxP = z;
        this.cxN = new a(context);
        this.cxO = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cxN.setFriction(f);
        this.cxO.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cxN.cxZ && this.cxO.cxZ;
    }

    public final int getCurrX() {
        return this.cxN.cxS;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cxN.cxV * this.cxN.cxV) + (this.cxO.cxV * this.cxO.cxV));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cxN.mStartTime;
                int i = this.cxN.zC;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = G(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cxN.H(interpolation);
                    this.cxO.H(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cxN.cxZ && !this.cxN.aiM() && !this.cxN.aiL()) {
                    this.cxN.finish();
                }
                if (!this.cxO.cxZ && !this.cxO.aiM() && !this.cxO.aiL()) {
                    this.cxO.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cxN.x(i, i3, i5);
        this.cxO.x(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cxN.y(i, i3, i4) || this.cxO.y(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cxP && !isFinished()) {
            float f = this.cxN.cxV;
            float f2 = this.cxO.cxV;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cxN.c(i, i11, i5, i6, i9);
                this.cxO.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cxN.c(i, i11, i5, i6, i9);
        this.cxO.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cxN.C(i, i2, i3);
    }

    public void abortAnimation() {
        this.cxN.finish();
        this.cxO.finish();
    }

    public boolean e(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cxN.cxT - this.cxN.mStart)) && Math.signum(f2) == Math.signum((float) (this.cxO.cxT - this.cxO.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cyd = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cye = new float[101];
        private static final float[] cyf = new float[101];
        private int cxS;
        private int cxT;
        private int cxU;
        private float cxV;
        private float cxW;
        private int cxX;
        private int cxY;
        private int cya;
        private float cyc;
        private int mStart;
        private long mStartTime;
        private int zC;
        private float cyb = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cxZ = true;

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
                cye[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cyf[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cye;
            cyf[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cyb = f;
        }

        a(Context context) {
            this.cyc = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void H(float f) {
            this.cxS = this.mStart + Math.round((this.cxT - this.mStart) * f);
        }

        private static float ke(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void w(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cyf[i4];
                this.zC = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cyf[i4 + 1] - f2)) + f2) * this.zC);
            }
        }

        void x(int i, int i2, int i3) {
            this.cxZ = false;
            this.mStart = i;
            this.cxT = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.zC = i3;
            this.cxW = 0.0f;
            this.cxU = 0;
        }

        void finish() {
            this.cxS = this.cxT;
            this.cxZ = true;
        }

        boolean y(int i, int i2, int i3) {
            this.cxZ = true;
            this.cxT = i;
            this.mStart = i;
            this.cxU = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.zC = 0;
            if (i < i2) {
                z(i, i2, 0);
            } else if (i > i3) {
                z(i, i3, 0);
            }
            return !this.cxZ;
        }

        private void z(int i, int i2, int i3) {
            this.cxZ = false;
            this.mState = 1;
            this.mStart = i;
            this.cxT = i2;
            int i4 = i - i2;
            this.cxW = ke(i4);
            this.cxU = -i4;
            this.cya = Math.abs(i4);
            this.zC = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cxW));
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.cya = i5;
            this.cxZ = false;
            this.cxU = i2;
            this.cxV = i2;
            this.cxX = 0;
            this.zC = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cxS = i;
            if (i > i4 || i < i3) {
                k(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kh = kh(i2);
                this.cxX = kh;
                this.zC = kh;
                d = kg(i2);
            }
            this.cxY = (int) (d * Math.signum(i2));
            this.cxT = this.cxY + i;
            if (this.cxT < i3) {
                w(this.mStart, this.cxT, i3);
                this.cxT = i3;
            }
            if (this.cxT > i4) {
                w(this.mStart, this.cxT, i4);
                this.cxT = i4;
            }
        }

        private double kf(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cyb * this.cyc));
        }

        private double kg(int i) {
            return Math.exp(kf(i) * (cyd / (cyd - 1.0d))) * this.cyb * this.cyc;
        }

        private int kh(int i) {
            return (int) (Math.exp(kf(i) / (cyd - 1.0d)) * 1000.0d);
        }

        private void A(int i, int i2, int i3) {
            float f = (-i3) / this.cxW;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cxW)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cxW));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cxU = (int) ((-this.cxW) * sqrt);
        }

        private void B(int i, int i2, int i3) {
            this.cxW = ke(i3 == 0 ? i - i2 : i3);
            A(i, i2, i3);
            aiK();
        }

        private void k(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cxZ = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                B(i, i5, i4);
            } else if (kg(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.cya);
            } else {
                z(i, i5, i4);
            }
        }

        void C(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cya = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.cxV);
            }
        }

        private void aiK() {
            float abs = (this.cxU * this.cxU) / (Math.abs(this.cxW) * 2.0f);
            float signum = Math.signum(this.cxU);
            if (abs > this.cya) {
                this.cxW = (((-signum) * this.cxU) * this.cxU) / (this.cya * 2.0f);
                abs = this.cya;
            }
            this.cya = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cxU <= 0) {
                abs = -abs;
            }
            this.cxT = ((int) abs) + i;
            this.zC = -((int) ((1000.0f * this.cxU) / this.cxW));
        }

        boolean aiL() {
            switch (this.mState) {
                case 0:
                    if (this.zC < this.cxX) {
                        this.mStart = this.cxT;
                        this.cxU = (int) this.cxV;
                        this.cxW = ke(this.cxU);
                        this.mStartTime += this.zC;
                        aiK();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.zC;
                    z(this.cxT, this.mStart, 0);
                    break;
            }
            aiM();
            return true;
        }

        boolean aiM() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.zC) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cxX;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cye[i];
                        f3 = (cye[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cxV = ((f3 * this.cxY) / this.cxX) * 1000.0f;
                    d = f2 * this.cxY;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.zC;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cxU);
                    d = this.cya * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cxV = ((-f6) + f7) * signum * this.cya * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cxV = this.cxU + (this.cxW * f8);
                    d = ((f8 * (this.cxW * f8)) / 2.0f) + (this.cxU * f8);
                    break;
            }
            this.cxS = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
