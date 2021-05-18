package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import d.a.j0.b1.j.e;
/* loaded from: classes3.dex */
public class ObservedChangeRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public e f13262e;

    public ObservedChangeRelativeLayout(Context context) {
        super(context);
    }

    public e getOnSizeChangeListener() {
        return this.f13262e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        e eVar = this.f13262e;
        if (eVar != null) {
            eVar.a(this, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setOnSizeChangeListener(e eVar) {
        this.f13262e = eVar;
    }

    public ObservedChangeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
