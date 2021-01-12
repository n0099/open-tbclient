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
    private String air;
    public BdUniqueId fEN;
    private aa iGf;
    private com.baidu.tieba.card.j jSV;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iGf = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.jSV != null && a.this.jSV.getView() != null && jVar != null && jVar.bkV() != null && !StringUtils.isNull(jVar.bkV().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == a.this.jSV.cqO() ? 1 : 2);
                    if (view == a.this.jSV.hiT.getCommentContainer() || view == a.this.jSV.ioL.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.an("obj_locate", 7);
                        aqVar.an("obj_type", 5);
                        aqVar.dW("tid", jVar.bkV().getTid());
                        aqVar.dW(IntentConfig.NID, jVar.bkV().blV());
                        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                        if (bV != null) {
                            aqVar.dW("obj_cur_page", bV.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                            aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
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
        this.jSV = new com.baidu.tieba.card.j(this.mPageContext, this.fEN);
        this.jSV.jB(true);
        if (this.fEN != null) {
            this.jSV.o(this.fEN);
        }
        return new CardViewHolder<>(this.jSV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.j> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.crP() == null) {
            return null;
        }
        jVar.wT(i + 1);
        com.baidu.tieba.card.s.crj().e(jVar.Ii("c12351"));
        if (cardViewHolder.crP() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.crP().setPage(this.air);
        }
        cardViewHolder.crP().a(jVar);
        cardViewHolder.crP().c(this.iGf);
        if (jVar.bkV() != null && jVar.bkV().bnQ() != null) {
            aq aqVar = new aq("c14007");
            aqVar.an("obj_locate", 2);
            aqVar.w("obj_param1", jVar.bkV().bnQ().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
