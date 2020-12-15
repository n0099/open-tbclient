package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float bFr = 8.0f;
    private static float bFs;
    private final boolean bFq;
    private final a kbs;
    private final a kbt;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bFs = 1.0f;
        bFs = 1.0f / t(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float t(float f) {
        float exp;
        float f2 = bFr * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bFs;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bFq = z;
        this.kbs = new a(context);
        this.kbt = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.kbs.setFriction(f);
        this.kbt.setFriction(f);
    }

    public final boolean isFinished() {
        return this.kbs.mFinished && this.kbt.mFinished;
    }

    public final int getCurrX() {
        return this.kbs.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.kbs.bFv * this.kbs.bFv) + (this.kbt.bFv * this.kbt.bFv));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.kbs.mStartTime;
                int i = this.kbs.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = t(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.kbs.u(interpolation);
                    this.kbt.u(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.kbs.mFinished && !this.kbs.update() && !this.kbs.Vf()) {
                    this.kbs.finish();
                }
                if (!this.kbt.mFinished && !this.kbt.update() && !this.kbt.Vf()) {
                    this.kbt.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.kbs.p(i, i3, i5);
        this.kbt.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.kbs.q(i, i3, i4) || this.kbt.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bFq && !isFinished()) {
            float f = this.kbs.bFv;
            float f2 = this.kbt.bFv;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.kbs.b(i, i11, i5, i6, i9);
                this.kbt.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.kbs.b(i, i11, i5, i6, i9);
        this.kbt.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.kbs.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.kbs.finish();
        this.kbt.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.kbs.bFt - this.kbs.mStart)) && Math.signum(f2) == Math.signum((float) (this.kbt.bFt - this.kbt.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float bFC = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bFD = new float[101];
        private static final float[] bFE = new float[101];
        private float bFB;
        private int bFt;
        private int bFu;
        private float bFv;
        private float bFw;
        private int bFx;
        private int bFy;
        private int bFz;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bFA = ViewConfiguration.getScrollFriction();
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
                bFD[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bFE[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bFD;
            bFE[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bFA = f;
        }

        a(Context context) {
            this.bFB = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void u(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bFt - this.mStart) * f);
        }

        private static float gj(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bFE[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bFE[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bFt = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bFw = 0.0f;
            this.bFu = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bFt;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bFt = i;
            this.mStart = i;
            this.bFu = 0;
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
            this.bFt = i2;
            int i4 = i - i2;
            this.bFw = gj(i4);
            this.bFu = -i4;
            this.bFz = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bFw) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bFz = i5;
            this.mFinished = false;
            this.bFu = i2;
            this.bFv = i2;
            this.bFx = 0;
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
                int gm = gm(i2);
                this.bFx = gm;
                this.mDuration = gm;
                d = gl(i2);
            }
            this.bFy = (int) (d * Math.signum(i2));
            this.bFt = this.bFy + i;
            if (this.bFt < i3) {
                o(this.mStart, this.bFt, i3);
                this.bFt = i3;
            }
            if (this.bFt > i4) {
                o(this.mStart, this.bFt, i4);
                this.bFt = i4;
            }
        }

        private double gk(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bFA * this.bFB));
        }

        private double gl(int i) {
            return Math.exp(gk(i) * (bFC / (bFC - 1.0d))) * this.bFA * this.bFB;
        }

        private int gm(int i) {
            return (int) (Math.exp(gk(i) / (bFC - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bFw;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bFw)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bFw));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bFu = (int) ((-this.bFw) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bFw = gj(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            Ve();
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
            } else if (gl(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bFz);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bFz = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.bFv);
            }
        }

        private void Ve() {
            float abs = (this.bFu * this.bFu) / (Math.abs(this.bFw) * 2.0f);
            float signum = Math.signum(this.bFu);
            if (abs > this.bFz) {
                this.bFw = (((-signum) * this.bFu) * this.bFu) / (this.bFz * 2.0f);
                abs = this.bFz;
            }
            this.bFz = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bFu <= 0) {
                abs = -abs;
            }
            this.bFt = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bFu) / this.bFw));
        }

        boolean Vf() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bFx) {
                        this.mStart = this.bFt;
                        this.bFu = (int) this.bFv;
                        this.bFw = gj(this.bFu);
                        this.mStartTime += this.mDuration;
                        Ve();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bFt, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bFx;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bFD[i];
                        f3 = (bFD[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bFv = ((f3 * this.bFy) / this.bFx) * 1000.0f;
                    d = f2 * this.bFy;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bFu);
                    d = this.bFz * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bFv = ((-f6) + f7) * signum * this.bFz * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bFv = this.bFu + (this.bFw * f8);
                    d = ((f8 * (this.bFw * f8)) / 2.0f) + (this.bFu * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
