package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import d.b.i0.b1.c.l;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageOverlayView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f17655e;

    /* renamed from: f  reason: collision with root package name */
    public int f17656f;

    /* renamed from: g  reason: collision with root package name */
    public int f17657g;

    /* renamed from: h  reason: collision with root package name */
    public int f17658h;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public ImageOverlayView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < this.f17655e && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.f17656f + paddingLeft, this.f17657g + paddingTop);
            paddingLeft += this.f17656f - this.f17658h;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = this.f17655e;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f17656f * i3)) - ((i3 - 1) * this.f17658h), i), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f17657g, i2));
    }

    public void setData(List<l> list) {
        HeadImageView headImageView;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < this.f17655e && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
            if (i >= list.size()) {
                headImageView.setVisibility(8);
            } else {
                headImageView.setVisibility(0);
                l lVar = (l) ListUtils.getItem(list, (list.size() - i) - 1);
                if (lVar == null) {
                    return;
                }
                headImageView.setUserId(String.valueOf(lVar.f52132a));
                headImageView.T(lVar.f52133b, 12, this.f17656f, this.f17657g, false);
            }
        }
    }

    public void setImageClickListener(a aVar) {
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
