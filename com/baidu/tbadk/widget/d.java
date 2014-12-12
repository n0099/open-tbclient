package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    final /* synthetic */ a aik;
    private boolean ail = false;
    private boolean aim = false;
    private long ain;
    private long aio;
    private long aip;
    private long aiq;
    private int mStartX;
    private int mStartY;

    public d(a aVar) {
        this.aik = aVar;
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
        this.ain = f;
        this.aio = f2;
        this.aip = Math.abs((f * 1000.0f) / 2500.0f);
        this.aiq = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.aip, this.aiq));
        interpolator = this.aik.aib;
        setInterpolator(interpolator);
        this.mStartX = this.aik.getScrollX();
        this.mStartY = this.aik.getScrollY();
        this.ail = true;
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
        if (this.aip > this.aiq) {
            j = ((float) this.aip) * f;
        } else {
            j = ((float) this.aiq) * f;
        }
        float f8 = ((float) (j > this.aip ? this.aip : j)) / 1000.0f;
        if (this.ain > 0) {
            i = this.mStartX - ((int) (f8 * (((float) this.ain) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.mStartX - ((int) (f8 * (((float) this.ain) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.aiq) {
            j = this.aiq;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.aio > 0) {
            i2 = this.mStartY - ((int) (f9 * (((float) this.aio) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.mStartY - ((int) (f9 * (((float) this.aio) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.aik.ahH;
        i3 = this.aik.mTop;
        float f10 = f2 + i3;
        i4 = this.aik.mBottom;
        if (f10 + i4 > this.aik.getHeight()) {
            i6 = this.aik.ahX;
            if (i2 < (-i6)) {
                i11 = this.aik.ahX;
                i2 = -i11;
            }
            f6 = this.aik.ahH;
            i7 = this.aik.mBottom;
            float f11 = f6 + i7;
            i8 = this.aik.ahY;
            if (this.aik.getHeight() + i2 > f11 + i8) {
                f7 = this.aik.ahH;
                i9 = this.aik.mBottom;
                float height = (f7 - this.aik.getHeight()) + i9;
                i10 = this.aik.ahY;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.aik.ahG;
        if (f3 > this.aik.getWidth()) {
            f4 = this.aik.ahG;
            if (this.aik.getWidth() + i > f4) {
                f5 = this.aik.ahG;
                i5 = (int) (f5 - this.aik.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.aik.scrollTo(i12, i2);
        this.aik.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.aim) {
            z = this.aik.ahL;
            if (z) {
                this.ail = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.ail = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.ail = false;
                return false;
            }
        }
        this.aim = false;
        this.ail = false;
        return false;
    }

    public boolean zH() {
        return this.ail;
    }

    public void stopAnimation() {
        this.aim = true;
    }
}
