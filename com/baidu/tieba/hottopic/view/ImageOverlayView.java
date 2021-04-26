package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import d.a.j0.c1.c.l;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageOverlayView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f17642e;

    /* renamed from: f  reason: collision with root package name */
    public int f17643f;

    /* renamed from: g  reason: collision with root package name */
    public int f17644g;

    /* renamed from: h  reason: collision with root package name */
    public int f17645h;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public ImageOverlayView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < this.f17642e && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            childAt.layout(paddingLeft, paddingTop, this.f17643f + paddingLeft, this.f17644g + paddingTop);
            paddingLeft += this.f17643f - this.f17645h;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i4 = this.f17642e;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f17643f * i4)) - ((i4 - 1) * this.f17645h), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f17644g, i3));
    }

    public void setData(List<l> list) {
        HeadImageView headImageView;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = 0; i2 < this.f17642e && (headImageView = (HeadImageView) getChildAt(i2)) != null; i2++) {
            if (i2 >= list.size()) {
                headImageView.setVisibility(8);
            } else {
                headImageView.setVisibility(0);
                l lVar = (l) ListUtils.getItem(list, (list.size() - i2) - 1);
                if (lVar == null) {
                    return;
                }
                headImageView.setUserId(String.valueOf(lVar.f51717a));
                headImageView.R(lVar.f51718b, 12, this.f17643f, this.f17644g, false);
            }
        }
    }

    public void setImageClickListener(a aVar) {
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
