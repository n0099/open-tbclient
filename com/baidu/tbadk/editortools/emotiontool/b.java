package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private View apy;
    private boolean visible;

    public b(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.apy != null) {
            this.apy.measure(getChildMeasureSpec(i, 0, this.apy.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.apy.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.apy != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.apy.getMeasuredWidth();
            this.apy.layout(measuredWidth, 0, this.apy.getMeasuredWidth() + measuredWidth, this.apy.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.apy = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.apy.getLeft(), this.apy.getTop());
            this.apy.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
