package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.frs.f<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private ab<bd> bwL;
    private String bwO;
    private com.baidu.tieba.frs.entelechy.view.d deV;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bwL = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if (view2.getId() == d.g.card_home_page_normal_thread_user_name || (view2 instanceof HeadImageView) || (view2 instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        this.deV = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.deV.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.deV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.afY() == null) {
            return null;
        }
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        com.baidu.tieba.frs.e.a(aVar.afY().afz(), this.cXS);
        com.baidu.tieba.frs.e.a(aVar.afY().afA(), this.cXS);
        aVar.afY().a(bdVar);
        aVar.afY().setForumName(this.mForumName);
        aVar.afY().b(this.bwL);
        com.baidu.tieba.frs.e.b.auG().a(dpD, bdVar);
        if (bdVar != null) {
            bdVar.sJ();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }
}
