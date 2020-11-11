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
    private byte jwO;
    private TbPageContext<?> pageContext;
    private int ajq = 3;
    private List<com.baidu.adp.widget.ListView.q> jwP = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jwQ = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.jwO = b;
        for (int i = 0; i < 6; i++) {
            this.jwQ.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.jwP);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.d dVar) {
        if (dVar != null && !com.baidu.tbadk.core.util.y.isEmpty(dVar.cIW())) {
            this.jwP.clear();
            this.jwP.addAll(dVar.cIW());
            for (int i = 0; i < this.jwP.size() && i < this.jwQ.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jwQ.get(i);
                bVar.qS(!dVar.cIX());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jwP, i));
            }
            notifyDataSetChanged();
            if (this.jwP.get(0) instanceof com.baidu.tieba.homepage.concern.a.e) {
                com.baidu.tieba.homepage.concern.a.e eVar = (com.baidu.tieba.homepage.concern.a.e) this.jwP.get(0);
                aq al = new aq("c14004").dR("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jwO).al("obj_param1", 0);
                if (!StringUtils.isNull(eVar.jxa)) {
                    al = al.dR("obj_name", eVar.jxa);
                }
                TiebaStatic.log(al);
                aq al2 = new aq("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", eVar.cIY()).al("obj_locate", this.jwO);
                TiebaStatic.log(StringUtils.isNull(eVar.jxa) ? al2 : al2.dR("obj_name", eVar.jxa));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jwQ.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jwQ == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.jwQ, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jwP, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.ajq != i) {
            this.ajq = i;
            if (this.jwQ != null && this.jwQ.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jwQ) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q Bl(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.jwP) || i >= this.jwP.size()) {
            return null;
        }
        return this.jwP.get(i);
    }

    public void l(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jwQ)) {
            for (int i = 0; i < this.jwQ.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jwQ.get(i);
                com.baidu.tieba.homepage.concern.a.e cJf = bVar.cJf();
                if (cJf != null) {
                    for (int i2 = 0; i2 < cJf.jxc.length; i2++) {
                        if (cJf.jxc[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
