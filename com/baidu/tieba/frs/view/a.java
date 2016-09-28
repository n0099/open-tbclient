package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cfB = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cfB.cfA;
        if (adapter != null) {
            adapter2 = this.cfB.cfA;
            int count = adapter2.getCount();
            int childCount = this.cfB.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cfB.getChildAt(i);
                adapter3 = this.cfB.cfA;
                View view = adapter3.getView(i, childAt, this.cfB);
                if (childAt == null && view != null) {
                    this.cfB.addView(view);
                }
            }
            if (childCount > 0) {
                this.cfB.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
