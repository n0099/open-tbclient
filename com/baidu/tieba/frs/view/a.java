package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout bUw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.bUw = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.bUw.bUv;
        if (adapter != null) {
            adapter2 = this.bUw.bUv;
            int count = adapter2.getCount();
            int childCount = this.bUw.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.bUw.getChildAt(i);
                adapter3 = this.bUw.bUv;
                View view = adapter3.getView(i, childAt, this.bUw);
                if (childAt == null && view != null) {
                    this.bUw.addView(view);
                }
            }
            if (childCount > 0) {
                this.bUw.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
