package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.k>> implements t, u, com.baidu.tieba.frs.e.c {
    private v<bd> clT;
    private int clW;
    private com.baidu.tieba.frs.entelechy.view.k dKU;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.clW = 0;
        this.clT = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 7);
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
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.k> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKU = new com.baidu.tieba.frs.entelechy.view.k(this.mPageContext, this.mPageId);
        this.dKU.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dKU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.k> aVar) {
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        if (bdVar != null) {
            bdVar.aQz = this.clW;
        }
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dEb);
        com.baidu.tieba.frs.f.a(aVar.alY().alv(), this.dEb);
        aVar.alY().a(bdVar);
        aVar.alY().setForumName(this.mForumName);
        aVar.alY().b(this.clT);
        com.baidu.tieba.frs.e.b.azR().a(dUq, bdVar);
        if (bdVar != null) {
            bdVar.Ai();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.u
    public void setCardShowType(int i) {
        this.clW = i;
    }
}
