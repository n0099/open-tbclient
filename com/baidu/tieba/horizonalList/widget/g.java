package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float cWX = 8.0f;
    private static float cWY;
    private final a cWU;
    private final a cWV;
    private final boolean cWW;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cWY = 1.0f;
        cWY = 1.0f / Z(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float Z(float f) {
        float exp;
        float f2 = cWX * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cWY;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cWW = z;
        this.cWU = new a(context);
        this.cWV = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cWU.setFriction(f);
        this.cWV.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cWU.cXg && this.cWV.cXg;
    }

    public final int getCurrX() {
        return this.cWU.cWZ;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cWU.cXc * this.cWU.cXc) + (this.cWV.cXc * this.cWV.cXc));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cWU.mStartTime;
                int i = this.cWU.Ii;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = Z(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cWU.aa(interpolation);
                    this.cWV.aa(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cWU.cXg && !this.cWU.apo() && !this.cWU.apn()) {
                    this.cWU.finish();
                }
                if (!this.cWV.cXg && !this.cWV.apo() && !this.cWV.apn()) {
                    this.cWV.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cWU.B(i, i3, i5);
        this.cWV.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cWU.C(i, i3, i4) || this.cWV.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cWW && !isFinished()) {
            float f = this.cWU.cXc;
            float f2 = this.cWV.cXc;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cWU.f(i, i11, i5, i6, i9);
                this.cWV.f(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cWU.f(i, i11, i5, i6, i9);
        this.cWV.f(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cWU.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cWU.finish();
        this.cWV.finish();
    }

    public boolean k(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cWU.cXa - this.cWU.mStart)) && Math.signum(f2) == Math.signum((float) (this.cWV.cXa - this.cWV.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cXk = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cXl = new float[101];
        private static final float[] cXm = new float[101];
        private int Ii;
        private int cWZ;
        private int cXa;
        private int cXb;
        private float cXc;
        private float cXd;
        private int cXe;
        private int cXf;
        private int cXh;
        private float cXj;
        private int mStart;
        private long mStartTime;
        private float cXi = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cXg = true;

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
                cXl[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cXm[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cXl;
            cXm[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cXi = f;
        }

        a(Context context) {
            this.cXj = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aa(float f) {
            this.cWZ = this.mStart + Math.round((this.cXa - this.mStart) * f);
        }

        private static float lj(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cXm[i4];
                this.Ii = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cXm[i4 + 1] - f2)) + f2) * this.Ii);
            }
        }

        void B(int i, int i2, int i3) {
            this.cXg = false;
            this.mStart = i;
            this.cXa = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ii = i3;
            this.cXd = 0.0f;
            this.cXb = 0;
        }

        void finish() {
            this.cWZ = this.cXa;
            this.cXg = true;
        }

        boolean C(int i, int i2, int i3) {
            this.cXg = true;
            this.cXa = i;
            this.mStart = i;
            this.cXb = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ii = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.cXg;
        }

        private void D(int i, int i2, int i3) {
            this.cXg = false;
            this.mState = 1;
            this.mStart = i;
            this.cXa = i2;
            int i4 = i - i2;
            this.cXd = lj(i4);
            this.cXb = -i4;
            this.cXh = Math.abs(i4);
            this.Ii = (int) (Math.sqrt((i4 * (-2.0d)) / this.cXd) * 1000.0d);
        }

        void f(int i, int i2, int i3, int i4, int i5) {
            this.cXh = i5;
            this.cXg = false;
            this.cXb = i2;
            this.cXc = i2;
            this.cXe = 0;
            this.Ii = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cWZ = i;
            if (i > i4 || i < i3) {
                o(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lm = lm(i2);
                this.cXe = lm;
                this.Ii = lm;
                d = ll(i2);
            }
            this.cXf = (int) (d * Math.signum(i2));
            this.cXa = this.cXf + i;
            if (this.cXa < i3) {
                A(this.mStart, this.cXa, i3);
                this.cXa = i3;
            }
            if (this.cXa > i4) {
                A(this.mStart, this.cXa, i4);
                this.cXa = i4;
            }
        }

        private double lk(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cXi * this.cXj));
        }

        private double ll(int i) {
            return Math.exp(lk(i) * (cXk / (cXk - 1.0d))) * this.cXi * this.cXj;
        }

        private int lm(int i) {
            return (int) (Math.exp(lk(i) / (cXk - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cXd;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cXd)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cXd));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cXb = (int) ((-this.cXd) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cXd = lj(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            apm();
        }

        private void o(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cXg = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (ll(i4) > Math.abs(i6)) {
                f(i, i4, z ? i2 : i, z ? i : i3, this.cXh);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cXh = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                o(i, i2, i2, (int) this.cXc);
            }
        }

        private void apm() {
            float abs = (this.cXb * this.cXb) / (Math.abs(this.cXd) * 2.0f);
            float signum = Math.signum(this.cXb);
            if (abs > this.cXh) {
                this.cXd = (((-signum) * this.cXb) * this.cXb) / (this.cXh * 2.0f);
                abs = this.cXh;
            }
            this.cXh = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cXb <= 0) {
                abs = -abs;
            }
            this.cXa = ((int) abs) + i;
            this.Ii = -((int) ((1000.0f * this.cXb) / this.cXd));
        }

        boolean apn() {
            switch (this.mState) {
                case 0:
                    if (this.Ii < this.cXe) {
                        this.mStart = this.cXa;
                        this.cXb = (int) this.cXc;
                        this.cXd = lj(this.cXb);
                        this.mStartTime += this.Ii;
                        apm();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Ii;
                    D(this.cXa, this.mStart, 0);
                    break;
            }
            apo();
            return true;
        }

        boolean apo() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Ii) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cXe;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cXl[i];
                        f3 = (cXl[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cXc = ((f3 * this.cXf) / this.cXe) * 1000.0f;
                    d = f2 * this.cXf;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Ii;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cXb);
                    d = this.cXh * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cXc = ((-f6) + f7) * signum * this.cXh * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cXc = this.cXb + (this.cXd * f8);
                    d = ((f8 * (this.cXd * f8)) / 2.0f) + (this.cXb * f8);
                    break;
            }
            this.cWZ = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
