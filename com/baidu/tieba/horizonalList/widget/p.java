package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class p {
    private static float bIS = 8.0f;
    private static float bIT;
    private final a bIP;
    private final a bIQ;
    private final boolean bIR;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bIT = 1.0f;
        bIT = 1.0f / D(1.0f);
    }

    public p(Context context) {
        this(context, null);
    }

    public static float D(float f) {
        float exp;
        float f2 = bIS * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bIT;
    }

    public p(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public p(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bIR = z;
        this.bIP = new a(context);
        this.bIQ = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bIP.setFriction(f);
        this.bIQ.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bIP.bJb && this.bIQ.bJb;
    }

    public final int getCurrX() {
        return this.bIP.bIU;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.bIP.bIX * this.bIP.bIX) + (this.bIQ.bIX * this.bIQ.bIX));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bIP.mStartTime;
                int i = this.bIP.Jh;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = D(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bIP.E(interpolation);
                    this.bIQ.E(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bIP.bJb && !this.bIP.Xq() && !this.bIP.Xp()) {
                    this.bIP.finish();
                }
                if (!this.bIQ.bJb && !this.bIQ.Xq() && !this.bIQ.Xp()) {
                    this.bIQ.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bIP.w(i, i3, i5);
        this.bIQ.w(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bIP.x(i, i3, i4) || this.bIQ.x(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bIR && !isFinished()) {
            float f = this.bIP.bIX;
            float f2 = this.bIQ.bIX;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bIP.c(i, i11, i5, i6, i9);
                this.bIQ.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bIP.c(i, i11, i5, i6, i9);
        this.bIQ.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bIP.B(i, i2, i3);
    }

    public void abortAnimation() {
        this.bIP.finish();
        this.bIQ.finish();
    }

    public boolean f(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bIP.bIV - this.bIP.mStart)) && Math.signum(f2) == Math.signum((float) (this.bIQ.bIV - this.bIQ.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bJf = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bJg = new float[101];
        private static final float[] bJh = new float[101];
        private int Jh;
        private int bIU;
        private int bIV;
        private int bIW;
        private float bIX;
        private float bIY;
        private int bIZ;
        private int bJa;
        private int bJc;
        private float bJe;
        private int mStart;
        private long mStartTime;
        private float bJd = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean bJb = true;

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
                bJg[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bJh[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bJg;
            bJh[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bJd = f;
        }

        a(Context context) {
            this.bJe = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void E(float f) {
            this.bIU = this.mStart + Math.round((this.bIV - this.mStart) * f);
        }

        private static float iv(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void v(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bJh[i4];
                this.Jh = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bJh[i4 + 1] - f2)) + f2) * this.Jh);
            }
        }

        void w(int i, int i2, int i3) {
            this.bJb = false;
            this.mStart = i;
            this.bIV = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Jh = i3;
            this.bIY = 0.0f;
            this.bIW = 0;
        }

        void finish() {
            this.bIU = this.bIV;
            this.bJb = true;
        }

        boolean x(int i, int i2, int i3) {
            this.bJb = true;
            this.bIV = i;
            this.mStart = i;
            this.bIW = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Jh = 0;
            if (i < i2) {
                y(i, i2, 0);
            } else if (i > i3) {
                y(i, i3, 0);
            }
            return !this.bJb;
        }

        private void y(int i, int i2, int i3) {
            this.bJb = false;
            this.mState = 1;
            this.mStart = i;
            this.bIV = i2;
            int i4 = i - i2;
            this.bIY = iv(i4);
            this.bIW = -i4;
            this.bJc = Math.abs(i4);
            this.Jh = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.bIY));
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.bJc = i5;
            this.bJb = false;
            this.bIW = i2;
            this.bIX = i2;
            this.bIZ = 0;
            this.Jh = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.bIU = i;
            if (i > i4 || i < i3) {
                k(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int iy = iy(i2);
                this.bIZ = iy;
                this.Jh = iy;
                d = ix(i2);
            }
            this.bJa = (int) (d * Math.signum(i2));
            this.bIV = this.bJa + i;
            if (this.bIV < i3) {
                v(this.mStart, this.bIV, i3);
                this.bIV = i3;
            }
            if (this.bIV > i4) {
                v(this.mStart, this.bIV, i4);
                this.bIV = i4;
            }
        }

        private double iw(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bJd * this.bJe));
        }

        private double ix(int i) {
            return Math.exp(iw(i) * (bJf / (bJf - 1.0d))) * this.bJd * this.bJe;
        }

        private int iy(int i) {
            return (int) (Math.exp(iw(i) / (bJf - 1.0d)) * 1000.0d);
        }

        private void z(int i, int i2, int i3) {
            float f = (-i3) / this.bIY;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bIY)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bIY));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bIW = (int) ((-this.bIY) * sqrt);
        }

        private void A(int i, int i2, int i3) {
            this.bIY = iv(i3 == 0 ? i - i2 : i3);
            z(i, i2, i3);
            Xo();
        }

        private void k(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.bJb = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                A(i, i5, i4);
            } else if (ix(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.bJc);
            } else {
                y(i, i5, i4);
            }
        }

        void B(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bJc = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.bIX);
            }
        }

        private void Xo() {
            float abs = (this.bIW * this.bIW) / (Math.abs(this.bIY) * 2.0f);
            float signum = Math.signum(this.bIW);
            if (abs > this.bJc) {
                this.bIY = (((-signum) * this.bIW) * this.bIW) / (this.bJc * 2.0f);
                abs = this.bJc;
            }
            this.bJc = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bIW <= 0) {
                abs = -abs;
            }
            this.bIV = ((int) abs) + i;
            this.Jh = -((int) ((1000.0f * this.bIW) / this.bIY));
        }

        boolean Xp() {
            switch (this.mState) {
                case 0:
                    if (this.Jh < this.bIZ) {
                        this.mStart = this.bIV;
                        this.bIW = (int) this.bIX;
                        this.bIY = iv(this.bIW);
                        this.mStartTime += this.Jh;
                        Xo();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Jh;
                    y(this.bIV, this.mStart, 0);
                    break;
            }
            Xq();
            return true;
        }

        boolean Xq() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Jh) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.bIZ;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bJg[i];
                        f3 = (bJg[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bIX = ((f3 * this.bJa) / this.bIZ) * 1000.0f;
                    d = f2 * this.bJa;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Jh;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bIW);
                    d = this.bJc * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bIX = ((-f6) + f7) * signum * this.bJc * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bIX = this.bIW + (this.bIY * f8);
                    d = ((f8 * (this.bIY * f8)) / 2.0f) + (this.bIW * f8);
                    break;
            }
            this.bIU = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
