package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.r.q.a2;
import d.b.i0.t.i.b.a;
import d.b.i0.t.i.d.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f14688a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f14689b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f14690c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f14691d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f14692e;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f14688a = tbPageContext;
        this.f14692e = bdUniqueId;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f14689b.get(i).c());
    }

    public final a e() {
        return new a(this.f14688a, this.f14692e);
    }

    public void f(List<a2> list, c cVar) {
        a aVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f14690c.clear();
        this.f14690c.addAll(list);
        int size = this.f14689b.size();
        int size2 = this.f14690c.size();
        if (size > size2) {
            ArrayList arrayList = new ArrayList();
            for (int i = size2; i < size; i++) {
                arrayList.add(this.f14689b.get(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                a aVar2 = (a) arrayList.get(i2);
                if (aVar2.c() != null && aVar2.c().getParent() != null) {
                    ((ViewGroup) aVar2.c().getParent()).removeView(aVar2.c());
                }
                this.f14689b.remove(aVar2);
            }
            arrayList.clear();
        }
        for (int i3 = 0; i3 < size2; i3++) {
            if (i3 >= size) {
                aVar = e();
                aVar.g(this.f14688a.getUniqueId());
                aVar.h(cVar);
                this.f14689b.add(aVar);
            } else {
                aVar = this.f14689b.get(i3);
            }
            if (this.f14690c.get(i3) != null && aVar != null) {
                aVar.f(this.f14690c.get(i3), this.f14691d);
            }
        }
        notifyDataSetChanged();
    }

    public void g(String str) {
        this.f14691d = str;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14689b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ArrayList<a> arrayList = this.f14689b;
        if (arrayList == null) {
            return super.instantiateItem(viewGroup, i);
        }
        a aVar = (a) ListUtils.getItem(arrayList, i);
        if (aVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (aVar.c().getParent() == null) {
            viewGroup.addView(aVar.c(), new ViewGroup.LayoutParams(-2, -2));
        }
        aVar.e();
        aVar.c().setTag(Integer.valueOf(i));
        return aVar.c();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
