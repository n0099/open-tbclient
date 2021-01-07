package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, CardViewHolder<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String aji;
    public BdUniqueId fJu;
    private aa iKM;
    private com.baidu.tieba.card.k jXC;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iKM = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && b.this.jXC != null && b.this.jXC.getView() != null && jVar != null && jVar.boP() != null && !StringUtils.isNull(jVar.boP().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == b.this.jXC.cuG() ? 1 : 2);
                    if (view == b.this.jXC.hnz.getCommentContainer() || view == b.this.jXC.its.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.an("obj_locate", 7);
                        aqVar.an("obj_type", 5);
                        aqVar.dX("tid", jVar.boP().getTid());
                        aqVar.dX(IntentConfig.NID, jVar.boP().bpP());
                        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                        if (bV != null) {
                            aqVar.dX("obj_cur_page", bV.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                            aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.k> e(ViewGroup viewGroup) {
        this.jXC = new com.baidu.tieba.card.k(this.mPageContext, this.fJu);
        this.jXC.jF(true);
        if (this.fJu != null) {
            this.jXC.o(this.fJu);
        }
        return new CardViewHolder<>(this.jXC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.cvH() == null) {
            return null;
        }
        jVar.yA(i + 1);
        com.baidu.tieba.card.s.cvb().e(jVar.Jt("c12351"));
        if (cardViewHolder.cvH() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.cvH().setPage(this.aji);
        }
        cardViewHolder.cvH().a(jVar);
        cardViewHolder.cvH().c(this.iKM);
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }
}
