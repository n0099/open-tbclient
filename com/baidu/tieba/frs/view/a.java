package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cbU = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cbU.cbT;
        if (adapter != null) {
            adapter2 = this.cbU.cbT;
            int count = adapter2.getCount();
            int childCount = this.cbU.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cbU.getChildAt(i);
                adapter3 = this.cbU.cbT;
                View view = adapter3.getView(i, childAt, this.cbU);
                if (childAt == null && view != null) {
                    this.cbU.addView(view);
                }
            }
            if (childCount > 0) {
                this.cbU.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
