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
public class m extends b<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> Gd;
    private com.baidu.tieba.horizonalList.widget.k aZb;
    private HListView aZn;
    public p aZo;
    private List<com.baidu.tieba.horizonalList.widget.l> aZp;
    private View.OnClickListener adX;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.adX = new n(this);
        this.Gd = tbPageContext;
        this.aZn = new HListView(getContext());
        this.aZn.setHeaderDividersEnabled(false);
        this.aZn.setFooterDividersEnabled(false);
        this.aZn.setSelector(r.f.list_selector_transparent);
        this.aZn.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0);
        this.aZo = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext.getPageActivity());
        this.aZo.setPageUniqueId(bdUniqueId);
        this.aZb = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.card_homepage_rec_god_item, this.aZo);
        this.aZb.setOnClickListener(this.adX);
        this.aZn.setAdapter((ListAdapter) this.aZb);
        this.aYv.addView(this.aZn);
        this.aYu.setVisibility(8);
        this.aYo.setTextSize(0, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds28));
        this.aYp.setVisibility(0);
        this.aYp.setText(this.Gd.getResources().getString(r.j.recommend_frs_hot_thread_more));
        this.aYn.setOnClickListener(new o(this));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aZn != null && this.aZb != null) {
            com.baidu.tbadk.core.util.av.j((View) this.aYp, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.j((View) this.aYo, r.d.cp_cont_d);
            this.aZb.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.k kVar) {
        super.onBindDataToView((m) kVar);
        if (kVar != null && !com.baidu.tbadk.core.util.y.t(kVar.Ft())) {
            if (StringUtils.isNull(kVar.bbF)) {
                this.aYo.setText(this.Gd.getPageActivity().getResources().getString(r.j.the_gods_you_may_interest_in));
            }
            if (V(kVar.Ft())) {
                this.aZp = kVar.Ft();
                this.aZb.setData(this.aZp);
                this.aZb.notifyDataSetChanged();
            }
        }
    }

    private boolean V(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.aZp) && com.baidu.tbadk.core.util.y.s(this.aZp) == com.baidu.tbadk.core.util.y.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.y.s(this.aZp); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(this.aZp, i);
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
