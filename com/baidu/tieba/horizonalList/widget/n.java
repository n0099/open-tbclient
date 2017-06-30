package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class n {
    private static float cOt = 8.0f;
    private static float cOu;
    private final a cOq;
    private final a cOr;
    private final boolean cOs;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        cOu = 1.0f;
        cOu = 1.0f / Z(1.0f);
    }

    public n(Context context) {
        this(context, null);
    }

    public static float Z(float f) {
        float exp;
        float f2 = cOt * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * cOu;
    }

    public n(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public n(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.cOs = z;
        this.cOq = new a(context);
        this.cOr = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.cOq.setFriction(f);
        this.cOr.setFriction(f);
    }

    public final boolean isFinished() {
        return this.cOq.cOC && this.cOr.cOC;
    }

    public final int getCurrX() {
        return this.cOq.cOv;
    }

    public float getCurrVelocity() {
        return FloatMath.sqrt((this.cOq.cOy * this.cOq.cOy) + (this.cOr.cOy * this.cOr.cOy));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.cOq.mStartTime;
                int i = this.cOq.Ii;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = Z(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.cOq.aa(interpolation);
                    this.cOr.aa(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.cOq.cOC && !this.cOq.anI() && !this.cOq.anH()) {
                    this.cOq.finish();
                }
                if (!this.cOr.cOC && !this.cOr.anI() && !this.cOr.anH()) {
                    this.cOr.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.cOq.C(i, i3, i5);
        this.cOr.C(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.cOq.D(i, i3, i4) || this.cOr.D(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.cOs && !isFinished()) {
            float f = this.cOq.cOy;
            float f2 = this.cOr.cOy;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.cOq.f(i, i11, i5, i6, i9);
                this.cOr.f(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.cOq.f(i, i11, i5, i6, i9);
        this.cOr.f(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.cOq.H(i, i2, i3);
    }

    public void abortAnimation() {
        this.cOq.finish();
        this.cOr.finish();
    }

    public boolean j(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.cOq.cOw - this.cOq.mStart)) && Math.signum(f2) == Math.signum((float) (this.cOr.cOw - this.cOr.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float cOG = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] cOH = new float[101];
        private static final float[] cOI = new float[101];
        private int Ii;
        private int cOA;
        private int cOB;
        private int cOD;
        private float cOF;
        private int cOv;
        private int cOw;
        private int cOx;
        private float cOy;
        private float cOz;
        private int mStart;
        private long mStartTime;
        private float cOE = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean cOC = true;

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
                cOH[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                cOI[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = cOH;
            cOI[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.cOE = f;
        }

        a(Context context) {
            this.cOF = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void aa(float f) {
            this.cOv = this.mStart + Math.round((this.cOw - this.mStart) * f);
        }

        private static float la(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void B(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = cOI[i4];
                this.Ii = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (cOI[i4 + 1] - f2)) + f2) * this.Ii);
            }
        }

        void C(int i, int i2, int i3) {
            this.cOC = false;
            this.mStart = i;
            this.cOw = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ii = i3;
            this.cOz = 0.0f;
            this.cOx = 0;
        }

        void finish() {
            this.cOv = this.cOw;
            this.cOC = true;
        }

        boolean D(int i, int i2, int i3) {
            this.cOC = true;
            this.cOw = i;
            this.mStart = i;
            this.cOx = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.Ii = 0;
            if (i < i2) {
                E(i, i2, 0);
            } else if (i > i3) {
                E(i, i3, 0);
            }
            return !this.cOC;
        }

        private void E(int i, int i2, int i3) {
            this.cOC = false;
            this.mState = 1;
            this.mStart = i;
            this.cOw = i2;
            int i4 = i - i2;
            this.cOz = la(i4);
            this.cOx = -i4;
            this.cOD = Math.abs(i4);
            this.Ii = (int) (1000.0d * Math.sqrt(((-2.0d) * i4) / this.cOz));
        }

        void f(int i, int i2, int i3, int i4, int i5) {
            this.cOD = i5;
            this.cOC = false;
            this.cOx = i2;
            this.cOy = i2;
            this.cOA = 0;
            this.Ii = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.cOv = i;
            if (i > i4 || i < i3) {
                l(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int ld = ld(i2);
                this.cOA = ld;
                this.Ii = ld;
                d = lc(i2);
            }
            this.cOB = (int) (d * Math.signum(i2));
            this.cOw = this.cOB + i;
            if (this.cOw < i3) {
                B(this.mStart, this.cOw, i3);
                this.cOw = i3;
            }
            if (this.cOw > i4) {
                B(this.mStart, this.cOw, i4);
                this.cOw = i4;
            }
        }

        private double lb(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.cOE * this.cOF));
        }

        private double lc(int i) {
            return Math.exp(lb(i) * (cOG / (cOG - 1.0d))) * this.cOE * this.cOF;
        }

        private int ld(int i) {
            return (int) (Math.exp(lb(i) / (cOG - 1.0d)) * 1000.0d);
        }

        private void F(int i, int i2, int i3) {
            float f = (-i3) / this.cOz;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.cOz)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.cOz));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.cOx = (int) ((-this.cOz) * sqrt);
        }

        private void G(int i, int i2, int i3) {
            this.cOz = la(i3 == 0 ? i - i2 : i3);
            F(i, i2, i3);
            anG();
        }

        private void l(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.cOC = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                G(i, i5, i4);
            } else if (lc(i4) > Math.abs(i6)) {
                f(i, i4, z ? i2 : i, z ? i : i3, this.cOD);
            } else {
                E(i, i5, i4);
            }
        }

        void H(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.cOD = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                l(i, i2, i2, (int) this.cOy);
            }
        }

        private void anG() {
            float abs = (this.cOx * this.cOx) / (Math.abs(this.cOz) * 2.0f);
            float signum = Math.signum(this.cOx);
            if (abs > this.cOD) {
                this.cOz = (((-signum) * this.cOx) * this.cOx) / (this.cOD * 2.0f);
                abs = this.cOD;
            }
            this.cOD = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.cOx <= 0) {
                abs = -abs;
            }
            this.cOw = ((int) abs) + i;
            this.Ii = -((int) ((1000.0f * this.cOx) / this.cOz));
        }

        boolean anH() {
            switch (this.mState) {
                case 0:
                    if (this.Ii < this.cOA) {
                        this.mStart = this.cOw;
                        this.cOx = (int) this.cOy;
                        this.cOz = la(this.cOx);
                        this.mStartTime += this.Ii;
                        anG();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.Ii;
                    E(this.cOw, this.mStart, 0);
                    break;
            }
            anI();
            return true;
        }

        boolean anI() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.Ii) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.cOA;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = cOH[i];
                        f3 = (cOH[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.cOy = ((f3 * this.cOB) / this.cOA) * 1000.0f;
                    d = f2 * this.cOB;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.Ii;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.cOx);
                    d = this.cOD * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.cOy = ((-f6) + f7) * signum * this.cOD * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.cOy = this.cOx + (this.cOz * f8);
                    d = ((f8 * (this.cOz * f8)) / 2.0f) + (this.cOx * f8);
                    break;
            }
            this.cOv = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
