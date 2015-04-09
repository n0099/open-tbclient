package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    private long arA;
    final /* synthetic */ a aru;
    private boolean arv = false;
    private boolean arw = false;
    private long arx;
    private long ary;
    private long arz;
    private int mStartX;
    private int mStartY;

    public d(a aVar) {
        this.aru = aVar;
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
        this.arx = f;
        this.ary = f2;
        this.arz = Math.abs((f * 1000.0f) / 2500.0f);
        this.arA = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.arz, this.arA));
        interpolator = this.aru.arl;
        setInterpolator(interpolator);
        this.mStartX = this.aru.getScrollX();
        this.mStartY = this.aru.getScrollY();
        this.arv = true;
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
        if (this.arz > this.arA) {
            j = ((float) this.arz) * f;
        } else {
            j = ((float) this.arA) * f;
        }
        float f8 = ((float) (j > this.arz ? this.arz : j)) / 1000.0f;
        if (this.arx > 0) {
            i = this.mStartX - ((int) (f8 * (((float) this.arx) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.mStartX - ((int) (f8 * (((float) this.arx) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.arA) {
            j = this.arA;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.ary > 0) {
            i2 = this.mStartY - ((int) (f9 * (((float) this.ary) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.mStartY - ((int) (f9 * (((float) this.ary) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.aru.aqP;
        i3 = this.aru.mTop;
        float f10 = f2 + i3;
        i4 = this.aru.mBottom;
        if (f10 + i4 > this.aru.getHeight()) {
            i6 = this.aru.arf;
            if (i2 < (-i6)) {
                i11 = this.aru.arf;
                i2 = -i11;
            }
            f6 = this.aru.aqP;
            i7 = this.aru.mBottom;
            float f11 = f6 + i7;
            i8 = this.aru.arg;
            if (this.aru.getHeight() + i2 > f11 + i8) {
                f7 = this.aru.aqP;
                i9 = this.aru.mBottom;
                float height = (f7 - this.aru.getHeight()) + i9;
                i10 = this.aru.arg;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.aru.aqO;
        if (f3 > this.aru.getWidth()) {
            f4 = this.aru.aqO;
            if (this.aru.getWidth() + i > f4) {
                f5 = this.aru.aqO;
                i5 = (int) (f5 - this.aru.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.aru.scrollTo(i12, i2);
        this.aru.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.arw) {
            z = this.aru.aqT;
            if (z) {
                this.arv = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.arv = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.arv = false;
                return false;
            }
        }
        this.arw = false;
        this.arv = false;
        return false;
    }

    public boolean Dx() {
        return this.arv;
    }

    public void stopAnimation() {
        this.arw = true;
    }
}
