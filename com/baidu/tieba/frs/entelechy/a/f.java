package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class f extends e<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buX;
    private com.baidu.tieba.frs.entelechy.view.c cNJ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNK;
    private com.baidu.adp.lib.e.b<TbImageView> cNL;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.cNJ = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.cNJ.setConstrainLayoutPool(this.cNK);
        this.cNJ.setConstrainImagePool(this.cNL);
        this.cNJ.setForumName(this.mForumName);
        this.cNJ.k(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.cNJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> aVar) {
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.a(aVar.acB().abX(), this.cGS);
        aVar.acB().a(bdVar);
        aVar.acB().b(this.buX);
        com.baidu.tieba.frs.e.b.aqw().a(cZc, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.e
    public void setFromCDN(boolean z) {
        if (this.cNJ != null) {
            this.cNJ.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
