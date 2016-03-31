package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float bTo = 8.0f;
    private static float bTp;
    private final a bTl;
    private final a bTm;
    private final boolean bTn;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bTp = 1.0f;
        bTp = 1.0f / E(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float E(float f) {
        float exp;
        float f2 = bTo * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bTp;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bTn = z;
        this.bTl = new a(context);
        this.bTm = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bTl.setFriction(f);
        this.bTm.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bTl.bTx && this.bTm.bTx;
    }

    public final int getCurrX() {
        return this.bTl.bTq;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.bTl.bTt * this.bTl.bTt) + (this.bTm.bTt * this.bTm.bTt));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bTl.mStartTime;
                int i = this.bTl.Jn;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = E(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bTl.F(interpolation);
                    this.bTm.F(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bTl.bTx && !this.bTl.aaQ() && !this.bTl.aaP()) {
                    this.bTl.finish();
                }
                if (!this.bTm.bTx && !this.bTm.aaQ() && !this.bTm.aaP()) {
                    this.bTm.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bTl.w(i, i3, i5);
        this.bTm.w(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bTl.x(i, i3, i4) || this.bTm.x(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bTn && !isFinished()) {
            float f = this.bTl.bTt;
            float f2 = this.bTm.bTt;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bTl.c(i, i11, i5, i6, i9);
                this.bTm.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bTl.c(i, i11, i5, i6, i9);
        this.bTm.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bTl.B(i, i2, i3);
    }

    public void abortAnimation() {
        this.bTl.finish();
        this.bTm.finish();
    }

    public boolean e(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bTl.bTr - this.bTl.mStart)) && Math.signum(f2) == Math.signum((float) (this.bTm.bTr - this.bTm.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bTB = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bTC = new float[101];
        private static final float[] bTD = new float[101];
        private int Jn;
        private float bTA;
        private int bTq;
        private int bTr;
        private int bTs;
        private float bTt;
        private float bTu;
        private int bTv;
        private int bTw;
        private int bTy;
        private int mStart;
        private long mStartTime;
        private float bTz = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean bTx = true;

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
                bTC[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bTD[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bTC;
            bTD[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bTz = f;
        }

        a(Context context) {
            this.bTA = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void F(float f) {
            this.bTq = this.mStart + Math.round((this.bTr - this.mStart) * f);
        }

        private static float jd(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void v(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bTD[i4];
                this.Jn = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bTD[i4 + 1] - f2)) + f2) * this.Jn);
            }
        }

        void w(int i, int i2, int i3) {
            this.bTx = false;
            this.mStart = i;
            this.bTr = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Jn = i3;
            this.bTu = 0.0f;
            this.bTs = 0;
        }

        void finish() {
            this.bTq = this.bTr;
            this.bTx = true;
        }

        boolean x(int i, int i2, int i3) {
            this.bTx = true;
            this.bTr = i;
            this.mStart = i;
            this.bTs = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Jn = 0;
            if (i < i2) {
                y(i, i2, 0);
            } else if (i > i3) {
                y(i, i3, 0);
            }
            return !this.bTx;
        }

        private void y(int i, int i2, int i3) {
            this.bTx = false;
            this.mState = 1;
            this.mStart = i;
            this.bTr = i2;
            int i4 = i - i2;
            this.bTu = jd(i4);
            this.bTs = -i4;
            this.bTy = Math.abs(i4);
            this.Jn = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.bTu));
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.bTy = i5;
            this.bTx = false;
            this.bTs = i2;
            this.bTt = i2;
            this.bTv = 0;
            this.Jn = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.bTq = i;
            if (i > i4 || i < i3) {
                i(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int jg = jg(i2);
                this.bTv = jg;
                this.Jn = jg;
                d = jf(i2);
            }
            this.bTw = (int) (d * Math.signum(i2));
            this.bTr = this.bTw + i;
            if (this.bTr < i3) {
                v(this.mStart, this.bTr, i3);
                this.bTr = i3;
            }
            if (this.bTr > i4) {
                v(this.mStart, this.bTr, i4);
                this.bTr = i4;
            }
        }

        private double je(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bTz * this.bTA));
        }

        private double jf(int i) {
            return Math.exp(je(i) * (bTB / (bTB - 1.0d))) * this.bTz * this.bTA;
        }

        private int jg(int i) {
            return (int) (Math.exp(je(i) / (bTB - 1.0d)) * 1000.0d);
        }

        private void z(int i, int i2, int i3) {
            float f = (-i3) / this.bTu;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bTu)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bTu));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bTs = (int) ((-this.bTu) * sqrt);
        }

        private void A(int i, int i2, int i3) {
            this.bTu = jd(i3 == 0 ? i - i2 : i3);
            z(i, i2, i3);
            aaO();
        }

        private void i(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.bTx = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                A(i, i5, i4);
            } else if (jf(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.bTy);
            } else {
                y(i, i5, i4);
            }
        }

        void B(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bTy = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                i(i, i2, i2, (int) this.bTt);
            }
        }

        private void aaO() {
            float abs = (this.bTs * this.bTs) / (Math.abs(this.bTu) * 2.0f);
            float signum = Math.signum(this.bTs);
            if (abs > this.bTy) {
                this.bTu = (((-signum) * this.bTs) * this.bTs) / (this.bTy * 2.0f);
                abs = this.bTy;
            }
            this.bTy = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bTs <= 0) {
                abs = -abs;
            }
            this.bTr = ((int) abs) + i;
            this.Jn = -((int) ((1000.0f * this.bTs) / this.bTu));
        }

        boolean aaP() {
            switch (this.mState) {
                case 0:
                    if (this.Jn < this.bTv) {
                        this.mStart = this.bTr;
                        this.bTs = (int) this.bTt;
                        this.bTu = jd(this.bTs);
                        this.mStartTime += this.Jn;
                        aaO();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Jn;
                    y(this.bTr, this.mStart, 0);
                    break;
            }
            aaQ();
            return true;
        }

        boolean aaQ() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Jn) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.bTv;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bTC[i];
                        f3 = (bTC[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bTt = ((f3 * this.bTw) / this.bTv) * 1000.0f;
                    d = f2 * this.bTw;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Jn;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bTs);
                    d = this.bTy * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bTt = ((-f6) + f7) * signum * this.bTy * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bTt = this.bTs + (this.bTu * f8);
                    d = ((f8 * (this.bTu * f8)) / 2.0f) + (this.bTs * f8);
                    break;
            }
            this.bTq = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
