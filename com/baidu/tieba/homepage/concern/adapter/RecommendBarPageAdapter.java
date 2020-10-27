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
/* loaded from: classes22.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte jqR;
    private TbPageContext<?> pageContext;
    private int ajq = 3;
    private List<com.baidu.adp.widget.ListView.q> jqS = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jqT = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.jqR = b;
        for (int i = 0; i < 6; i++) {
            this.jqT.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.jqS);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.d dVar) {
        if (dVar != null && !com.baidu.tbadk.core.util.y.isEmpty(dVar.cGv())) {
            this.jqS.clear();
            this.jqS.addAll(dVar.cGv());
            for (int i = 0; i < this.jqS.size() && i < this.jqT.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jqT.get(i);
                bVar.qJ(!dVar.cGw());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jqS, i));
            }
            notifyDataSetChanged();
            if (this.jqS.get(0) instanceof com.baidu.tieba.homepage.concern.a.e) {
                com.baidu.tieba.homepage.concern.a.e eVar = (com.baidu.tieba.homepage.concern.a.e) this.jqS.get(0);
                aq aj = new aq("c14004").dR("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jqR).aj("obj_param1", 0);
                if (!StringUtils.isNull(eVar.jrd)) {
                    aj = aj.dR("obj_name", eVar.jrd);
                }
                TiebaStatic.log(aj);
                aq aj2 = new aq("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", eVar.cGx()).aj("obj_locate", this.jqR);
                TiebaStatic.log(StringUtils.isNull(eVar.jrd) ? aj2 : aj2.dR("obj_name", eVar.jrd));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jqT.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jqT == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.jqT, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jqS, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.ajq != i) {
            this.ajq = i;
            if (this.jqT != null && this.jqT.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jqT) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q AY(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.jqS) || i >= this.jqS.size()) {
            return null;
        }
        return this.jqS.get(i);
    }

    public void l(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jqT)) {
            for (int i = 0; i < this.jqT.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jqT.get(i);
                com.baidu.tieba.homepage.concern.a.e cGE = bVar.cGE();
                if (cGE != null) {
                    for (int i2 = 0; i2 < cGE.jrf.length; i2++) {
                        if (cGE.jrf[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
