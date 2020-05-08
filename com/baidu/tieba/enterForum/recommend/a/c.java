package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.d, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c>> {
    private z gEm;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, z zVar) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.d.gED);
        this.mPageContext = tbPageContext;
        this.gEm = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.c cVar = new com.baidu.tieba.enterForum.recommend.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> aVar) {
        if (dVar == null || aVar == null || aVar.bFz() == null) {
            return null;
        }
        if (viewGroup instanceof BdTypeRecyclerView) {
            aVar.bFz().lU(dVar.needTopMargin);
        }
        aVar.bFz().a(dVar);
        if (this.gEm != null) {
            aVar.bFz().c(this.gEm);
        }
        return aVar.getView();
    }
}
