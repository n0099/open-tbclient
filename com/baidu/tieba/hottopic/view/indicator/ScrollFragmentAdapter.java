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
import d.a.n0.d1.c.j;
import d.a.n0.d1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f16906a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f16907b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f16908c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f16909d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f16910e;

    /* renamed from: f  reason: collision with root package name */
    public int f16911f = -1;

    public ScrollFragmentAdapter(Context context) {
        this.f16906a = context;
        f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16907b = (TbPageContext) a2;
        }
        this.f16909d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f16908c = arrayList;
        arrayList.add(g());
        this.f16908c.add(g());
        this.f16908c.add(g());
    }

    public void b(boolean z) {
        List<HotRankView> list = this.f16908c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.c(z);
                }
            }
        }
    }

    public final HotRankView c() {
        int i2 = this.f16911f;
        if (i2 == -1) {
            return null;
        }
        return (HotRankView) ListUtils.getItem(this.f16908c, i2 % 3);
    }

    public List<j> d() {
        return this.f16909d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public int e(p pVar) {
        String str;
        if (this.f16909d == null) {
            return -1;
        }
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            p pVar2 = this.f16909d.get(0).f52587b.get(i2);
            if (pVar2 != null && (str = pVar2.f52611e) != null && str.equals(pVar.f52611e)) {
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
        return new HotRankView(this.f16906a);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f16909d);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        int count = getCount();
        if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f16909d) || this.f16909d.get(0) == null || ListUtils.isEmpty(this.f16909d.get(0).f52587b)) {
            return null;
        }
        return this.f16909d.get(0).f52587b.get(i2).f52611e;
    }

    public void h(View view, int i2, int i3, int i4, int i5) {
        List<HotRankView> list = this.f16908c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.j(view, i2, i3, i4, i5);
                }
            }
        }
    }

    public final void i() {
        int i2 = this.f16911f;
        if (i2 < 0) {
            return;
        }
        HotRankView hotRankView = this.f16908c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f16909d, this.f16911f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f16910e, this.f16911f);
            hotRankView.k(jVar, pVar != null ? pVar.f52612f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        String str;
        HotRankView hotRankView = this.f16908c.get(i2 % this.f16908c.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.f16909d.get(i2);
        viewGroup.addView(hotRankView);
        hotRankView.d();
        hotRankView.e();
        int i3 = this.f16911f;
        if (i3 == -1) {
            str = this.f16910e.get(0).f52612f;
        } else {
            str = this.f16910e.get(i3).f52612f;
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
            c().l(true, l.g(this.f16907b.getPageActivity(), R.dimen.ds500));
        }
    }

    public void k(List<j> list) {
        if (this.f16909d == null) {
            this.f16909d = new ArrayList();
        }
        if (!ListUtils.isEmpty(list)) {
            this.f16909d.clear();
            this.f16909d.addAll(list);
        }
        if (this.f16910e == null && !ListUtils.isEmpty(this.f16909d)) {
            ArrayList arrayList = new ArrayList();
            this.f16910e = arrayList;
            arrayList.clear();
            this.f16910e.addAll(this.f16909d.get(0).f52587b);
        }
        notifyDataSetChanged();
        i();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        for (HotRankView hotRankView : this.f16908c) {
            if (hotRankView != null) {
                hotRankView.i();
            }
        }
        if (this.f16911f == i2) {
            return;
        }
        this.f16911f = i2;
        if (ListUtils.isEmpty(this.f16909d)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        j jVar = this.f16909d.get(this.f16911f);
        List<HotRankView> list = this.f16908c;
        HotRankView hotRankView2 = list.get(i2 % list.size());
        if (jVar == null || ListUtils.isEmpty(jVar.b())) {
            if (!d.a.c.e.p.j.A()) {
                hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                return;
            }
            hotRankView2.l(true, 0);
            ((HotRanklistActivity) this.f16907b.getOrignalPage()).loadHotTopicRanklistData();
        }
    }
}
