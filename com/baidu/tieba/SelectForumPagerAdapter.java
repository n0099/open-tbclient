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
/* loaded from: classes22.dex */
public class SelectForumPagerAdapter extends PagerAdapter {
    private TbPageContext<SelectForumActivity> mPageContext;
    private int fJQ = -1;
    private List<d> fJP = new ArrayList();

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fJP.add(new LatelyView(this.mPageContext.getPageActivity()));
        this.fJP.add(new AttentionView(this.mPageContext.getPageActivity()));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.fJP);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return y.getItem(this.fJP, i) == null ? "" : ((d) y.getItem(this.fJP, i)).getTitle();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    /* renamed from: n */
    public d instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        d dVar = (d) y.getItem(this.fJP, i);
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
        if (this.fJQ != i) {
            this.fJQ = i;
            d dVar = (d) y.getItem(this.fJP, i);
            if (dVar != null) {
                dVar.az(null);
            }
        }
    }

    public void bGc() {
        for (d dVar : this.fJP) {
            dVar.onChangeSkinType();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }
}
