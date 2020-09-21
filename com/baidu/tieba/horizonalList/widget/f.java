package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float bpO = 8.0f;
    private static float bpP;
    private final boolean bpN;
    private final a jfH;
    private final a jfI;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bpP = 1.0f;
        bpP = 1.0f / s(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float s(float f) {
        float exp;
        float f2 = bpO * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bpP;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bpN = z;
        this.jfH = new a(context);
        this.jfI = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.jfH.setFriction(f);
        this.jfI.setFriction(f);
    }

    public final boolean isFinished() {
        return this.jfH.mFinished && this.jfI.mFinished;
    }

    public final int getCurrX() {
        return this.jfH.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.jfH.bpS * this.jfH.bpS) + (this.jfI.bpS * this.jfI.bpS));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.jfH.mStartTime;
                int i = this.jfH.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = s(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.jfH.t(interpolation);
                    this.jfI.t(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.jfH.mFinished && !this.jfH.update() && !this.jfH.OG()) {
                    this.jfH.finish();
                }
                if (!this.jfI.mFinished && !this.jfI.update() && !this.jfI.OG()) {
                    this.jfI.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.jfH.o(i, i3, i5);
        this.jfI.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.jfH.p(i, i3, i4) || this.jfI.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bpN && !isFinished()) {
            float f = this.jfH.bpS;
            float f2 = this.jfI.bpS;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.jfH.b(i, i11, i5, i6, i9);
                this.jfI.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.jfH.b(i, i11, i5, i6, i9);
        this.jfI.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.jfH.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.jfH.finish();
        this.jfI.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.jfH.bpQ - this.jfH.mStart)) && Math.signum(f2) == Math.signum((float) (this.jfI.bpQ - this.jfI.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bpZ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bqa = new float[101];
        private static final float[] bqb = new float[101];
        private int bpQ;
        private int bpR;
        private float bpS;
        private float bpT;
        private int bpU;
        private int bpV;
        private int bpW;
        private float bpY;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bpX = ViewConfiguration.getScrollFriction();
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
                bqa[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bqb[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bqa;
            bqb[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bpX = f;
        }

        a(Context context) {
            this.bpY = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void t(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bpQ - this.mStart) * f);
        }

        private static float fr(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bqb[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bqb[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bpQ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bpT = 0.0f;
            this.bpR = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bpQ;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.bpQ = i;
            this.mStart = i;
            this.bpR = 0;
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
            this.bpQ = i2;
            int i4 = i - i2;
            this.bpT = fr(i4);
            this.bpR = -i4;
            this.bpW = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bpT) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bpW = i5;
            this.mFinished = false;
            this.bpR = i2;
            this.bpS = i2;
            this.bpU = 0;
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
                int fu = fu(i2);
                this.bpU = fu;
                this.mDuration = fu;
                d = ft(i2);
            }
            this.bpV = (int) (d * Math.signum(i2));
            this.bpQ = this.bpV + i;
            if (this.bpQ < i3) {
                n(this.mStart, this.bpQ, i3);
                this.bpQ = i3;
            }
            if (this.bpQ > i4) {
                n(this.mStart, this.bpQ, i4);
                this.bpQ = i4;
            }
        }

        private double fs(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bpX * this.bpY));
        }

        private double ft(int i) {
            return Math.exp(fs(i) * (bpZ / (bpZ - 1.0d))) * this.bpX * this.bpY;
        }

        private int fu(int i) {
            return (int) (Math.exp(fs(i) / (bpZ - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.bpT;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bpT)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bpT));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bpR = (int) ((-this.bpT) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.bpT = fr(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            OF();
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
            } else if (ft(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bpW);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bpW = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.bpS);
            }
        }

        private void OF() {
            float abs = (this.bpR * this.bpR) / (Math.abs(this.bpT) * 2.0f);
            float signum = Math.signum(this.bpR);
            if (abs > this.bpW) {
                this.bpT = (((-signum) * this.bpR) * this.bpR) / (this.bpW * 2.0f);
                abs = this.bpW;
            }
            this.bpW = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bpR <= 0) {
                abs = -abs;
            }
            this.bpQ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bpR) / this.bpT));
        }

        boolean OG() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bpU) {
                        this.mStart = this.bpQ;
                        this.bpR = (int) this.bpS;
                        this.bpT = fr(this.bpR);
                        this.mStartTime += this.mDuration;
                        OF();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.bpQ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bpU;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bqa[i];
                        f3 = (bqa[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bpS = ((f3 * this.bpV) / this.bpU) * 1000.0f;
                    d = f2 * this.bpV;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bpR);
                    d = this.bpW * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bpS = ((-f6) + f7) * signum * this.bpW * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bpS = this.bpR + (this.bpT * f8);
                    d = ((f8 * (this.bpT * f8)) / 2.0f) + (this.bpR * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
