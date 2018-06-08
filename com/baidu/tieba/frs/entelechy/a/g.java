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
    private ab<bd> bEO;
    private String bER;
    private com.baidu.tieba.frs.entelechy.view.d dok;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bEO = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 7);
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        this.dok = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        this.dok.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dok);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.d> aVar) {
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bdVar, aVar);
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        com.baidu.tieba.frs.e.a(aVar.ajG().UW(), this.dhf);
        com.baidu.tieba.frs.e.a(aVar.ajG().UX(), this.dhf);
        aVar.ajG().a(bdVar);
        aVar.ajG().setForumName(this.mForumName);
        aVar.ajG().b(this.bEO);
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        if (bdVar != null) {
            bdVar.wg();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
