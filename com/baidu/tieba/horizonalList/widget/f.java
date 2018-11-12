package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class f {
    private static float esj = 8.0f;
    private static float esk;
    private final a esg;
    private final a esh;
    private final boolean esi;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        esk = 1.0f;
        esk = 1.0f / aq(1.0f);
    }

    public f(Context context) {
        this(context, null);
    }

    public static float aq(float f) {
        float exp;
        float f2 = esj * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * esk;
    }

    public f(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public f(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.esi = z;
        this.esg = new a(context);
        this.esh = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.esg.setFriction(f);
        this.esh.setFriction(f);
    }

    public final boolean isFinished() {
        return this.esg.mFinished && this.esh.mFinished;
    }

    public final int getCurrX() {
        return this.esg.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.esg.esn * this.esg.esn) + (this.esh.esn * this.esh.esn));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.esg.mStartTime;
                int i = this.esg.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = aq(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.esg.ar(interpolation);
                    this.esh.ar(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.esg.mFinished && !this.esg.update() && !this.esg.aKc()) {
                    this.esg.finish();
                }
                if (!this.esh.mFinished && !this.esh.update() && !this.esh.aKc()) {
                    this.esh.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.esg.L(i, i3, i5);
        this.esh.L(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.esg.M(i, i3, i4) || this.esh.M(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.esi && !isFinished()) {
            float f = this.esg.esn;
            float f2 = this.esh.esn;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.esg.c(i, i11, i5, i6, i9);
                this.esh.c(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.esg.c(i, i11, i5, i6, i9);
        this.esh.c(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.esg.Q(i, i2, i3);
    }

    public void abortAnimation() {
        this.esg.finish();
        this.esh.finish();
    }

    public boolean x(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.esg.esl - this.esg.mStart)) && Math.signum(f2) == Math.signum((float) (this.esh.esl - this.esh.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static float esu = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] esv = new float[101];
        private static final float[] esw = new float[101];
        private int esl;
        private int esm;
        private float esn;
        private float eso;
        private int esp;
        private int esq;
        private int esr;
        private float est;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float ess = ViewConfiguration.getScrollFriction();
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
                esv[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                esw[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = esv;
            esw[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.ess = f;
        }

        a(Context context) {
            this.est = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void ar(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.esl - this.mStart) * f);
        }

        private static float oD(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void K(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = esw[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (esw[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void L(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.esl = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.eso = 0.0f;
            this.esm = 0;
        }

        void finish() {
            this.mCurrentPosition = this.esl;
            this.mFinished = true;
        }

        boolean M(int i, int i2, int i3) {
            this.mFinished = true;
            this.esl = i;
            this.mStart = i;
            this.esm = 0;
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
            this.esl = i2;
            int i4 = i - i2;
            this.eso = oD(i4);
            this.esm = -i4;
            this.esr = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.eso) * 1000.0d);
        }

        void c(int i, int i2, int i3, int i4, int i5) {
            this.esr = i5;
            this.mFinished = false;
            this.esm = i2;
            this.esn = i2;
            this.esp = 0;
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
                int oG = oG(i2);
                this.esp = oG;
                this.mDuration = oG;
                d = oF(i2);
            }
            this.esq = (int) (d * Math.signum(i2));
            this.esl = this.esq + i;
            if (this.esl < i3) {
                K(this.mStart, this.esl, i3);
                this.esl = i3;
            }
            if (this.esl > i4) {
                K(this.mStart, this.esl, i4);
                this.esl = i4;
            }
        }

        private double oE(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.ess * this.est));
        }

        private double oF(int i) {
            return Math.exp(oE(i) * (esu / (esu - 1.0d))) * this.ess * this.est;
        }

        private int oG(int i) {
            return (int) (Math.exp(oE(i) / (esu - 1.0d)) * 1000.0d);
        }

        private void O(int i, int i2, int i3) {
            float f = (-i3) / this.eso;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.eso)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.eso));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.esm = (int) ((-this.eso) * sqrt);
        }

        private void P(int i, int i2, int i3) {
            this.eso = oD(i3 == 0 ? i - i2 : i3);
            O(i, i2, i3);
            aKb();
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
            } else if (oF(i4) > Math.abs(i6)) {
                c(i, i4, z ? i2 : i, z ? i : i3, this.esr);
            } else {
                N(i, i5, i4);
            }
        }

        void Q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.esr = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                t(i, i2, i2, (int) this.esn);
            }
        }

        private void aKb() {
            float abs = (this.esm * this.esm) / (Math.abs(this.eso) * 2.0f);
            float signum = Math.signum(this.esm);
            if (abs > this.esr) {
                this.eso = (((-signum) * this.esm) * this.esm) / (this.esr * 2.0f);
                abs = this.esr;
            }
            this.esr = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.esm <= 0) {
                abs = -abs;
            }
            this.esl = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.esm) / this.eso));
        }

        boolean aKc() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.esp) {
                        this.mStart = this.esl;
                        this.esm = (int) this.esn;
                        this.eso = oD(this.esm);
                        this.mStartTime += this.mDuration;
                        aKb();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    N(this.esl, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.esp;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = esv[i];
                        f3 = (esv[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.esn = ((f3 * this.esq) / this.esp) * 1000.0f;
                    d = f2 * this.esq;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.esm);
                    d = this.esr * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.esn = ((-f6) + f7) * signum * this.esr * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.esn = this.esm + (this.eso * f8);
                    d = ((f8 * (this.eso * f8)) / 2.0f) + (this.esm * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
