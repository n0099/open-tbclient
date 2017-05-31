package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cii;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cii = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cii.cih;
        if (adapter != null) {
            adapter2 = this.cii.cih;
            int count = adapter2.getCount();
            int childCount = this.cii.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cii.getChildAt(i);
                adapter3 = this.cii.cih;
                View view = adapter3.getView(i, childAt, this.cii);
                if (childAt == null && view != null) {
                    this.cii.addView(view);
                }
            }
            if (childCount > 0) {
                this.cii.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
