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
import d.b.b.a.f;
import d.b.b.e.p.l;
import d.b.i0.b1.c.j;
import d.b.i0.b1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17690a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f17691b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f17692c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f17693d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f17694e;

    /* renamed from: f  reason: collision with root package name */
    public int f17695f = -1;

    public ScrollFragmentAdapter(Context context) {
        this.f17690a = context;
        f<?> a2 = d.b.b.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17691b = (TbPageContext) a2;
        }
        this.f17693d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f17692c = arrayList;
        arrayList.add(j());
        this.f17692c.add(j());
        this.f17692c.add(j());
    }

    public void c(boolean z) {
        List<HotRankView> list = this.f17692c;
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
        int i = this.f17695f;
        if (i == -1) {
            return null;
        }
        return (HotRankView) ListUtils.getItem(this.f17692c, i % 3);
    }

    public List<j> f() {
        return this.f17693d;
    }

    public int g(p pVar) {
        String str;
        if (this.f17693d == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.f17693d.get(0).f52123b.get(i);
            if (pVar2 != null && (str = pVar2.f52145e) != null && str.equals(pVar.f52145e)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f17693d);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count || ListUtils.isEmpty(this.f17693d) || this.f17693d.get(0) == null || ListUtils.isEmpty(this.f17693d.get(0).f52123b)) {
            return null;
        }
        return this.f17693d.get(0).f52123b.get(i).f52145e;
    }

    public void i() {
        if (e() != null) {
            e().e();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.f17692c.get(i % this.f17692c.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.f17693d.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.d();
        hotRankView.e();
        int i2 = this.f17695f;
        if (i2 == -1) {
            str = this.f17694e.get(0).f52146f;
        } else {
            str = this.f17694e.get(i2).f52146f;
        }
        hotRankView.k(jVar, str);
        return hotRankView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final HotRankView j() {
        return new HotRankView(this.f17690a);
    }

    public void k(View view, int i, int i2, int i3, int i4) {
        List<HotRankView> list = this.f17692c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.j(view, i, i2, i3, i4);
                }
            }
        }
    }

    public final void l() {
        int i = this.f17695f;
        if (i < 0) {
            return;
        }
        HotRankView hotRankView = this.f17692c.get(i % 3);
        j jVar = (j) ListUtils.getItem(this.f17693d, this.f17695f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f17694e, this.f17695f);
            hotRankView.k(jVar, pVar != null ? pVar.f52146f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void m() {
        if (e() != null) {
            e().l(true, l.g(this.f17691b.getPageActivity(), R.dimen.ds500));
        }
    }

    public void n(List<j> list) {
        if (this.f17693d == null) {
            this.f17693d = new ArrayList();
        }
        if (!ListUtils.isEmpty(list)) {
            this.f17693d.clear();
            this.f17693d.addAll(list);
        }
        if (this.f17694e == null && !ListUtils.isEmpty(this.f17693d)) {
            ArrayList arrayList = new ArrayList();
            this.f17694e = arrayList;
            arrayList.clear();
            this.f17694e.addAll(this.f17693d.get(0).f52123b);
        }
        notifyDataSetChanged();
        l();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.f17692c) {
            if (hotRankView != null) {
                hotRankView.i();
            }
        }
        if (this.f17695f == i) {
            return;
        }
        this.f17695f = i;
        if (ListUtils.isEmpty(this.f17693d)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        j jVar = this.f17693d.get(this.f17695f);
        List<HotRankView> list = this.f17692c;
        HotRankView hotRankView2 = list.get(i % list.size());
        if (jVar == null || ListUtils.isEmpty(jVar.b())) {
            if (!d.b.b.e.p.j.A()) {
                hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                return;
            }
            hotRankView2.l(true, 0);
            ((HotRanklistActivity) this.f17691b.getOrignalPage()).loadHotTopicRanklistData();
        }
    }
}
