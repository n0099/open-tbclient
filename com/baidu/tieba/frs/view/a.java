package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout ckE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.ckE = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.ckE.ckD;
        if (adapter != null) {
            adapter2 = this.ckE.ckD;
            int count = adapter2.getCount();
            int childCount = this.ckE.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.ckE.getChildAt(i);
                adapter3 = this.ckE.ckD;
                View view = adapter3.getView(i, childAt, this.ckE);
                if (childAt == null && view != null) {
                    this.ckE.addView(view);
                }
            }
            if (childCount > 0) {
                this.ckE.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
