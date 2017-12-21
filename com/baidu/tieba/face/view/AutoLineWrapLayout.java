package com.baidu.tieba.face.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class AutoLineWrapLayout extends ViewGroup {
    private int bin;

    public AutoLineWrapLayout(Context context) {
        super(context);
        init();
    }

    public AutoLineWrapLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AutoLineWrapLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.bin = l.f(getContext(), d.e.ds20);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(0, 0);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i9 == 0) {
                i5 = i7 + measuredWidth;
            } else {
                i5 = this.bin + measuredWidth + i7;
            }
            int i10 = ((this.bin + measuredHeight) * i8) + this.bin + measuredHeight + i2;
            if (i5 > i3) {
                i7 = measuredWidth + i;
                i8++;
                i6 = ((this.bin + measuredHeight) * i8) + this.bin + measuredHeight + i2;
            } else {
                i7 = i5;
                i6 = i10;
            }
            childAt.layout(i7 - measuredWidth, i6 - measuredHeight, i7, i6);
        }
    }
}
