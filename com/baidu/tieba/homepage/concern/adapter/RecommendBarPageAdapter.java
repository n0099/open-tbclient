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
import d.b.b.j.e.n;
import d.b.i0.z0.b.f.c;
import d.b.i0.z0.b.f.d;
import d.b.i0.z0.b.g.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendBarPageAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f17030c;

    /* renamed from: e  reason: collision with root package name */
    public byte f17032e;

    /* renamed from: d  reason: collision with root package name */
    public int f17031d = 3;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f17028a = new ArrayList(6);

    /* renamed from: b  reason: collision with root package name */
    public List<b> f17029b = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        this.f17030c = tbPageContext;
        this.f17032e = b2;
        for (int i = 0; i < 6; i++) {
            this.f17029b.add(new b(LayoutInflater.from(this.f17030c.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.f17030c, b2));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.f17029b.get(i).b());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f17028a);
    }

    public n i(int i) {
        if (ListUtils.isEmpty(this.f17028a) || i >= this.f17028a.size()) {
            return null;
        }
        return this.f17028a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        List<b> list = this.f17029b;
        if (list == null) {
            return super.instantiateItem(viewGroup, i);
        }
        b bVar = (b) ListUtils.getItem(list, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.b().getParent() == null) {
            viewGroup.addView(bVar.b(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.b().setTag(Integer.valueOf(i));
        bVar.c((n) ListUtils.getItem(this.f17028a, i));
        return bVar.b();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void j(int i) {
        if (this.f17031d == i) {
            return;
        }
        this.f17031d = i;
        List<b> list = this.f17029b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f17029b) {
            bVar.l(i);
        }
    }

    public void k(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.z())) {
            return;
        }
        this.f17028a.clear();
        this.f17028a.addAll(cVar.z());
        for (int i = 0; i < this.f17028a.size() && i < this.f17029b.size(); i++) {
            b bVar = this.f17029b.get(i);
            bVar.m(!cVar.A());
            bVar.c((n) ListUtils.getItem(this.f17028a, i));
        }
        notifyDataSetChanged();
        if (this.f17028a.get(0) instanceof d) {
            d dVar = (d) this.f17028a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f17032e).param("obj_param1", 0);
            if (!StringUtils.isNull(dVar.f62796e)) {
                param = param.param("obj_name", dVar.f62796e);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.a()).param("obj_locate", (int) this.f17032e);
            if (!StringUtils.isNull(dVar.f62796e)) {
                param2 = param2.param("obj_name", dVar.f62796e);
            }
            TiebaStatic.log(param2);
        }
    }

    public void l(long j, boolean z) {
        if (ListUtils.isEmpty(this.f17029b)) {
            return;
        }
        for (int i = 0; i < this.f17029b.size(); i++) {
            b bVar = this.f17029b.get(i);
            d j2 = bVar.j();
            if (j2 != null) {
                int i2 = 0;
                while (true) {
                    d.a[] aVarArr = j2.f62799h;
                    if (i2 < aVarArr.length) {
                        if (aVarArr[i2].j() == j) {
                            bVar.n(i2, z);
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
