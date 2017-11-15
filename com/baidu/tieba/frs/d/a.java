package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cOZ;
    private int cPa;
    private LinearLayout.LayoutParams cPb;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cOZ = view;
            if (this.cOZ.getVisibility() == 8 && i2 > 0) {
                this.cPa = i2;
            } else {
                this.cPa = this.cOZ.getMeasuredHeight();
            }
            this.cPb = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cPb.bottomMargin = -this.cPa;
                return;
            }
            this.cPb.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cPb.bottomMargin = (-this.cPa) + ((int) (this.cPa * f));
            } else {
                this.cPb.bottomMargin = -((int) (this.cPa * f));
            }
            this.cOZ.requestLayout();
        } else if (this.mType == 0) {
            this.cPb.bottomMargin = 0;
            this.cOZ.requestLayout();
            this.cPa = this.cOZ.getMeasuredHeight();
        } else {
            this.cPb.bottomMargin = -this.cPa;
            this.cOZ.setVisibility(8);
            this.cOZ.requestLayout();
        }
    }
}
