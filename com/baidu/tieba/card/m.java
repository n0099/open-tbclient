package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class m extends b<com.baidu.tieba.card.data.j> {
    private TbPageContext<?> aaX;
    private View.OnClickListener aiC;
    private com.baidu.tieba.horizonalList.widget.k brN;
    private HListView bsa;
    public p bsb;
    private List<com.baidu.tieba.horizonalList.widget.l> bsc;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiC = new n(this);
        this.aaX = tbPageContext;
        this.bsa = new HListView(getContext());
        this.bsa.setHeaderDividersEnabled(false);
        this.bsa.setFooterDividersEnabled(false);
        this.bsa.setSelector(w.g.list_selector_transparent);
        this.bsa.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        this.bsb = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.brN = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.card_homepage_rec_god_item, this.bsb);
        this.brN.setOnClickListener(this.aiC);
        this.bsa.setAdapter((ListAdapter) this.brN);
        this.bri.addView(this.bsa);
        this.brh.setVisibility(8);
        this.brb.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds28));
        this.brc.setVisibility(0);
        this.brc.setText(this.aaX.getResources().getString(w.l.recommend_frs_hot_thread_more));
        this.bra.setOnClickListener(new o(this));
        this.bsb.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bsa != null && this.brN != null) {
            com.baidu.tbadk.core.util.aq.i(this.brc, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.brb, w.e.cp_cont_d);
            this.brN.df(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((m) jVar);
        if (jVar != null && !com.baidu.tbadk.core.util.x.q(jVar.getDataList())) {
            if (StringUtils.isNull(jVar.mGroupTitle)) {
                this.brb.setText(this.aaX.getPageActivity().getResources().getString(w.l.the_gods_you_may_interest_in));
            }
            if (V(jVar.getDataList())) {
                this.bsc = jVar.getDataList();
                this.brN.setData(this.bsc);
                this.brN.notifyDataSetChanged();
            }
        }
    }

    private boolean V(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bsc) && com.baidu.tbadk.core.util.x.p(this.bsc) == com.baidu.tbadk.core.util.x.p(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.p(this.bsc); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(this.bsc, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(list, i);
                if ((lVar instanceof com.baidu.tieba.card.data.k) && (lVar2 instanceof com.baidu.tieba.card.data.k)) {
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) lVar;
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) lVar2;
                    if (kVar.author != null && !StringUtils.isNull(kVar.author.getUserId()) && kVar2.author != null && !StringUtils.isNull(kVar2.author.getUserId()) && !kVar.author.getUserId().equals(kVar2.author.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
