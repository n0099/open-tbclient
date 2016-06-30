package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.bSw = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.bSw.bSv;
        if (adapter != null) {
            adapter2 = this.bSw.bSv;
            int count = adapter2.getCount();
            int childCount = this.bSw.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.bSw.getChildAt(i);
                adapter3 = this.bSw.bSv;
                View view = adapter3.getView(i, childAt, this.bSw);
                if (childAt == null && view != null) {
                    this.bSw.addView(view);
                }
            }
            if (childCount > 0) {
                this.bSw.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
