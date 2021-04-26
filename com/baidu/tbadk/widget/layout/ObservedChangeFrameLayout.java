package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.a.i0.b1.j.e;
/* loaded from: classes3.dex */
public class ObservedChangeFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public e f13924e;

    public ObservedChangeFrameLayout(Context context) {
        super(context);
    }

    public e getOnSizeChangeListener() {
        return this.f13924e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        e eVar = this.f13924e;
        if (eVar != null) {
            eVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setOnSizeChangeListener(e eVar) {
        this.f13924e = eVar;
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservedChangeFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
