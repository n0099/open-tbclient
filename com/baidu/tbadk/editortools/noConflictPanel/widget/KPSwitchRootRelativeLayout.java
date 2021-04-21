package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import d.b.i0.w.v.c.c;
/* loaded from: classes3.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f13550e;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f13550e = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.f13550e.b(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
