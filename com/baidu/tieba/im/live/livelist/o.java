package com.baidu.tieba.im.live.livelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private ArrayList<Integer> a = new ArrayList<>();
    private ArrayList<Integer> b = new ArrayList<>();
    private FrsLiveListActivity c;
    private p d;
    private t e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    public p a() {
        return this.d;
    }

    public void a(boolean z) {
        this.h = z;
        this.d.a(z);
    }

    public void b(boolean z) {
        this.f = z;
        this.d.c(z);
    }

    public void a(s sVar) {
        this.d.a(sVar);
    }

    public void c(boolean z) {
        this.i = z;
        this.d.d(z);
    }

    public boolean b() {
        return this.g;
    }

    public void d(boolean z) {
        this.g = z;
        this.d.b(z);
    }

    public o(FrsLiveListActivity frsLiveListActivity) {
        this.c = frsLiveListActivity;
        this.d = new p(frsLiveListActivity);
        this.e = new t(frsLiveListActivity);
        this.a.add(-1);
        this.a.add(0);
        this.b.add(1);
        this.b.add(2);
        this.b.add(3);
    }

    public void a(List<LiveCardData> list) {
        this.d.a(list);
    }

    public void b(List<LiveCardData> list) {
        this.e.a(list);
    }

    public void c() {
        this.d.a();
        this.e.a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f ? this.d.getCount() + this.e.getCount() : this.d.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < this.d.getCount()) {
            return this.d.getItem(i);
        }
        if (i >= this.d.getCount() && this.f) {
            return this.e.getItem(i - this.d.getCount());
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.d.getCount()) {
            return this.d.getItemId(i);
        }
        if (i >= this.d.getCount() && this.f) {
            return this.e.getItemId(i - this.d.getCount());
        }
        return -1000L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < this.d.getCount()) {
            return this.d.getItemViewType(i);
        }
        if (i >= this.d.getCount() && this.f) {
            return this.e.getItemViewType(i - this.d.getCount());
        }
        return -1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        if (this.a.contains(Integer.valueOf(getItemViewType(i)))) {
            view2 = this.d.getView(i, view, viewGroup);
        } else {
            view2 = this.e.getView(i - this.d.getCount(), view, viewGroup);
        }
        a(view2);
        return view2;
    }

    private void a(View view) {
        this.c.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.c.getLayoutMode().a(view);
    }
}
