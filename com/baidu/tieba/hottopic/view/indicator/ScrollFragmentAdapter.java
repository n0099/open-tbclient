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
import d.a.j0.c1.c.j;
import d.a.j0.c1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17681a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f17682b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f17683c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f17684d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f17685e;

    /* renamed from: f  reason: collision with root package name */
    public int f17686f = -1;

    public ScrollFragmentAdapter(Context context) {
        this.f17681a = context;
        f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17682b = (TbPageContext) a2;
        }
        this.f17684d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f17683c = arrayList;
        arrayList.add(g());
        this.f17683c.add(g());
        this.f17683c.add(g());
    }

    public void b(boolean z) {
        List<HotRankView> list = this.f17683c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.c(z);
                }
            }
        }
    }

    public final HotRankView c() {
        int i2 = this.f17686f;
        if (i2 == -1) {
            return null;
        }
        return (HotRankView) ListUtils.getItem(this.f17683c, i2 % 3);
    }

    public List<j> d() {
        return this.f17684d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public int e(p pVar) {
        String str;
        if (this.f17684d == null) {
            return -1;
        }
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            p pVar2 = this.f17684d.get(0).f51708b.get(i2);
            if (pVar2 != null && (str = pVar2.f51732e) != null && str.equals(pVar.f51732e)) {
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
        return new HotRankView(this.f17681a);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f17684d);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        int count = getCount();
        if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f17684d) || this.f17684d.get(0) == null || ListUtils.isEmpty(this.f17684d.get(0).f51708b)) {
            return null;
        }
        return this.f17684d.get(0).f51708b.get(i2).f51732e;
    }

    public void h(View view, int i2, int i3, int i4, int i5) {
        List<HotRankView> list = this.f17683c;
        if (list != null) {
            for (HotRankView hotRankView : list) {
                if (hotRankView != null) {
                    hotRankView.j(view, i2, i3, i4, i5);
                }
            }
        }
    }

    public final void i() {
        int i2 = this.f17686f;
        if (i2 < 0) {
            return;
        }
        HotRankView hotRankView = this.f17683c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f17684d, this.f17686f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f17685e, this.f17686f);
            hotRankView.k(jVar, pVar != null ? pVar.f51733f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        String str;
        HotRankView hotRankView = this.f17683c.get(i2 % this.f17683c.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.f17684d.get(i2);
        viewGroup.addView(hotRankView);
        hotRankView.d();
        hotRankView.e();
        int i3 = this.f17686f;
        if (i3 == -1) {
            str = this.f17685e.get(0).f51733f;
        } else {
            str = this.f17685e.get(i3).f51733f;
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
            c().l(true, l.g(this.f17682b.getPageActivity(), R.dimen.ds500));
        }
    }

    public void k(List<j> list) {
        if (this.f17684d == null) {
            this.f17684d = new ArrayList();
        }
        if (!ListUtils.isEmpty(list)) {
            this.f17684d.clear();
            this.f17684d.addAll(list);
        }
        if (this.f17685e == null && !ListUtils.isEmpty(this.f17684d)) {
            ArrayList arrayList = new ArrayList();
            this.f17685e = arrayList;
            arrayList.clear();
            this.f17685e.addAll(this.f17684d.get(0).f51708b);
        }
        notifyDataSetChanged();
        i();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        for (HotRankView hotRankView : this.f17683c) {
            if (hotRankView != null) {
                hotRankView.i();
            }
        }
        if (this.f17686f == i2) {
            return;
        }
        this.f17686f = i2;
        if (ListUtils.isEmpty(this.f17684d)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        j jVar = this.f17684d.get(this.f17686f);
        List<HotRankView> list = this.f17683c;
        HotRankView hotRankView2 = list.get(i2 % list.size());
        if (jVar == null || ListUtils.isEmpty(jVar.b())) {
            if (!d.a.c.e.p.j.A()) {
                hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                return;
            }
            hotRankView2.l(true, 0);
            ((HotRanklistActivity) this.f17682b.getOrignalPage()).loadHotTopicRanklistData();
        }
    }
}
