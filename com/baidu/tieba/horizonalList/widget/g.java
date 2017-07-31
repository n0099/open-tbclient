package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class g {
    private static float cYq = 8.0f;
    private static float cYr;
    private final a cYn;
    private final a cYo;
    private final boolean cYp;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cYr = 1.0f;
        cYr = 1.0f / Z(1.0f);
    }

    public g(Context context) {
        this(context, null);
    }

    public static float Z(float f) {
        float exp;
        float f2 = cYq * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cYr;
    }

    public g(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public g(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cYp = z;
        this.cYn = new a(context);
        this.cYo = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cYn.setFriction(f);
        this.cYo.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cYn.lh && this.cYo.lh;
    }

    public final int getCurrX() {
        return this.cYn.cYs;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cYn.cYv * this.cYn.cYv) + (this.cYo.cYv * this.cYo.cYv));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cYn.mStartTime;
                int i = this.cYn.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = Z(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cYn.aa(interpolation);
                    this.cYo.aa(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cYn.lh && !this.cYn.apA() && !this.cYn.apz()) {
                    this.cYn.finish();
                }
                if (!this.cYo.lh && !this.cYo.apA() && !this.cYo.apz()) {
                    this.cYo.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cYn.B(i, i3, i5);
        this.cYo.B(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cYn.C(i, i3, i4) || this.cYo.C(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cYp && !isFinished()) {
            float f = this.cYn.cYv;
            float f2 = this.cYo.cYv;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cYn.f(i, i11, i5, i6, i9);
                this.cYo.f(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cYn.f(i, i11, i5, i6, i9);
        this.cYo.f(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cYn.G(i, i2, i3);
    }

    public void abortAnimation() {
        this.cYn.finish();
        this.cYo.finish();
    }

    public boolean k(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cYn.cYt - this.cYn.mStart)) && Math.signum(f2) == Math.signum((float) (this.cYo.cYt - this.cYo.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cYC = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cYD = new float[101];
        private static final float[] cYE = new float[101];
        private float cYB;
        private int cYs;
        private int cYt;
        private int cYu;
        private float cYv;
        private float cYw;
        private int cYx;
        private int cYy;
        private int cYz;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float cYA = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean lh = true;

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
                cYD[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cYE[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cYD;
            cYE[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cYA = f;
        }

        a(Context context) {
            this.cYB = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aa(float f) {
            this.cYs = this.mStart + Math.round((this.cYt - this.mStart) * f);
        }

        private static float lj(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void A(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cYE[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cYE[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void B(int i, int i2, int i3) {
            this.lh = false;
            this.mStart = i;
            this.cYt = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.cYw = 0.0f;
            this.cYu = 0;
        }

        void finish() {
            this.cYs = this.cYt;
            this.lh = true;
        }

        boolean C(int i, int i2, int i3) {
            this.lh = true;
            this.cYt = i;
            this.mStart = i;
            this.cYu = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                D(i, i2, 0);
            } else if (i > i3) {
                D(i, i3, 0);
            }
            return !this.lh;
        }

        private void D(int i, int i2, int i3) {
            this.lh = false;
            this.mState = 1;
            this.mStart = i;
            this.cYt = i2;
            int i4 = i - i2;
            this.cYw = lj(i4);
            this.cYu = -i4;
            this.cYz = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.cYw) * 1000.0d);
        }

        void f(int i, int i2, int i3, int i4, int i5) {
            this.cYz = i5;
            this.lh = false;
            this.cYu = i2;
            this.cYv = i2;
            this.cYx = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cYs = i;
            if (i > i4 || i < i3) {
                o(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int lm = lm(i2);
                this.cYx = lm;
                this.mDuration = lm;
                d = ll(i2);
            }
            this.cYy = (int) (d * Math.signum(i2));
            this.cYt = this.cYy + i;
            if (this.cYt < i3) {
                A(this.mStart, this.cYt, i3);
                this.cYt = i3;
            }
            if (this.cYt > i4) {
                A(this.mStart, this.cYt, i4);
                this.cYt = i4;
            }
        }

        private double lk(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cYA * this.cYB));
        }

        private double ll(int i) {
            return Math.exp(lk(i) * (cYC / (cYC - 1.0d))) * this.cYA * this.cYB;
        }

        private int lm(int i) {
            return (int) (Math.exp(lk(i) / (cYC - 1.0d)) * 1000.0d);
        }

        private void E(int i, int i2, int i3) {
            float f = (-i3) / this.cYw;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cYw)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cYw));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cYu = (int) ((-this.cYw) * sqrt);
        }

        private void F(int i, int i2, int i3) {
            this.cYw = lj(i3 == 0 ? i - i2 : i3);
            E(i, i2, i3);
            apy();
        }

        private void o(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.lh = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                F(i, i5, i4);
            } else if (ll(i4) > Math.abs(i6)) {
                f(i, i4, z ? i2 : i, z ? i : i3, this.cYz);
            } else {
                D(i, i5, i4);
            }
        }

        void G(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cYz = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                o(i, i2, i2, (int) this.cYv);
            }
        }

        private void apy() {
            float abs = (this.cYu * this.cYu) / (Math.abs(this.cYw) * 2.0f);
            float signum = Math.signum(this.cYu);
            if (abs > this.cYz) {
                this.cYw = (((-signum) * this.cYu) * this.cYu) / (this.cYz * 2.0f);
                abs = this.cYz;
            }
            this.cYz = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cYu <= 0) {
                abs = -abs;
            }
            this.cYt = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.cYu) / this.cYw));
        }

        boolean apz() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.cYx) {
                        this.mStart = this.cYt;
                        this.cYu = (int) this.cYv;
                        this.cYw = lj(this.cYu);
                        this.mStartTime += this.mDuration;
                        apy();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    D(this.cYt, this.mStart, 0);
                    break;
            }
            apA();
            return true;
        }

        boolean apA() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cYx;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cYD[i];
                        f3 = (cYD[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cYv = ((f3 * this.cYy) / this.cYx) * 1000.0f;
                    d = f2 * this.cYy;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cYu);
                    d = this.cYz * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cYv = ((-f6) + f7) * signum * this.cYz * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cYv = this.cYu + (this.cYw * f8);
                    d = ((f8 * (this.cYw * f8)) / 2.0f) + (this.cYu * f8);
                    break;
            }
            this.cYs = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
