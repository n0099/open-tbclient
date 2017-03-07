package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cdN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cdN = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cdN.cdM;
        if (adapter != null) {
            adapter2 = this.cdN.cdM;
            int count = adapter2.getCount();
            int childCount = this.cdN.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cdN.getChildAt(i);
                adapter3 = this.cdN.cdM;
                View view = adapter3.getView(i, childAt, this.cdN);
                if (childAt == null && view != null) {
                    this.cdN.addView(view);
                }
            }
            if (childCount > 0) {
                this.cdN.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
