package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cco = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cco.ccn;
        if (adapter != null) {
            adapter2 = this.cco.ccn;
            int count = adapter2.getCount();
            int childCount = this.cco.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cco.getChildAt(i);
                adapter3 = this.cco.ccn;
                View view = adapter3.getView(i, childAt, this.cco);
                if (childAt == null && view != null) {
                    this.cco.addView(view);
                }
            }
            if (childCount > 0) {
                this.cco.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
