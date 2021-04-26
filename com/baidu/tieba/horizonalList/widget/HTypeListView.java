package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.c.j.e.a;
import d.a.c.j.e.n;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HTypeListView extends HListView {

    /* renamed from: e  reason: collision with root package name */
    public TypeAdapter f17503e;

    public HTypeListView(Context context) {
        super(context);
        this.f17503e = null;
        b();
    }

    public void a(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.f17503e.c(it.next());
        }
        setAdapter((ListAdapter) this.f17503e);
    }

    public final void b() {
        if (this.f17503e == null) {
            this.f17503e = new TypeAdapter();
        }
    }

    public List<n> getData() {
        return this.f17503e.d();
    }

    public void setData(List<? extends n> list) {
        this.f17503e.h(list);
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17503e = null;
        b();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17503e = null;
    }
}
