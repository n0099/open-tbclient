package com.baidu.tieba.frs.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cEL;
    private int cEM;
    private LinearLayout.LayoutParams cEN;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cEL = view;
            if (this.cEL.getVisibility() == 8 && i2 > 0) {
                this.cEM = i2;
            } else {
                this.cEM = this.cEL.getMeasuredHeight();
            }
            this.cEN = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cEN.bottomMargin = -this.cEM;
                return;
            }
            this.cEN.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cEN.bottomMargin = (-this.cEM) + ((int) (this.cEM * f));
            } else {
                this.cEN.bottomMargin = -((int) (this.cEM * f));
            }
            this.cEL.requestLayout();
        } else if (this.mType == 0) {
            this.cEN.bottomMargin = 0;
            this.cEL.requestLayout();
            this.cEM = this.cEL.getMeasuredHeight();
        } else {
            this.cEN.bottomMargin = -this.cEM;
            this.cEL.setVisibility(8);
            this.cEL.requestLayout();
        }
    }
}
