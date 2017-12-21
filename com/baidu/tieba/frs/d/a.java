package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cYE;
    private int cYF;
    private LinearLayout.LayoutParams cYG;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cYE = view;
            if (this.cYE.getVisibility() == 8 && i2 > 0) {
                this.cYF = i2;
            } else {
                this.cYF = this.cYE.getMeasuredHeight();
            }
            this.cYG = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cYG.bottomMargin = -this.cYF;
                return;
            }
            this.cYG.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cYG.bottomMargin = (-this.cYF) + ((int) (this.cYF * f));
            } else {
                this.cYG.bottomMargin = -((int) (this.cYF * f));
            }
            this.cYE.requestLayout();
        } else if (this.mType == 0) {
            this.cYG.bottomMargin = 0;
            this.cYE.requestLayout();
            this.cYF = this.cYE.getMeasuredHeight();
        } else {
            this.cYG.bottomMargin = -this.cYF;
            this.cYE.setVisibility(8);
            this.cYE.requestLayout();
        }
    }
}
