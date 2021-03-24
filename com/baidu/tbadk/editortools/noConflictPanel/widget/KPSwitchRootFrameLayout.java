package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import d.b.h0.w.v.c.c;
/* loaded from: classes3.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f13878e;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f13878e = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.f13878e.b(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
