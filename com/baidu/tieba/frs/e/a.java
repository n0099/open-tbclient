package com.baidu.tieba.frs.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends Animation {
    private View cFs;
    private int cFt;
    private LinearLayout.LayoutParams cFu;
    private int mType;

    public a(View view, int i, int i2) {
        if (view != null) {
            this.cFs = view;
            if (this.cFs.getVisibility() == 8 && i2 > 0) {
                this.cFt = i2;
            } else {
                this.cFt = this.cFs.getMeasuredHeight();
            }
            this.cFu = (LinearLayout.LayoutParams) view.getLayoutParams();
            this.mType = i;
            if (this.mType == 0) {
                this.cFu.bottomMargin = -this.cFt;
                return;
            }
            this.cFu.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (f < 1.0f) {
            if (this.mType == 0) {
                this.cFu.bottomMargin = (-this.cFt) + ((int) (this.cFt * f));
            } else {
                this.cFu.bottomMargin = -((int) (this.cFt * f));
            }
            this.cFs.requestLayout();
        } else if (this.mType == 0) {
            this.cFu.bottomMargin = 0;
            this.cFs.requestLayout();
            this.cFt = this.cFs.getMeasuredHeight();
        } else {
            this.cFu.bottomMargin = -this.cFt;
            this.cFs.setVisibility(8);
            this.cFs.requestLayout();
        }
    }
}
