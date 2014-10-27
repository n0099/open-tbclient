package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private View Rn;
    private boolean Ro;

    public g(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Rn != null) {
            this.Rn.measure(getChildMeasureSpec(i, 0, this.Rn.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.Rn.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.Rn != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.Rn.getMeasuredWidth();
            this.Rn.layout(measuredWidth, 0, this.Rn.getMeasuredWidth() + measuredWidth, this.Rn.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.Rn = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Ro) {
            canvas.save();
            canvas.translate(this.Rn.getLeft(), this.Rn.getTop());
            this.Rn.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.Ro = z;
        invalidate();
    }
}
