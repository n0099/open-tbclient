package com.baidu.tieba.homepage.personalize.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class CommonSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f17242a;

    /* renamed from: b  reason: collision with root package name */
    public int f17243b;

    /* renamed from: c  reason: collision with root package name */
    public int f17244c;

    public CommonSpaceItemDecoration(int i2, int i3, int i4) {
        this.f17242a = i2;
        this.f17243b = i3;
        this.f17244c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.f17242a;
            } else {
                rect.top = this.f17243b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.f17244c;
                return;
            }
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.f17242a;
        } else {
            rect.left = this.f17243b;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.f17244c;
        }
    }
}
