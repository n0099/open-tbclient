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
    private TbPageContext<?> Fp;
    private View.OnClickListener acY;
    private com.baidu.tieba.horizonalList.widget.k bld;
    private HListView blp;
    public p blq;
    private List<com.baidu.tieba.horizonalList.widget.l> blr;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.acY = new n(this);
        this.Fp = tbPageContext;
        this.blp = new HListView(getContext());
        this.blp.setHeaderDividersEnabled(false);
        this.blp.setFooterDividersEnabled(false);
        this.blp.setSelector(r.g.list_selector_transparent);
        this.blp.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.f.ds4), 0);
        this.blq = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bld = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.j.card_homepage_rec_god_item, this.blq);
        this.bld.setOnClickListener(this.acY);
        this.blp.setAdapter((ListAdapter) this.bld);
        this.bky.addView(this.blp);
        this.bkx.setVisibility(8);
        this.bkr.setTextSize(0, com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds28));
        this.bks.setVisibility(0);
        this.bks.setText(this.Fp.getResources().getString(r.l.recommend_frs_hot_thread_more));
        this.bkq.setOnClickListener(new o(this));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.blp != null && this.bld != null) {
            com.baidu.tbadk.core.util.ap.i((View) this.bks, r.e.cp_cont_d);
            com.baidu.tbadk.core.util.ap.i((View) this.bkr, r.e.cp_cont_d);
            this.bld.dg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((m) jVar);
        if (jVar != null && !com.baidu.tbadk.core.util.w.s(jVar.getDataList())) {
            if (StringUtils.isNull(jVar.mGroupTitle)) {
                this.bkr.setText(this.Fp.getPageActivity().getResources().getString(r.l.the_gods_you_may_interest_in));
            }
            if (Y(jVar.getDataList())) {
                this.blr = jVar.getDataList();
                this.bld.setData(this.blr);
                this.bld.notifyDataSetChanged();
            }
        }
    }

    private boolean Y(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.w.s(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.w.s(this.blr) && com.baidu.tbadk.core.util.w.r(this.blr) == com.baidu.tbadk.core.util.w.r(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.w.r(this.blr); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.w.c(this.blr, i);
                com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.w.c(list, i);
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
