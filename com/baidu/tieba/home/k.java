package com.baidu.tieba.home;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements com.baidu.tieba.view.v {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.g f932a;
    private ArrayList b;
    private com.baidu.tieba.util.a c;
    private z d;
    private r e;
    private com.baidu.tieba.square.g f;
    private Boolean g = false;
    private View.OnClickListener h = null;
    private View.OnLongClickListener i = null;
    private View.OnClickListener j = null;
    private m k;

    public k(com.baidu.tieba.g gVar) {
        this.f932a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.k = null;
        this.f932a = gVar;
        this.b = new ArrayList();
        this.c = new com.baidu.tieba.util.a(gVar);
        this.e = new r(this.f932a);
        this.k = new l(this);
        this.d = new z(this.f932a, this.k);
        this.f = new com.baidu.tieba.square.g(this.f932a);
        this.b.add(this.e);
        this.b.add(this.d);
        this.b.add(this.f);
    }

    public void a(com.baidu.tieba.data.m mVar) {
        if (this.e != null) {
            this.e.a(this.g);
            this.e.a(mVar.a());
        }
        if (this.d != null) {
            this.d.a(mVar.c(), mVar.d());
        }
        if (this.f != null) {
            this.f.a(mVar.b());
        }
    }

    public void a(Boolean bool) {
        this.g = bool;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
        this.e.b(this.h);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.i = onLongClickListener;
        this.e.a(this.i);
    }

    public void b(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.e.a(this.j);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        Iterator it = this.b.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((BaseAdapter) it.next()).getCount() + i2;
            } else {
                return i2;
            }
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.b.size()) {
                BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
                if (i < baseAdapter.getCount()) {
                    return baseAdapter.getItem(i);
                }
                i -= baseAdapter.getCount();
                i2 = i3 + 1;
            } else {
                return null;
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        int i;
        int i2 = 0;
        Iterator it = this.b.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = ((BaseAdapter) it.next()).getViewTypeCount() + i;
        }
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
            if (i < baseAdapter.getCount()) {
                return baseAdapter.getItemViewType(i) + i2;
            }
            i2 += baseAdapter.getViewTypeCount();
            i -= baseAdapter.getCount();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.b.size()) {
                BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
                if (i < baseAdapter.getCount()) {
                    return baseAdapter.getView(i, view, viewGroup);
                }
                i -= baseAdapter.getCount();
                i2 = i3 + 1;
            } else {
                return null;
            }
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.b(Boolean.valueOf(!this.e.a().booleanValue()));
        }
    }

    public Boolean b() {
        if (this.e != null) {
            return this.e.a();
        }
        return false;
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.view.v
    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            BaseAdapter baseAdapter = (BaseAdapter) it.next();
            if (baseAdapter instanceof com.baidu.tieba.view.v) {
                ((com.baidu.tieba.view.v) baseAdapter).c();
            }
        }
    }

    @Override // com.baidu.tieba.view.v
    public void a(View view, int i, int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            BaseAdapter baseAdapter = (BaseAdapter) this.b.get(i3);
            if (baseAdapter instanceof com.baidu.tieba.view.v) {
                ((com.baidu.tieba.view.v) baseAdapter).a(view, i < 0 ? 0 : i, i2 > baseAdapter.getCount() + (-1) ? baseAdapter.getCount() - 1 : i2);
            }
            com.baidu.tieba.util.z.a(getClass().getName(), "startLoadImage", "start:" + i + "en:" + i2);
            i -= baseAdapter.getCount();
            i2 -= baseAdapter.getCount();
            if (i2 < 0) {
                return;
            }
        }
    }
}
