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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte jxF;
    private TbPageContext<?> pageContext;
    private int ajv = 3;
    private List<com.baidu.adp.widget.ListView.q> jxG = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jxH = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.jxF = b;
        for (int i = 0; i < 6; i++) {
            this.jxH.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.jxG);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.y.isEmpty(cVar.cIB())) {
            this.jxG.clear();
            this.jxG.addAll(cVar.cIB());
            for (int i = 0; i < this.jxG.size() && i < this.jxH.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jxH.get(i);
                bVar.qV(!cVar.cIC());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jxG, i));
            }
            notifyDataSetChanged();
            if (this.jxG.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.jxG.get(0);
                ar ak = new ar("c14004").dR("uid", TbadkApplication.getCurrentAccount()).ak("obj_locate", this.jxF).ak("obj_param1", 0);
                if (!StringUtils.isNull(dVar.jxR)) {
                    ak = ak.dR("obj_name", dVar.jxR);
                }
                TiebaStatic.log(ak);
                ar ak2 = new ar("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", dVar.cID()).ak("obj_locate", this.jxF);
                TiebaStatic.log(StringUtils.isNull(dVar.jxR) ? ak2 : ak2.dR("obj_name", dVar.jxR));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jxH.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jxH == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.jxH, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jxG, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.ajv != i) {
            this.ajv = i;
            if (this.jxH != null && this.jxH.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jxH) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q BJ(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.jxG) || i >= this.jxG.size()) {
            return null;
        }
        return this.jxG.get(i);
    }

    public void l(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jxH)) {
            for (int i = 0; i < this.jxH.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jxH.get(i);
                com.baidu.tieba.homepage.concern.a.d cIK = bVar.cIK();
                if (cIK != null) {
                    for (int i2 = 0; i2 < cIK.jxT.length; i2++) {
                        if (cIK.jxT[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
