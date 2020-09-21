package com.baidu.tieba.homepage.concern.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private int aiX = 3;
    private List<com.baidu.adp.widget.ListView.q> iPA = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> iPB = new ArrayList(6);
    private byte iPz;
    private TbPageContext<?> pageContext;

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.iPz = b;
        for (int i = 0; i < 6; i++) {
            this.iPB.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.iPA);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.d dVar) {
        if (dVar != null && !com.baidu.tbadk.core.util.y.isEmpty(dVar.czK())) {
            this.iPA.clear();
            this.iPA.addAll(dVar.czK());
            for (int i = 0; i < this.iPA.size() && i < this.iPB.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.iPB.get(i);
                bVar.pL(!dVar.czL());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.iPA, i));
            }
            notifyDataSetChanged();
            if (this.iPA.get(0) instanceof com.baidu.tieba.homepage.concern.a.e) {
                com.baidu.tieba.homepage.concern.a.e eVar = (com.baidu.tieba.homepage.concern.a.e) this.iPA.get(0);
                aq ai = new aq("c14004").dF("uid", TbadkApplication.getCurrentAccount()).ai("obj_locate", this.iPz).ai("obj_param1", 0);
                if (!StringUtils.isNull(eVar.iPL)) {
                    ai = ai.dF("obj_name", eVar.iPL);
                }
                TiebaStatic.log(ai);
                aq ai2 = new aq("c13643").dF("uid", TbadkApplication.getCurrentAccount()).dF("fid", eVar.czM()).ai("obj_locate", this.iPz);
                TiebaStatic.log(StringUtils.isNull(eVar.iPL) ? ai2 : ai2.dF("obj_name", eVar.iPL));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.iPB.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.iPB == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.iPB, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.iPA, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.aiX != i) {
            this.aiX = i;
            if (this.iPB != null && this.iPB.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.iPB) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q zZ(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.iPA) || i >= this.iPA.size()) {
            return null;
        }
        return this.iPA.get(i);
    }

    public void k(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iPB)) {
            for (int i = 0; i < this.iPB.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.iPB.get(i);
                com.baidu.tieba.homepage.concern.a.e czT = bVar.czT();
                if (czT != null) {
                    for (int i2 = 0; i2 < czT.iPN.length; i2++) {
                        if (czT.iPN[i2].getForumId() == j) {
                            bVar.U(i2, z);
                        }
                    }
                }
            }
        }
    }
}
