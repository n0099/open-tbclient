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
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.n0.d1.c.e;
import d.a.n0.d1.f.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static String[] f16808g = {"最热", "最新"};

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f16809a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicView> f16810b;

    /* renamed from: c  reason: collision with root package name */
    public List<e> f16811c;

    /* renamed from: d  reason: collision with root package name */
    public int f16812d = -1;

    /* renamed from: e  reason: collision with root package name */
    public c.f f16813e;

    /* renamed from: f  reason: collision with root package name */
    public c f16814f;

    public HotTopicThreadPagerAdapter(Context context, c.f fVar) {
        this.f16813e = fVar;
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16809a = (TbPageContext) a2;
        }
        this.f16811c = new ArrayList();
        this.f16810b = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.f16813e);
        hotTopicView2.setScrollCallback(this.f16813e);
        this.f16810b.add(hotTopicView);
        this.f16810b.add(hotTopicView2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f16811c);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return f16808g[i2];
    }

    public void i(int i2) {
        if (ListUtils.isEmpty(this.f16810b)) {
            return;
        }
        for (HotTopicView hotTopicView : this.f16810b) {
            hotTopicView.k(i2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(boolean z) {
        List<HotTopicView> list = this.f16810b;
        if (list != null) {
            for (HotTopicView hotTopicView : list) {
                if (hotTopicView != null) {
                    hotTopicView.m(z);
                }
            }
        }
    }

    public void k() {
        for (HotTopicView hotTopicView : this.f16810b) {
            if (hotTopicView != null) {
                hotTopicView.n();
            }
        }
    }

    public HotTopicView l() {
        int i2 = this.f16812d;
        if (i2 == -1) {
            return null;
        }
        return (HotTopicView) ListUtils.getItem(this.f16810b, i2 % 2);
    }

    public void m(int i2) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f16810b;
        if (list == null || i2 >= list.size() || (hotTopicView = this.f16810b.get(i2)) == null) {
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
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i2) {
        HotTopicView hotTopicView = this.f16810b.get(i2 % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.f16814f);
        viewGroup.addView(hotTopicView);
        hotTopicView.q();
        hotTopicView.r();
        hotTopicView.A(this.f16811c.get(i2));
        return hotTopicView;
    }

    public void p(int i2) {
        for (int i3 = 0; i3 < this.f16811c.size(); i3++) {
            HotTopicView hotTopicView = this.f16810b.get(i3);
            if (hotTopicView != null) {
                hotTopicView.w(i2);
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
        int i2 = this.f16812d;
        if (i2 < 0) {
            return;
        }
        HotTopicView hotTopicView = this.f16810b.get(i2 % 2);
        e eVar = (e) ListUtils.getItem(this.f16811c, this.f16812d);
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
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        int i3 = this.f16812d;
        if (i3 == i2) {
            return;
        }
        this.f16812d = i2;
        if (ListUtils.isEmpty(this.f16811c)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        e eVar = (e) ListUtils.getItem(this.f16811c, this.f16812d);
        if (eVar != null && eVar.h() != null) {
            if (this.f16812d == 0) {
                TiebaStatic.log(new StatisticItem("c11970").param("obj_id", eVar.h().f56262e));
            } else {
                TiebaStatic.log(new StatisticItem("c11971").param("obj_id", eVar.h().f56262e));
            }
        }
        HotTopicView hotTopicView = (HotTopicView) ListUtils.getItem(this.f16810b, i3 % 2);
        if (hotTopicView != null) {
            hotTopicView.z();
        }
        HotTopicView hotTopicView2 = (HotTopicView) ListUtils.getItem(this.f16810b, i2 % 2);
        if (hotTopicView2 != null) {
            if (eVar != null && !ListUtils.isEmpty(eVar.i())) {
                hotTopicView2.B();
            } else if (!d.a.c.e.p.j.A()) {
                hotTopicView2.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            } else {
                hotTopicView2.F(true);
                this.f16809a.getOrignalPage().loadHotTopicData();
            }
        }
    }

    public void t(int i2) {
        for (HotTopicView hotTopicView : this.f16810b) {
            if (hotTopicView != null && hotTopicView != l()) {
                hotTopicView.C(i2);
            }
        }
    }

    public void u(float f2) {
        for (HotTopicView hotTopicView : this.f16810b) {
            if (hotTopicView != null && hotTopicView != l()) {
                hotTopicView.D(f2);
            }
        }
    }

    public void v(c cVar) {
        this.f16814f = cVar;
    }

    public void w(int i2) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f16810b;
        if (list == null || i2 >= list.size() || (hotTopicView = this.f16810b.get(i2)) == null) {
            return;
        }
        hotTopicView.E();
    }

    public void x() {
        if (l() != null) {
            l().F(true);
        }
    }

    public void y(int i2) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f16810b;
        if (list == null || i2 >= list.size() || (hotTopicView = this.f16810b.get(i2)) == null) {
            return;
        }
        hotTopicView.H();
    }

    public void z(List<e> list) {
        if (!ListUtils.isEmpty(list)) {
            this.f16811c.clear();
            this.f16811c.addAll(list);
        }
        notifyDataSetChanged();
        r();
    }
}
