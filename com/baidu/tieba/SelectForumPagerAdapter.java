package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.tieba.lately.LatelyView;
import d.b.i0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f14123a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f14124b;

    /* renamed from: c  reason: collision with root package name */
    public int f14125c = -1;

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        this.f14123a = tbPageContext;
        ArrayList arrayList = new ArrayList();
        this.f14124b = arrayList;
        arrayList.add(new LatelyView(this.f14123a.getPageActivity()));
        this.f14124b.add(new AttentionView(this.f14123a.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    /* renamed from: b */
    public d instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.f14124b, i);
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
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void e() {
        for (d dVar : this.f14124b) {
            dVar.onDestroy();
        }
    }

    public void f() {
        for (d dVar : this.f14124b) {
            dVar.a();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14124b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return ListUtils.getItem(this.f14124b, i) == null ? "" : ((d) ListUtils.getItem(this.f14124b, i)).getTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.f14125c == i) {
            return;
        }
        this.f14125c = i;
        d dVar = (d) ListUtils.getItem(this.f14124b, i);
        if (dVar != null) {
            dVar.c(null);
        }
    }
}
