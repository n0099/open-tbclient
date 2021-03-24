package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.i0.b1.c.e;
import d.b.i0.b1.f.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static String[] f17528g = {"最热", "最新"};

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f17529a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicView> f17530b;

    /* renamed from: c  reason: collision with root package name */
    public List<e> f17531c;

    /* renamed from: d  reason: collision with root package name */
    public int f17532d = -1;

    /* renamed from: e  reason: collision with root package name */
    public c.f f17533e;

    /* renamed from: f  reason: collision with root package name */
    public c f17534f;

    public HotTopicThreadPagerAdapter(Context context, c.f fVar) {
        this.f17533e = fVar;
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17529a = (TbPageContext) a2;
        }
        this.f17531c = new ArrayList();
        this.f17530b = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.f17533e);
        hotTopicView2.setScrollCallback(this.f17533e);
        this.f17530b.add(hotTopicView);
        this.f17530b.add(hotTopicView2);
    }

    public void A(List<e> list) {
        if (!ListUtils.isEmpty(list)) {
            this.f17531c.clear();
            this.f17531c.addAll(list);
        }
        notifyDataSetChanged();
        r();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f17531c);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return f17528g[i];
    }

    public void i(int i) {
        if (ListUtils.isEmpty(this.f17530b)) {
            return;
        }
        for (HotTopicView hotTopicView : this.f17530b) {
            hotTopicView.k(i);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(boolean z) {
        List<HotTopicView> list = this.f17530b;
        if (list != null) {
            for (HotTopicView hotTopicView : list) {
                if (hotTopicView != null) {
                    hotTopicView.m(z);
                }
            }
        }
    }

    public void k() {
        for (HotTopicView hotTopicView : this.f17530b) {
            if (hotTopicView != null) {
                hotTopicView.n();
            }
        }
    }

    public HotTopicView l() {
        int i = this.f17532d;
        if (i == -1) {
            return null;
        }
        return (HotTopicView) ListUtils.getItem(this.f17530b, i % 2);
    }

    public void m(int i) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f17530b;
        if (list == null || i >= list.size() || (hotTopicView = this.f17530b.get(i)) == null) {
            return;
        }
        hotTopicView.p();
    }

    public void n() {
        if (l() != null) {
            l().r();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: o */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.f17530b.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.f17534f);
        viewGroup.addView(hotTopicView);
        hotTopicView.q();
        hotTopicView.r();
        hotTopicView.A(this.f17531c.get(i));
        return hotTopicView;
    }

    public void p(int i) {
        for (int i2 = 0; i2 < this.f17531c.size(); i2++) {
            HotTopicView hotTopicView = this.f17530b.get(i2);
            if (hotTopicView != null) {
                hotTopicView.w(i);
            }
        }
    }

    public void q() {
        HotTopicView l = l();
        if (l != null) {
            l.z();
        }
    }

    public final void r() {
        int i = this.f17532d;
        if (i < 0) {
            return;
        }
        HotTopicView hotTopicView = this.f17530b.get(i % 2);
        e eVar = (e) ListUtils.getItem(this.f17531c, this.f17532d);
        if (hotTopicView != null) {
            hotTopicView.q();
            hotTopicView.r();
            hotTopicView.A(eVar);
            if (eVar == null || ListUtils.isEmpty(eVar.i())) {
                hotTopicView.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void s() {
        HotTopicView l = l();
        if (l != null) {
            l.B();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        int i2 = this.f17532d;
        if (i2 == i) {
            return;
        }
        this.f17532d = i;
        if (ListUtils.isEmpty(this.f17531c)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        e eVar = (e) ListUtils.getItem(this.f17531c, this.f17532d);
        if (eVar != null && eVar.h() != null) {
            if (this.f17532d == 0) {
                TiebaStatic.log(new StatisticItem("c11970").param("obj_id", eVar.h().f52110e));
            } else {
                TiebaStatic.log(new StatisticItem("c11971").param("obj_id", eVar.h().f52110e));
            }
        }
        HotTopicView hotTopicView = (HotTopicView) ListUtils.getItem(this.f17530b, i2 % 2);
        if (hotTopicView != null) {
            hotTopicView.z();
        }
        HotTopicView hotTopicView2 = (HotTopicView) ListUtils.getItem(this.f17530b, i % 2);
        if (hotTopicView2 != null) {
            if (eVar != null && !ListUtils.isEmpty(eVar.i())) {
                hotTopicView2.B();
            } else if (!d.b.b.e.p.j.A()) {
                hotTopicView2.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            } else {
                hotTopicView2.F(true);
                this.f17529a.getOrignalPage().loadHotTopicData();
            }
        }
    }

    public void u(int i) {
        for (HotTopicView hotTopicView : this.f17530b) {
            if (hotTopicView != null && hotTopicView != l()) {
                hotTopicView.C(i);
            }
        }
    }

    public void v(float f2) {
        for (HotTopicView hotTopicView : this.f17530b) {
            if (hotTopicView != null && hotTopicView != l()) {
                hotTopicView.D(f2);
            }
        }
    }

    public void w(c cVar) {
        this.f17534f = cVar;
    }

    public void x(int i) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f17530b;
        if (list == null || i >= list.size() || (hotTopicView = this.f17530b.get(i)) == null) {
            return;
        }
        hotTopicView.E();
    }

    public void y() {
        if (l() != null) {
            l().F(true);
        }
    }

    public void z(int i) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f17530b;
        if (list == null || i >= list.size() || (hotTopicView = this.f17530b.get(i)) == null) {
            return;
        }
        hotTopicView.H();
    }
}
