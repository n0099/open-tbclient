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
import d.a.k0.c1.c.e;
import d.a.k0.c1.f.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static String[] f16822g = {"最热", "最新"};

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f16823a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicView> f16824b;

    /* renamed from: c  reason: collision with root package name */
    public List<e> f16825c;

    /* renamed from: d  reason: collision with root package name */
    public int f16826d = -1;

    /* renamed from: e  reason: collision with root package name */
    public c.f f16827e;

    /* renamed from: f  reason: collision with root package name */
    public c f16828f;

    public HotTopicThreadPagerAdapter(Context context, c.f fVar) {
        this.f16827e = fVar;
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16823a = (TbPageContext) a2;
        }
        this.f16825c = new ArrayList();
        this.f16824b = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.f16827e);
        hotTopicView2.setScrollCallback(this.f16827e);
        this.f16824b.add(hotTopicView);
        this.f16824b.add(hotTopicView2);
    }

    public void b(int i2) {
        if (ListUtils.isEmpty(this.f16824b)) {
            return;
        }
        for (HotTopicView hotTopicView : this.f16824b) {
            hotTopicView.k(i2);
        }
    }

    public void c(boolean z) {
        List<HotTopicView> list = this.f16824b;
        if (list != null) {
            for (HotTopicView hotTopicView : list) {
                if (hotTopicView != null) {
                    hotTopicView.m(z);
                }
            }
        }
    }

    public void d() {
        for (HotTopicView hotTopicView : this.f16824b) {
            if (hotTopicView != null) {
                hotTopicView.n();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public HotTopicView e() {
        int i2 = this.f16826d;
        if (i2 == -1) {
            return null;
        }
        return (HotTopicView) ListUtils.getItem(this.f16824b, i2 % 2);
    }

    public void f(int i2) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f16824b;
        if (list == null || i2 >= list.size() || (hotTopicView = this.f16824b.get(i2)) == null) {
            return;
        }
        hotTopicView.p();
    }

    public void g() {
        if (e() != null) {
            e().r();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f16825c);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return f16822g[i2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: h */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i2) {
        HotTopicView hotTopicView = this.f16824b.get(i2 % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.f16828f);
        viewGroup.addView(hotTopicView);
        hotTopicView.q();
        hotTopicView.r();
        hotTopicView.A(this.f16825c.get(i2));
        return hotTopicView;
    }

    public void i(int i2) {
        for (int i3 = 0; i3 < this.f16825c.size(); i3++) {
            HotTopicView hotTopicView = this.f16824b.get(i3);
            if (hotTopicView != null) {
                hotTopicView.w(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j() {
        HotTopicView e2 = e();
        if (e2 != null) {
            e2.z();
        }
    }

    public final void k() {
        int i2 = this.f16826d;
        if (i2 < 0) {
            return;
        }
        HotTopicView hotTopicView = this.f16824b.get(i2 % 2);
        e eVar = (e) ListUtils.getItem(this.f16825c, this.f16826d);
        if (hotTopicView != null) {
            hotTopicView.q();
            hotTopicView.r();
            hotTopicView.A(eVar);
            if (eVar == null || ListUtils.isEmpty(eVar.i())) {
                hotTopicView.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void l() {
        HotTopicView e2 = e();
        if (e2 != null) {
            e2.B();
        }
    }

    public void m(int i2) {
        for (HotTopicView hotTopicView : this.f16824b) {
            if (hotTopicView != null && hotTopicView != e()) {
                hotTopicView.C(i2);
            }
        }
    }

    public void n(float f2) {
        for (HotTopicView hotTopicView : this.f16824b) {
            if (hotTopicView != null && hotTopicView != e()) {
                hotTopicView.D(f2);
            }
        }
    }

    public void o(c cVar) {
        this.f16828f = cVar;
    }

    public void p(int i2) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f16824b;
        if (list == null || i2 >= list.size() || (hotTopicView = this.f16824b.get(i2)) == null) {
            return;
        }
        hotTopicView.E();
    }

    public void q() {
        if (e() != null) {
            e().F(true);
        }
    }

    public void r(int i2) {
        HotTopicView hotTopicView;
        List<HotTopicView> list = this.f16824b;
        if (list == null || i2 >= list.size() || (hotTopicView = this.f16824b.get(i2)) == null) {
            return;
        }
        hotTopicView.H();
    }

    public void s(List<e> list) {
        if (!ListUtils.isEmpty(list)) {
            this.f16825c.clear();
            this.f16825c.addAll(list);
        }
        notifyDataSetChanged();
        k();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        int i3 = this.f16826d;
        if (i3 == i2) {
            return;
        }
        this.f16826d = i2;
        if (ListUtils.isEmpty(this.f16825c)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        e eVar = (e) ListUtils.getItem(this.f16825c, this.f16826d);
        if (eVar != null && eVar.h() != null) {
            if (this.f16826d == 0) {
                TiebaStatic.log(new StatisticItem("c11970").param("obj_id", eVar.h().f52393e));
            } else {
                TiebaStatic.log(new StatisticItem("c11971").param("obj_id", eVar.h().f52393e));
            }
        }
        HotTopicView hotTopicView = (HotTopicView) ListUtils.getItem(this.f16824b, i3 % 2);
        if (hotTopicView != null) {
            hotTopicView.z();
        }
        HotTopicView hotTopicView2 = (HotTopicView) ListUtils.getItem(this.f16824b, i2 % 2);
        if (hotTopicView2 != null) {
            if (eVar != null && !ListUtils.isEmpty(eVar.i())) {
                hotTopicView2.B();
            } else if (!d.a.c.e.p.j.A()) {
                hotTopicView2.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            } else {
                hotTopicView2.F(true);
                this.f16823a.getOrignalPage().loadHotTopicData();
            }
        }
    }
}
