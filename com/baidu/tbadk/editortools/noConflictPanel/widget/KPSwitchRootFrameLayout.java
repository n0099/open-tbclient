package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import d.a.m0.w.v.c.c;
/* loaded from: classes3.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f12849e;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f12849e = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        this.f12849e.b(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
