package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import d.b.h0.b1.j.e;
/* loaded from: classes3.dex */
public class ObservedChangeLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public e f13893e;

    public ObservedChangeLinearLayout(Context context) {
        super(context);
    }

    public e getOnSizeChangeListener() {
        return this.f13893e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        e eVar = this.f13893e;
        if (eVar != null) {
            eVar.a(this, i, i2, i3, i4);
        }
    }

    public void setOnSizeChangeListener(e eVar) {
        this.f13893e = eVar;
    }

    public ObservedChangeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
