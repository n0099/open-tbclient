package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    final /* synthetic */ a aiN;
    private boolean aiO = false;
    private boolean aiP = false;
    private long aiQ;
    private long aiR;
    private long aiS;
    private long aiT;
    private int mStartX;
    private int mStartY;

    public d(a aVar) {
        this.aiN = aVar;
    }

    public void b(float f, float f2) {
        Interpolator interpolator;
        if (f > 1500.0f) {
            f = 1500.0f;
        } else if (f < -1500.0f) {
            f = -1500.0f;
        }
        if (f2 > 1500.0f) {
            f2 = 1500.0f;
        } else if (f2 < -1500.0f) {
            f2 = -1500.0f;
        }
        this.aiQ = f;
        this.aiR = f2;
        this.aiS = Math.abs((f * 1000.0f) / 2500.0f);
        this.aiT = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.aiS, this.aiT));
        interpolator = this.aiN.aiE;
        setInterpolator(interpolator);
        this.mStartX = this.aiN.getScrollX();
        this.mStartY = this.aiN.getScrollY();
        this.aiO = true;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        long j;
        int i;
        int i2;
        float f2;
        int i3;
        int i4;
        float f3;
        float f4;
        int i5;
        float f5;
        int i6;
        float f6;
        int i7;
        int i8;
        float f7;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.aiS > this.aiT) {
            j = ((float) this.aiS) * f;
        } else {
            j = ((float) this.aiT) * f;
        }
        float f8 = ((float) (j > this.aiS ? this.aiS : j)) / 1000.0f;
        if (this.aiQ > 0) {
            i = this.mStartX - ((int) (f8 * (((float) this.aiQ) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.mStartX - ((int) (f8 * (((float) this.aiQ) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.aiT) {
            j = this.aiT;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.aiR > 0) {
            i2 = this.mStartY - ((int) (f9 * (((float) this.aiR) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.mStartY - ((int) (f9 * (((float) this.aiR) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.aiN.aij;
        i3 = this.aiN.mTop;
        float f10 = f2 + i3;
        i4 = this.aiN.mBottom;
        if (f10 + i4 > this.aiN.getHeight()) {
            i6 = this.aiN.aiz;
            if (i2 < (-i6)) {
                i11 = this.aiN.aiz;
                i2 = -i11;
            }
            f6 = this.aiN.aij;
            i7 = this.aiN.mBottom;
            float f11 = f6 + i7;
            i8 = this.aiN.aiA;
            if (this.aiN.getHeight() + i2 > f11 + i8) {
                f7 = this.aiN.aij;
                i9 = this.aiN.mBottom;
                float height = (f7 - this.aiN.getHeight()) + i9;
                i10 = this.aiN.aiA;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.aiN.aii;
        if (f3 > this.aiN.getWidth()) {
            f4 = this.aiN.aii;
            if (this.aiN.getWidth() + i > f4) {
                f5 = this.aiN.aii;
                i5 = (int) (f5 - this.aiN.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.aiN.scrollTo(i12, i2);
        this.aiN.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.aiP) {
            z = this.aiN.ain;
            if (z) {
                this.aiO = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.aiO = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.aiO = false;
                return false;
            }
        }
        this.aiP = false;
        this.aiO = false;
        return false;
    }

    public boolean Ab() {
        return this.aiO;
    }

    public void stopAnimation() {
        this.aiP = true;
    }
}
