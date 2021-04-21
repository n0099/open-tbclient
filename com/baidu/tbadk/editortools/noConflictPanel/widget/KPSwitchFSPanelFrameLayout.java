package com.baidu.tbadk.editortools.noConflictPanel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.b.i0.w.v.b;
import d.b.i0.w.v.c.a;
import d.b.i0.w.v.d.d;
/* loaded from: classes3.dex */
public class KPSwitchFSPanelFrameLayout extends FrameLayout implements b {

    /* renamed from: e  reason: collision with root package name */
    public a f13546e;

    public KPSwitchFSPanelFrameLayout(Context context) {
        super(context);
        b();
    }

    @Override // d.b.i0.w.v.b
    public void a(boolean z) {
        this.f13546e.a(z);
    }

    public final void b() {
        this.f13546e = new a(this);
    }

    @Override // d.b.i0.w.v.b
    public void refreshHeight(int i) {
        d.d(this, i);
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
