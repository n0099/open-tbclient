package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private View ahU;
    private boolean ahV;

    public c(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ahU != null) {
            this.ahU.measure(getChildMeasureSpec(i, 0, this.ahU.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.ahU.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.ahU != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.ahU.getMeasuredWidth();
            this.ahU.layout(measuredWidth, 0, this.ahU.getMeasuredWidth() + measuredWidth, this.ahU.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.ahU = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ahV) {
            canvas.save();
            canvas.translate(this.ahU.getLeft(), this.ahU.getTop());
            this.ahU.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.ahV = z;
        invalidate();
    }
}
