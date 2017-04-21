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
    private TbPageContext<?> aaY;
    private View.OnClickListener aiD;
    private com.baidu.tieba.horizonalList.widget.k buf;
    private HListView bus;
    public p but;
    private List<com.baidu.tieba.horizonalList.widget.l> buu;

    public m(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiD = new n(this);
        this.aaY = tbPageContext;
        this.bus = new HListView(getContext());
        this.bus.setHeaderDividersEnabled(false);
        this.bus.setFooterDividersEnabled(false);
        this.bus.setSelector(w.g.list_selector_transparent);
        this.bus.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        this.but = new p(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.buf = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.card_homepage_rec_god_item, this.but);
        this.buf.setOnClickListener(this.aiD);
        this.bus.setAdapter((ListAdapter) this.buf);
        this.btA.addView(this.bus);
        this.btz.setVisibility(8);
        this.btt.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds28));
        this.btu.setVisibility(0);
        this.btu.setText(this.aaY.getResources().getString(w.l.recommend_frs_hot_thread_more));
        this.bts.setOnClickListener(new o(this));
        this.but.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bus != null && this.buf != null) {
            com.baidu.tbadk.core.util.aq.i(this.btu, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.i(this.btt, w.e.cp_cont_d);
            this.buf.df(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((m) jVar);
        if (jVar != null && !com.baidu.tbadk.core.util.x.q(jVar.getDataList())) {
            if (StringUtils.isNull(jVar.mGroupTitle)) {
                this.btt.setText(this.aaY.getPageActivity().getResources().getString(w.l.the_gods_you_may_interest_in));
            }
            if (W(jVar.getDataList())) {
                this.buu = jVar.getDataList();
                this.buf.setData(this.buu);
                this.buf.notifyDataSetChanged();
            }
        }
    }

    private boolean W(List<com.baidu.tieba.horizonalList.widget.l> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.q(this.buu) && com.baidu.tbadk.core.util.x.p(this.buu) == com.baidu.tbadk.core.util.x.p(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.p(this.buu); i++) {
                com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(this.buu, i);
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
