package com.baidu.tieba.frs.view;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
/* loaded from: classes.dex */
class a extends DataSetObserver {
    final /* synthetic */ AdapterLinearLayout bPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdapterLinearLayout adapterLinearLayout) {
        this.bPN = adapterLinearLayout;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        Adapter adapter;
        Adapter adapter2;
        Adapter adapter3;
        adapter = this.bPN.bPM;
        if (adapter != null) {
            adapter2 = this.bPN.bPM;
            int count = adapter2.getCount();
            int childCount = this.bPN.getChildCount() - count;
            for (int i = 0; i < count; i++) {
                View childAt = this.bPN.getChildAt(i);
                adapter3 = this.bPN.bPM;
                View view = adapter3.getView(i, childAt, this.bPN);
                if (childAt == null && view != null) {
                    this.bPN.addView(view);
                }
            }
            if (childCount > 0) {
                this.bPN.removeViews(count, childCount);
            }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
    }
}
