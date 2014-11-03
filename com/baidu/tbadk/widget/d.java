package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    private long aaA;
    private long aaB;
    final /* synthetic */ a aau;
    private boolean aav = false;
    private boolean aaw = false;
    private long aax;
    private long aay;
    private int aaz;
    private int vk;

    public d(a aVar) {
        this.aau = aVar;
    }

    public void a(float f, float f2) {
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
        this.aax = f;
        this.aay = f2;
        this.aaA = Math.abs((f * 1000.0f) / 2500.0f);
        this.aaB = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.aaA, this.aaB));
        interpolator = this.aau.aat;
        setInterpolator(interpolator);
        this.aaz = this.aau.getScrollX();
        this.vk = this.aau.getScrollY();
        this.aav = true;
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
        if (this.aaA > this.aaB) {
            j = ((float) this.aaA) * f;
        } else {
            j = ((float) this.aaB) * f;
        }
        float f8 = ((float) (j > this.aaA ? this.aaA : j)) / 1000.0f;
        if (this.aax > 0) {
            i = this.aaz - ((int) (f8 * (((float) this.aax) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.aaz - ((int) (f8 * (((float) this.aax) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.aaB) {
            j = this.aaB;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.aay > 0) {
            i2 = this.vk - ((int) (f9 * (((float) this.aay) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.vk - ((int) (f9 * (((float) this.aay) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.aau.ZR;
        i3 = this.aau.aan;
        float f10 = f2 + i3;
        i4 = this.aau.aao;
        if (f10 + i4 > this.aau.getHeight()) {
            i6 = this.aau.aap;
            if (i2 < (-i6)) {
                i11 = this.aau.aap;
                i2 = -i11;
            }
            f6 = this.aau.ZR;
            i7 = this.aau.aao;
            float f11 = f6 + i7;
            i8 = this.aau.aaq;
            if (this.aau.getHeight() + i2 > f11 + i8) {
                f7 = this.aau.ZR;
                i9 = this.aau.aao;
                float height = (f7 - this.aau.getHeight()) + i9;
                i10 = this.aau.aaq;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.aau.ZQ;
        if (f3 > this.aau.getWidth()) {
            f4 = this.aau.ZQ;
            if (this.aau.getWidth() + i > f4) {
                f5 = this.aau.ZQ;
                i5 = (int) (f5 - this.aau.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.aau.scrollTo(i12, i2);
        this.aau.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.aaw) {
            z = this.aau.ZX;
            if (z) {
                this.aav = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.aav = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.aav = false;
                return false;
            }
        }
        this.aaw = false;
        this.aav = false;
        return false;
    }

    public boolean vu() {
        return this.aav;
    }

    public void stopAnimation() {
        this.aaw = true;
    }
}
