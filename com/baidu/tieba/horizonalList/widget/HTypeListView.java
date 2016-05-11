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
    y zH;

    public HTypeListView(Context context) {
        super(context);
        this.zH = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zH = null;
        init();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zH = null;
    }

    private void init() {
        if (this.zH == null) {
            this.zH = new y();
        }
    }

    public void g(List<com.baidu.adp.widget.ListView.a> list) {
        Iterator<com.baidu.adp.widget.ListView.a> it = list.iterator();
        while (it.hasNext()) {
            this.zH.a(it.next());
        }
        setAdapter((ListAdapter) this.zH);
    }

    public void setData(List<v> list) {
        this.zH.setData(list);
    }

    public List<v> getData() {
        return this.zH.getData();
    }
}
