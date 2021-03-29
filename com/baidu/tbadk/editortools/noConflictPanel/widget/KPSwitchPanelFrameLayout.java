package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.b.h0.w.v.a;
import d.b.h0.w.v.b;
/* loaded from: classes3.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements b, a {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.w.v.c.b f13878e;

    public KPSwitchPanelFrameLayout(Context context) {
        super(context);
        c(null);
    }

    @Override // d.b.h0.w.v.b
    public void a(boolean z) {
        this.f13878e.f(z);
    }

    @Override // d.b.h0.w.v.a
    public boolean b() {
        return this.f13878e.b();
    }

    public final void c(AttributeSet attributeSet) {
        this.f13878e = new d.b.h0.w.v.c.b(this, attributeSet);
    }

    @Override // d.b.h0.w.v.a
    public void handleHide() {
        this.f13878e.handleHide();
    }

    @Override // d.b.h0.w.v.a
    public void handleShow() {
        super.setVisibility(0);
    }

    @Override // d.b.h0.w.v.a
    public boolean isVisible() {
        return this.f13878e.isVisible();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int[] c2 = this.f13878e.c(i, i2);
        super.onMeasure(c2[0], c2[1]);
    }

    @Override // d.b.h0.w.v.b
    public void refreshHeight(int i) {
        this.f13878e.d(i);
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.f13878e.e(z);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f13878e.a(i)) {
            return;
        }
        super.setVisibility(i);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(attributeSet);
    }
}
