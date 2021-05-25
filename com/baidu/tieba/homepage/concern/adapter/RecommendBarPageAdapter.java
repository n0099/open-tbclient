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
import d.a.c.j.e.n;
import d.a.n0.b1.b.f.c;
import d.a.n0.b1.b.f.d;
import d.a.n0.b1.b.g.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendBarPageAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f16181c;

    /* renamed from: e  reason: collision with root package name */
    public byte f16183e;

    /* renamed from: d  reason: collision with root package name */
    public int f16182d = 3;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f16179a = new ArrayList(6);

    /* renamed from: b  reason: collision with root package name */
    public List<b> f16180b = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        this.f16181c = tbPageContext;
        this.f16183e = b2;
        for (int i2 = 0; i2 < 6; i2++) {
            this.f16180b.add(new b(LayoutInflater.from(this.f16181c.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.f16181c, b2));
        }
    }

    public n b(int i2) {
        if (ListUtils.isEmpty(this.f16179a) || i2 >= this.f16179a.size()) {
            return null;
        }
        return this.f16179a.get(i2);
    }

    public void c(int i2) {
        if (this.f16182d == i2) {
            return;
        }
        this.f16182d = i2;
        List<b> list = this.f16180b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f16180b) {
            bVar.l(i2);
        }
    }

    public void d(c cVar) {
        if (cVar == null || ListUtils.isEmpty(cVar.z())) {
            return;
        }
        this.f16179a.clear();
        this.f16179a.addAll(cVar.z());
        for (int i2 = 0; i2 < this.f16179a.size() && i2 < this.f16180b.size(); i2++) {
            b bVar = this.f16180b.get(i2);
            bVar.m(!cVar.A());
            bVar.c((n) ListUtils.getItem(this.f16179a, i2));
        }
        notifyDataSetChanged();
        if (this.f16179a.get(0) instanceof d) {
            d dVar = (d) this.f16179a.get(0);
            StatisticItem param = new StatisticItem("c14004").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.f16183e).param("obj_param1", 0);
            if (!StringUtils.isNull(dVar.f51393e)) {
                param = param.param("obj_name", dVar.f51393e);
            }
            TiebaStatic.log(param);
            StatisticItem param2 = new StatisticItem("c13643").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", dVar.c()).param("obj_locate", (int) this.f16183e);
            if (!StringUtils.isNull(dVar.f51393e)) {
                param2 = param2.param("obj_name", dVar.f51393e);
            }
            TiebaStatic.log(param2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, @NonNull Object obj) {
        viewGroup.removeView(this.f16180b.get(i2).b());
    }

    public void e(long j, boolean z) {
        if (ListUtils.isEmpty(this.f16180b)) {
            return;
        }
        for (int i2 = 0; i2 < this.f16180b.size(); i2++) {
            b bVar = this.f16180b.get(i2);
            d j2 = bVar.j();
            if (j2 != null) {
                int i3 = 0;
                while (true) {
                    d.a[] aVarArr = j2.f51396h;
                    if (i3 < aVarArr.length) {
                        if (aVarArr[i3].i() == j) {
                            bVar.n(i3, z);
                        }
                        i3++;
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f16179a);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        List<b> list = this.f16180b;
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
        bVar.c((n) ListUtils.getItem(this.f16179a, i2));
        return bVar.b();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
