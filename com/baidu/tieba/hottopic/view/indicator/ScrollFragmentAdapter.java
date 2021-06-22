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
import d.a.o0.d1.c.j;
import d.a.o0.d1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17064a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f17065b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f17066c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f17067d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f17068e;

    /* renamed from: f  reason: collision with root package name */
    public int f17069f = -1;

    public ScrollFragmentAdapter(Context context) {
        this.f17064a = context;
        f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17065b = (TbPageContext) a2;
        }
        this.f17067d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f17066c = arrayList;
        arrayList.add(j());
        this.f17066c.add(j());
        this.f17066c.add(j());
    }

    public void c(boolean z) {
        List<HotRankView> list = this.f17066c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.c(z);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public final HotRankView e() {
        int i2 = this.f17069f;
        if (i2 == -1) {
            return null;
        }
        return (HotRankView) ListUtils.getItem(this.f17066c, i2 % 3);
    }

    public List<j> f() {
        return this.f17067d;
    }

    public int g(p pVar) {
        String str;
        if (this.f17067d == null) {
            return -1;
        }
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            p pVar2 = this.f17067d.get(0).f56401b.get(i2);
            if (pVar2 != null && (str = pVar2.f56425e) != null && str.equals(pVar.f56425e)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f17067d);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        int count = getCount();
        if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f17067d) || this.f17067d.get(0) == null || ListUtils.isEmpty(this.f17067d.get(0).f56401b)) {
            return null;
        }
        return this.f17067d.get(0).f56401b.get(i2).f56425e;
    }

    public void i() {
        if (e() != null) {
            e().e();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        String str;
        HotRankView hotRankView = this.f17066c.get(i2 % this.f17066c.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.f17067d.get(i2);
        viewGroup.addView(hotRankView);
        hotRankView.d();
        hotRankView.e();
        int i3 = this.f17069f;
        if (i3 == -1) {
            str = this.f17068e.get(0).f56426f;
        } else {
            str = this.f17068e.get(i3).f56426f;
        }
        hotRankView.k(jVar, str);
        return hotRankView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final HotRankView j() {
        return new HotRankView(this.f17064a);
    }

    public void k(View view, int i2, int i3, int i4, int i5) {
        List<HotRankView> list = this.f17066c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.j(view, i2, i3, i4, i5);
                }
            }
        }
    }

    public final void l() {
        int i2 = this.f17069f;
        if (i2 < 0) {
            return;
        }
        HotRankView hotRankView = this.f17066c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f17067d, this.f17069f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f17068e, this.f17069f);
            hotRankView.k(jVar, pVar != null ? pVar.f56426f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void m() {
        if (e() != null) {
            e().l(true, l.g(this.f17065b.getPageActivity(), R.dimen.ds500));
        }
    }

    public void n(List<j> list) {
        if (this.f17067d == null) {
            this.f17067d = new ArrayList();
        }
        if (!ListUtils.isEmpty(list)) {
            this.f17067d.clear();
            this.f17067d.addAll(list);
        }
        if (this.f17068e == null && !ListUtils.isEmpty(this.f17067d)) {
            ArrayList arrayList = new ArrayList();
            this.f17068e = arrayList;
            arrayList.clear();
            this.f17068e.addAll(this.f17067d.get(0).f56401b);
        }
        notifyDataSetChanged();
        l();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        for (HotRankView hotRankView : this.f17066c) {
            if (hotRankView != null) {
                hotRankView.i();
            }
        }
        if (this.f17069f == i2) {
            return;
        }
        this.f17069f = i2;
        if (ListUtils.isEmpty(this.f17067d)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        j jVar = this.f17067d.get(this.f17069f);
        List<HotRankView> list = this.f17066c;
        HotRankView hotRankView2 = list.get(i2 % list.size());
        if (jVar == null || ListUtils.isEmpty(jVar.b())) {
            if (!d.a.c.e.p.j.A()) {
                hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                return;
            }
            hotRankView2.l(true, 0);
            ((HotRanklistActivity) this.f17065b.getOrignalPage()).loadHotTopicRanklistData();
        }
    }
}
