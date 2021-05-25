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
    public TbPageContext<?> f13994a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f13995b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f13996c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f13997d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f13998e;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f13994a = tbPageContext;
        this.f13998e = bdUniqueId;
    }

    public final a b() {
        return new a(this.f13994a, this.f13998e);
    }

    public void c(List<a2> list, c cVar) {
        a aVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f13996c.clear();
        this.f13996c.addAll(list);
        int size = this.f13995b.size();
        int size2 = this.f13996c.size();
        if (size > size2) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = size2; i2 < size; i2++) {
                arrayList.add(this.f13995b.get(i2));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                a aVar2 = (a) arrayList.get(i3);
                if (aVar2.c() != null && aVar2.c().getParent() != null) {
                    ((ViewGroup) aVar2.c().getParent()).removeView(aVar2.c());
                }
                this.f13995b.remove(aVar2);
            }
            arrayList.clear();
        }
        for (int i4 = 0; i4 < size2; i4++) {
            if (i4 >= size) {
                aVar = b();
                aVar.g(this.f13994a.getUniqueId());
                aVar.h(cVar);
                this.f13995b.add(aVar);
            } else {
                aVar = this.f13995b.get(i4);
            }
            if (this.f13996c.get(i4) != null && aVar != null) {
                aVar.f(this.f13996c.get(i4), this.f13997d);
            }
        }
        notifyDataSetChanged();
    }

    public void d(String str) {
        this.f13997d = str;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView(this.f13995b.get(i2).c());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f13995b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        ArrayList<a> arrayList = this.f13995b;
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
