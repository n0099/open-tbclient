package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float btC = 8.0f;
    private static float btD;
    private final boolean btB;
    private final a juG;
    private final a juH;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        btD = 1.0f;
        btD = 1.0f / u(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float u(float f) {
        float exp;
        float f2 = btC * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * btD;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.btB = z;
        this.juG = new a(context);
        this.juH = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.juG.setFriction(f);
        this.juH.setFriction(f);
    }

    public final boolean isFinished() {
        return this.juG.mFinished && this.juH.mFinished;
    }

    public final int getCurrX() {
        return this.juG.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.juG.btG * this.juG.btG) + (this.juH.btG * this.juH.btG));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.juG.mStartTime;
                int i = this.juG.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = u(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.juG.v(interpolation);
                    this.juH.v(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.juG.mFinished && !this.juG.update() && !this.juG.PL()) {
                    this.juG.finish();
                }
                if (!this.juH.mFinished && !this.juH.update() && !this.juH.PL()) {
                    this.juH.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.juG.o(i, i3, i5);
        this.juH.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.juG.p(i, i3, i4) || this.juH.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.btB && !isFinished()) {
            float f = this.juG.btG;
            float f2 = this.juH.btG;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.juG.b(i, i11, i5, i6, i9);
                this.juH.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.juG.b(i, i11, i5, i6, i9);
        this.juH.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.juG.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.juG.finish();
        this.juH.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.juG.btE - this.juG.mStart)) && Math.signum(f2) == Math.signum((float) (this.juH.btE - this.juH.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float btN = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] btO = new float[101];
        private static final float[] btP = new float[101];
        private int btE;
        private int btF;
        private float btG;
        private float btH;
        private int btI;
        private int btJ;
        private int btK;
        private float btM;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float btL = ViewConfiguration.getScrollFriction();
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
                btO[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                btP[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = btO;
            btP[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.btL = f;
        }

        a(Context context) {
            this.btM = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void v(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.btE - this.mStart) * f);
        }

        private static float fA(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = btP[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (btP[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.btE = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.btH = 0.0f;
            this.btF = 0;
        }

        void finish() {
            this.mCurrentPosition = this.btE;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.btE = i;
            this.mStart = i;
            this.btF = 0;
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
            this.btE = i2;
            int i4 = i - i2;
            this.btH = fA(i4);
            this.btF = -i4;
            this.btK = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.btH) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.btK = i5;
            this.mFinished = false;
            this.btF = i2;
            this.btG = i2;
            this.btI = 0;
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
                int fD = fD(i2);
                this.btI = fD;
                this.mDuration = fD;
                d = fC(i2);
            }
            this.btJ = (int) (d * Math.signum(i2));
            this.btE = this.btJ + i;
            if (this.btE < i3) {
                n(this.mStart, this.btE, i3);
                this.btE = i3;
            }
            if (this.btE > i4) {
                n(this.mStart, this.btE, i4);
                this.btE = i4;
            }
        }

        private double fB(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.btL * this.btM));
        }

        private double fC(int i) {
            return Math.exp(fB(i) * (btN / (btN - 1.0d))) * this.btL * this.btM;
        }

        private int fD(int i) {
            return (int) (Math.exp(fB(i) / (btN - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.btH;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.btH)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.btH));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.btF = (int) ((-this.btH) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.btH = fA(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            PK();
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
            } else if (fC(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.btK);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.btK = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.btG);
            }
        }

        private void PK() {
            float abs = (this.btF * this.btF) / (Math.abs(this.btH) * 2.0f);
            float signum = Math.signum(this.btF);
            if (abs > this.btK) {
                this.btH = (((-signum) * this.btF) * this.btF) / (this.btK * 2.0f);
                abs = this.btK;
            }
            this.btK = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.btF <= 0) {
                abs = -abs;
            }
            this.btE = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.btF) / this.btH));
        }

        boolean PL() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.btI) {
                        this.mStart = this.btE;
                        this.btF = (int) this.btG;
                        this.btH = fA(this.btF);
                        this.mStartTime += this.mDuration;
                        PK();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.btE, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.btI;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = btO[i];
                        f3 = (btO[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.btG = ((f3 * this.btJ) / this.btI) * 1000.0f;
                    d = f2 * this.btJ;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.btF);
                    d = this.btK * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.btG = ((-f6) + f7) * signum * this.btK * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.btG = this.btF + (this.btH * f8);
                    d = ((f8 * (this.btH * f8)) / 2.0f) + (this.btF * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
