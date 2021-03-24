package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class DeskLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f13929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13930f;

    public DeskLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f13930f) {
            canvas.save();
            canvas.translate(this.f13929e.getLeft(), this.f13929e.getTop());
            this.f13929e.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.f13929e == null || childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth() - this.f13929e.getMeasuredWidth();
        View view = this.f13929e;
        view.layout(measuredWidth, 0, view.getMeasuredWidth() + measuredWidth, this.f13929e.getMeasuredHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f13929e;
        if (view != null) {
            this.f13929e.measure(LinearLayout.getChildMeasureSpec(i, 0, view.getLayoutParams().width), LinearLayout.getChildMeasureSpec(i2, 0, this.f13929e.getLayoutParams().height));
        }
    }

    public void setNewView(View view) {
        this.f13929e = view;
    }

    public void setNewViewVisible(boolean z) {
        this.f13930f = z;
        invalidate();
    }

    public DeskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
