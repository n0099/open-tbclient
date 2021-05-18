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
    public TypeAdapter f16818e;

    public HTypeListView(Context context) {
        super(context);
        this.f16818e = null;
        b();
    }

    public void a(List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            this.f16818e.c(it.next());
        }
        setAdapter((ListAdapter) this.f16818e);
    }

    public final void b() {
        if (this.f16818e == null) {
            this.f16818e = new TypeAdapter();
        }
    }

    public List<n> getData() {
        return this.f16818e.d();
    }

    public void setData(List<? extends n> list) {
        this.f16818e.h(list);
    }

    public HTypeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16818e = null;
        b();
    }

    public HTypeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16818e = null;
    }
}
