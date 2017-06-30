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
    private TbPageContext<?> aat;
    private View.OnClickListener aiv;
    private com.baidu.tieba.horizonalList.widget.j bAI;
    private HListView bAV;
    public p bAW;
    private List<com.baidu.tieba.horizonalList.widget.k> bAX;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiv = new n(this);
        this.aat = tbPageContext;
        this.bAV = new HListView(getContext());
        this.bAV.setHeaderDividersEnabled(false);
        this.bAV.setFooterDividersEnabled(false);
        this.bAV.setSelector(w.g.list_selector_transparent);
        this.bAV.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        this.bAW = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bAI = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.card_homepage_rec_god_item, this.bAW);
        this.bAI.setOnClickListener(this.aiv);
        this.bAV.setAdapter((ListAdapter) this.bAI);
        this.bAs.addView(this.bAV);
        this.bAr.setVisibility(8);
        this.bAl.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds28));
        this.bAm.setVisibility(0);
        this.bAm.setText(this.aat.getResources().getString(w.l.recommend_frs_hot_thread_more));
        this.bAk.setOnClickListener(new o(this));
        this.bAW.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bAV != null && this.bAI != null) {
            com.baidu.tbadk.core.util.as.i(this.bAm, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.as.i(this.bAl, w.e.cp_cont_d);
            this.bAI.de(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((m) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.z.t(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bAl.setText(this.aat.getPageActivity().getResources().getString(w.l.the_gods_you_may_interest_in));
            }
            if (ac(hVar.getDataList())) {
                this.bAX = hVar.getDataList();
                this.bAI.setData(this.bAX);
                this.bAI.notifyDataSetChanged();
            }
        }
    }

    private boolean ac(List<com.baidu.tieba.horizonalList.widget.k> list) {
        if (com.baidu.tbadk.core.util.z.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.z.t(this.bAX) && com.baidu.tbadk.core.util.z.s(this.bAX) == com.baidu.tbadk.core.util.z.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.z.s(this.bAX); i++) {
                com.baidu.tieba.horizonalList.widget.k kVar = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.z.c(this.bAX, i);
                com.baidu.tieba.horizonalList.widget.k kVar2 = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.z.c(list, i);
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
