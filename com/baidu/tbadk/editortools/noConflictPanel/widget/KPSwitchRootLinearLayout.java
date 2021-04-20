package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import d.b.h0.w.v.c.c;
/* loaded from: classes3.dex */
public class KPSwitchRootLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f13541e;

    public KPSwitchRootLinearLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f13541e = new c(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.f13541e.b(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    @TargetApi(11)
    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
