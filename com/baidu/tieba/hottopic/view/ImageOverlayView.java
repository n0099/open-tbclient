package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import d.a.k0.c1.c.l;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageOverlayView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f16957e;

    /* renamed from: f  reason: collision with root package name */
    public int f16958f;

    /* renamed from: g  reason: collision with root package name */
    public int f16959g;

    /* renamed from: h  reason: collision with root package name */
    public int f16960h;

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
        for (int i6 = 0; i6 < this.f16957e && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            childAt.layout(paddingLeft, paddingTop, this.f16958f + paddingLeft, this.f16959g + paddingTop);
            paddingLeft += this.f16958f - this.f16960h;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i4 = this.f16957e;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f16958f * i4)) - ((i4 - 1) * this.f16960h), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f16959g, i3));
    }

    public void setData(List<l> list) {
        HeadImageView headImageView;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = 0; i2 < this.f16957e && (headImageView = (HeadImageView) getChildAt(i2)) != null; i2++) {
            if (i2 >= list.size()) {
                headImageView.setVisibility(8);
            } else {
                headImageView.setVisibility(0);
                l lVar = (l) ListUtils.getItem(list, (list.size() - i2) - 1);
                if (lVar == null) {
                    return;
                }
                headImageView.setUserId(String.valueOf(lVar.f52416a));
                headImageView.R(lVar.f52417b, 12, this.f16958f, this.f16959g, false);
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
