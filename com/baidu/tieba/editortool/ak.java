package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ak extends LinearLayout {
    private View Rr;
    private boolean Rs;

    public ak(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Rr != null) {
            this.Rr.measure(getChildMeasureSpec(i, 0, this.Rr.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.Rr.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.Rr != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.Rr.getMeasuredWidth();
            this.Rr.layout(measuredWidth, 0, this.Rr.getMeasuredWidth() + measuredWidth, this.Rr.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.Rr = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Rs) {
            canvas.save();
            canvas.translate(this.Rr.getLeft(), this.Rr.getTop());
            this.Rr.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.Rs = z;
        invalidate();
    }
}
