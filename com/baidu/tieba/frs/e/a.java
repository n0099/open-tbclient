package com.baidu.tieba.frs.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cDT;
    private int cDU;
    private LinearLayout.LayoutParams cDV;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cDT = view;
            if (this.cDT.getVisibility() == 8 && i2 > 0) {
                this.cDU = i2;
            } else {
                this.cDU = this.cDT.getMeasuredHeight();
            }
            this.cDV = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cDV.bottomMargin = -this.cDU;
                return;
            }
            this.cDV.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cDV.bottomMargin = (-this.cDU) + ((int) (this.cDU * f));
            } else {
                this.cDV.bottomMargin = -((int) (this.cDU * f));
            }
            this.cDT.requestLayout();
        } else if (this.mType == 0) {
            this.cDV.bottomMargin = 0;
            this.cDT.requestLayout();
            this.cDU = this.cDT.getMeasuredHeight();
        } else {
            this.cDV.bottomMargin = -this.cDU;
            this.cDT.setVisibility(8);
            this.cDT.requestLayout();
        }
    }
}
