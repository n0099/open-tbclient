package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private View bvu;
    private boolean visible;

    public c(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.bvu != null) {
            this.bvu.measure(getChildMeasureSpec(i, 0, this.bvu.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.bvu.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.bvu != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.bvu.getMeasuredWidth();
            this.bvu.layout(measuredWidth, 0, this.bvu.getMeasuredWidth() + measuredWidth, this.bvu.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.bvu = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.visible) {
            canvas.save();
            canvas.translate(this.bvu.getLeft(), this.bvu.getTop());
            this.bvu.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.visible = z;
        invalidate();
    }
}
