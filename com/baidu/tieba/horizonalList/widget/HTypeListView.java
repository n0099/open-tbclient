package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HTypeListView extends HListView {
    y mTypeAdapter;

    public HTypeListView(Context context) {
        super(context);
        this.mTypeAdapter = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypeAdapter = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTypeAdapter = null;
    }

    private void init() {
        if (this.mTypeAdapter == null) {
            this.mTypeAdapter = new y();
        }
    }

    public void addAdapters(List<com.baidu.adp.widget.ListView.a> list) {
        Iterator<com.baidu.adp.widget.ListView.a> it = list.iterator();
        while (it.hasNext()) {
            this.mTypeAdapter.addAdapter(it.next());
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void setData(List<v> list) {
        this.mTypeAdapter.setData(list);
    }

    public List<v> getData() {
        return this.mTypeAdapter.getData();
    }
}
