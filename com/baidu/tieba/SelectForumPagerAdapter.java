package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.tieba.lately.LatelyView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectForumPagerAdapter extends PagerAdapter {
    private TbPageContext<SelectForumActivity> mPageContext;
    private int gcz = -1;
    private List<d> gcy = new ArrayList();

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gcy.add(new LatelyView(this.mPageContext.getPageActivity()));
        this.gcy.add(new AttentionView(this.mPageContext.getPageActivity()));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.gcy);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return x.getItem(this.gcy, i) == null ? "" : ((d) x.getItem(this.gcy, i)).getTitle();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    /* renamed from: r */
    public d instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        d dVar = (d) x.getItem(this.gcy, i);
        if (dVar instanceof View) {
            if (((View) dVar).getParent() != null) {
                viewGroup.removeView((View) dVar);
            }
            viewGroup.addView((View) dVar);
        }
        return dVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.gcz != i) {
            this.gcz = i;
            d dVar = (d) x.getItem(this.gcy, i);
            if (dVar != null) {
                dVar.aB(null);
            }
        }
    }

    public void bKf() {
        for (d dVar : this.gcy) {
            dVar.onChangeSkinType();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void onDestroy() {
        for (d dVar : this.gcy) {
            dVar.onDestroy();
        }
    }
}
