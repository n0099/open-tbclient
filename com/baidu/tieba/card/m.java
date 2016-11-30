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
    private TbPageContext<?> Gf;
    private View.OnClickListener aev;
    private com.baidu.tieba.horizonalList.widget.k bck;
    private HListView bcw;
    public p bcx;
    private List<com.baidu.tieba.horizonalList.widget.l> bcy;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aev = new n(this);
        this.Gf = tbPageContext;
        this.bcw = new HListView(getContext());
        this.bcw.setHeaderDividersEnabled(false);
        this.bcw.setFooterDividersEnabled(false);
        this.bcw.setSelector(r.f.list_selector_transparent);
        this.bcw.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0);
        this.bcx = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bck = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.card_homepage_rec_god_item, this.bcx);
        this.bck.setOnClickListener(this.aev);
        this.bcw.setAdapter((ListAdapter) this.bck);
        this.bbE.addView(this.bcw);
        this.bbD.setVisibility(8);
        this.bbx.setTextSize(0, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds28));
        this.bby.setVisibility(0);
        this.bby.setText(this.Gf.getResources().getString(r.j.recommend_frs_hot_thread_more));
        this.bbw.setOnClickListener(new o(this));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bcw != null && this.bck != null) {
            com.baidu.tbadk.core.util.at.j((View) this.bby, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) this.bbx, r.d.cp_cont_d);
            this.bck.dd(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.k kVar) {
        super.onBindDataToView((m) kVar);
        if (kVar != null && !com.baidu.tbadk.core.util.x.t(kVar.Fy())) {
            if (StringUtils.isNull(kVar.mGroupTitle)) {
                this.bbx.setText(this.Gf.getPageActivity().getResources().getString(r.j.the_gods_you_may_interest_in));
            }
            if (W(kVar.Fy())) {
                this.bcy = kVar.Fy();
                this.bck.setData(this.bcy);
                this.bck.notifyDataSetChanged();
            }
        }
    }

    private boolean W(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bcy) && com.baidu.tbadk.core.util.x.s(this.bcy) == com.baidu.tbadk.core.util.x.s(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.s(this.bcy); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(this.bcy, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(list, i);
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
