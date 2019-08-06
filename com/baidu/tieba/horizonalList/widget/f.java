package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float gqX = 8.0f;
    private static float gqY;
    private final a gqU;
    private final a gqV;
    private final boolean gqW;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        gqY = 1.0f;
        gqY = 1.0f / aI(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aI(float f) {
        float exp;
        float f2 = gqX * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * gqY;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.gqW = z;
        this.gqU = new a(context);
        this.gqV = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.gqU.setFriction(f);
        this.gqV.setFriction(f);
    }

    public final boolean isFinished() {
        return this.gqU.mFinished && this.gqV.mFinished;
    }

    public final int getCurrX() {
        return this.gqU.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.gqU.grb * this.gqU.grb) + (this.gqV.grb * this.gqV.grb));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.gqU.mStartTime;
                int i = this.gqU.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aI(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.gqU.aJ(interpolation);
                    this.gqV.aJ(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.gqU.mFinished && !this.gqU.update() && !this.gqU.byk()) {
                    this.gqU.finish();
                }
                if (!this.gqV.mFinished && !this.gqV.update() && !this.gqV.byk()) {
                    this.gqV.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.gqU.Q(i, i3, i5);
        this.gqV.Q(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.gqU.R(i, i3, i4) || this.gqV.R(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.gqW && !isFinished()) {
            float f = this.gqU.grb;
            float f2 = this.gqV.grb;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.gqU.e(i, i11, i5, i6, i9);
                this.gqV.e(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.gqU.e(i, i11, i5, i6, i9);
        this.gqV.e(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.gqU.V(i, i2, i3);
    }

    public void abortAnimation() {
        this.gqU.finish();
        this.gqV.finish();
    }

    public boolean C(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.gqU.gqZ - this.gqU.mStart)) && Math.signum(f2) == Math.signum((float) (this.gqV.gqZ - this.gqV.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float gri = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] grj = new float[101];
        private static final float[] grk = new float[101];
        private int gqZ;
        private int gra;
        private float grb;
        private float grc;
        private int grd;
        private int gre;
        private int grf;
        private float grh;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float grg = ViewConfiguration.getScrollFriction();
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
                grj[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                grk[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = grj;
            grk[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.grg = f;
        }

        a(Context context) {
            this.grh = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aJ(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.gqZ - this.mStart) * f);
        }

        private static float uD(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void P(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = grk[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (grk[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void Q(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.gqZ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.grc = 0.0f;
            this.gra = 0;
        }

        void finish() {
            this.mCurrentPosition = this.gqZ;
            this.mFinished = true;
        }

        boolean R(int i, int i2, int i3) {
            this.mFinished = true;
            this.gqZ = i;
            this.mStart = i;
            this.gra = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                S(i, i2, 0);
            } else if (i > i3) {
                S(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void S(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.gqZ = i2;
            int i4 = i - i2;
            this.grc = uD(i4);
            this.gra = -i4;
            this.grf = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.grc) * 1000.0d);
        }

        void e(int i, int i2, int i3, int i4, int i5) {
            this.grf = i5;
            this.mFinished = false;
            this.gra = i2;
            this.grb = i2;
            this.grd = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                y(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int uG = uG(i2);
                this.grd = uG;
                this.mDuration = uG;
                d = uF(i2);
            }
            this.gre = (int) (d * Math.signum(i2));
            this.gqZ = this.gre + i;
            if (this.gqZ < i3) {
                P(this.mStart, this.gqZ, i3);
                this.gqZ = i3;
            }
            if (this.gqZ > i4) {
                P(this.mStart, this.gqZ, i4);
                this.gqZ = i4;
            }
        }

        private double uE(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.grg * this.grh));
        }

        private double uF(int i) {
            return Math.exp(uE(i) * (gri / (gri - 1.0d))) * this.grg * this.grh;
        }

        private int uG(int i) {
            return (int) (Math.exp(uE(i) / (gri - 1.0d)) * 1000.0d);
        }

        private void T(int i, int i2, int i3) {
            float f = (-i3) / this.grc;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.grc)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.grc));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.gra = (int) ((-this.grc) * sqrt);
        }

        private void U(int i, int i2, int i3) {
            this.grc = uD(i3 == 0 ? i - i2 : i3);
            T(i, i2, i3);
            byj();
        }

        private void y(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                U(i, i5, i4);
            } else if (uF(i4) > Math.abs(i6)) {
                e(i, i4, z ? i2 : i, z ? i : i3, this.grf);
            } else {
                S(i, i5, i4);
            }
        }

        void V(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.grf = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                y(i, i2, i2, (int) this.grb);
            }
        }

        private void byj() {
            float abs = (this.gra * this.gra) / (Math.abs(this.grc) * 2.0f);
            float signum = Math.signum(this.gra);
            if (abs > this.grf) {
                this.grc = (((-signum) * this.gra) * this.gra) / (this.grf * 2.0f);
                abs = this.grf;
            }
            this.grf = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.gra <= 0) {
                abs = -abs;
            }
            this.gqZ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.gra) / this.grc));
        }

        boolean byk() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.grd) {
                        this.mStart = this.gqZ;
                        this.gra = (int) this.grb;
                        this.grc = uD(this.gra);
                        this.mStartTime += this.mDuration;
                        byj();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    S(this.gqZ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.grd;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = grj[i];
                        f3 = (grj[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.grb = ((f3 * this.gre) / this.grd) * 1000.0f;
                    d = f2 * this.gre;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.gra);
                    d = this.grf * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.grb = ((-f6) + f7) * signum * this.grf * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.grb = this.gra + (this.grc * f8);
                    d = ((f8 * (this.grc * f8)) / 2.0f) + (this.gra * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
