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
    private byte jTS;
    private TbPageContext<?> pageContext;
    private int akf = 3;
    private List<com.baidu.adp.widget.ListView.n> jTT = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jTU = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        this.pageContext = tbPageContext;
        this.jTS = b2;
        for (int i = 0; i < 6; i++) {
            this.jTU.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b2));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.x.getCount(this.jTT);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.x.isEmpty(cVar.cNg())) {
            this.jTT.clear();
            this.jTT.addAll(cVar.cNg());
            for (int i = 0; i < this.jTT.size() && i < this.jTU.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jTU.get(i);
                bVar.rP(!cVar.cNh());
                bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(this.jTT, i));
            }
            notifyDataSetChanged();
            if (this.jTT.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.jTT.get(0);
                aq an = new aq("c14004").dW("uid", TbadkApplication.getCurrentAccount()).an("obj_locate", this.jTS).an("obj_param1", 0);
                if (!StringUtils.isNull(dVar.jUe)) {
                    an = an.dW("obj_name", dVar.jUe);
                }
                TiebaStatic.log(an);
                aq an2 = new aq("c13643").dW("uid", TbadkApplication.getCurrentAccount()).dW("fid", dVar.cNi()).an("obj_locate", this.jTS);
                TiebaStatic.log(StringUtils.isNull(dVar.jUe) ? an2 : an2.dW("obj_name", dVar.jUe));
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jTU.get(i).getView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jTU == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.x.getItem(this.jTU, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(this.jTT, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.akf != i) {
            this.akf = i;
            if (this.jTU != null && this.jTU.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jTU) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.n Bf(int i) {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.jTT) || i >= this.jTT.size()) {
            return null;
        }
        return this.jTT.get(i);
    }

    public void n(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jTU)) {
            for (int i = 0; i < this.jTU.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jTU.get(i);
                com.baidu.tieba.homepage.concern.a.d cNp = bVar.cNp();
                if (cNp != null) {
                    for (int i2 = 0; i2 < cNp.jUg.length; i2++) {
                        if (cNp.jUg[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
