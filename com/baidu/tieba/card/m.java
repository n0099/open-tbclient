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
public class m extends b<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> aas;
    private View.OnClickListener ahN;
    private HListView bAc;
    public p bAd;
    private List<com.baidu.tieba.horizonalList.widget.k> bAe;
    private com.baidu.tieba.horizonalList.widget.j bzP;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ahN = new n(this);
        this.aas = tbPageContext;
        this.bAc = new HListView(getContext());
        this.bAc.setHeaderDividersEnabled(false);
        this.bAc.setFooterDividersEnabled(false);
        this.bAc.setSelector(w.g.list_selector_transparent);
        this.bAc.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        this.bAd = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bzP = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.card_homepage_rec_god_item, this.bAd);
        this.bzP.setOnClickListener(this.ahN);
        this.bAc.setAdapter((ListAdapter) this.bzP);
        this.bzz.addView(this.bAc);
        this.bzy.setVisibility(8);
        this.bzs.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds28));
        this.bzt.setVisibility(0);
        this.bzt.setText(this.aas.getResources().getString(w.l.recommend_frs_hot_thread_more));
        this.bzr.setOnClickListener(new o(this));
        this.bAd.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bAc != null && this.bzP != null) {
            com.baidu.tbadk.core.util.aq.i(this.bzt, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.bzs, w.e.cp_cont_d);
            this.bzP.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((m) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.x.r(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bzs.setText(this.aas.getPageActivity().getResources().getString(w.l.the_gods_you_may_interest_in));
            }
            if (Y(hVar.getDataList())) {
                this.bAe = hVar.getDataList();
                this.bzP.setData(this.bAe);
                this.bzP.notifyDataSetChanged();
            }
        }
    }

    private boolean Y(List<com.baidu.tieba.horizonalList.widget.k> list) {
        if (com.baidu.tbadk.core.util.x.r(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.r(this.bAe) && com.baidu.tbadk.core.util.x.q(this.bAe) == com.baidu.tbadk.core.util.x.q(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.q(this.bAe); i++) {
                com.baidu.tieba.horizonalList.widget.k kVar = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.x.c(this.bAe, i);
                com.baidu.tieba.horizonalList.widget.k kVar2 = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.x.c(list, i);
                if ((kVar instanceof com.baidu.tieba.card.data.i) && (kVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) kVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) kVar2;
                    if (iVar.author != null && !StringUtils.isNull(iVar.author.getUserId()) && iVar2.author != null && !StringUtils.isNull(iVar2.author.getUserId()) && !iVar.author.getUserId().equals(iVar2.author.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
