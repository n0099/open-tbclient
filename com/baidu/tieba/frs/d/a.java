package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cvo;
    private int cvp;
    private LinearLayout.LayoutParams cvq;
    private int mType;

    public a(View view, int i, int i2) {
        this.cvo = view;
        if (this.cvo.getVisibility() == 8) {
            this.cvp = i2;
        } else {
            this.cvp = this.cvo.getMeasuredHeight();
        }
        this.cvq = (LinearLayout.LayoutParams) view.getLayoutParams();
        this.mType = i;
        if (this.mType == 0) {
            this.cvq.bottomMargin = -this.cvp;
            return;
        }
        this.cvq.bottomMargin = 0;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cvq.bottomMargin = (-this.cvp) + ((int) (this.cvp * f));
            } else {
                this.cvq.bottomMargin = -((int) (this.cvp * f));
            }
            this.cvo.requestLayout();
        } else if (this.mType == 0) {
            this.cvq.bottomMargin = 0;
            this.cvo.requestLayout();
            this.cvp = this.cvo.getMeasuredHeight();
        } else {
            this.cvq.bottomMargin = -this.cvp;
            this.cvo.setVisibility(8);
            this.cvo.requestLayout();
        }
    }
}
