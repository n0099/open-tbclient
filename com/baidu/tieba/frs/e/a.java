package com.baidu.tieba.frs.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View ctW;
    private int ctX;
    private LinearLayout.LayoutParams ctY;
    private int mType;

    public a(View view, int i, int i2) {
        this.ctW = view;
        if (this.ctW.getVisibility() == 8) {
            this.ctX = i2;
        } else {
            this.ctX = this.ctW.getMeasuredHeight();
        }
        this.ctY = (LinearLayout.LayoutParams) view.getLayoutParams();
        this.mType = i;
        if (this.mType == 0) {
            this.ctY.bottomMargin = -this.ctX;
            return;
        }
        this.ctY.bottomMargin = 0;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.ctY.bottomMargin = (-this.ctX) + ((int) (this.ctX * f));
            } else {
                this.ctY.bottomMargin = -((int) (this.ctX * f));
            }
            this.ctW.requestLayout();
        } else if (this.mType == 0) {
            this.ctY.bottomMargin = 0;
            this.ctW.requestLayout();
            this.ctX = this.ctW.getMeasuredHeight();
        } else {
            this.ctY.bottomMargin = -this.ctX;
            this.ctW.setVisibility(8);
            this.ctW.requestLayout();
        }
    }
}
