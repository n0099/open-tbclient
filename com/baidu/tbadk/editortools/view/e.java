package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private View aqW;
    private boolean aqX;

    public e(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aqW != null) {
            this.aqW.measure(getChildMeasureSpec(i, 0, this.aqW.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.aqW.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.aqW != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.aqW.getMeasuredWidth();
            this.aqW.layout(measuredWidth, 0, this.aqW.getMeasuredWidth() + measuredWidth, this.aqW.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.aqW = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aqX) {
            canvas.save();
            canvas.translate(this.aqW.getLeft(), this.aqW.getTop());
            this.aqW.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.aqX = z;
        invalidate();
    }
}
