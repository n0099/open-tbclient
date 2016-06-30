package com.baidu.tieba.frs.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class AdapterLinearLayout extends LinearLayout {
    private Adapter bSv;
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
        if (this.bSv != null) {
            this.bSv.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bSv = adapter;
        if (this.bSv != null) {
            this.bSv.registerDataSetObserver(this.mDataSetObserver);
        }
    }
}
