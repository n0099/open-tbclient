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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte kdJ;
    private TbPageContext<?> pageContext;
    private int aln = 3;
    private List<com.baidu.adp.widget.ListView.n> kdK = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> kdL = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.kdJ = b;
        for (int i = 0; i < 6; i++) {
            this.kdL.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.kdK);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.y.isEmpty(cVar.cPq())) {
            this.kdK.clear();
            this.kdK.addAll(cVar.cPq());
            for (int i = 0; i < this.kdK.size() && i < this.kdL.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.kdL.get(i);
                bVar.sb(!cVar.cPr());
                bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(this.kdK, i));
            }
            notifyDataSetChanged();
            if (this.kdK.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.kdK.get(0);
                ar aq = new ar("c14004").dR("uid", TbadkApplication.getCurrentAccount()).aq("obj_locate", this.kdJ).aq("obj_param1", 0);
                if (!StringUtils.isNull(dVar.kdV)) {
                    aq = aq.dR("obj_name", dVar.kdV);
                }
                TiebaStatic.log(aq);
                ar aq2 = new ar("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", dVar.cPs()).aq("obj_locate", this.kdJ);
                TiebaStatic.log(StringUtils.isNull(dVar.kdV) ? aq2 : aq2.dR("obj_name", dVar.kdV));
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.kdL.get(i).getView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kdL == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.kdL, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(this.kdK, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.aln != i) {
            this.aln = i;
            if (this.kdL != null && this.kdL.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.kdL) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.n By(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.kdK) || i >= this.kdK.size()) {
            return null;
        }
        return this.kdK.get(i);
    }

    public void n(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.kdL)) {
            for (int i = 0; i < this.kdL.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.kdL.get(i);
                com.baidu.tieba.homepage.concern.a.d cPz = bVar.cPz();
                if (cPz != null) {
                    for (int i2 = 0; i2 < cPz.kdX.length; i2++) {
                        if (cPz.kdX[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
