package com.baidu.tieba.homepage.concern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.o0.b1.c.f.c;
import d.a.o0.b1.c.f.d;
import d.a.o0.b1.c.g.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendBarPageAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f16331c;

    /* renamed from: e  reason: collision with root package name */
    public byte f16333e;

    /* renamed from: d  reason: collision with root package name */
    public int f16332d = 3;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f16329a = new ArrayList(6);

    /* renamed from: b  reason: collision with root package name */
    public List<b> f16330b = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        this.f16331c = tbPageContext;
        this.f16333e = b2;
        for (int i2 = 0; i2 < 6; i2++) {
            this.f16330b.add(new b(LayoutInflater.from(this.f16331c.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.f16331c, b2));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, @NonNull Object obj) {
        viewGroup.removeView(this.f16330b.get(i2).b());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f16329a);
    }

    public n i(int i2) {
        if (ListUtils.isEmpty(this.f16329a) || i2 >= this.f16329a.size()) {
            return null;
        }
        return this.f16329a.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        List<b> list = this.f16330b;
        if (list == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        b bVar = (b) ListUtils.getItem(list, i2);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        if (bVar.b().getParent() == null) {
            viewGroup.addView(bVar.b(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.b().setTag(Integer.valueOf(i2));
        bVar.c((n) ListUtils.getItem(this.f16329a, i2));
        return bVar.b();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void j(int i2) {
        if (this.f16332d == i2) {
            return;
        }
        this.f16332d = i2;
        List<b> list = this.f16330b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f16330b) {
            bVar.l(i2);
        }
    }

    public void k(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.z())) {
            return;
        }
        this.f16329a.clear();
        this.f16329a.addAll(cVar.z());
        for (int i2 = 0; i2 < this.f16329a.size() && i2 < this.f16330b.size(); i2++) {
            b bVar = this.f16330b.get(i2);
            bVar.m(!cVar.A());
            bVar.c((n) ListUtils.getItem(this.f16329a, i2));
        }
        notifyDataSetChanged();
        if (this.f16329a.get(0) instanceof d) {
            d dVar = (d) this.f16329a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f16333e).param("obj_param1", 0);
            if (!StringUtils.isNull(dVar.f55201e)) {
                param = param.param("obj_name", dVar.f55201e);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.b()).param("obj_locate", (int) this.f16333e);
            if (!StringUtils.isNull(dVar.f55201e)) {
                param2 = param2.param("obj_name", dVar.f55201e);
            }
            TiebaStatic.log(param2);
        }
    }

    public void l(long j, boolean z) {
        if (ListUtils.isEmpty(this.f16330b)) {
            return;
        }
        for (int i2 = 0; i2 < this.f16330b.size(); i2++) {
            b bVar = this.f16330b.get(i2);
            d j2 = bVar.j();
            if (j2 != null) {
                int i3 = 0;
                while (true) {
                    d.a[] aVarArr = j2.f55204h;
                    if (i3 < aVarArr.length) {
                        if (aVarArr[i3].h() == j) {
                            bVar.n(i3, z);
                        }
                        i3++;
                    }
                }
            }
        }
    }
}
