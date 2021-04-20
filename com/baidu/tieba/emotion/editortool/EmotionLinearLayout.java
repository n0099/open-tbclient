package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes4.dex */
public class EmotionLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f14979e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14980f;

    public EmotionLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f14980f) {
            canvas.save();
            canvas.translate(this.f14979e.getLeft(), this.f14979e.getTop());
            this.f14979e.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.f14979e == null || childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth() - this.f14979e.getMeasuredWidth();
        View view = this.f14979e;
        view.layout(measuredWidth, 0, view.getMeasuredWidth() + measuredWidth, this.f14979e.getMeasuredHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f14979e;
        if (view != null) {
            this.f14979e.measure(LinearLayout.getChildMeasureSpec(i, 0, view.getLayoutParams().width), LinearLayout.getChildMeasureSpec(i2, 0, this.f14979e.getLayoutParams().height));
        }
    }

    public void setNewView(View view) {
        this.f14979e = view;
    }

    public void setNewViewVisible(boolean z) {
        this.f14980f = z;
        invalidate();
    }

    public EmotionLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
