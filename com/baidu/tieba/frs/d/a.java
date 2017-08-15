package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cxr;
    private int cxs;
    private LinearLayout.LayoutParams cxt;
    private int mType;

    public a(View view, int i, int i2) {
        this.cxr = view;
        if (this.cxr.getVisibility() == 8) {
            this.cxs = i2;
        } else {
            this.cxs = this.cxr.getMeasuredHeight();
        }
        this.cxt = (LinearLayout.LayoutParams) view.getLayoutParams();
        this.mType = i;
        if (this.mType == 0) {
            this.cxt.bottomMargin = -this.cxs;
            return;
        }
        this.cxt.bottomMargin = 0;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cxt.bottomMargin = (-this.cxs) + ((int) (this.cxs * f));
            } else {
                this.cxt.bottomMargin = -((int) (this.cxs * f));
            }
            this.cxr.requestLayout();
        } else if (this.mType == 0) {
            this.cxt.bottomMargin = 0;
            this.cxr.requestLayout();
            this.cxs = this.cxr.getMeasuredHeight();
        } else {
            this.cxt.bottomMargin = -this.cxs;
            this.cxr.setVisibility(8);
            this.cxr.requestLayout();
        }
    }
}
