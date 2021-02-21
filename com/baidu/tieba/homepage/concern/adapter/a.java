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
    private String aif;
    public BdUniqueId fGZ;
    private ab iMc;
    private com.baidu.tieba.card.j kaK;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iMc = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.kaK != null && a.this.kaK.getView() != null && jVar != null && jVar.bln() != null && !StringUtils.isNull(jVar.bln().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, jVar, view == a.this.kaK.csf() ? 1 : 2);
                    if (view == a.this.kaK.hnu.getCommentContainer() || view == a.this.kaK.iuD.getCommentContainer()) {
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
    public CardViewHolder<com.baidu.tieba.card.j> e(ViewGroup viewGroup) {
        this.kaK = new com.baidu.tieba.card.j(this.mPageContext, this.fGZ);
        this.kaK.jD(true);
        if (this.fGZ != null) {
            this.kaK.o(this.fGZ);
        }
        return new CardViewHolder<>(this.kaK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.j> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        jVar.xd(i + 1);
        com.baidu.tieba.card.t.csB().e(jVar.IU("c12351"));
        if (cardViewHolder.cti() instanceof com.baidu.tieba.a.e) {
            cardViewHolder.cti().setPage(this.aif);
        }
        cardViewHolder.cti().a(jVar);
        cardViewHolder.cti().c(this.iMc);
        if (jVar.bln() != null && jVar.bln().boj() != null) {
            ar arVar = new ar("c14007");
            arVar.ap("obj_locate", 2);
            arVar.v("obj_param1", jVar.bln().boj().live_id);
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
        return cardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }
}
