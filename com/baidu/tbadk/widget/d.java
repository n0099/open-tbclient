package com.baidu.tbadk.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Animation {
    final /* synthetic */ a aaq;
    private boolean aar = false;
    private boolean aas = false;
    private long aat;
    private long aau;
    private int aav;
    private long aaw;
    private long aax;
    private int vk;

    public d(a aVar) {
        this.aaq = aVar;
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
        this.aat = f;
        this.aau = f2;
        this.aaw = Math.abs((f * 1000.0f) / 2500.0f);
        this.aax = Math.abs((f2 * 1000.0f) / 2500.0f);
        setDuration(Math.max(this.aaw, this.aax));
        interpolator = this.aaq.aap;
        setInterpolator(interpolator);
        this.aav = this.aaq.getScrollX();
        this.vk = this.aaq.getScrollY();
        this.aar = true;
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
        if (this.aaw > this.aax) {
            j = ((float) this.aaw) * f;
        } else {
            j = ((float) this.aax) * f;
        }
        float f8 = ((float) (j > this.aaw ? this.aaw : j)) / 1000.0f;
        if (this.aat > 0) {
            i = this.aav - ((int) (f8 * (((float) this.aat) - ((2500.0f * f8) / 2.0f))));
        } else {
            i = this.aav - ((int) (f8 * (((float) this.aat) + ((2500.0f * f8) / 2.0f))));
        }
        if (j > this.aax) {
            j = this.aax;
        }
        float f9 = ((float) j) / 1000.0f;
        if (this.aau > 0) {
            i2 = this.vk - ((int) (f9 * (((float) this.aau) - ((2500.0f * f9) / 2.0f))));
        } else {
            i2 = this.vk - ((int) (f9 * (((float) this.aau) + ((2500.0f * f9) / 2.0f))));
        }
        f2 = this.aaq.ZN;
        i3 = this.aaq.aaj;
        float f10 = f2 + i3;
        i4 = this.aaq.aak;
        if (f10 + i4 > this.aaq.getHeight()) {
            i6 = this.aaq.aal;
            if (i2 < (-i6)) {
                i11 = this.aaq.aal;
                i2 = -i11;
            }
            f6 = this.aaq.ZN;
            i7 = this.aaq.aak;
            float f11 = f6 + i7;
            i8 = this.aaq.aam;
            if (this.aaq.getHeight() + i2 > f11 + i8) {
                f7 = this.aaq.ZN;
                i9 = this.aaq.aak;
                float height = (f7 - this.aaq.getHeight()) + i9;
                i10 = this.aaq.aam;
                i2 = (int) (height + i10);
            }
        } else {
            i2 = 0;
        }
        f3 = this.aaq.ZM;
        if (f3 > this.aaq.getWidth()) {
            f4 = this.aaq.ZM;
            if (this.aaq.getWidth() + i > f4) {
                f5 = this.aaq.ZM;
                i5 = (int) (f5 - this.aaq.getWidth());
            } else {
                i5 = i;
            }
            if (i5 >= 0) {
                i12 = i5;
            }
        }
        this.aaq.scrollTo(i12, i2);
        this.aaq.invalidate();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        boolean z;
        if (!this.aas) {
            z = this.aaq.ZT;
            if (z) {
                this.aar = false;
                return false;
            }
            try {
                if (!super.getTransformation(j, transformation)) {
                    this.aar = false;
                    return false;
                }
                return true;
            } catch (Exception e) {
                this.aar = false;
                return false;
            }
        }
        this.aas = false;
        this.aar = false;
        return false;
    }

    public boolean vs() {
        return this.aar;
    }

    public void stopAnimation() {
        this.aas = true;
    }
}
