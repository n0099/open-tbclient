package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class AutoLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12703e;

    /* renamed from: f  reason: collision with root package name */
    public int f12704f;

    /* renamed from: g  reason: collision with root package name */
    public int f12705g;

    /* renamed from: h  reason: collision with root package name */
    public int f12706h;

    /* renamed from: i  reason: collision with root package name */
    public int f12707i;
    public int j;
    public int k;
    public int l;

    public AutoLinearLayout(Context context) {
        super(context);
        this.f12704f = 0;
        this.f12705g = 0;
        this.f12706h = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f12703e = context;
        setOrientation(0);
        this.f12705g = l.g(context, R.dimen.ds24);
        this.f12706h = l.g(context, R.dimen.ds20);
        this.k = l.g(context, R.dimen.ds32);
        this.f12707i = l.k(this.f12703e) - (this.k * 2);
        this.l = (int) this.f12703e.getResources().getDimension(R.dimen.ds60);
    }

    private int getCulumnsCount() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
        int childCount = getChildCount();
        int i2 = this.f12707i;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = childAt.getMeasuredWidth();
                if (i2 < measuredWidth) {
                    i3++;
                    if (i3 == 1) {
                        this.j = i5;
                    }
                    i4 = measuredWidth + this.f12706h + 0;
                } else {
                    i4 += measuredWidth + this.f12706h;
                }
                i2 = this.f12707i - i4;
            }
        }
        return i3 + 1;
    }

    public final void a(int i2) {
        int i3 = this.j;
        if (i3 > i2) {
            return;
        }
        removeViews(i3, i2 - i3);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int dimension = (int) this.f12703e.getResources().getDimension(R.dimen.ds24);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i6 != 0 && i7 < measuredWidth) {
                    dimension += this.f12705g + measuredHeight;
                    i6 = 0;
                }
                childAt.layout(i6, dimension, i6 + measuredWidth, measuredHeight + dimension);
                int i9 = this.f12706h;
                i7 = (((i4 - i2) - i6) - measuredWidth) - i9;
                i6 += measuredWidth + i9;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.l, 1073741824);
        int childCount = getChildCount();
        int culumnsCount = getCulumnsCount();
        if (this.f12704f != 0 && this.j != 0) {
            a(childCount);
        }
        if (this.f12704f != 0) {
            for (int i4 = 0; i4 < this.j; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
            this.j = 0;
        } else {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2 != null) {
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                }
            }
        }
        if (this.f12704f != 0) {
            setMeasuredDimension(LinearLayout.resolveSize(0, i2), LinearLayout.resolveSize((this.l * this.f12704f) + this.f12705g, i3));
        } else {
            setMeasuredDimension(LinearLayout.resolveSize(0, i2), LinearLayout.resolveSize((this.l * culumnsCount) + (culumnsCount * this.f12705g), i3));
        }
    }

    public void setCellHeight(int i2) {
        this.l = i2;
    }

    public void setMarginRight(int i2) {
        this.f12706h = i2;
    }

    public void setParentWidth(int i2) {
        this.f12707i = i2;
    }

    public void setShowColumns(int i2) {
        this.f12704f = i2;
    }

    public AutoLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12704f = 0;
        this.f12705g = 0;
        this.f12706h = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f12703e = context;
        setOrientation(0);
        this.f12705g = l.g(context, R.dimen.ds24);
        this.f12706h = l.g(context, R.dimen.ds20);
        this.k = l.g(context, R.dimen.ds32);
        this.f12707i = l.k(this.f12703e) - (this.k * 2);
        this.l = (int) this.f12703e.getResources().getDimension(R.dimen.ds60);
    }
}
