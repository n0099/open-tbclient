package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.c>> implements v, com.baidu.tieba.frs.e.c {
    private x<bh> bok;
    private com.baidu.tieba.frs.entelechy.view.c cEq;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cEr;
    private com.baidu.adp.lib.e.b<TbImageView> cEs;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cEq = new com.baidu.tieba.frs.entelechy.view.c(this.mPageContext, this.mPageId);
        this.cEq.setConstrainLayoutPool(this.cEr);
        this.cEq.setConstrainImagePool(this.cEs);
        this.cEq.setForumName(this.mForumName);
        this.cEq.k(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.cEq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        aVar.aaJ().a((com.baidu.tieba.card.a) bhVar);
        aVar.aaJ().b(this.bok);
        com.baidu.tieba.frs.e.b.aot().a(cPx, bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
