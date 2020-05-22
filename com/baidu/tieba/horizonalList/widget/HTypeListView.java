package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HTypeListView extends HListView {
    aa mTypeAdapter;

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
            this.mTypeAdapter = new aa();
        }
    }

    public void addAdapters(List<com.baidu.adp.widget.ListView.a> list) {
        Iterator<com.baidu.adp.widget.ListView.a> it = list.iterator();
        while (it.hasNext()) {
            this.mTypeAdapter.addAdapter(it.next());
        }
        setAdapter((ListAdapter) this.mTypeAdapter);
    }

    public void setData(List<? extends o> list) {
        this.mTypeAdapter.setData(list);
    }

    public List<o> getData() {
        return this.mTypeAdapter.getData();
    }
}
