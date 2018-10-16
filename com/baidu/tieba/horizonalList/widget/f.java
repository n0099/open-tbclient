package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float eqO = 8.0f;
    private static float eqP;
    private final a eqL;
    private final a eqM;
    private final boolean eqN;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eqP = 1.0f;
        eqP = 1.0f / ao(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float ao(float f) {
        float exp;
        float f2 = eqO * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eqP;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eqN = z;
        this.eqL = new a(context);
        this.eqM = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eqL.setFriction(f);
        this.eqM.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eqL.mFinished && this.eqM.mFinished;
    }

    public final int getCurrX() {
        return this.eqL.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eqL.eqS * this.eqL.eqS) + (this.eqM.eqS * this.eqM.eqS));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eqL.mStartTime;
                int i = this.eqL.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ao(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eqL.ap(interpolation);
                    this.eqM.ap(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eqL.mFinished && !this.eqL.update() && !this.eqL.aKE()) {
                    this.eqL.finish();
                }
                if (!this.eqM.mFinished && !this.eqM.update() && !this.eqM.aKE()) {
                    this.eqM.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eqL.L(i, i3, i5);
        this.eqM.L(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eqL.M(i, i3, i4) || this.eqM.M(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eqN && !isFinished()) {
            float f = this.eqL.eqS;
            float f2 = this.eqM.eqS;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eqL.b(i, i11, i5, i6, i9);
                this.eqM.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eqL.b(i, i11, i5, i6, i9);
        this.eqM.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eqL.Q(i, i2, i3);
    }

    public void abortAnimation() {
        this.eqL.finish();
        this.eqM.finish();
    }

    public boolean u(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eqL.eqQ - this.eqL.mStart)) && Math.signum(f2) == Math.signum((float) (this.eqM.eqQ - this.eqM.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float eqZ = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] era = new float[101];
        private static final float[] erb = new float[101];
        private int eqQ;
        private int eqR;
        private float eqS;
        private float eqT;
        private int eqU;
        private int eqV;
        private int eqW;
        private float eqY;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float eqX = ViewConfiguration.getScrollFriction();
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
                era[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                erb[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = era;
            erb[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.eqX = f;
        }

        a(Context context) {
            this.eqY = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ap(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.eqQ - this.mStart) * f);
        }

        private static float ol(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void K(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = erb[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (erb[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void L(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eqQ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eqT = 0.0f;
            this.eqR = 0;
        }

        void finish() {
            this.mCurrentPosition = this.eqQ;
            this.mFinished = true;
        }

        boolean M(int i, int i2, int i3) {
            this.mFinished = true;
            this.eqQ = i;
            this.mStart = i;
            this.eqR = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                N(i, i2, 0);
            } else if (i > i3) {
                N(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void N(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.eqQ = i2;
            int i4 = i - i2;
            this.eqT = ol(i4);
            this.eqR = -i4;
            this.eqW = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eqT) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.eqW = i5;
            this.mFinished = false;
            this.eqR = i2;
            this.eqS = i2;
            this.eqU = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                t(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int oo = oo(i2);
                this.eqU = oo;
                this.mDuration = oo;
                d = on(i2);
            }
            this.eqV = (int) (d * Math.signum(i2));
            this.eqQ = this.eqV + i;
            if (this.eqQ < i3) {
                K(this.mStart, this.eqQ, i3);
                this.eqQ = i3;
            }
            if (this.eqQ > i4) {
                K(this.mStart, this.eqQ, i4);
                this.eqQ = i4;
            }
        }

        private double om(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.eqX * this.eqY));
        }

        private double on(int i) {
            return Math.exp(om(i) * (eqZ / (eqZ - 1.0d))) * this.eqX * this.eqY;
        }

        private int oo(int i) {
            return (int) (Math.exp(om(i) / (eqZ - 1.0d)) * 1000.0d);
        }

        private void O(int i, int i2, int i3) {
            float f = (-i3) / this.eqT;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eqT)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eqT));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eqR = (int) ((-this.eqT) * sqrt);
        }

        private void P(int i, int i2, int i3) {
            this.eqT = ol(i3 == 0 ? i - i2 : i3);
            O(i, i2, i3);
            aKD();
        }

        private void t(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                P(i, i5, i4);
            } else if (on(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.eqW);
            } else {
                N(i, i5, i4);
            }
        }

        void Q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eqW = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.eqS);
            }
        }

        private void aKD() {
            float abs = (this.eqR * this.eqR) / (Math.abs(this.eqT) * 2.0f);
            float signum = Math.signum(this.eqR);
            if (abs > this.eqW) {
                this.eqT = (((-signum) * this.eqR) * this.eqR) / (this.eqW * 2.0f);
                abs = this.eqW;
            }
            this.eqW = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eqR <= 0) {
                abs = -abs;
            }
            this.eqQ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eqR) / this.eqT));
        }

        boolean aKE() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eqU) {
                        this.mStart = this.eqQ;
                        this.eqR = (int) this.eqS;
                        this.eqT = ol(this.eqR);
                        this.mStartTime += this.mDuration;
                        aKD();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    N(this.eqQ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.eqU;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = era[i];
                        f3 = (era[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eqS = ((f3 * this.eqV) / this.eqU) * 1000.0f;
                    d = f2 * this.eqV;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eqR);
                    d = this.eqW * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eqS = ((-f6) + f7) * signum * this.eqW * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eqS = this.eqR + (this.eqT * f8);
                    d = ((f8 * (this.eqT * f8)) / 2.0f) + (this.eqR * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
