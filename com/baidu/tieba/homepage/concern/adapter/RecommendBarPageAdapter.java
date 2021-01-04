package com.baidu.tieba.homepage.concern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte jYx;
    private TbPageContext<?> pageContext;
    private int akW = 3;
    private List<com.baidu.adp.widget.ListView.n> jYy = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jYz = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        this.pageContext = tbPageContext;
        this.jYx = b2;
        for (int i = 0; i < 6; i++) {
            this.jYz.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b2));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.getCount(this.jYy);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.x.isEmpty(cVar.cQX())) {
            this.jYy.clear();
            this.jYy.addAll(cVar.cQX());
            for (int i = 0; i < this.jYy.size() && i < this.jYz.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jYz.get(i);
                bVar.rT(!cVar.cQY());
                bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(this.jYy, i));
            }
            notifyDataSetChanged();
            if (this.jYy.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.jYy.get(0);
                aq an = new aq("c14004").dX("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jYx).an("obj_param1", 0);
                if (!StringUtils.isNull(dVar.jYJ)) {
                    an = an.dX("obj_name", dVar.jYJ);
                }
                TiebaStatic.log(an);
                aq an2 = new aq("c13643").dX("uid", TbadkApplication.getCurrentAccount()).dX("fid", dVar.cQZ()).an("obj_locate", this.jYx);
                TiebaStatic.log(StringUtils.isNull(dVar.jYJ) ? an2 : an2.dX("obj_name", dVar.jYJ));
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jYz.get(i).getView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jYz == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.x.getItem(this.jYz, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(this.jYy, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.akW != i) {
            this.akW = i;
            if (this.jYz != null && this.jYz.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jYz) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.n CM(int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.jYy) || i >= this.jYy.size()) {
            return null;
        }
        return this.jYy.get(i);
    }

    public void m(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jYz)) {
            for (int i = 0; i < this.jYz.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jYz.get(i);
                com.baidu.tieba.homepage.concern.a.d cRg = bVar.cRg();
                if (cRg != null) {
                    for (int i2 = 0; i2 < cRg.jYL.length; i2++) {
                        if (cRg.jYL[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
