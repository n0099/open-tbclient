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
    private v<bd> clH;
    private com.baidu.tieba.frs.entelechy.view.c dKA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKB;
    private com.baidu.adp.lib.e.b<TbImageView> dKC;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKA = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.dKA.setConstrainLayoutPool(this.dKB);
        this.dKA.setConstrainImagePool(this.dKC);
        this.dKA.setForumName(this.mForumName);
        this.dKA.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dKA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> aVar) {
        if (aVar == null || aVar.alX() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alX().alt(), this.dDP);
        aVar.alX().a(bdVar);
        aVar.alX().b(this.clH);
        com.baidu.tieba.frs.e.b.azQ().a(dUe, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dKA != null) {
            this.dKA.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
