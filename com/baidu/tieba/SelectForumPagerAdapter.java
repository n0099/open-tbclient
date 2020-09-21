package com.baidu.tieba;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.tieba.lately.LatelyView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class SelectForumPagerAdapter extends PagerAdapter {
    private TbPageContext<SelectForumActivity> mPageContext;
    private int fph = -1;
    private List<d> fpg = new ArrayList();

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fpg.add(new LatelyView(this.mPageContext.getPageActivity()));
        this.fpg.add(new AttentionView(this.mPageContext.getPageActivity()));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.fpg);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return y.getItem(this.fpg, i) == null ? "" : ((d) y.getItem(this.fpg, i)).getTitle();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    /* renamed from: l */
    public d instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        d dVar = (d) y.getItem(this.fpg, i);
        if (dVar instanceof View) {
            if (((View) dVar).getParent() != null) {
                viewGroup.removeView((View) dVar);
            }
            viewGroup.addView((View) dVar);
        }
        return dVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.fph != i) {
            this.fph = i;
            d dVar = (d) y.getItem(this.fpg, i);
            if (dVar != null) {
                dVar.aw(null);
            }
        }
    }

    public void bBx() {
        for (d dVar : this.fpg) {
            dVar.onChangeSkinType();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }
}
