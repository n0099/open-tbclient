package com.baidu.tieba.frs.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f16768a;

    /* renamed from: b  reason: collision with root package name */
    public int f16769b;

    /* renamed from: c  reason: collision with root package name */
    public int f16770c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16771d;

    public GridSpacingItemDecoration(int i, int i2, int i3, boolean z) {
        this.f16768a = i;
        this.f16769b = i2;
        this.f16770c = i3;
        this.f16771d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f16768a;
        int i2 = childAdapterPosition % i;
        if (this.f16771d) {
            int i3 = this.f16769b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (childAdapterPosition < i) {
                rect.top = i3;
            }
            rect.bottom = this.f16769b;
            return;
        }
        int i4 = this.f16769b;
        rect.left = (i2 * i4) / i;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (childAdapterPosition >= i) {
            rect.top = this.f16770c;
        }
    }
}
