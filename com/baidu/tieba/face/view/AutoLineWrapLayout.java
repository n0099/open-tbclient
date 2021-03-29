package com.baidu.tieba.face.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class AutoLineWrapLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f15556e;

    public AutoLineWrapLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f15556e = l.g(getContext(), R.dimen.ds20);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = i;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i6 = i5 == 0 ? i6 + measuredWidth : i6 + this.f15556e + measuredWidth;
            int i8 = this.f15556e;
            int i9 = ((measuredHeight + i8) * i7) + i8 + measuredHeight + i2;
            if (i6 > i3) {
                i6 = measuredWidth + i;
                i7++;
                i9 = ((measuredHeight + i8) * i7) + i8 + measuredHeight + i2;
            }
            childAt.layout(i6 - measuredWidth, i9 - measuredHeight, i6, i9);
            i5++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(0, 0);
        }
        super.onMeasure(i, i2);
    }

    public AutoLineWrapLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public AutoLineWrapLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
