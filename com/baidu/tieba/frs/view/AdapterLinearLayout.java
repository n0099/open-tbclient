package com.baidu.tieba.frs.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class AdapterLinearLayout extends LinearLayout {
    private Adapter ckD;
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
        if (this.ckD != null) {
            this.ckD.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ckD = adapter;
        if (this.ckD != null) {
            this.ckD.registerDataSetObserver(this.mDataSetObserver);
        }
    }
}
