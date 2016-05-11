package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.buK = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.buK.buJ;
        if (adapter != null) {
            adapter2 = this.buK.buJ;
            int count = adapter2.getCount();
            int childCount = this.buK.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.buK.getChildAt(i);
                adapter3 = this.buK.buJ;
                View view = adapter3.getView(i, childAt, this.buK);
                if (childAt == null && view != null) {
                    this.buK.addView(view);
                }
            }
            if (childCount > 0) {
                this.buK.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
