package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class DeskLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f12840e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12841f;

    public DeskLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f12841f) {
            canvas.save();
            canvas.translate(this.f12840e.getLeft(), this.f12840e.getTop());
            this.f12840e.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View childAt = getChildAt(0);
        if (this.f12840e == null || childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth() - this.f12840e.getMeasuredWidth();
        View view = this.f12840e;
        view.layout(measuredWidth, 0, view.getMeasuredWidth() + measuredWidth, this.f12840e.getMeasuredHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f12840e;
        if (view != null) {
            this.f12840e.measure(LinearLayout.getChildMeasureSpec(i2, 0, view.getLayoutParams().width), LinearLayout.getChildMeasureSpec(i3, 0, this.f12840e.getLayoutParams().height));
        }
    }

    public void setNewView(View view) {
        this.f12840e = view;
    }

    public void setNewViewVisible(boolean z) {
        this.f12841f = z;
        invalidate();
    }

    public DeskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
