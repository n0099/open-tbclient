package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout cfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.cfE = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.cfE.cfD;
        if (adapter != null) {
            adapter2 = this.cfE.cfD;
            int count = adapter2.getCount();
            int childCount = this.cfE.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.cfE.getChildAt(i);
                adapter3 = this.cfE.cfD;
                View view = adapter3.getView(i, childAt, this.cfE);
                if (childAt == null && view != null) {
                    this.cfE.addView(view);
                }
            }
            if (childCount > 0) {
                this.cfE.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
