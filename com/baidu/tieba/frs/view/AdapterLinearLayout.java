package com.baidu.tieba.frs.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes6.dex */
public class AdapterLinearLayout extends LinearLayout {
    private Adapter dXJ;
    private final DataSetObserver mDataSetObserver;

    public AdapterLinearLayout(Context context) {
        super(context);
        this.mDataSetObserver = new DataSetObserver() { // from class: com.baidu.tieba.frs.view.AdapterLinearLayout.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (AdapterLinearLayout.this.dXJ != null) {
                    int count = AdapterLinearLayout.this.dXJ.getCount();
                    int childCount = AdapterLinearLayout.this.getChildCount() - count;
                    for (int i = 0; i < count; i++) {
                        View childAt = AdapterLinearLayout.this.getChildAt(i);
                        View view = AdapterLinearLayout.this.dXJ.getView(i, childAt, AdapterLinearLayout.this);
                        if (childAt == null && view != null) {
                            AdapterLinearLayout.this.addView(view);
                        }
                    }
                    if (childCount > 0) {
                        AdapterLinearLayout.this.removeViews(count, childCount);
                    }
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
            }
        };
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDataSetObserver = new DataSetObserver() { // from class: com.baidu.tieba.frs.view.AdapterLinearLayout.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (AdapterLinearLayout.this.dXJ != null) {
                    int count = AdapterLinearLayout.this.dXJ.getCount();
                    int childCount = AdapterLinearLayout.this.getChildCount() - count;
                    for (int i = 0; i < count; i++) {
                        View childAt = AdapterLinearLayout.this.getChildAt(i);
                        View view = AdapterLinearLayout.this.dXJ.getView(i, childAt, AdapterLinearLayout.this);
                        if (childAt == null && view != null) {
                            AdapterLinearLayout.this.addView(view);
                        }
                    }
                    if (childCount > 0) {
                        AdapterLinearLayout.this.removeViews(count, childCount);
                    }
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
            }
        };
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDataSetObserver = new DataSetObserver() { // from class: com.baidu.tieba.frs.view.AdapterLinearLayout.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (AdapterLinearLayout.this.dXJ != null) {
                    int count = AdapterLinearLayout.this.dXJ.getCount();
                    int childCount = AdapterLinearLayout.this.getChildCount() - count;
                    for (int i2 = 0; i2 < count; i2++) {
                        View childAt = AdapterLinearLayout.this.getChildAt(i2);
                        View view = AdapterLinearLayout.this.dXJ.getView(i2, childAt, AdapterLinearLayout.this);
                        if (childAt == null && view != null) {
                            AdapterLinearLayout.this.addView(view);
                        }
                    }
                    if (childCount > 0) {
                        AdapterLinearLayout.this.removeViews(count, childCount);
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
        if (this.dXJ != null) {
            this.dXJ.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dXJ = adapter;
        if (this.dXJ != null) {
            this.dXJ.registerDataSetObserver(this.mDataSetObserver);
        }
    }
}
