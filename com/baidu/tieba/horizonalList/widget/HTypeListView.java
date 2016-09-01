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
    y Cw;

    public HTypeListView(Context context) {
        super(context);
        this.Cw = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Cw = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Cw = null;
    }

    private void init() {
        if (this.Cw == null) {
            this.Cw = new y();
        }
    }

    public void g(List<com.baidu.adp.widget.ListView.a> list) {
        Iterator<com.baidu.adp.widget.ListView.a> it = list.iterator();
        while (it.hasNext()) {
            this.Cw.a(it.next());
        }
        setAdapter((ListAdapter) this.Cw);
    }

    public void setData(List<v> list) {
        this.Cw.setData(list);
    }

    public List<v> getData() {
        return this.Cw.getData();
    }
}
