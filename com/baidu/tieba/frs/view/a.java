package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout bWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.bWs = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.bWs.bWr;
        if (adapter != null) {
            adapter2 = this.bWs.bWr;
            int count = adapter2.getCount();
            int childCount = this.bWs.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.bWs.getChildAt(i);
                adapter3 = this.bWs.bWr;
                View view = adapter3.getView(i, childAt, this.bWs);
                if (childAt == null && view != null) {
                    this.bWs.addView(view);
                }
            }
            if (childCount > 0) {
                this.bWs.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
