package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class u extends b<com.baidu.tieba.card.a.k> {
    private TbPageContext<?> DQ;
    private HListView aTL;
    public x aTM;
    private List<com.baidu.tieba.horizonalList.widget.l> aTN;
    private com.baidu.tieba.horizonalList.widget.k aTz;
    private View.OnClickListener abc;

    public u(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.abc = new v(this);
        this.DQ = tbPageContext;
        this.aTL = new HListView(getContext());
        this.aTL.setHeaderDividersEnabled(false);
        this.aTL.setFooterDividersEnabled(false);
        this.aTL.setSelector(u.f.list_selector_transparent);
        this.aTL.setPadding(tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0);
        this.aTM = new x(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(u.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext.getPageActivity());
        this.aTM.setPageUniqueId(bdUniqueId);
        this.aTz = new com.baidu.tieba.horizonalList.widget.k(getContext(), u.h.card_homepage_rec_god_item, this.aTM);
        this.aTz.setOnClickListener(this.abc);
        this.aTL.setAdapter((ListAdapter) this.aTz);
        this.aSq.addView(this.aTL);
        this.aSp.setVisibility(8);
        this.aSj.setTextSize(0, com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds28));
        this.aSk.setVisibility(0);
        this.aSk.setText(this.DQ.getResources().getString(u.j.recommend_frs_hot_thread_more));
        this.aSi.setOnClickListener(new w(this));
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aTL != null && this.aTz != null) {
            com.baidu.tbadk.core.util.av.j((View) this.aSk, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aSj, u.d.cp_cont_d);
            this.aTz.cO(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.k kVar) {
        super.a((u) kVar);
        if (kVar != null && !com.baidu.tbadk.core.util.y.t(kVar.Ea())) {
            if (StringUtils.isNull(kVar.aVL)) {
                this.aSj.setText(this.DQ.getPageActivity().getResources().getString(u.j.the_gods_you_may_interest_in));
            }
            if (S(kVar.Ea())) {
                this.aTN = kVar.Ea();
                this.aTz.setData(this.aTN);
                this.aTz.notifyDataSetChanged();
            }
        }
    }

    private boolean S(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.aTN) && com.baidu.tbadk.core.util.y.s(this.aTN) == com.baidu.tbadk.core.util.y.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.y.s(this.aTN); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(this.aTN, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(list, i);
                if ((lVar instanceof com.baidu.tieba.card.a.l) && (lVar2 instanceof com.baidu.tieba.card.a.l)) {
                    com.baidu.tieba.card.a.l lVar3 = (com.baidu.tieba.card.a.l) lVar;
                    com.baidu.tieba.card.a.l lVar4 = (com.baidu.tieba.card.a.l) lVar2;
                    if (lVar3.author != null && !StringUtils.isNull(lVar3.author.getUserId()) && lVar4.author != null && !StringUtils.isNull(lVar4.author.getUserId()) && !lVar3.author.getUserId().equals(lVar4.author.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
