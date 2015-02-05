package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    final /* synthetic */ a aiK;
    private boolean aiL = false;
    private boolean aiM = false;
    private long aiN;
    private long aiO;
    private long aiP;
    private long aiQ;
    private int mStartX;
    private int mStartY;

    public d(a aVar) {
        this.aiK = aVar;
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
        this.aiN = f;
        this.aiO = f2;
        this.aiP = Math.abs((f * 1000.0f) / 2500.0f);
        this.aiQ = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.aiP, this.aiQ));
        interpolator = this.aiK.aiB;
        setInterpolator(interpolator);
        this.mStartX = this.aiK.getScrollX();
        this.mStartY = this.aiK.getScrollY();
        this.aiL = true;
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
        if (this.aiP > this.aiQ) {
            j = ((float) this.aiP) * f;
        } else {
            j = ((float) this.aiQ) * f;
        }
        float f8 = ((float) (j > this.aiP ? this.aiP : j)) / 1000.0f;
        if (this.aiN > 0) {
            i = this.mStartX - ((int) (f8 * (((float) this.aiN) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.mStartX - ((int) (f8 * (((float) this.aiN) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.aiQ) {
            j = this.aiQ;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.aiO > 0) {
            i2 = this.mStartY - ((int) (f9 * (((float) this.aiO) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.mStartY - ((int) (f9 * (((float) this.aiO) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.aiK.aig;
        i3 = this.aiK.mTop;
        float f10 = f2 + i3;
        i4 = this.aiK.mBottom;
        if (f10 + i4 > this.aiK.getHeight()) {
            i6 = this.aiK.aiw;
            if (i2 < (-i6)) {
                i11 = this.aiK.aiw;
                i2 = -i11;
            }
            f6 = this.aiK.aig;
            i7 = this.aiK.mBottom;
            float f11 = f6 + i7;
            i8 = this.aiK.aix;
            if (this.aiK.getHeight() + i2 > f11 + i8) {
                f7 = this.aiK.aig;
                i9 = this.aiK.mBottom;
                float height = (f7 - this.aiK.getHeight()) + i9;
                i10 = this.aiK.aix;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.aiK.aif;
        if (f3 > this.aiK.getWidth()) {
            f4 = this.aiK.aif;
            if (this.aiK.getWidth() + i > f4) {
                f5 = this.aiK.aif;
                i5 = (int) (f5 - this.aiK.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.aiK.scrollTo(i12, i2);
        this.aiK.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.aiM) {
            z = this.aiK.aik;
            if (z) {
                this.aiL = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.aiL = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.aiL = false;
                return false;
            }
        }
        this.aiM = false;
        this.aiL = false;
        return false;
    }

    public boolean zV() {
        return this.aiL;
    }

    public void stopAnimation() {
        this.aiM = true;
    }
}
