package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public final class ad extends LinearLayout {
    private View a;
    private boolean b;

    public ad(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null) {
            this.a.measure(getChildMeasureSpec(i, 0, this.a.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.a.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.a != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.a.getMeasuredWidth();
            this.a.layout(measuredWidth, 0, this.a.getMeasuredWidth() + measuredWidth, this.a.getMeasuredHeight());
        }
    }

    public final void setNewView(View view) {
        this.a = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.b) {
            canvas.save();
            canvas.translate(this.a.getLeft(), this.a.getTop());
            this.a.draw(canvas);
            canvas.restore();
        }
    }

    public final void setNewViewVisible(boolean z) {
        this.b = z;
        invalidate();
    }
}
