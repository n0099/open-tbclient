package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.tieba.lately.LatelyView;
import d.a.o0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f13569a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f13570b;

    /* renamed from: c  reason: collision with root package name */
    public int f13571c = -1;

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        this.f13569a = tbPageContext;
        ArrayList arrayList = new ArrayList();
        this.f13570b = arrayList;
        arrayList.add(new LatelyView(this.f13569a.getPageActivity()));
        this.f13570b.add(new AttentionView(this.f13569a.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    /* renamed from: b */
    public d instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        d dVar = (d) ListUtils.getItem(this.f13570b, i2);
        if (dVar instanceof View) {
            View view = (View) dVar;
            if (view.getParent() != null) {
                viewGroup.removeView(view);
            }
            viewGroup.addView(view);
        }
        return dVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.destroyItem(viewGroup, i2, obj);
    }

    public void e() {
        for (d dVar : this.f13570b) {
            dVar.onDestroy();
        }
    }

    public void f() {
        for (d dVar : this.f13570b) {
            dVar.a();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f13570b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return ListUtils.getItem(this.f13570b, i2) == null ? "" : ((d) ListUtils.getItem(this.f13570b, i2)).getTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.f13571c == i2) {
            return;
        }
        this.f13571c = i2;
        d dVar = (d) ListUtils.getItem(this.f13570b, i2);
        if (dVar != null) {
            dVar.c(null);
        }
    }
}
