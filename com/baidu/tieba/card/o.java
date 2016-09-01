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
public class o extends b<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> Gd;
    private com.baidu.tieba.horizonalList.widget.k aYH;
    private HListView aYT;
    public r aYU;
    private List<com.baidu.tieba.horizonalList.widget.l> aYV;
    private View.OnClickListener adM;

    public o(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.adM = new p(this);
        this.Gd = tbPageContext;
        this.aYT = new HListView(getContext());
        this.aYT.setHeaderDividersEnabled(false);
        this.aYT.setFooterDividersEnabled(false);
        this.aYT.setSelector(t.f.list_selector_transparent);
        this.aYT.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        this.aYU = new r(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext.getPageActivity());
        this.aYU.setPageUniqueId(bdUniqueId);
        this.aYH = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.card_homepage_rec_god_item, this.aYU);
        this.aYH.setOnClickListener(this.adM);
        this.aYT.setAdapter((ListAdapter) this.aYH);
        this.aXR.addView(this.aYT);
        this.aXQ.setVisibility(8);
        this.aXK.setTextSize(0, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds28));
        this.aXL.setVisibility(0);
        this.aXL.setText(this.Gd.getResources().getString(t.j.recommend_frs_hot_thread_more));
        this.aXJ.setOnClickListener(new q(this));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aYT != null && this.aYH != null) {
            com.baidu.tbadk.core.util.av.j((View) this.aXL, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aXK, t.d.cp_cont_d);
            this.aYH.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.k kVar) {
        super.onBindDataToView((o) kVar);
        if (kVar != null && !com.baidu.tbadk.core.util.y.t(kVar.Fu())) {
            if (StringUtils.isNull(kVar.bbo)) {
                this.aXK.setText(this.Gd.getPageActivity().getResources().getString(t.j.the_gods_you_may_interest_in));
            }
            if (V(kVar.Fu())) {
                this.aYV = kVar.Fu();
                this.aYH.setData(this.aYV);
                this.aYH.notifyDataSetChanged();
            }
        }
    }

    private boolean V(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.aYV) && com.baidu.tbadk.core.util.y.s(this.aYV) == com.baidu.tbadk.core.util.y.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.y.s(this.aYV); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(this.aYV, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(list, i);
                if ((lVar instanceof com.baidu.tieba.card.data.l) && (lVar2 instanceof com.baidu.tieba.card.data.l)) {
                    com.baidu.tieba.card.data.l lVar3 = (com.baidu.tieba.card.data.l) lVar;
                    com.baidu.tieba.card.data.l lVar4 = (com.baidu.tieba.card.data.l) lVar2;
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
