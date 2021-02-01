package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class e {
    private static float bJd = 8.0f;
    private static float bJe;
    private final boolean bJc;
    private final a ksg;
    private final a ksh;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bJe = 1.0f;
        bJe = 1.0f / t(1.0f);
    }

    public e(Context context) {
        this(context, null);
    }

    public static float t(float f) {
        float exp;
        float f2 = bJd * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bJe;
    }

    public e(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public e(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bJc = z;
        this.ksg = new a(context);
        this.ksh = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.ksg.setFriction(f);
        this.ksh.setFriction(f);
    }

    public final boolean isFinished() {
        return this.ksg.mFinished && this.ksh.mFinished;
    }

    public final int getCurrX() {
        return this.ksg.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.ksg.bJh * this.ksg.bJh) + (this.ksh.bJh * this.ksh.bJh));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.ksg.mStartTime;
                int i = this.ksg.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = t(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.ksg.u(interpolation);
                    this.ksh.u(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.ksg.mFinished && !this.ksg.update() && !this.ksg.TX()) {
                    this.ksg.finish();
                }
                if (!this.ksh.mFinished && !this.ksh.update() && !this.ksh.TX()) {
                    this.ksh.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.ksg.p(i, i3, i5);
        this.ksh.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.ksg.q(i, i3, i4) || this.ksh.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bJc && !isFinished()) {
            float f = this.ksg.bJh;
            float f2 = this.ksh.bJh;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.ksg.b(i, i11, i5, i6, i9);
                this.ksh.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.ksg.b(i, i11, i5, i6, i9);
        this.ksh.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.ksg.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.ksg.finish();
        this.ksh.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.ksg.bJf - this.ksg.mStart)) && Math.signum(f2) == Math.signum((float) (this.ksh.bJf - this.ksh.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bJo = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bJp = new float[101];
        private static final float[] bJq = new float[101];
        private int bJf;
        private int bJg;
        private float bJh;
        private float bJi;
        private int bJj;
        private int bJk;
        private int bJl;
        private float bJn;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bJm = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            int i = 0;
            float f5 = 0.0f;
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
                bJp[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bJq[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bJp;
            bJq[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bJm = f;
        }

        a(Context context) {
            this.bJn = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void u(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bJf - this.mStart) * f);
        }

        private static float eI(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bJq[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bJq[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bJf = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bJi = 0.0f;
            this.bJg = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bJf;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bJf = i;
            this.mStart = i;
            this.bJg = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                r(i, i2, 0);
            } else if (i > i3) {
                r(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void r(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.bJf = i2;
            int i4 = i - i2;
            this.bJi = eI(i4);
            this.bJg = -i4;
            this.bJl = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bJi) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bJl = i5;
            this.mFinished = false;
            this.bJg = i2;
            this.bJh = i2;
            this.bJj = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                k(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int eL = eL(i2);
                this.bJj = eL;
                this.mDuration = eL;
                d = eK(i2);
            }
            this.bJk = (int) (d * Math.signum(i2));
            this.bJf = this.bJk + i;
            if (this.bJf < i3) {
                o(this.mStart, this.bJf, i3);
                this.bJf = i3;
            }
            if (this.bJf > i4) {
                o(this.mStart, this.bJf, i4);
                this.bJf = i4;
            }
        }

        private double eJ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bJm * this.bJn));
        }

        private double eK(int i) {
            return Math.exp(eJ(i) * (bJo / (bJo - 1.0d))) * this.bJm * this.bJn;
        }

        private int eL(int i) {
            return (int) (Math.exp(eJ(i) / (bJo - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bJi;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bJi)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bJi));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bJg = (int) ((-this.bJi) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bJi = eI(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            TW();
        }

        private void k(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                t(i, i5, i4);
            } else if (eK(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bJl);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bJl = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.bJh);
            }
        }

        private void TW() {
            float abs = (this.bJg * this.bJg) / (Math.abs(this.bJi) * 2.0f);
            float signum = Math.signum(this.bJg);
            if (abs > this.bJl) {
                this.bJi = (((-signum) * this.bJg) * this.bJg) / (this.bJl * 2.0f);
                abs = this.bJl;
            }
            this.bJl = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bJg <= 0) {
                abs = -abs;
            }
            this.bJf = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bJg) / this.bJi));
        }

        boolean TX() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bJj) {
                        this.mStart = this.bJf;
                        this.bJg = (int) this.bJh;
                        this.bJi = eI(this.bJg);
                        this.mStartTime += this.mDuration;
                        TW();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bJf, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bJj;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bJp[i];
                        f3 = (bJp[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bJh = ((f3 * this.bJk) / this.bJj) * 1000.0f;
                    d = f2 * this.bJk;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bJg);
                    d = this.bJl * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bJh = ((-f6) + f7) * signum * this.bJl * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bJh = this.bJg + (this.bJi * f8);
                    d = ((f8 * (this.bJi * f8)) / 2.0f) + (this.bJg * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
