package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout ceF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.ceF = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.ceF.ceE;
        if (adapter != null) {
            adapter2 = this.ceF.ceE;
            int count = adapter2.getCount();
            int childCount = this.ceF.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.ceF.getChildAt(i);
                adapter3 = this.ceF.ceE;
                View view = adapter3.getView(i, childAt, this.ceF);
                if (childAt == null && view != null) {
                    this.ceF.addView(view);
                }
            }
            if (childCount > 0) {
                this.ceF.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
