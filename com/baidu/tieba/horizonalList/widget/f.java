package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float avp = 8.0f;
    private static float avq;
    private final boolean avo;
    private final a hek;
    private final a hel;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        avq = 1.0f;
        avq = 1.0f / J(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float J(float f) {
        float exp;
        float f2 = avp * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * avq;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.avo = z;
        this.hek = new a(context);
        this.hel = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.hek.setFriction(f);
        this.hel.setFriction(f);
    }

    public final boolean isFinished() {
        return this.hek.mFinished && this.hel.mFinished;
    }

    public final int getCurrX() {
        return this.hek.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.hek.avt * this.hek.avt) + (this.hel.avt * this.hel.avt));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.hek.mStartTime;
                int i = this.hek.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = J(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.hek.K(interpolation);
                    this.hel.K(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.hek.mFinished && !this.hek.update() && !this.hek.xn()) {
                    this.hek.finish();
                }
                if (!this.hel.mFinished && !this.hel.update() && !this.hel.xn()) {
                    this.hel.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.hek.l(i, i3, i5);
        this.hel.l(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.hek.m(i, i3, i4) || this.hel.m(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.avo && !isFinished()) {
            float f = this.hek.avt;
            float f2 = this.hel.avt;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.hek.b(i, i11, i5, i6, i9);
                this.hel.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.hek.b(i, i11, i5, i6, i9);
        this.hel.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.hek.q(i, i2, i3);
    }

    public void abortAnimation() {
        this.hek.finish();
        this.hel.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.hek.avr - this.hek.mStart)) && Math.signum(f2) == Math.signum((float) (this.hel.avr - this.hel.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float avA = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] avB = new float[101];
        private static final float[] avC = new float[101];
        private int avr;
        private int avs;
        private float avt;
        private float avu;
        private int avv;
        private int avw;
        private int avx;
        private float avz;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float avy = ViewConfiguration.getScrollFriction();
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
                avB[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                avC[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = avB;
            avC[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.avy = f;
        }

        a(Context context) {
            this.avz = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void K(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.avr - this.mStart) * f);
        }

        private static float co(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void k(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = avC[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (avC[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void l(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.avr = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.avu = 0.0f;
            this.avs = 0;
        }

        void finish() {
            this.mCurrentPosition = this.avr;
            this.mFinished = true;
        }

        boolean m(int i, int i2, int i3) {
            this.mFinished = true;
            this.avr = i;
            this.mStart = i;
            this.avs = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                n(i, i2, 0);
            } else if (i > i3) {
                n(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void n(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.avr = i2;
            int i4 = i - i2;
            this.avu = co(i4);
            this.avs = -i4;
            this.avx = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.avu) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.avx = i5;
            this.mFinished = false;
            this.avs = i2;
            this.avt = i2;
            this.avv = 0;
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
                int cr = cr(i2);
                this.avv = cr;
                this.mDuration = cr;
                d = cq(i2);
            }
            this.avw = (int) (d * Math.signum(i2));
            this.avr = this.avw + i;
            if (this.avr < i3) {
                k(this.mStart, this.avr, i3);
                this.avr = i3;
            }
            if (this.avr > i4) {
                k(this.mStart, this.avr, i4);
                this.avr = i4;
            }
        }

        private double cp(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.avy * this.avz));
        }

        private double cq(int i) {
            return Math.exp(cp(i) * (avA / (avA - 1.0d))) * this.avy * this.avz;
        }

        private int cr(int i) {
            return (int) (Math.exp(cp(i) / (avA - 1.0d)) * 1000.0d);
        }

        private void o(int i, int i2, int i3) {
            float f = (-i3) / this.avu;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.avu)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.avu));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.avs = (int) ((-this.avu) * sqrt);
        }

        private void p(int i, int i2, int i3) {
            this.avu = co(i3 == 0 ? i - i2 : i3);
            o(i, i2, i3);
            xm();
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
                p(i, i5, i4);
            } else if (cq(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.avx);
            } else {
                n(i, i5, i4);
            }
        }

        void q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.avx = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.avt);
            }
        }

        private void xm() {
            float abs = (this.avs * this.avs) / (Math.abs(this.avu) * 2.0f);
            float signum = Math.signum(this.avs);
            if (abs > this.avx) {
                this.avu = (((-signum) * this.avs) * this.avs) / (this.avx * 2.0f);
                abs = this.avx;
            }
            this.avx = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.avs <= 0) {
                abs = -abs;
            }
            this.avr = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.avs) / this.avu));
        }

        boolean xn() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.avv) {
                        this.mStart = this.avr;
                        this.avs = (int) this.avt;
                        this.avu = co(this.avs);
                        this.mStartTime += this.mDuration;
                        xm();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    n(this.avr, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.avv;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = avB[i];
                        f3 = (avB[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.avt = ((f3 * this.avw) / this.avv) * 1000.0f;
                    d = f2 * this.avw;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.avs);
                    d = this.avx * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.avt = ((-f6) + f7) * signum * this.avx * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.avt = this.avs + (this.avu * f8);
                    d = ((f8 * (this.avu * f8)) / 2.0f) + (this.avs * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
