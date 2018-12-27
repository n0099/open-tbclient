package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float eBV = 8.0f;
    private static float eBW;
    private final a eBS;
    private final a eBT;
    private final boolean eBU;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        eBW = 1.0f;
        eBW = 1.0f / aq(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aq(float f) {
        float exp;
        float f2 = eBV * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * eBW;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.eBU = z;
        this.eBS = new a(context);
        this.eBT = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.eBS.setFriction(f);
        this.eBT.setFriction(f);
    }

    public final boolean isFinished() {
        return this.eBS.mFinished && this.eBT.mFinished;
    }

    public final int getCurrX() {
        return this.eBS.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.eBS.eBZ * this.eBS.eBZ) + (this.eBT.eBZ * this.eBT.eBZ));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.eBS.mStartTime;
                int i = this.eBS.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aq(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.eBS.ar(interpolation);
                    this.eBT.ar(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.eBS.mFinished && !this.eBS.update() && !this.eBS.aMH()) {
                    this.eBS.finish();
                }
                if (!this.eBT.mFinished && !this.eBT.update() && !this.eBT.aMH()) {
                    this.eBT.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.eBS.L(i, i3, i5);
        this.eBT.L(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.eBS.M(i, i3, i4) || this.eBT.M(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.eBU && !isFinished()) {
            float f = this.eBS.eBZ;
            float f2 = this.eBT.eBZ;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.eBS.d(i, i11, i5, i6, i9);
                this.eBT.d(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.eBS.d(i, i11, i5, i6, i9);
        this.eBT.d(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.eBS.Q(i, i2, i3);
    }

    public void abortAnimation() {
        this.eBS.finish();
        this.eBT.finish();
    }

    public boolean x(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.eBS.eBX - this.eBS.mStart)) && Math.signum(f2) == Math.signum((float) (this.eBT.eBX - this.eBT.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float eCg = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] eCh = new float[101];
        private static final float[] eCi = new float[101];
        private int eBX;
        private int eBY;
        private float eBZ;
        private float eCa;
        private int eCb;
        private int eCc;
        private int eCd;
        private float eCf;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float eCe = ViewConfiguration.getScrollFriction();
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
                eCh[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                eCi[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = eCh;
            eCi[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.eCe = f;
        }

        a(Context context) {
            this.eCf = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ar(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.eBX - this.mStart) * f);
        }

        private static float pk(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void K(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = eCi[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (eCi[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void L(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.eBX = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eCa = 0.0f;
            this.eBY = 0;
        }

        void finish() {
            this.mCurrentPosition = this.eBX;
            this.mFinished = true;
        }

        boolean M(int i, int i2, int i3) {
            this.mFinished = true;
            this.eBX = i;
            this.mStart = i;
            this.eBY = 0;
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
            this.eBX = i2;
            int i4 = i - i2;
            this.eCa = pk(i4);
            this.eBY = -i4;
            this.eCd = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eCa) * 1000.0d);
        }

        void d(int i, int i2, int i3, int i4, int i5) {
            this.eCd = i5;
            this.mFinished = false;
            this.eBY = i2;
            this.eBZ = i2;
            this.eCb = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                u(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int po = po(i2);
                this.eCb = po;
                this.mDuration = po;
                d = pm(i2);
            }
            this.eCc = (int) (d * Math.signum(i2));
            this.eBX = this.eCc + i;
            if (this.eBX < i3) {
                K(this.mStart, this.eBX, i3);
                this.eBX = i3;
            }
            if (this.eBX > i4) {
                K(this.mStart, this.eBX, i4);
                this.eBX = i4;
            }
        }

        private double pl(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.eCe * this.eCf));
        }

        private double pm(int i) {
            return Math.exp(pl(i) * (eCg / (eCg - 1.0d))) * this.eCe * this.eCf;
        }

        private int po(int i) {
            return (int) (Math.exp(pl(i) / (eCg - 1.0d)) * 1000.0d);
        }

        private void O(int i, int i2, int i3) {
            float f = (-i3) / this.eCa;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eCa)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eCa));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.eBY = (int) ((-this.eCa) * sqrt);
        }

        private void P(int i, int i2, int i3) {
            this.eCa = pk(i3 == 0 ? i - i2 : i3);
            O(i, i2, i3);
            aMG();
        }

        private void u(int i, int i2, int i3, int i4) {
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
            } else if (pm(i4) > Math.abs(i6)) {
                d(i, i4, z ? i2 : i, z ? i : i3, this.eCd);
            } else {
                N(i, i5, i4);
            }
        }

        void Q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.eCd = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                u(i, i2, i2, (int) this.eBZ);
            }
        }

        private void aMG() {
            float abs = (this.eBY * this.eBY) / (Math.abs(this.eCa) * 2.0f);
            float signum = Math.signum(this.eBY);
            if (abs > this.eCd) {
                this.eCa = (((-signum) * this.eBY) * this.eBY) / (this.eCd * 2.0f);
                abs = this.eCd;
            }
            this.eCd = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.eBY <= 0) {
                abs = -abs;
            }
            this.eBX = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.eBY) / this.eCa));
        }

        boolean aMH() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.eCb) {
                        this.mStart = this.eBX;
                        this.eBY = (int) this.eBZ;
                        this.eCa = pk(this.eBY);
                        this.mStartTime += this.mDuration;
                        aMG();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    N(this.eBX, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.eCb;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = eCh[i];
                        f3 = (eCh[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.eBZ = ((f3 * this.eCc) / this.eCb) * 1000.0f;
                    d = f2 * this.eCc;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.eBY);
                    d = this.eCd * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.eBZ = ((-f6) + f7) * signum * this.eCd * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.eBZ = this.eBY + (this.eCa * f8);
                    d = ((f8 * (this.eCa * f8)) / 2.0f) + (this.eBY * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
