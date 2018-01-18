package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<bd> ciw;
    private com.baidu.tieba.frs.entelechy.view.c dHl;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHm;
    private com.baidu.adp.lib.e.b<TbImageView> dHn;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> onCreateViewHolder(ViewGroup viewGroup) {
        this.dHl = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.dHl.setConstrainLayoutPool(this.dHm);
        this.dHl.setConstrainImagePool(this.dHn);
        this.dHl.setForumName(this.mForumName);
        this.dHl.j(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(this.dHl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c> aVar) {
        if (aVar == null || aVar.alk() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alk().akG(), this.dAN);
        aVar.alk().a(bdVar);
        aVar.alk().b(this.ciw);
        com.baidu.tieba.frs.d.b.ayK().a(dQJ, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dHl != null) {
            this.dHl.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
