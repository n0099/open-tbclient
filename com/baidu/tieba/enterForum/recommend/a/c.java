package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.d, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c>> {
    private aa gTf;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, aa aaVar) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.d.gTw);
        this.mPageContext = tbPageContext;
        this.gTf = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.c cVar = new com.baidu.tieba.enterForum.recommend.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> aVar) {
        if (dVar == null || aVar == null || aVar.bLW() == null) {
            return null;
        }
        if (viewGroup instanceof BdTypeRecyclerView) {
            aVar.bLW().mp(dVar.needTopMargin);
        }
        aVar.bLW().a(dVar);
        if (this.gTf != null) {
            aVar.bLW().c(this.gTf);
        }
        return aVar.getView();
    }
}
