package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.tieba.lately.LatelyView;
import d.a.n0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f13422a;

    /* renamed from: b  reason: collision with root package name */
    public List<d> f13423b;

    /* renamed from: c  reason: collision with root package name */
    public int f13424c = -1;

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        this.f13422a = tbPageContext;
        ArrayList arrayList = new ArrayList();
        this.f13423b = arrayList;
        arrayList.add(new LatelyView(this.f13422a.getPageActivity()));
        this.f13423b.add(new AttentionView(this.f13422a.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    /* renamed from: b */
    public d instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        d dVar = (d) ListUtils.getItem(this.f13423b, i2);
        if (dVar instanceof View) {
            View view = (View) dVar;
            if (view.getParent() != null) {
                viewGroup.removeView(view);
            }
            viewGroup.addView(view);
        }
        return dVar;
    }

    public void c() {
        for (d dVar : this.f13423b) {
            dVar.onDestroy();
        }
    }

    public void d() {
        for (d dVar : this.f13423b) {
            dVar.a();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.destroyItem(viewGroup, i2, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f13423b);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        return ListUtils.getItem(this.f13423b, i2) == null ? "" : ((d) ListUtils.getItem(this.f13423b, i2)).getTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.f13424c == i2) {
            return;
        }
        this.f13424c = i2;
        d dVar = (d) ListUtils.getItem(this.f13423b, i2);
        if (dVar != null) {
            dVar.c(null);
        }
    }
}
