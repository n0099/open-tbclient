package com.baidu.tieba.frs.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a extends LinearLayout {
    private Adapter dTf;
    private final DataSetObserver mDataSetObserver;

    public a(Context context) {
        super(context);
        this.mDataSetObserver = new DataSetObserver() { // from class: com.baidu.tieba.frs.view.a.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (a.this.dTf != null) {
                    int count = a.this.dTf.getCount();
                    int childCount = a.this.getChildCount() - count;
                    for (int i = 0; i < count; i++) {
                        View childAt = a.this.getChildAt(i);
                        View view = a.this.dTf.getView(i, childAt, a.this);
                        if (childAt == null && view != null) {
                            a.this.addView(view);
                        }
                    }
                    if (childCount > 0) {
                        a.this.removeViews(count, childCount);
                    }
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
            }
        };
    }

    public void setAdapter(Adapter adapter) {
        if (this.dTf != null) {
            this.dTf.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dTf = adapter;
        if (this.dTf != null) {
            this.dTf.registerDataSetObserver(this.mDataSetObserver);
        }
    }
}
