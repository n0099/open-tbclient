package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class AutoLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13387e;

    /* renamed from: f  reason: collision with root package name */
    public int f13388f;

    /* renamed from: g  reason: collision with root package name */
    public int f13389g;

    /* renamed from: h  reason: collision with root package name */
    public int f13390h;
    public int i;
    public int j;
    public int k;
    public int l;

    public AutoLinearLayout(Context context) {
        super(context);
        this.f13388f = 0;
        this.f13389g = 0;
        this.f13390h = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f13387e = context;
        setOrientation(0);
        this.f13389g = l.g(context, R.dimen.ds24);
        this.f13390h = l.g(context, R.dimen.ds20);
        this.k = l.g(context, R.dimen.ds32);
        this.i = l.k(this.f13387e) - (this.k * 2);
        this.l = (int) this.f13387e.getResources().getDimension(R.dimen.ds60);
    }

    private int getCulumnsCount() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
        int childCount = getChildCount();
        int i = this.i;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null) {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (i < measuredWidth) {
                    i2++;
                    if (i2 == 1) {
                        this.j = i4;
                    }
                    i3 = measuredWidth + this.f13390h + 0;
                } else {
                    i3 += measuredWidth + this.f13390h;
                }
                i = this.i - i3;
            }
        }
        return i2 + 1;
    }

    public final void a(int i) {
        int i2 = this.j;
        if (i2 > i) {
            return;
        }
        removeViews(i2, i - i2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int dimension = (int) this.f13387e.getResources().getDimension(R.dimen.ds24);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i5 != 0 && i6 < measuredWidth) {
                    dimension += this.f13389g + measuredHeight;
                    i5 = 0;
                }
                childAt.layout(i5, dimension, i5 + measuredWidth, measuredHeight + dimension);
                int i8 = this.f13390h;
                i6 = (((i3 - i) - i5) - measuredWidth) - i8;
                i5 += measuredWidth + i8;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.f13388f != 0 && this.j != 0) {
            a(childCount);
        }
        if (this.f13388f != 0) {
            for (int i3 = 0; i3 < this.j; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.j = 0;
        } else {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.f13388f != 0) {
            setMeasuredDimension(LinearLayout.resolveSize(0, i), LinearLayout.resolveSize((this.l * this.f13388f) + this.f13389g, i2));
        } else {
            setMeasuredDimension(LinearLayout.resolveSize(0, i), LinearLayout.resolveSize((this.l * culumnsCount) + (culumnsCount * this.f13389g), i2));
        }
    }

    public void setCellHeight(int i) {
        this.l = i;
    }

    public void setMarginRight(int i) {
        this.f13390h = i;
    }

    public void setParentWidth(int i) {
        this.i = i;
    }

    public void setShowColumns(int i) {
        this.f13388f = i;
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13388f = 0;
        this.f13389g = 0;
        this.f13390h = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f13387e = context;
        setOrientation(0);
        this.f13389g = l.g(context, R.dimen.ds24);
        this.f13390h = l.g(context, R.dimen.ds20);
        this.k = l.g(context, R.dimen.ds32);
        this.i = l.k(this.f13387e) - (this.k * 2);
        this.l = (int) this.f13387e.getResources().getDimension(R.dimen.ds60);
    }
}
