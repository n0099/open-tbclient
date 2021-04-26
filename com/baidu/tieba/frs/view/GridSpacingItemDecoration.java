package com.baidu.tieba.frs.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f16672a;

    /* renamed from: b  reason: collision with root package name */
    public int f16673b;

    /* renamed from: c  reason: collision with root package name */
    public int f16674c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16675d;

    public GridSpacingItemDecoration(int i2, int i3, int i4, boolean z) {
        this.f16672a = i2;
        this.f16673b = i3;
        this.f16674c = i4;
        this.f16675d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.f16672a;
        int i3 = childAdapterPosition % i2;
        if (this.f16675d) {
            int i4 = this.f16673b;
            rect.left = i4 - ((i3 * i4) / i2);
            rect.right = ((i3 + 1) * i4) / i2;
            if (childAdapterPosition < i2) {
                rect.top = i4;
            }
            rect.bottom = this.f16673b;
            return;
        }
        int i5 = this.f16673b;
        rect.left = (i3 * i5) / i2;
        rect.right = i5 - (((i3 + 1) * i5) / i2);
        if (childAdapterPosition >= i2) {
            rect.top = this.f16674c;
        }
    }
}
