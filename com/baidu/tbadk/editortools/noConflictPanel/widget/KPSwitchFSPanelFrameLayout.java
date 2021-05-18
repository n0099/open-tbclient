package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.a.j0.w.v.b;
import d.a.j0.w.v.c.a;
import d.a.j0.w.v.d.d;
/* loaded from: classes3.dex */
public class KPSwitchFSPanelFrameLayout extends FrameLayout implements b {

    /* renamed from: e  reason: collision with root package name */
    public a f12874e;

    public KPSwitchFSPanelFrameLayout(Context context) {
        super(context);
        b();
    }

    @Override // d.a.j0.w.v.b
    public void a(boolean z) {
        this.f12874e.a(z);
    }

    public final void b() {
        this.f12874e = new a(this);
    }

    @Override // d.a.j0.w.v.b
    public void refreshHeight(int i2) {
        d.d(this, i2);
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
