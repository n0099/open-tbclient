package com.baidu.tieba.frs.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class AdapterLinearLayout extends LinearLayout {
    private Adapter cdM;
    private final DataSetObserver mDataSetObserver;

    public AdapterLinearLayout(Context context) {
        super(context);
        this.mDataSetObserver = new a(this);
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDataSetObserver = new a(this);
    }

    public AdapterLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDataSetObserver = new a(this);
    }

    public void setAdapter(Adapter adapter) {
        if (this.cdM != null) {
            this.cdM.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cdM = adapter;
        if (this.cdM != null) {
            this.cdM.registerDataSetObserver(this.mDataSetObserver);
        }
    }
}
