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
public class u extends b<com.baidu.tieba.card.a.j> {
    private TbPageContext<?> Do;
    private com.baidu.tieba.horizonalList.widget.k aPh;
    private HListView aPt;
    public x aPu;
    private List<com.baidu.tieba.horizonalList.widget.l> aPv;
    private View.OnClickListener aac;

    public u(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aac = new v(this);
        this.Do = tbPageContext;
        this.aPt = new HListView(getContext());
        this.aPt.setHeaderDividersEnabled(false);
        this.aPt.setFooterDividersEnabled(false);
        this.aPt.setSelector(t.f.list_selector_transparent);
        this.aPt.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        this.aPu = new x(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext.getPageActivity());
        this.aPu.setPageUniqueId(bdUniqueId);
        this.aPh = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.card_homepage_rec_god_item, this.aPu);
        this.aPh.setOnClickListener(this.aac);
        this.aPt.setAdapter((ListAdapter) this.aPh);
        this.aNZ.addView(this.aPt);
        this.aNY.setVisibility(8);
        this.aNS.setTextSize(0, com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds28));
        this.aNT.setVisibility(0);
        this.aNT.setText(this.Do.getResources().getString(t.j.recommend_frs_hot_thread_more));
        this.aNR.setOnClickListener(new w(this));
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aPt != null && this.aPh != null) {
            com.baidu.tbadk.core.util.at.j((View) this.aNT, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) this.aNS, t.d.cp_cont_d);
            this.aPh.cM(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.j jVar) {
        super.a((u) jVar);
        if (jVar != null && !com.baidu.tbadk.core.util.y.s(jVar.DS())) {
            if (StringUtils.isNull(jVar.aRs)) {
                this.aNS.setText(this.Do.getPageActivity().getResources().getString(t.j.the_gods_you_may_interest_in));
            }
            if (L(jVar.DS())) {
                this.aPv = jVar.DS();
                this.aPh.setData(this.aPv);
                this.aPh.notifyDataSetChanged();
            }
        }
    }

    private boolean L(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.y.s(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.y.s(this.aPv) && com.baidu.tbadk.core.util.y.r(this.aPv) == com.baidu.tbadk.core.util.y.r(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.y.r(this.aPv); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(this.aPv, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(list, i);
                if ((lVar instanceof com.baidu.tieba.card.a.k) && (lVar2 instanceof com.baidu.tieba.card.a.k)) {
                    com.baidu.tieba.card.a.k kVar = (com.baidu.tieba.card.a.k) lVar;
                    com.baidu.tieba.card.a.k kVar2 = (com.baidu.tieba.card.a.k) lVar2;
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
