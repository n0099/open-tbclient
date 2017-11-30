package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buS;
    private com.baidu.tieba.frs.entelechy.view.c cNu;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNv;
    private com.baidu.adp.lib.e.b<TbImageView> cNw;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cNu = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.cNu.setConstrainLayoutPool(this.cNv);
        this.cNu.setConstrainImagePool(this.cNw);
        this.cNu.setForumName(this.mForumName);
        this.cNu.k(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cNu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.acs() == null) {
            return null;
        }
        aVar.acs().a(bdVar);
        aVar.acs().b(this.buS);
        com.baidu.tieba.frs.e.b.aqn().a(cYM, bdVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
