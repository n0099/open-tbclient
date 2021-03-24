package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.b.h0.b1.j.e;
/* loaded from: classes3.dex */
public class ObservedChangeFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public e f14215e;

    public ObservedChangeFrameLayout(Context context) {
        super(context);
    }

    public e getOnSizeChangeListener() {
        return this.f14215e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        e eVar = this.f14215e;
        if (eVar != null) {
            eVar.a(this, i, i2, i3, i4);
        }
    }

    public void setOnSizeChangeListener(e eVar) {
        this.f14215e = eVar;
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
