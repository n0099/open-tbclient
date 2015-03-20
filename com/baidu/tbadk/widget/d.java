package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    final /* synthetic */ a arm;
    private boolean arn = false;
    private boolean aro = false;
    private long arp;
    private long arq;
    private long arr;
    private long ars;
    private int mStartX;
    private int mStartY;

    public d(a aVar) {
        this.arm = aVar;
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
        this.arp = f;
        this.arq = f2;
        this.arr = Math.abs((f * 1000.0f) / 2500.0f);
        this.ars = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.arr, this.ars));
        interpolator = this.arm.ard;
        setInterpolator(interpolator);
        this.mStartX = this.arm.getScrollX();
        this.mStartY = this.arm.getScrollY();
        this.arn = true;
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
        if (this.arr > this.ars) {
            j = ((float) this.arr) * f;
        } else {
            j = ((float) this.ars) * f;
        }
        float f8 = ((float) (j > this.arr ? this.arr : j)) / 1000.0f;
        if (this.arp > 0) {
            i = this.mStartX - ((int) (f8 * (((float) this.arp) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.mStartX - ((int) (f8 * (((float) this.arp) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.ars) {
            j = this.ars;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.arq > 0) {
            i2 = this.mStartY - ((int) (f9 * (((float) this.arq) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.mStartY - ((int) (f9 * (((float) this.arq) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.arm.aqH;
        i3 = this.arm.mTop;
        float f10 = f2 + i3;
        i4 = this.arm.mBottom;
        if (f10 + i4 > this.arm.getHeight()) {
            i6 = this.arm.aqX;
            if (i2 < (-i6)) {
                i11 = this.arm.aqX;
                i2 = -i11;
            }
            f6 = this.arm.aqH;
            i7 = this.arm.mBottom;
            float f11 = f6 + i7;
            i8 = this.arm.aqY;
            if (this.arm.getHeight() + i2 > f11 + i8) {
                f7 = this.arm.aqH;
                i9 = this.arm.mBottom;
                float height = (f7 - this.arm.getHeight()) + i9;
                i10 = this.arm.aqY;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.arm.aqG;
        if (f3 > this.arm.getWidth()) {
            f4 = this.arm.aqG;
            if (this.arm.getWidth() + i > f4) {
                f5 = this.arm.aqG;
                i5 = (int) (f5 - this.arm.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.arm.scrollTo(i12, i2);
        this.arm.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.aro) {
            z = this.arm.aqL;
            if (z) {
                this.arn = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.arn = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.arn = false;
                return false;
            }
        }
        this.aro = false;
        this.arn = false;
        return false;
    }

    public boolean Dr() {
        return this.arn;
    }

    public void stopAnimation() {
        this.aro = true;
    }
}
