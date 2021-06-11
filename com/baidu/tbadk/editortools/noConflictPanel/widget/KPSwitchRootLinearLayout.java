package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import d.a.m0.w.v.c.c;
/* loaded from: classes3.dex */
public class KPSwitchRootLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public c f12850e;

    public KPSwitchRootLinearLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f12850e = new c(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        this.f12850e.b(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    @TargetApi(11)
    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
