package com.baidu.tieba.frs.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cFE;
    private int cFF;
    private LinearLayout.LayoutParams cFG;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cFE = view;
            if (this.cFE.getVisibility() == 8 && i2 > 0) {
                this.cFF = i2;
            } else {
                this.cFF = this.cFE.getMeasuredHeight();
            }
            this.cFG = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cFG.bottomMargin = -this.cFF;
                return;
            }
            this.cFG.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cFG.bottomMargin = (-this.cFF) + ((int) (this.cFF * f));
            } else {
                this.cFG.bottomMargin = -((int) (this.cFF * f));
            }
            this.cFE.requestLayout();
        } else if (this.mType == 0) {
            this.cFG.bottomMargin = 0;
            this.cFE.requestLayout();
            this.cFF = this.cFE.getMeasuredHeight();
        } else {
            this.cFG.bottomMargin = -this.cFF;
            this.cFE.setVisibility(8);
            this.cFE.requestLayout();
        }
    }
}
