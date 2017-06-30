package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cqi = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cqi.cqh;
        if (adapter != null) {
            adapter2 = this.cqi.cqh;
            int count = adapter2.getCount();
            int childCount = this.cqi.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cqi.getChildAt(i);
                adapter3 = this.cqi.cqh;
                View view = adapter3.getView(i, childAt, this.cqi);
                if (childAt == null && view != null) {
                    this.cqi.addView(view);
                }
            }
            if (childCount > 0) {
                this.cqi.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
