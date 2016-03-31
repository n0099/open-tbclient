package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class af extends b<com.baidu.tieba.card.a.q> {
    private TbPageContext<?> MX;
    private com.baidu.tieba.horizonalList.widget.k aSR;
    private HListView aTf;
    public ai aTg;
    private List<com.baidu.tieba.horizonalList.widget.l> aTh;
    private View.OnClickListener aeD;

    public af(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aeD = new ag(this);
        this.MX = tbPageContext;
        this.aTf = new HListView(getContext());
        this.aTf.setHeaderDividersEnabled(false);
        this.aTf.setFooterDividersEnabled(false);
        this.aTf.setSelector(t.f.list_selector_transparent);
        this.aTf.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        this.aTg = new ai(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext.getPageActivity());
        this.aTg.setPageUniqueId(bdUniqueId);
        this.aSR = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.card_homepage_rec_god_item, this.aTg);
        this.aSR.setOnClickListener(this.aeD);
        this.aTf.setAdapter((ListAdapter) this.aSR);
        this.aRx.addView(this.aTf);
        this.aRw.setVisibility(8);
        this.aRq.setTextSize(0, com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds28));
        this.aRr.setVisibility(0);
        this.aRr.setText(this.MX.getResources().getString(t.j.recommend_frs_hot_thread_more));
        this.aRp.setOnClickListener(new ah(this));
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aTf != null && this.aSR != null) {
            com.baidu.tbadk.core.util.at.j((View) this.aRr, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) this.aRq, t.d.cp_cont_d);
            this.aSR.de(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.q qVar) {
        super.a((af) qVar);
        if (qVar != null && !com.baidu.tbadk.core.util.y.q(qVar.FZ())) {
            if (StringUtils.isNull(qVar.aVn)) {
                this.aRq.setText(this.MX.getPageActivity().getResources().getString(t.j.the_gods_you_may_interest_in));
            }
            if (K(qVar.FZ())) {
                this.aTh = qVar.FZ();
                this.aSR.setData(this.aTh);
                this.aSR.notifyDataSetChanged();
            }
        }
    }

    private boolean K(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.y.q(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.y.q(this.aTh) && com.baidu.tbadk.core.util.y.p(this.aTh) == com.baidu.tbadk.core.util.y.p(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.y.p(this.aTh); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.b(this.aTh, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.b(list, i);
                if ((lVar instanceof com.baidu.tieba.card.a.r) && (lVar2 instanceof com.baidu.tieba.card.a.r)) {
                    com.baidu.tieba.card.a.r rVar = (com.baidu.tieba.card.a.r) lVar;
                    com.baidu.tieba.card.a.r rVar2 = (com.baidu.tieba.card.a.r) lVar2;
                    if (rVar.author != null && !StringUtils.isNull(rVar.author.getUserId()) && rVar2.author != null && !StringUtils.isNull(rVar2.author.getUserId()) && !rVar.author.getUserId().equals(rVar2.author.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
