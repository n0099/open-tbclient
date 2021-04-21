package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class FlowLabelLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f13867e;

    /* renamed from: f  reason: collision with root package name */
    public int f13868f;

    public FlowLabelLayout(Context context) {
        super(context);
        this.f13867e = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f13868f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    public int getHorizontalSpacing() {
        return this.f13868f;
    }

    public int getVerticalSpacing() {
        return this.f13867e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (childAt.getMeasuredWidth() + i6 + paddingRight > i5) {
                    paddingTop += childAt.getMeasuredHeight() + this.f13867e;
                    i6 = paddingLeft;
                }
                if (childAt.getVisibility() != 8) {
                    childAt.layout(i6, paddingTop, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingTop);
                    i6 += childAt.getMeasuredWidth() + this.f13868f;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        int i3 = paddingLeft;
        int i4 = paddingTop;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            i4 = Math.max(childAt.getMeasuredHeight() + paddingTop, i4);
            if (childAt.getMeasuredWidth() + i3 + paddingRight > size) {
                i4 += childAt.getMeasuredHeight() + this.f13867e;
                i3 = paddingLeft;
            }
            i3 += childAt.getMeasuredWidth() + this.f13868f;
        }
        setMeasuredDimension(size, i4 + paddingBottom);
    }

    public void setHorizontalSpacing(int i) {
        this.f13868f = i;
    }

    public void setVerticalSpacing(int i) {
        this.f13867e = i;
    }

    public FlowLabelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13867e = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f13868f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    public FlowLabelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13867e = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f13868f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }
}
