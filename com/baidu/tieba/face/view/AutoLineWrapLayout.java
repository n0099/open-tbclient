package com.baidu.tieba.face.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AutoLineWrapLayout extends ViewGroup {
    private int iSK;

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
        this.iSK = l.getDimens(getContext(), R.dimen.ds20);
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
        int childCount = getChildCount();
        int i6 = i;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i8 == 0) {
                i5 = i6 + measuredWidth;
            } else {
                i5 = this.iSK + measuredWidth + i6;
            }
            int i9 = ((this.iSK + measuredHeight) * i7) + this.iSK + measuredHeight + i2;
            if (i5 > i3) {
                i6 = measuredWidth + i;
                i7++;
                i9 = ((this.iSK + measuredHeight) * i7) + this.iSK + measuredHeight + i2;
            } else {
                i6 = i5;
            }
            childAt.layout(i6 - measuredWidth, i9 - measuredHeight, i6, i9);
        }
    }
}
