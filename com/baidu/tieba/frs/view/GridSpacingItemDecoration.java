package com.baidu.tieba.frs.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int hSpacing;
    private boolean jTK;
    private int spanCount;
    private int vSpacing;

    public GridSpacingItemDecoration(int i, int i2, int i3, boolean z) {
        this.spanCount = i;
        this.vSpacing = i2;
        this.hSpacing = i3;
        this.jTK = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.spanCount;
        if (this.jTK) {
            rect.left = this.vSpacing - ((this.vSpacing * i) / this.spanCount);
            rect.right = ((i + 1) * this.vSpacing) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                rect.top = this.vSpacing;
            }
            rect.bottom = this.vSpacing;
            return;
        }
        rect.left = (this.vSpacing * i) / this.spanCount;
        rect.right = this.vSpacing - (((i + 1) * this.vSpacing) / this.spanCount);
        if (childAdapterPosition >= this.spanCount) {
            rect.top = this.hSpacing;
        }
    }
}
