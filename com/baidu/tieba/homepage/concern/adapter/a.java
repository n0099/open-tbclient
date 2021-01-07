package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, CardViewHolder<com.baidu.tieba.card.j>> implements com.baidu.tieba.a.f {
    private String aji;
    public BdUniqueId fJu;
    private aa iKM;
    private com.baidu.tieba.card.j jXA;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iKM = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.jXA != null && a.this.jXA.getView() != null && jVar != null && jVar.boP() != null && !StringUtils.isNull(jVar.boP().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == a.this.jXA.cuG() ? 1 : 2);
                    if (view == a.this.jXA.hnz.getCommentContainer() || view == a.this.jXA.its.getCommentContainer()) {
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
    public CardViewHolder<com.baidu.tieba.card.j> e(ViewGroup viewGroup) {
        this.jXA = new com.baidu.tieba.card.j(this.mPageContext, this.fJu);
        this.jXA.jF(true);
        if (this.fJu != null) {
            this.jXA.o(this.fJu);
        }
        return new CardViewHolder<>(this.jXA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.j> cardViewHolder) {
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
        if (jVar.boP() != null && jVar.boP().brK() != null) {
            aq aqVar = new aq("c14007");
            aqVar.an("obj_locate", 2);
            aqVar.w("obj_param1", jVar.boP().brK().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }
}
