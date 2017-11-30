package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cYo;
    private int cYp;
    private LinearLayout.LayoutParams cYq;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cYo = view;
            if (this.cYo.getVisibility() == 8 && i2 > 0) {
                this.cYp = i2;
            } else {
                this.cYp = this.cYo.getMeasuredHeight();
            }
            this.cYq = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cYq.bottomMargin = -this.cYp;
                return;
            }
            this.cYq.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cYq.bottomMargin = (-this.cYp) + ((int) (this.cYp * f));
            } else {
                this.cYq.bottomMargin = -((int) (this.cYp * f));
            }
            this.cYo.requestLayout();
        } else if (this.mType == 0) {
            this.cYq.bottomMargin = 0;
            this.cYo.requestLayout();
            this.cYp = this.cYo.getMeasuredHeight();
        } else {
            this.cYq.bottomMargin = -this.cYp;
            this.cYo.setVisibility(8);
            this.cYo.requestLayout();
        }
    }
}
