package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float eiX = 8.0f;
    private static float eiY;
    private final a eiU;
    private final a eiV;
    private final boolean eiW;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eiY = 1.0f;
        eiY = 1.0f / an(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float an(float f) {
        float exp;
        float f2 = eiX * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eiY;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eiW = z;
        this.eiU = new a(context);
        this.eiV = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eiU.setFriction(f);
        this.eiV.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eiU.mFinished && this.eiV.mFinished;
    }

    public final int getCurrX() {
        return this.eiU.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eiU.ejb * this.eiU.ejb) + (this.eiV.ejb * this.eiV.ejb));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eiU.mStartTime;
                int i = this.eiU.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = an(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eiU.ao(interpolation);
                    this.eiV.ao(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eiU.mFinished && !this.eiU.update() && !this.eiU.aHm()) {
                    this.eiU.finish();
                }
                if (!this.eiV.mFinished && !this.eiV.update() && !this.eiV.aHm()) {
                    this.eiV.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eiU.L(i, i3, i5);
        this.eiV.L(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eiU.M(i, i3, i4) || this.eiV.M(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eiW && !isFinished()) {
            float f = this.eiU.ejb;
            float f2 = this.eiV.ejb;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eiU.b(i, i11, i5, i6, i9);
                this.eiV.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eiU.b(i, i11, i5, i6, i9);
        this.eiV.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eiU.Q(i, i2, i3);
    }

    public void abortAnimation() {
        this.eiU.finish();
        this.eiV.finish();
    }

    public boolean u(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eiU.eiZ - this.eiU.mStart)) && Math.signum(f2) == Math.signum((float) (this.eiV.eiZ - this.eiV.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float eji = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] ejj = new float[101];
        private static final float[] ejk = new float[101];
        private int eiZ;
        private int eja;
        private float ejb;
        private float ejc;
        private int ejd;
        private int eje;
        private int ejf;
        private float ejh;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float ejg = ViewConfiguration.getScrollFriction();
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
                ejj[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                ejk[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = ejj;
            ejk[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.ejg = f;
        }

        a(Context context) {
            this.ejh = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ao(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.eiZ - this.mStart) * f);
        }

        private static float nN(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void K(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = ejk[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (ejk[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void L(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eiZ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.ejc = 0.0f;
            this.eja = 0;
        }

        void finish() {
            this.mCurrentPosition = this.eiZ;
            this.mFinished = true;
        }

        boolean M(int i, int i2, int i3) {
            this.mFinished = true;
            this.eiZ = i;
            this.mStart = i;
            this.eja = 0;
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
            this.eiZ = i2;
            int i4 = i - i2;
            this.ejc = nN(i4);
            this.eja = -i4;
            this.ejf = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.ejc) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.ejf = i5;
            this.mFinished = false;
            this.eja = i2;
            this.ejb = i2;
            this.ejd = 0;
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
                int nQ = nQ(i2);
                this.ejd = nQ;
                this.mDuration = nQ;
                d = nP(i2);
            }
            this.eje = (int) (d * Math.signum(i2));
            this.eiZ = this.eje + i;
            if (this.eiZ < i3) {
                K(this.mStart, this.eiZ, i3);
                this.eiZ = i3;
            }
            if (this.eiZ > i4) {
                K(this.mStart, this.eiZ, i4);
                this.eiZ = i4;
            }
        }

        private double nO(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.ejg * this.ejh));
        }

        private double nP(int i) {
            return Math.exp(nO(i) * (eji / (eji - 1.0d))) * this.ejg * this.ejh;
        }

        private int nQ(int i) {
            return (int) (Math.exp(nO(i) / (eji - 1.0d)) * 1000.0d);
        }

        private void O(int i, int i2, int i3) {
            float f = (-i3) / this.ejc;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.ejc)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.ejc));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eja = (int) ((-this.ejc) * sqrt);
        }

        private void P(int i, int i2, int i3) {
            this.ejc = nN(i3 == 0 ? i - i2 : i3);
            O(i, i2, i3);
            aHl();
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
            } else if (nP(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.ejf);
            } else {
                N(i, i5, i4);
            }
        }

        void Q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.ejf = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.ejb);
            }
        }

        private void aHl() {
            float abs = (this.eja * this.eja) / (Math.abs(this.ejc) * 2.0f);
            float signum = Math.signum(this.eja);
            if (abs > this.ejf) {
                this.ejc = (((-signum) * this.eja) * this.eja) / (this.ejf * 2.0f);
                abs = this.ejf;
            }
            this.ejf = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eja <= 0) {
                abs = -abs;
            }
            this.eiZ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eja) / this.ejc));
        }

        boolean aHm() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.ejd) {
                        this.mStart = this.eiZ;
                        this.eja = (int) this.ejb;
                        this.ejc = nN(this.eja);
                        this.mStartTime += this.mDuration;
                        aHl();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    N(this.eiZ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.ejd;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = ejj[i];
                        f3 = (ejj[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.ejb = ((f3 * this.eje) / this.ejd) * 1000.0f;
                    d = f2 * this.eje;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eja);
                    d = this.ejf * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.ejb = ((-f6) + f7) * signum * this.ejf * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.ejb = this.eja + (this.ejc * f8);
                    d = ((f8 * (this.ejc * f8)) / 2.0f) + (this.eja * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
