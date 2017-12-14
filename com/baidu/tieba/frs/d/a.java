package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cYA;
    private int cYB;
    private LinearLayout.LayoutParams cYC;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cYA = view;
            if (this.cYA.getVisibility() == 8 && i2 > 0) {
                this.cYB = i2;
            } else {
                this.cYB = this.cYA.getMeasuredHeight();
            }
            this.cYC = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cYC.bottomMargin = -this.cYB;
                return;
            }
            this.cYC.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cYC.bottomMargin = (-this.cYB) + ((int) (this.cYB * f));
            } else {
                this.cYC.bottomMargin = -((int) (this.cYB * f));
            }
            this.cYA.requestLayout();
        } else if (this.mType == 0) {
            this.cYC.bottomMargin = 0;
            this.cYA.requestLayout();
            this.cYB = this.cYA.getMeasuredHeight();
        } else {
            this.cYC.bottomMargin = -this.cYB;
            this.cYA.setVisibility(8);
            this.cYA.requestLayout();
        }
    }
}
