package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.view.HotRankView;
import d.b.c.a.f;
import d.b.c.e.p.l;
import d.b.j0.c1.c.j;
import d.b.j0.c1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17375a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f17376b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f17377c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f17378d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f17379e;

    /* renamed from: f  reason: collision with root package name */
    public int f17380f = -1;

    public ScrollFragmentAdapter(Context context) {
        this.f17375a = context;
        f<?> a2 = d.b.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17376b = (TbPageContext) a2;
        }
        this.f17378d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f17377c = arrayList;
        arrayList.add(j());
        this.f17377c.add(j());
        this.f17377c.add(j());
    }

    public void c(boolean z) {
        List<HotRankView> list = this.f17377c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.c(z);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public final HotRankView e() {
        int i = this.f17380f;
        if (i == -1) {
            return null;
        }
        return (HotRankView) ListUtils.getItem(this.f17377c, i % 3);
    }

    public List<j> f() {
        return this.f17378d;
    }

    public int g(p pVar) {
        String str;
        if (this.f17378d == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.f17378d.get(0).f53945b.get(i);
            if (pVar2 != null && (str = pVar2.f53967e) != null && str.equals(pVar.f53967e)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f17378d);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count || ListUtils.isEmpty(this.f17378d) || this.f17378d.get(0) == null || ListUtils.isEmpty(this.f17378d.get(0).f53945b)) {
            return null;
        }
        return this.f17378d.get(0).f53945b.get(i).f53967e;
    }

    public void i() {
        if (e() != null) {
            e().e();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.f17377c.get(i % this.f17377c.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.f17378d.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.d();
        hotRankView.e();
        int i2 = this.f17380f;
        if (i2 == -1) {
            str = this.f17379e.get(0).f53968f;
        } else {
            str = this.f17379e.get(i2).f53968f;
        }
        hotRankView.k(jVar, str);
        return hotRankView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final HotRankView j() {
        return new HotRankView(this.f17375a);
    }

    public void k(View view, int i, int i2, int i3, int i4) {
        List<HotRankView> list = this.f17377c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.j(view, i, i2, i3, i4);
                }
            }
        }
    }

    public final void l() {
        int i = this.f17380f;
        if (i < 0) {
            return;
        }
        HotRankView hotRankView = this.f17377c.get(i % 3);
        j jVar = (j) ListUtils.getItem(this.f17378d, this.f17380f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f17379e, this.f17380f);
            hotRankView.k(jVar, pVar != null ? pVar.f53968f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void m() {
        if (e() != null) {
            e().l(true, l.g(this.f17376b.getPageActivity(), R.dimen.ds500));
        }
    }

    public void n(List<j> list) {
        if (this.f17378d == null) {
            this.f17378d = new ArrayList();
        }
        if (!ListUtils.isEmpty(list)) {
            this.f17378d.clear();
            this.f17378d.addAll(list);
        }
        if (this.f17379e == null && !ListUtils.isEmpty(this.f17378d)) {
            ArrayList arrayList = new ArrayList();
            this.f17379e = arrayList;
            arrayList.clear();
            this.f17379e.addAll(this.f17378d.get(0).f53945b);
        }
        notifyDataSetChanged();
        l();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.f17377c) {
            if (hotRankView != null) {
                hotRankView.i();
            }
        }
        if (this.f17380f == i) {
            return;
        }
        this.f17380f = i;
        if (ListUtils.isEmpty(this.f17378d)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        j jVar = this.f17378d.get(this.f17380f);
        List<HotRankView> list = this.f17377c;
        HotRankView hotRankView2 = list.get(i % list.size());
        if (jVar == null || ListUtils.isEmpty(jVar.b())) {
            if (!d.b.c.e.p.j.A()) {
                hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                return;
            }
            hotRankView2.l(true, 0);
            ((HotRanklistActivity) this.f17376b.getOrignalPage()).loadHotTopicRanklistData();
        }
    }
}
