package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float aUt = 8.0f;
    private static float aUu;
    private final boolean aUs;
    private final a hVr;
    private final a hVs;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        aUu = 1.0f;
        aUu = 1.0f / q(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float q(float f) {
        float exp;
        float f2 = aUt * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * aUu;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.aUs = z;
        this.hVr = new a(context);
        this.hVs = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.hVr.setFriction(f);
        this.hVs.setFriction(f);
    }

    public final boolean isFinished() {
        return this.hVr.mFinished && this.hVs.mFinished;
    }

    public final int getCurrX() {
        return this.hVr.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.hVr.aUx * this.hVr.aUx) + (this.hVs.aUx * this.hVs.aUx));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.hVr.mStartTime;
                int i = this.hVr.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = q(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.hVr.r(interpolation);
                    this.hVs.r(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.hVr.mFinished && !this.hVr.update() && !this.hVr.Fa()) {
                    this.hVr.finish();
                }
                if (!this.hVs.mFinished && !this.hVs.update() && !this.hVs.Fa()) {
                    this.hVs.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.hVr.o(i, i3, i5);
        this.hVs.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.hVr.p(i, i3, i4) || this.hVs.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.aUs && !isFinished()) {
            float f = this.hVr.aUx;
            float f2 = this.hVs.aUx;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.hVr.b(i, i11, i5, i6, i9);
                this.hVs.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.hVr.b(i, i11, i5, i6, i9);
        this.hVs.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.hVr.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.hVr.finish();
        this.hVs.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.hVr.aUv - this.hVr.mStart)) && Math.signum(f2) == Math.signum((float) (this.hVs.aUv - this.hVs.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float aUE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] aUF = new float[101];
        private static final float[] aUG = new float[101];
        private int aUA;
        private int aUB;
        private float aUD;
        private int aUv;
        private int aUw;
        private float aUx;
        private float aUy;
        private int aUz;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float aUC = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

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
                aUF[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                aUG[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = aUF;
            aUG[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.aUC = f;
        }

        a(Context context) {
            this.aUD = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void r(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.aUv - this.mStart) * f);
        }

        private static float cU(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = aUG[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (aUG[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.aUv = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.aUy = 0.0f;
            this.aUw = 0;
        }

        void finish() {
            this.mCurrentPosition = this.aUv;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.aUv = i;
            this.mStart = i;
            this.aUw = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                q(i, i2, 0);
            } else if (i > i3) {
                q(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void q(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.aUv = i2;
            int i4 = i - i2;
            this.aUy = cU(i4);
            this.aUw = -i4;
            this.aUB = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.aUy) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.aUB = i5;
            this.mFinished = false;
            this.aUw = i2;
            this.aUx = i2;
            this.aUz = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                h(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int cX = cX(i2);
                this.aUz = cX;
                this.mDuration = cX;
                d = cW(i2);
            }
            this.aUA = (int) (d * Math.signum(i2));
            this.aUv = this.aUA + i;
            if (this.aUv < i3) {
                n(this.mStart, this.aUv, i3);
                this.aUv = i3;
            }
            if (this.aUv > i4) {
                n(this.mStart, this.aUv, i4);
                this.aUv = i4;
            }
        }

        private double cV(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.aUC * this.aUD));
        }

        private double cW(int i) {
            return Math.exp(cV(i) * (aUE / (aUE - 1.0d))) * this.aUC * this.aUD;
        }

        private int cX(int i) {
            return (int) (Math.exp(cV(i) / (aUE - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.aUy;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.aUy)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.aUy));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.aUw = (int) ((-this.aUy) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.aUy = cU(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            EZ();
        }

        private void h(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                s(i, i5, i4);
            } else if (cW(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.aUB);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.aUB = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.aUx);
            }
        }

        private void EZ() {
            float abs = (this.aUw * this.aUw) / (Math.abs(this.aUy) * 2.0f);
            float signum = Math.signum(this.aUw);
            if (abs > this.aUB) {
                this.aUy = (((-signum) * this.aUw) * this.aUw) / (this.aUB * 2.0f);
                abs = this.aUB;
            }
            this.aUB = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.aUw <= 0) {
                abs = -abs;
            }
            this.aUv = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.aUw) / this.aUy));
        }

        boolean Fa() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.aUz) {
                        this.mStart = this.aUv;
                        this.aUw = (int) this.aUx;
                        this.aUy = cU(this.aUw);
                        this.mStartTime += this.mDuration;
                        EZ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.aUv, this.mStart, 0);
                    break;
            }
            update();
            return true;
        }

        boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.aUz;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = aUF[i];
                        f3 = (aUF[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.aUx = ((f3 * this.aUA) / this.aUz) * 1000.0f;
                    d = f2 * this.aUA;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.aUw);
                    d = this.aUB * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.aUx = ((-f6) + f7) * signum * this.aUB * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.aUx = this.aUw + (this.aUy * f8);
                    d = ((f8 * (this.aUy * f8)) / 2.0f) + (this.aUw * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
