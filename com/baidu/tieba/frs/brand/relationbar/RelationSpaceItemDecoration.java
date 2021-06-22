package com.baidu.tieba.frs.brand.relationbar;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class RelationSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f15408a;

    /* renamed from: b  reason: collision with root package name */
    public int f15409b;

    /* renamed from: c  reason: collision with root package name */
    public int f15410c;

    public RelationSpaceItemDecoration(int i2, int i3, int i4) {
        this.f15408a = i2;
        this.f15409b = i3;
        this.f15410c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.f15408a;
            } else {
                rect.top = this.f15409b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.f15410c;
                return;
            }
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.f15408a;
        } else {
            rect.left = this.f15409b;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.f15410c;
        }
    }
}
