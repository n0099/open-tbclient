package com.baidu.tieba.frs.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f16438a;

    /* renamed from: b  reason: collision with root package name */
    public int f16439b;

    /* renamed from: c  reason: collision with root package name */
    public int f16440c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16441d;

    public GridSpacingItemDecoration(int i, int i2, int i3, boolean z) {
        this.f16438a = i;
        this.f16439b = i2;
        this.f16440c = i3;
        this.f16441d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f16438a;
        int i2 = childAdapterPosition % i;
        if (this.f16441d) {
            int i3 = this.f16439b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (childAdapterPosition < i) {
                rect.top = i3;
            }
            rect.bottom = this.f16439b;
            return;
        }
        int i4 = this.f16439b;
        rect.left = (i2 * i4) / i;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (childAdapterPosition >= i) {
            rect.top = this.f16440c;
        }
    }
}
