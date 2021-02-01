package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, CardViewHolder<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String aif;
    public BdUniqueId fGZ;
    private ab iLO;
    private com.baidu.tieba.card.k kay;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iLO = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && b.this.kay != null && b.this.kay.getView() != null && jVar != null && jVar.bln() != null && !StringUtils.isNull(jVar.bln().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == b.this.kay.crY() ? 1 : 2);
                    if (view == b.this.kay.hng.getCommentContainer() || view == b.this.kay.iup.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.ap("obj_locate", 7);
                        arVar.ap("obj_type", 5);
                        arVar.dR("tid", jVar.bln().getTid());
                        arVar.dR(IntentConfig.NID, jVar.bln().bmo());
                        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                        if (bR != null) {
                            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                        }
                        TiebaStatic.log(arVar);
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
        this.kay = new com.baidu.tieba.card.k(this.mPageContext, this.fGZ);
        this.kay.jD(true);
        if (this.fGZ != null) {
            this.kay.o(this.fGZ);
        }
        return new CardViewHolder<>(this.kay);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.ctb() == null) {
            return null;
        }
        jVar.xd(i + 1);
        com.baidu.tieba.card.t.csu().e(jVar.IT("c12351"));
        if (cardViewHolder.ctb() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.ctb().setPage(this.aif);
        }
        cardViewHolder.ctb().a(jVar);
        cardViewHolder.ctb().c(this.iLO);
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }
}
