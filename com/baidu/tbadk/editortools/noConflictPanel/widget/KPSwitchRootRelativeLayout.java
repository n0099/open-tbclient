package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import d.a.j0.w.v.c.c;
/* loaded from: classes3.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f12878e;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f12878e = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        this.f12878e.b(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
