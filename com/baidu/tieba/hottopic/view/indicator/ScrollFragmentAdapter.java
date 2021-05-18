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
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.k0.c1.c.j;
import d.a.k0.c1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f16996a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f16997b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f16998c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f16999d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f17000e;

    /* renamed from: f  reason: collision with root package name */
    public int f17001f = -1;

    public ScrollFragmentAdapter(Context context) {
        this.f16996a = context;
        f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16997b = (TbPageContext) a2;
        }
        this.f16999d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f16998c = arrayList;
        arrayList.add(g());
        this.f16998c.add(g());
        this.f16998c.add(g());
    }

    public void b(boolean z) {
        List<HotRankView> list = this.f16998c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.c(z);
                }
            }
        }
    }

    public final HotRankView c() {
        int i2 = this.f17001f;
        if (i2 == -1) {
            return null;
        }
        return (HotRankView) ListUtils.getItem(this.f16998c, i2 % 3);
    }

    public List<j> d() {
        return this.f16999d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public int e(p pVar) {
        String str;
        if (this.f16999d == null) {
            return -1;
        }
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            p pVar2 = this.f16999d.get(0).f52407b.get(i2);
            if (pVar2 != null && (str = pVar2.f52431e) != null && str.equals(pVar.f52431e)) {
                return i2;
            }
        }
        return -1;
    }

    public void f() {
        if (c() != null) {
            c().e();
        }
    }

    public final HotRankView g() {
        return new HotRankView(this.f16996a);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f16999d);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        int count = getCount();
        if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f16999d) || this.f16999d.get(0) == null || ListUtils.isEmpty(this.f16999d.get(0).f52407b)) {
            return null;
        }
        return this.f16999d.get(0).f52407b.get(i2).f52431e;
    }

    public void h(View view, int i2, int i3, int i4, int i5) {
        List<HotRankView> list = this.f16998c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.j(view, i2, i3, i4, i5);
                }
            }
        }
    }

    public final void i() {
        int i2 = this.f17001f;
        if (i2 < 0) {
            return;
        }
        HotRankView hotRankView = this.f16998c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f16999d, this.f17001f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f17000e, this.f17001f);
            hotRankView.k(jVar, pVar != null ? pVar.f52432f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        String str;
        HotRankView hotRankView = this.f16998c.get(i2 % this.f16998c.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.f16999d.get(i2);
        viewGroup.addView(hotRankView);
        hotRankView.d();
        hotRankView.e();
        int i3 = this.f17001f;
        if (i3 == -1) {
            str = this.f17000e.get(0).f52432f;
        } else {
            str = this.f17000e.get(i3).f52432f;
        }
        hotRankView.k(jVar, str);
        return hotRankView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j() {
        if (c() != null) {
            c().l(true, l.g(this.f16997b.getPageActivity(), R.dimen.ds500));
        }
    }

    public void k(List<j> list) {
        if (this.f16999d == null) {
            this.f16999d = new ArrayList();
        }
        if (!ListUtils.isEmpty(list)) {
            this.f16999d.clear();
            this.f16999d.addAll(list);
        }
        if (this.f17000e == null && !ListUtils.isEmpty(this.f16999d)) {
            ArrayList arrayList = new ArrayList();
            this.f17000e = arrayList;
            arrayList.clear();
            this.f17000e.addAll(this.f16999d.get(0).f52407b);
        }
        notifyDataSetChanged();
        i();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        for (HotRankView hotRankView : this.f16998c) {
            if (hotRankView != null) {
                hotRankView.i();
            }
        }
        if (this.f17001f == i2) {
            return;
        }
        this.f17001f = i2;
        if (ListUtils.isEmpty(this.f16999d)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        j jVar = this.f16999d.get(this.f17001f);
        List<HotRankView> list = this.f16998c;
        HotRankView hotRankView2 = list.get(i2 % list.size());
        if (jVar == null || ListUtils.isEmpty(jVar.b())) {
            if (!d.a.c.e.p.j.A()) {
                hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                return;
            }
            hotRankView2.l(true, 0);
            ((HotRanklistActivity) this.f16997b.getOrignalPage()).loadHotTopicRanklistData();
        }
    }
}
