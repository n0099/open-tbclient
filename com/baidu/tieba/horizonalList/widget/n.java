package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class n {
    private static float cAY = 8.0f;
    private static float cAZ;
    private final a cAV;
    private final a cAW;
    private final boolean cAX;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cAZ = 1.0f;
        cAZ = 1.0f / U(1.0f);
    }

    public n(Context context) {
        this(context, null);
    }

    public static float U(float f) {
        float exp;
        float f2 = cAY * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cAZ;
    }

    public n(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public n(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cAX = z;
        this.cAV = new a(context);
        this.cAW = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cAV.setFriction(f);
        this.cAW.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cAV.cBh && this.cAW.cBh;
    }

    public final int getCurrX() {
        return this.cAV.cBa;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cAV.cBd * this.cAV.cBd) + (this.cAW.cBd * this.cAW.cBd));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cAV.mStartTime;
                int i = this.cAV.Iv;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = U(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cAV.V(interpolation);
                    this.cAW.V(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cAV.cBh && !this.cAV.aiY() && !this.cAV.aiX()) {
                    this.cAV.finish();
                }
                if (!this.cAW.cBh && !this.cAW.aiY() && !this.cAW.aiX()) {
                    this.cAW.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cAV.B(i, i3, i5);
        this.cAW.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cAV.C(i, i3, i4) || this.cAW.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cAX && !isFinished()) {
            float f = this.cAV.cBd;
            float f2 = this.cAW.cBd;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cAV.f(i, i11, i5, i6, i9);
                this.cAW.f(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cAV.f(i, i11, i5, i6, i9);
        this.cAW.f(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cAV.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cAV.finish();
        this.cAW.finish();
    }

    public boolean h(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cAV.cBb - this.cAV.mStart)) && Math.signum(f2) == Math.signum((float) (this.cAW.cBb - this.cAW.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cBl = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cBm = new float[101];
        private static final float[] cBn = new float[101];
        private int Iv;
        private int cBa;
        private int cBb;
        private int cBc;
        private float cBd;
        private float cBe;
        private int cBf;
        private int cBg;
        private int cBi;
        private float cBk;
        private int mStart;
        private long mStartTime;
        private float cBj = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cBh = true;

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
                cBm[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cBn[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cBm;
            cBn[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cBj = f;
        }

        a(Context context) {
            this.cBk = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void V(float f) {
            this.cBa = this.mStart + Math.round((this.cBb - this.mStart) * f);
        }

        private static float kv(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cBn[i4];
                this.Iv = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cBn[i4 + 1] - f2)) + f2) * this.Iv);
            }
        }

        void B(int i, int i2, int i3) {
            this.cBh = false;
            this.mStart = i;
            this.cBb = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Iv = i3;
            this.cBe = 0.0f;
            this.cBc = 0;
        }

        void finish() {
            this.cBa = this.cBb;
            this.cBh = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cBh = true;
            this.cBb = i;
            this.mStart = i;
            this.cBc = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Iv = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cBh;
        }

        private void D(int i, int i2, int i3) {
            this.cBh = false;
            this.mState = 1;
            this.mStart = i;
            this.cBb = i2;
            int i4 = i - i2;
            this.cBe = kv(i4);
            this.cBc = -i4;
            this.cBi = Math.abs(i4);
            this.Iv = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cBe));
        }

        void f(int i, int i2, int i3, int i4, int i5) {
            this.cBi = i5;
            this.cBh = false;
            this.cBc = i2;
            this.cBd = i2;
            this.cBf = 0;
            this.Iv = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cBa = i;
            if (i > i4 || i < i3) {
                k(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int ky = ky(i2);
                this.cBf = ky;
                this.Iv = ky;
                d = kx(i2);
            }
            this.cBg = (int) (d * Math.signum(i2));
            this.cBb = this.cBg + i;
            if (this.cBb < i3) {
                A(this.mStart, this.cBb, i3);
                this.cBb = i3;
            }
            if (this.cBb > i4) {
                A(this.mStart, this.cBb, i4);
                this.cBb = i4;
            }
        }

        private double kw(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cBj * this.cBk));
        }

        private double kx(int i) {
            return Math.exp(kw(i) * (cBl / (cBl - 1.0d))) * this.cBj * this.cBk;
        }

        private int ky(int i) {
            return (int) (Math.exp(kw(i) / (cBl - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cBe;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cBe)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cBe));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cBc = (int) ((-this.cBe) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cBe = kv(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            aiW();
        }

        private void k(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cBh = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kx(i4) > Math.abs(i6)) {
                f(i, i4, z ? i2 : i, z ? i : i3, this.cBi);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cBi = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.cBd);
            }
        }

        private void aiW() {
            float abs = (this.cBc * this.cBc) / (Math.abs(this.cBe) * 2.0f);
            float signum = Math.signum(this.cBc);
            if (abs > this.cBi) {
                this.cBe = (((-signum) * this.cBc) * this.cBc) / (this.cBi * 2.0f);
                abs = this.cBi;
            }
            this.cBi = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cBc <= 0) {
                abs = -abs;
            }
            this.cBb = ((int) abs) + i;
            this.Iv = -((int) ((1000.0f * this.cBc) / this.cBe));
        }

        boolean aiX() {
            switch (this.mState) {
                case 0:
                    if (this.Iv < this.cBf) {
                        this.mStart = this.cBb;
                        this.cBc = (int) this.cBd;
                        this.cBe = kv(this.cBc);
                        this.mStartTime += this.Iv;
                        aiW();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Iv;
                    D(this.cBb, this.mStart, 0);
                    break;
            }
            aiY();
            return true;
        }

        boolean aiY() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Iv) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cBf;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cBm[i];
                        f3 = (cBm[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cBd = ((f3 * this.cBg) / this.cBf) * 1000.0f;
                    d = f2 * this.cBg;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Iv;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cBc);
                    d = this.cBi * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cBd = ((-f6) + f7) * signum * this.cBi * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cBd = this.cBc + (this.cBe * f8);
                    d = ((f8 * (this.cBe * f8)) / 2.0f) + (this.cBc * f8);
                    break;
            }
            this.cBa = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
