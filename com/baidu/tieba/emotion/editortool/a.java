package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private View bvH;
    private boolean visible;

    public a(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.bvH != null) {
            this.bvH.measure(getChildMeasureSpec(i, 0, this.bvH.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.bvH.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.bvH != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.bvH.getMeasuredWidth();
            this.bvH.layout(measuredWidth, 0, this.bvH.getMeasuredWidth() + measuredWidth, this.bvH.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.bvH = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.bvH.getLeft(), this.bvH.getTop());
            this.bvH.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
