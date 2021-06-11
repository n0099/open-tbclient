package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import d.a.n0.v.i.b.a;
import d.a.n0.v.i.d.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f14051a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f14052b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f14053c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f14054d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f14055e;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f14051a = tbPageContext;
        this.f14055e = bdUniqueId;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView(this.f14052b.get(i2).c());
    }

    public final a e() {
        return new a(this.f14051a, this.f14055e);
    }

    public void f(List<a2> list, c cVar) {
        a aVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f14053c.clear();
        this.f14053c.addAll(list);
        int size = this.f14052b.size();
        int size2 = this.f14053c.size();
        if (size > size2) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = size2; i2 < size; i2++) {
                arrayList.add(this.f14052b.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                a aVar2 = (a) arrayList.get(i3);
                if (aVar2.c() != null && aVar2.c().getParent() != null) {
                    ((ViewGroup) aVar2.c().getParent()).removeView(aVar2.c());
                }
                this.f14052b.remove(aVar2);
            }
            arrayList.clear();
        }
        for (int i4 = 0; i4 < size2; i4++) {
            if (i4 >= size) {
                aVar = e();
                aVar.g(this.f14051a.getUniqueId());
                aVar.h(cVar);
                this.f14052b.add(aVar);
            } else {
                aVar = this.f14052b.get(i4);
            }
            if (this.f14053c.get(i4) != null && aVar != null) {
                aVar.f(this.f14053c.get(i4), this.f14054d);
            }
        }
        notifyDataSetChanged();
    }

    public void g(String str) {
        this.f14054d = str;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14052b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        ArrayList<a> arrayList = this.f14052b;
        if (arrayList == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        a aVar = (a) ListUtils.getItem(arrayList, i2);
        if (aVar == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        if (aVar.c().getParent() == null) {
            viewGroup.addView(aVar.c(), new ViewGroup.LayoutParams(-2, -2));
        }
        aVar.e();
        aVar.c().setTag(Integer.valueOf(i2));
        return aVar.c();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
