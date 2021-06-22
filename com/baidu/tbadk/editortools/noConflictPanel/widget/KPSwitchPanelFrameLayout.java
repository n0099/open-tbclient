package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.a.n0.w.v.a;
import d.a.n0.w.v.b;
/* loaded from: classes3.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements b, a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.w.v.c.b f12930e;

    public KPSwitchPanelFrameLayout(Context context) {
        super(context);
        c(null);
    }

    @Override // d.a.n0.w.v.b
    public void a(boolean z) {
        this.f12930e.f(z);
    }

    @Override // d.a.n0.w.v.a
    public boolean b() {
        return this.f12930e.b();
    }

    public final void c(AttributeSet attributeSet) {
        this.f12930e = new d.a.n0.w.v.c.b(this, attributeSet);
    }

    @Override // d.a.n0.w.v.a
    public void handleHide() {
        this.f12930e.handleHide();
    }

    @Override // d.a.n0.w.v.a
    public void handleShow() {
        super.setVisibility(0);
    }

    @Override // d.a.n0.w.v.a
    public boolean isVisible() {
        return this.f12930e.isVisible();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int[] c2 = this.f12930e.c(i2, i3);
        super.onMeasure(c2[0], c2[1]);
    }

    @Override // d.a.n0.w.v.b
    public void refreshHeight(int i2) {
        this.f12930e.d(i2);
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.f12930e.e(z);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (this.f12930e.a(i2)) {
            return;
        }
        super.setVisibility(i2);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(attributeSet);
    }
}
