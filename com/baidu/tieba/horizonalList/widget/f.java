package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float eqP = 8.0f;
    private static float eqQ;
    private final a eqM;
    private final a eqN;
    private final boolean eqO;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eqQ = 1.0f;
        eqQ = 1.0f / ao(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float ao(float f) {
        float exp;
        float f2 = eqP * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eqQ;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eqO = z;
        this.eqM = new a(context);
        this.eqN = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eqM.setFriction(f);
        this.eqN.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eqM.mFinished && this.eqN.mFinished;
    }

    public final int getCurrX() {
        return this.eqM.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eqM.eqT * this.eqM.eqT) + (this.eqN.eqT * this.eqN.eqT));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eqM.mStartTime;
                int i = this.eqM.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = ao(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eqM.ap(interpolation);
                    this.eqN.ap(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eqM.mFinished && !this.eqM.update() && !this.eqM.aKE()) {
                    this.eqM.finish();
                }
                if (!this.eqN.mFinished && !this.eqN.update() && !this.eqN.aKE()) {
                    this.eqN.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eqM.L(i, i3, i5);
        this.eqN.L(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eqM.M(i, i3, i4) || this.eqN.M(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eqO && !isFinished()) {
            float f = this.eqM.eqT;
            float f2 = this.eqN.eqT;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eqM.b(i, i11, i5, i6, i9);
                this.eqN.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eqM.b(i, i11, i5, i6, i9);
        this.eqN.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eqM.Q(i, i2, i3);
    }

    public void abortAnimation() {
        this.eqM.finish();
        this.eqN.finish();
    }

    public boolean u(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eqM.eqR - this.eqM.mStart)) && Math.signum(f2) == Math.signum((float) (this.eqN.eqR - this.eqN.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float era = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] erb = new float[101];
        private static final float[] erc = new float[101];
        private int eqR;
        private int eqS;
        private float eqT;
        private float eqU;
        private int eqV;
        private int eqW;
        private int eqX;
        private float eqZ;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float eqY = ViewConfiguration.getScrollFriction();
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
                erb[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                erc[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = erb;
            erc[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.eqY = f;
        }

        a(Context context) {
            this.eqZ = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ap(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.eqR - this.mStart) * f);
        }

        private static float ol(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void K(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = erc[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (erc[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void L(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eqR = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eqU = 0.0f;
            this.eqS = 0;
        }

        void finish() {
            this.mCurrentPosition = this.eqR;
            this.mFinished = true;
        }

        boolean M(int i, int i2, int i3) {
            this.mFinished = true;
            this.eqR = i;
            this.mStart = i;
            this.eqS = 0;
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
            this.eqR = i2;
            int i4 = i - i2;
            this.eqU = ol(i4);
            this.eqS = -i4;
            this.eqX = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eqU) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.eqX = i5;
            this.mFinished = false;
            this.eqS = i2;
            this.eqT = i2;
            this.eqV = 0;
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
                this.eqV = oo;
                this.mDuration = oo;
                d = on(i2);
            }
            this.eqW = (int) (d * Math.signum(i2));
            this.eqR = this.eqW + i;
            if (this.eqR < i3) {
                K(this.mStart, this.eqR, i3);
                this.eqR = i3;
            }
            if (this.eqR > i4) {
                K(this.mStart, this.eqR, i4);
                this.eqR = i4;
            }
        }

        private double om(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.eqY * this.eqZ));
        }

        private double on(int i) {
            return Math.exp(om(i) * (era / (era - 1.0d))) * this.eqY * this.eqZ;
        }

        private int oo(int i) {
            return (int) (Math.exp(om(i) / (era - 1.0d)) * 1000.0d);
        }

        private void O(int i, int i2, int i3) {
            float f = (-i3) / this.eqU;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eqU)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eqU));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eqS = (int) ((-this.eqU) * sqrt);
        }

        private void P(int i, int i2, int i3) {
            this.eqU = ol(i3 == 0 ? i - i2 : i3);
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
                b(i, i4, z ? i2 : i, z ? i : i3, this.eqX);
            } else {
                N(i, i5, i4);
            }
        }

        void Q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eqX = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.eqT);
            }
        }

        private void aKD() {
            float abs = (this.eqS * this.eqS) / (Math.abs(this.eqU) * 2.0f);
            float signum = Math.signum(this.eqS);
            if (abs > this.eqX) {
                this.eqU = (((-signum) * this.eqS) * this.eqS) / (this.eqX * 2.0f);
                abs = this.eqX;
            }
            this.eqX = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eqS <= 0) {
                abs = -abs;
            }
            this.eqR = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eqS) / this.eqU));
        }

        boolean aKE() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eqV) {
                        this.mStart = this.eqR;
                        this.eqS = (int) this.eqT;
                        this.eqU = ol(this.eqS);
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
                    N(this.eqR, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.eqV;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = erb[i];
                        f3 = (erb[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eqT = ((f3 * this.eqW) / this.eqV) * 1000.0f;
                    d = f2 * this.eqW;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eqS);
                    d = this.eqX * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eqT = ((-f6) + f7) * signum * this.eqX * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eqT = this.eqS + (this.eqU * f8);
                    d = ((f8 * (this.eqU * f8)) / 2.0f) + (this.eqS * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
