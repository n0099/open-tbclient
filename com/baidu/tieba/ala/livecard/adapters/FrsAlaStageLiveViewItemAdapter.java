package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.r.q.a2;
import d.b.j0.t.i.b.a;
import d.b.j0.t.i.d.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f14696a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f14697b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f14698c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f14699d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f14700e;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f14696a = tbPageContext;
        this.f14700e = bdUniqueId;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f14697b.get(i).c());
    }

    public final a e() {
        return new a(this.f14696a, this.f14700e);
    }

    public void f(List<a2> list, c cVar) {
        a aVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f14698c.clear();
        this.f14698c.addAll(list);
        int size = this.f14697b.size();
        int size2 = this.f14698c.size();
        if (size > size2) {
            ArrayList arrayList = new ArrayList();
            for (int i = size2; i < size; i++) {
                arrayList.add(this.f14697b.get(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                a aVar2 = (a) arrayList.get(i2);
                if (aVar2.c() != null && aVar2.c().getParent() != null) {
                    ((ViewGroup) aVar2.c().getParent()).removeView(aVar2.c());
                }
                this.f14697b.remove(aVar2);
            }
            arrayList.clear();
        }
        for (int i3 = 0; i3 < size2; i3++) {
            if (i3 >= size) {
                aVar = e();
                aVar.g(this.f14696a.getUniqueId());
                aVar.h(cVar);
                this.f14697b.add(aVar);
            } else {
                aVar = this.f14697b.get(i3);
            }
            if (this.f14698c.get(i3) != null && aVar != null) {
                aVar.f(this.f14698c.get(i3), this.f14699d);
            }
        }
        notifyDataSetChanged();
    }

    public void g(String str) {
        this.f14699d = str;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14697b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ArrayList<a> arrayList = this.f14697b;
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
