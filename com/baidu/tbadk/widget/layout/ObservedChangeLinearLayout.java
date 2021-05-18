package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import d.a.j0.b1.j.e;
/* loaded from: classes3.dex */
public class ObservedChangeLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public e f13261e;

    public ObservedChangeLinearLayout(Context context) {
        super(context);
    }

    public e getOnSizeChangeListener() {
        return this.f13261e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        e eVar = this.f13261e;
        if (eVar != null) {
            eVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setOnSizeChangeListener(e eVar) {
        this.f13261e = eVar;
    }

    public ObservedChangeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
