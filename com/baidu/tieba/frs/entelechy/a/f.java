package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements t, com.baidu.tieba.frs.e.c {
    private v<bd> clT;
    private com.baidu.tieba.frs.entelechy.view.c dKM;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKN;
    private com.baidu.adp.lib.e.b<TbImageView> dKO;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKM = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.dKM.setConstrainLayoutPool(this.dKN);
        this.dKM.setConstrainImagePool(this.dKO);
        this.dKM.setForumName(this.mForumName);
        this.dKM.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dKM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> aVar) {
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dEb);
        aVar.alY().a(bdVar);
        aVar.alY().b(this.clT);
        com.baidu.tieba.frs.e.b.azR().a(dUq, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dKM != null) {
            this.dKM.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
