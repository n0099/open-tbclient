package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private View XU;
    private boolean XV;

    public g(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.XU != null) {
            this.XU.measure(getChildMeasureSpec(i, 0, this.XU.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.XU.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.XU != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.XU.getMeasuredWidth();
            this.XU.layout(measuredWidth, 0, this.XU.getMeasuredWidth() + measuredWidth, this.XU.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.XU = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.XV) {
            canvas.save();
            canvas.translate(this.XU.getLeft(), this.XU.getTop());
            this.XU.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.XV = z;
        invalidate();
    }
}
