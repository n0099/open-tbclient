package com.baidu.tieba.homepage.personalize.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class CommonSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f16962a;

    /* renamed from: b  reason: collision with root package name */
    public int f16963b;

    /* renamed from: c  reason: collision with root package name */
    public int f16964c;

    public CommonSpaceItemDecoration(int i, int i2, int i3) {
        this.f16962a = i;
        this.f16963b = i2;
        this.f16964c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.f16962a;
            } else {
                rect.top = this.f16963b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.f16964c;
                return;
            }
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.f16962a;
        } else {
            rect.left = this.f16963b;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.f16964c;
        }
    }
}
