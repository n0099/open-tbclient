package com.baidu.tieba.frs.brand.relationbar;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes6.dex */
public class c extends RecyclerView.ItemDecoration {
    private int dOA;
    private int dOB;
    private int mEnd;

    public c(int i, int i2, int i3) {
        this.dOA = i;
        this.dOB = i2;
        this.mEnd = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.dOA;
            } else {
                rect.top = this.dOB;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.mEnd;
                return;
            }
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.dOA;
        } else {
            rect.left = this.dOB;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.mEnd;
        }
    }
}
