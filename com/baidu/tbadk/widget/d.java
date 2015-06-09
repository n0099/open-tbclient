package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    final /* synthetic */ a asX;
    private boolean asY = false;
    private boolean asZ = false;
    private long ata;
    private long atb;
    private long atc;
    private long atd;
    private int mStartX;
    private int mStartY;

    public d(a aVar) {
        this.asX = aVar;
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
        this.ata = f;
        this.atb = f2;
        this.atc = Math.abs((f * 1000.0f) / 2500.0f);
        this.atd = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.atc, this.atd));
        interpolator = this.asX.asO;
        setInterpolator(interpolator);
        this.mStartX = this.asX.getScrollX();
        this.mStartY = this.asX.getScrollY();
        this.asY = true;
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
        if (this.atc > this.atd) {
            j = ((float) this.atc) * f;
        } else {
            j = ((float) this.atd) * f;
        }
        float f8 = ((float) (j > this.atc ? this.atc : j)) / 1000.0f;
        if (this.ata > 0) {
            i = this.mStartX - ((int) (f8 * (((float) this.ata) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.mStartX - ((int) (f8 * (((float) this.ata) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.atd) {
            j = this.atd;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.atb > 0) {
            i2 = this.mStartY - ((int) (f9 * (((float) this.atb) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.mStartY - ((int) (f9 * (((float) this.atb) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.asX.ass;
        i3 = this.asX.mTop;
        float f10 = f2 + i3;
        i4 = this.asX.mBottom;
        if (f10 + i4 > this.asX.getHeight()) {
            i6 = this.asX.asI;
            if (i2 < (-i6)) {
                i11 = this.asX.asI;
                i2 = -i11;
            }
            f6 = this.asX.ass;
            i7 = this.asX.mBottom;
            float f11 = f6 + i7;
            i8 = this.asX.asJ;
            if (this.asX.getHeight() + i2 > f11 + i8) {
                f7 = this.asX.ass;
                i9 = this.asX.mBottom;
                float height = (f7 - this.asX.getHeight()) + i9;
                i10 = this.asX.asJ;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.asX.asr;
        if (f3 > this.asX.getWidth()) {
            f4 = this.asX.asr;
            if (this.asX.getWidth() + i > f4) {
                f5 = this.asX.asr;
                i5 = (int) (f5 - this.asX.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.asX.scrollTo(i12, i2);
        this.asX.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.asZ) {
            z = this.asX.asw;
            if (z) {
                this.asY = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.asY = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.asY = false;
                return false;
            }
        }
        this.asZ = false;
        this.asY = false;
        return false;
    }

    public boolean Ei() {
        return this.asY;
    }

    public void stopAnimation() {
        this.asZ = true;
    }
}
