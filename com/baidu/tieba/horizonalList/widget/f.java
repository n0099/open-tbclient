package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float awb = 8.0f;
    private static float awc;
    private final boolean awa;
    private final a hhN;
    private final a hhO;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        awc = 1.0f;
        awc = 1.0f / J(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float J(float f) {
        float exp;
        float f2 = awb * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * awc;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.awa = z;
        this.hhN = new a(context);
        this.hhO = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.hhN.setFriction(f);
        this.hhO.setFriction(f);
    }

    public final boolean isFinished() {
        return this.hhN.mFinished && this.hhO.mFinished;
    }

    public final int getCurrX() {
        return this.hhN.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.hhN.awf * this.hhN.awf) + (this.hhO.awf * this.hhO.awf));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.hhN.mStartTime;
                int i = this.hhN.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = J(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.hhN.K(interpolation);
                    this.hhO.K(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.hhN.mFinished && !this.hhN.update() && !this.hhN.xD()) {
                    this.hhN.finish();
                }
                if (!this.hhO.mFinished && !this.hhO.update() && !this.hhO.xD()) {
                    this.hhO.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.hhN.l(i, i3, i5);
        this.hhO.l(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.hhN.m(i, i3, i4) || this.hhO.m(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.awa && !isFinished()) {
            float f = this.hhN.awf;
            float f2 = this.hhO.awf;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.hhN.b(i, i11, i5, i6, i9);
                this.hhO.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.hhN.b(i, i11, i5, i6, i9);
        this.hhO.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.hhN.q(i, i2, i3);
    }

    public void abortAnimation() {
        this.hhN.finish();
        this.hhO.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.hhN.awd - this.hhN.mStart)) && Math.signum(f2) == Math.signum((float) (this.hhO.awd - this.hhO.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float awm = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] awn = new float[101];
        private static final float[] awo = new float[101];
        private int awd;
        private int awe;
        private float awf;
        private float awg;
        private int awh;
        private int awi;
        private int awj;
        private float awl;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float awk = ViewConfiguration.getScrollFriction();
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
                awn[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                awo[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = awn;
            awo[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.awk = f;
        }

        a(Context context) {
            this.awl = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void K(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.awd - this.mStart) * f);
        }

        private static float cp(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void k(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = awo[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (awo[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void l(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.awd = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.awg = 0.0f;
            this.awe = 0;
        }

        void finish() {
            this.mCurrentPosition = this.awd;
            this.mFinished = true;
        }

        boolean m(int i, int i2, int i3) {
            this.mFinished = true;
            this.awd = i;
            this.mStart = i;
            this.awe = 0;
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
            this.awd = i2;
            int i4 = i - i2;
            this.awg = cp(i4);
            this.awe = -i4;
            this.awj = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.awg) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.awj = i5;
            this.mFinished = false;
            this.awe = i2;
            this.awf = i2;
            this.awh = 0;
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
                int cs = cs(i2);
                this.awh = cs;
                this.mDuration = cs;
                d = cr(i2);
            }
            this.awi = (int) (d * Math.signum(i2));
            this.awd = this.awi + i;
            if (this.awd < i3) {
                k(this.mStart, this.awd, i3);
                this.awd = i3;
            }
            if (this.awd > i4) {
                k(this.mStart, this.awd, i4);
                this.awd = i4;
            }
        }

        private double cq(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.awk * this.awl));
        }

        private double cr(int i) {
            return Math.exp(cq(i) * (awm / (awm - 1.0d))) * this.awk * this.awl;
        }

        private int cs(int i) {
            return (int) (Math.exp(cq(i) / (awm - 1.0d)) * 1000.0d);
        }

        private void o(int i, int i2, int i3) {
            float f = (-i3) / this.awg;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.awg)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.awg));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.awe = (int) ((-this.awg) * sqrt);
        }

        private void p(int i, int i2, int i3) {
            this.awg = cp(i3 == 0 ? i - i2 : i3);
            o(i, i2, i3);
            xC();
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
            } else if (cr(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.awj);
            } else {
                n(i, i5, i4);
            }
        }

        void q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.awj = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.awf);
            }
        }

        private void xC() {
            float abs = (this.awe * this.awe) / (Math.abs(this.awg) * 2.0f);
            float signum = Math.signum(this.awe);
            if (abs > this.awj) {
                this.awg = (((-signum) * this.awe) * this.awe) / (this.awj * 2.0f);
                abs = this.awj;
            }
            this.awj = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.awe <= 0) {
                abs = -abs;
            }
            this.awd = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.awe) / this.awg));
        }

        boolean xD() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.awh) {
                        this.mStart = this.awd;
                        this.awe = (int) this.awf;
                        this.awg = cp(this.awe);
                        this.mStartTime += this.mDuration;
                        xC();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    n(this.awd, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.awh;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = awn[i];
                        f3 = (awn[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.awf = ((f3 * this.awi) / this.awh) * 1000.0f;
                    d = f2 * this.awi;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.awe);
                    d = this.awj * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.awf = ((-f6) + f7) * signum * this.awj * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.awf = this.awe + (this.awg * f8);
                    d = ((f8 * (this.awg * f8)) / 2.0f) + (this.awe * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
