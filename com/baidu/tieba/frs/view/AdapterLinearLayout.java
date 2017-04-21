package com.baidu.tieba.frs.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class AdapterLinearLayout extends LinearLayout {
    private Adapter ceE;
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
        if (this.ceE != null) {
            this.ceE.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ceE = adapter;
        if (this.ceE != null) {
            this.ceE.registerDataSetObserver(this.mDataSetObserver);
        }
    }
}
