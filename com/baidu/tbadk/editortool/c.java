package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private View ajc;
    private boolean ajd;

    public c(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ajc != null) {
            this.ajc.measure(getChildMeasureSpec(i, 0, this.ajc.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.ajc.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.ajc != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.ajc.getMeasuredWidth();
            this.ajc.layout(measuredWidth, 0, this.ajc.getMeasuredWidth() + measuredWidth, this.ajc.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.ajc = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ajd) {
            canvas.save();
            canvas.translate(this.ajc.getLeft(), this.ajc.getTop());
            this.ajc.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.ajd = z;
        invalidate();
    }
}
