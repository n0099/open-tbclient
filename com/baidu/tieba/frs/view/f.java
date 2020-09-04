package com.baidu.tieba.frs.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes16.dex */
public class f extends RecyclerView.ItemDecoration {
    private int hSpacing;
    private boolean iAd;
    private int spanCount;
    private int vSpacing;

    public f(int i, int i2, int i3, boolean z) {
        this.spanCount = i;
        this.vSpacing = i2;
        this.hSpacing = i3;
        this.iAd = z;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.spanCount;
        if (this.iAd) {
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
