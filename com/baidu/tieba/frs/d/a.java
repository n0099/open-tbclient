package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cOF;
    private int cOG;
    private LinearLayout.LayoutParams cOH;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cOF = view;
            if (this.cOF.getVisibility() == 8 && i2 > 0) {
                this.cOG = i2;
            } else {
                this.cOG = this.cOF.getMeasuredHeight();
            }
            this.cOH = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cOH.bottomMargin = -this.cOG;
                return;
            }
            this.cOH.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cOH.bottomMargin = (-this.cOG) + ((int) (this.cOG * f));
            } else {
                this.cOH.bottomMargin = -((int) (this.cOG * f));
            }
            this.cOF.requestLayout();
        } else if (this.mType == 0) {
            this.cOH.bottomMargin = 0;
            this.cOF.requestLayout();
            this.cOG = this.cOF.getMeasuredHeight();
        } else {
            this.cOH.bottomMargin = -this.cOG;
            this.cOF.setVisibility(8);
            this.cOF.requestLayout();
        }
    }
}
