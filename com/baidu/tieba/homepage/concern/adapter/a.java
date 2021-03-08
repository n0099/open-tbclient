package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, CardViewHolder<com.baidu.tieba.card.j>> implements com.baidu.tieba.a.f {
    private String ajx;
    public BdUniqueId fIy;
    private ab iNL;
    private com.baidu.tieba.card.j kcM;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iNL = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.kcM != null && a.this.kcM.getView() != null && jVar != null && jVar.blp() != null && !StringUtils.isNull(jVar.blp().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == a.this.kcM.csl() ? 1 : 2);
                    if (view == a.this.kcM.hpe.getCommentContainer() || view == a.this.kcM.iwm.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.aq("obj_locate", 7);
                        arVar.aq("obj_type", 5);
                        arVar.dR("tid", jVar.blp().getTid());
                        arVar.dR(IntentConfig.NID, jVar.blp().bmq());
                        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                        if (bR != null) {
                            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
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
    public CardViewHolder<com.baidu.tieba.card.j> e(ViewGroup viewGroup) {
        this.kcM = new com.baidu.tieba.card.j(this.mPageContext, this.fIy);
        this.kcM.jD(true);
        if (this.fIy != null) {
            this.kcM.o(this.fIy);
        }
        return new CardViewHolder<>(this.kcM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.j> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        jVar.xe(i + 1);
        com.baidu.tieba.card.t.csH().e(jVar.Jd("c12351"));
        if (cardViewHolder.cto() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.cto().setPage(this.ajx);
        }
        cardViewHolder.cto().a(jVar);
        cardViewHolder.cto().c(this.iNL);
        if (jVar.blp() != null && jVar.blp().bol() != null) {
            ar arVar = new ar("c14007");
            arVar.aq("obj_locate", 2);
            arVar.v("obj_param1", jVar.blp().bol().live_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }
}
