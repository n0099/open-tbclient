package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<bd> ciE;
    private com.baidu.tieba.frs.entelechy.view.c dHG;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHH;
    private com.baidu.adp.lib.e.b<TbImageView> dHI;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.dHG = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.dHG.setConstrainLayoutPool(this.dHH);
        this.dHG.setConstrainImagePool(this.dHI);
        this.dHG.setForumName(this.mForumName);
        this.dHG.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dHG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> aVar) {
        if (aVar == null || aVar.alp() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alp().akL(), this.dBi);
        aVar.alp().a(bdVar);
        aVar.alp().b(this.ciE);
        com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dHG != null) {
            this.dHG.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
