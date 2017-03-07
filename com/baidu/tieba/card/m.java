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
    private TbPageContext<?> aaI;
    private View.OnClickListener aio;
    private com.baidu.tieba.horizonalList.widget.k brV;
    private HListView bsi;
    public p bsj;
    private List<com.baidu.tieba.horizonalList.widget.l> bsk;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aio = new n(this);
        this.aaI = tbPageContext;
        this.bsi = new HListView(getContext());
        this.bsi.setHeaderDividersEnabled(false);
        this.bsi.setFooterDividersEnabled(false);
        this.bsi.setSelector(w.g.list_selector_transparent);
        this.bsi.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        this.bsj = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.brV = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.card_homepage_rec_god_item, this.bsj);
        this.brV.setOnClickListener(this.aio);
        this.bsi.setAdapter((ListAdapter) this.brV);
        this.brq.addView(this.bsi);
        this.brp.setVisibility(8);
        this.brj.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds28));
        this.brk.setVisibility(0);
        this.brk.setText(this.aaI.getResources().getString(w.l.recommend_frs_hot_thread_more));
        this.bri.setOnClickListener(new o(this));
        this.bsj.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bsi != null && this.brV != null) {
            com.baidu.tbadk.core.util.aq.i((View) this.brk, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i((View) this.brj, w.e.cp_cont_d);
            this.brV.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((m) jVar);
        if (jVar != null && !com.baidu.tbadk.core.util.x.q(jVar.getDataList())) {
            if (StringUtils.isNull(jVar.mGroupTitle)) {
                this.brj.setText(this.aaI.getPageActivity().getResources().getString(w.l.the_gods_you_may_interest_in));
            }
            if (V(jVar.getDataList())) {
                this.bsk = jVar.getDataList();
                this.brV.setData(this.bsk);
                this.brV.notifyDataSetChanged();
            }
        }
    }

    private boolean V(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bsk) && com.baidu.tbadk.core.util.x.p(this.bsk) == com.baidu.tbadk.core.util.x.p(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.p(this.bsk); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(this.bsk, i);
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
