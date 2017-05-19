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
public class i extends b<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> aat;
    private View.OnClickListener ahW;
    private com.baidu.tieba.horizonalList.widget.j bub;
    private HListView buo;
    public l bup;
    private List<com.baidu.tieba.horizonalList.widget.k> buq;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ahW = new j(this);
        this.aat = tbPageContext;
        this.buo = new HListView(getContext());
        this.buo.setHeaderDividersEnabled(false);
        this.buo.setFooterDividersEnabled(false);
        this.buo.setSelector(w.g.list_selector_transparent);
        this.buo.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        this.bup = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bub = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.card_homepage_rec_god_item, this.bup);
        this.bub.setOnClickListener(this.ahW);
        this.buo.setAdapter((ListAdapter) this.bub);
        this.btT.addView(this.buo);
        this.btS.setVisibility(8);
        this.btM.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds28));
        this.btN.setVisibility(0);
        this.btN.setText(this.aat.getResources().getString(w.l.recommend_frs_hot_thread_more));
        this.btL.setOnClickListener(new k(this));
        this.bup.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.buo != null && this.bub != null) {
            com.baidu.tbadk.core.util.aq.i(this.btN, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.btM, w.e.cp_cont_d);
            this.bub.db(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.onBindDataToView((i) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.x.r(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.btM.setText(this.aat.getPageActivity().getResources().getString(w.l.the_gods_you_may_interest_in));
            }
            if (Y(hVar.getDataList())) {
                this.buq = hVar.getDataList();
                this.bub.setData(this.buq);
                this.bub.notifyDataSetChanged();
            }
        }
    }

    private boolean Y(List<com.baidu.tieba.horizonalList.widget.k> list) {
        if (com.baidu.tbadk.core.util.x.r(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.r(this.buq) && com.baidu.tbadk.core.util.x.q(this.buq) == com.baidu.tbadk.core.util.x.q(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.q(this.buq); i++) {
                com.baidu.tieba.horizonalList.widget.k kVar = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.x.c(this.buq, i);
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
