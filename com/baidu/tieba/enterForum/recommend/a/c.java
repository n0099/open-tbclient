package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.d, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c>> {
    private aa hUs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, aa aaVar) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.d.hUJ);
        this.mPageContext = tbPageContext;
        this.hUs = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> c(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.c cVar = new com.baidu.tieba.enterForum.recommend.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> aVar) {
        if (dVar == null || aVar == null || aVar.cjq() == null) {
            return null;
        }
        if (viewGroup instanceof BdTypeRecyclerView) {
            aVar.cjq().ow(dVar.needTopMargin);
        }
        aVar.cjq().a(dVar);
        if (this.hUs != null) {
            aVar.cjq().c(this.hUs);
        }
        return aVar.getView();
    }
}
