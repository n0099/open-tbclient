package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.b.j.e.a;
import d.b.b.j.e.n;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HTypeListView extends HListView {

    /* renamed from: e  reason: collision with root package name */
    public TypeAdapter f17524e;

    public HTypeListView(Context context) {
        super(context);
        this.f17524e = null;
        b();
    }

    public void a(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.f17524e.c(it.next());
        }
        setAdapter((ListAdapter) this.f17524e);
    }

    public final void b() {
        if (this.f17524e == null) {
            this.f17524e = new TypeAdapter();
        }
    }

    public List<n> getData() {
        return this.f17524e.d();
    }

    public void setData(List<? extends n> list) {
        this.f17524e.h(list);
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17524e = null;
        b();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17524e = null;
    }
}
