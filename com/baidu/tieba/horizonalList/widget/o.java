package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class o {
    private static float cNb = 8.0f;
    private static float cNc;
    private final a cMY;
    private final a cMZ;
    private final boolean cNa;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cNc = 1.0f;
        cNc = 1.0f / ak(1.0f);
    }

    public o(Context context) {
        this(context, null);
    }

    public static float ak(float f) {
        float exp;
        float f2 = cNb * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cNc;
    }

    public o(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public o(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cNa = z;
        this.cMY = new a(context);
        this.cMZ = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cMY.setFriction(f);
        this.cMZ.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cMY.cNk && this.cMZ.cNk;
    }

    public final int getCurrX() {
        return this.cMY.cNd;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cMY.cNg * this.cMY.cNg) + (this.cMZ.cNg * this.cMZ.cNg));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cMY.mStartTime;
                int i = this.cMY.Cs;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ak(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cMY.al(interpolation);
                    this.cMZ.al(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cMY.cNk && !this.cMY.aoy() && !this.cMY.aox()) {
                    this.cMY.finish();
                }
                if (!this.cMZ.cNk && !this.cMZ.aoy() && !this.cMZ.aox()) {
                    this.cMZ.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cMY.B(i, i3, i5);
        this.cMZ.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cMY.C(i, i3, i4) || this.cMZ.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cNa && !isFinished()) {
            float f = this.cMY.cNg;
            float f2 = this.cMZ.cNg;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cMY.e(i, i11, i5, i6, i9);
                this.cMZ.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cMY.e(i, i11, i5, i6, i9);
        this.cMZ.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cMY.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cMY.finish();
        this.cMZ.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cMY.cNe - this.cMY.mStart)) && Math.signum(f2) == Math.signum((float) (this.cMZ.cNe - this.cMZ.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cNo = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cNp = new float[101];
        private static final float[] cNq = new float[101];
        private int Cs;
        private int cNd;
        private int cNe;
        private int cNf;
        private float cNg;
        private float cNh;
        private int cNi;
        private int cNj;
        private int cNl;
        private float cNn;
        private int mStart;
        private long mStartTime;
        private float cNm = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cNk = true;

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
                cNp[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cNq[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cNp;
            cNq[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cNm = f;
        }

        a(Context context) {
            this.cNn = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void al(float f) {
            this.cNd = this.mStart + Math.round((this.cNe - this.mStart) * f);
        }

        private static float kT(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cNq[i4];
                this.Cs = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cNq[i4 + 1] - f2)) + f2) * this.Cs);
            }
        }

        void B(int i, int i2, int i3) {
            this.cNk = false;
            this.mStart = i;
            this.cNe = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Cs = i3;
            this.cNh = 0.0f;
            this.cNf = 0;
        }

        void finish() {
            this.cNd = this.cNe;
            this.cNk = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cNk = true;
            this.cNe = i;
            this.mStart = i;
            this.cNf = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Cs = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cNk;
        }

        private void D(int i, int i2, int i3) {
            this.cNk = false;
            this.mState = 1;
            this.mStart = i;
            this.cNe = i2;
            int i4 = i - i2;
            this.cNh = kT(i4);
            this.cNf = -i4;
            this.cNl = Math.abs(i4);
            this.Cs = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cNh));
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.cNl = i5;
            this.cNk = false;
            this.cNf = i2;
            this.cNg = i2;
            this.cNi = 0;
            this.Cs = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cNd = i;
            if (i > i4 || i < i3) {
                n(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int kW = kW(i2);
                this.cNi = kW;
                this.Cs = kW;
                d = kV(i2);
            }
            this.cNj = (int) (d * Math.signum(i2));
            this.cNe = this.cNj + i;
            if (this.cNe < i3) {
                A(this.mStart, this.cNe, i3);
                this.cNe = i3;
            }
            if (this.cNe > i4) {
                A(this.mStart, this.cNe, i4);
                this.cNe = i4;
            }
        }

        private double kU(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cNm * this.cNn));
        }

        private double kV(int i) {
            return Math.exp(kU(i) * (cNo / (cNo - 1.0d))) * this.cNm * this.cNn;
        }

        private int kW(int i) {
            return (int) (Math.exp(kU(i) / (cNo - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cNh;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cNh)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cNh));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cNf = (int) ((-this.cNh) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cNh = kT(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            aow();
        }

        private void n(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cNk = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (kV(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.cNl);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cNl = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                n(i, i2, i2, (int) this.cNg);
            }
        }

        private void aow() {
            float abs = (this.cNf * this.cNf) / (Math.abs(this.cNh) * 2.0f);
            float signum = Math.signum(this.cNf);
            if (abs > this.cNl) {
                this.cNh = (((-signum) * this.cNf) * this.cNf) / (this.cNl * 2.0f);
                abs = this.cNl;
            }
            this.cNl = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cNf <= 0) {
                abs = -abs;
            }
            this.cNe = ((int) abs) + i;
            this.Cs = -((int) ((1000.0f * this.cNf) / this.cNh));
        }

        boolean aox() {
            switch (this.mState) {
                case 0:
                    if (this.Cs < this.cNi) {
                        this.mStart = this.cNe;
                        this.cNf = (int) this.cNg;
                        this.cNh = kT(this.cNf);
                        this.mStartTime += this.Cs;
                        aow();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Cs;
                    D(this.cNe, this.mStart, 0);
                    break;
            }
            aoy();
            return true;
        }

        boolean aoy() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Cs) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cNi;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cNp[i];
                        f3 = (cNp[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cNg = ((f3 * this.cNj) / this.cNi) * 1000.0f;
                    d = f2 * this.cNj;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Cs;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cNf);
                    d = this.cNl * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cNg = ((-f6) + f7) * signum * this.cNl * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cNg = this.cNf + (this.cNh * f8);
                    d = ((f8 * (this.cNh * f8)) / 2.0f) + (this.cNf * f8);
                    break;
            }
            this.cNd = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
