package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class FlowLabelLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f13888e;

    /* renamed from: f  reason: collision with root package name */
    public int f13889f;

    public FlowLabelLayout(Context context) {
        super(context);
        this.f13888e = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f13889f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    public int getHorizontalSpacing() {
        return this.f13889f;
    }

    public int getVerticalSpacing() {
        return this.f13888e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i7 = paddingLeft;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (childAt.getMeasuredWidth() + i7 + paddingRight > i6) {
                    paddingTop += childAt.getMeasuredHeight() + this.f13888e;
                    i7 = paddingLeft;
                }
                if (childAt.getVisibility() != 8) {
                    childAt.layout(i7, paddingTop, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + paddingTop);
                    i7 += childAt.getMeasuredWidth() + this.f13889f;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        measureChildren(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        int i4 = paddingLeft;
        int i5 = paddingTop;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            i5 = Math.max(childAt.getMeasuredHeight() + paddingTop, i5);
            if (childAt.getMeasuredWidth() + i4 + paddingRight > size) {
                i5 += childAt.getMeasuredHeight() + this.f13888e;
                i4 = paddingLeft;
            }
            i4 += childAt.getMeasuredWidth() + this.f13889f;
        }
        setMeasuredDimension(size, i5 + paddingBottom);
    }

    public void setHorizontalSpacing(int i2) {
        this.f13889f = i2;
    }

    public void setVerticalSpacing(int i2) {
        this.f13888e = i2;
    }

    public FlowLabelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13888e = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f13889f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }

    public FlowLabelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13888e = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X008);
        this.f13889f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
    }
}
