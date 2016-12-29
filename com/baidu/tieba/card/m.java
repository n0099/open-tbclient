package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class m extends b<com.baidu.tieba.card.data.j> {
    private TbPageContext<?> Gf;
    private View.OnClickListener adO;
    private HListView bbC;
    public p bbD;
    private List<com.baidu.tieba.horizonalList.widget.l> bbE;
    private com.baidu.tieba.horizonalList.widget.k bbq;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.adO = new n(this);
        this.Gf = tbPageContext;
        this.bbC = new HListView(getContext());
        this.bbC.setHeaderDividersEnabled(false);
        this.bbC.setFooterDividersEnabled(false);
        this.bbC.setSelector(r.f.list_selector_transparent);
        this.bbC.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0);
        this.bbD = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bbq = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.card_homepage_rec_god_item, this.bbD);
        this.bbq.setOnClickListener(this.adO);
        this.bbC.setAdapter((ListAdapter) this.bbq);
        this.baK.addView(this.bbC);
        this.baJ.setVisibility(8);
        this.baD.setTextSize(0, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds28));
        this.baE.setVisibility(0);
        this.baE.setText(this.Gf.getResources().getString(r.j.recommend_frs_hot_thread_more));
        this.baC.setOnClickListener(new o(this));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bbC != null && this.bbq != null) {
            com.baidu.tbadk.core.util.ar.j((View) this.baE, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.j((View) this.baD, r.d.cp_cont_d);
            this.bbq.df(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((m) jVar);
        if (jVar != null && !com.baidu.tbadk.core.util.x.t(jVar.getDataList())) {
            if (StringUtils.isNull(jVar.mGroupTitle)) {
                this.baD.setText(this.Gf.getPageActivity().getResources().getString(r.j.the_gods_you_may_interest_in));
            }
            if (W(jVar.getDataList())) {
                this.bbE = jVar.getDataList();
                this.bbq.setData(this.bbE);
                this.bbq.notifyDataSetChanged();
            }
        }
    }

    private boolean W(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bbE) && com.baidu.tbadk.core.util.x.s(this.bbE) == com.baidu.tbadk.core.util.x.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.s(this.bbE); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(this.bbE, i);
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
