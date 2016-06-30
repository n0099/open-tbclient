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
    private TbPageContext<?> Dp;
    private com.baidu.tieba.horizonalList.widget.k aSD;
    private HListView aSP;
    public x aSQ;
    private List<com.baidu.tieba.horizonalList.widget.l> aSR;
    private View.OnClickListener aat;

    public u(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aat = new v(this);
        this.Dp = tbPageContext;
        this.aSP = new HListView(getContext());
        this.aSP.setHeaderDividersEnabled(false);
        this.aSP.setFooterDividersEnabled(false);
        this.aSP.setSelector(u.f.list_selector_transparent);
        this.aSP.setPadding(tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0);
        this.aSQ = new x(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(u.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext.getPageActivity());
        this.aSQ.setPageUniqueId(bdUniqueId);
        this.aSD = new com.baidu.tieba.horizonalList.widget.k(getContext(), u.h.card_homepage_rec_god_item, this.aSQ);
        this.aSD.setOnClickListener(this.aat);
        this.aSP.setAdapter((ListAdapter) this.aSD);
        this.aRw.addView(this.aSP);
        this.aRv.setVisibility(8);
        this.aRp.setTextSize(0, com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds28));
        this.aRq.setVisibility(0);
        this.aRq.setText(this.Dp.getResources().getString(u.j.recommend_frs_hot_thread_more));
        this.aRo.setOnClickListener(new w(this));
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aSP != null && this.aSD != null) {
            com.baidu.tbadk.core.util.av.j((View) this.aRq, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aRp, u.d.cp_cont_d);
            this.aSD.cO(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.k kVar) {
        super.a((u) kVar);
        if (kVar != null && !com.baidu.tbadk.core.util.y.t(kVar.Eb())) {
            if (StringUtils.isNull(kVar.aUO)) {
                this.aRp.setText(this.Dp.getPageActivity().getResources().getString(u.j.the_gods_you_may_interest_in));
            }
            if (S(kVar.Eb())) {
                this.aSR = kVar.Eb();
                this.aSD.setData(this.aSR);
                this.aSD.notifyDataSetChanged();
            }
        }
    }

    private boolean S(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.aSR) && com.baidu.tbadk.core.util.y.s(this.aSR) == com.baidu.tbadk.core.util.y.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.y.s(this.aSR); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(this.aSR, i);
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
