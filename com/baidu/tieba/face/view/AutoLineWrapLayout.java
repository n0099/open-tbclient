package com.baidu.tieba.face.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class AutoLineWrapLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f14583e;

    public AutoLineWrapLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f14583e = l.g(getContext(), R.dimen.ds20);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = i2;
        int i8 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i7 = i6 == 0 ? i7 + measuredWidth : i7 + this.f14583e + measuredWidth;
            int i9 = this.f14583e;
            int i10 = ((measuredHeight + i9) * i8) + i9 + measuredHeight + i3;
            if (i7 > i4) {
                i7 = measuredWidth + i2;
                i8++;
                i10 = ((measuredHeight + i9) * i8) + i9 + measuredHeight + i3;
            }
            childAt.layout(i7 - measuredWidth, i10 - measuredHeight, i7, i10);
            i6++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).measure(0, 0);
        }
        super.onMeasure(i2, i3);
    }

    public AutoLineWrapLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public AutoLineWrapLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
