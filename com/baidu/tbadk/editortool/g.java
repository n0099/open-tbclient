package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private View XR;
    private boolean XS;

    public g(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.XR != null) {
            this.XR.measure(getChildMeasureSpec(i, 0, this.XR.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.XR.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.XR != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.XR.getMeasuredWidth();
            this.XR.layout(measuredWidth, 0, this.XR.getMeasuredWidth() + measuredWidth, this.XR.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.XR = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.XS) {
            canvas.save();
            canvas.translate(this.XR.getLeft(), this.XR.getTop());
            this.XR.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.XS = z;
        invalidate();
    }
}
