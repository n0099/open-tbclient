package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.c, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.b>> {
    private ab<com.baidu.tieba.enterForum.recommend.b.c> iyz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.c.iyN);
        this.iyz = new ab<com.baidu.tieba.enterForum.recommend.b.c>() { // from class: com.baidu.tieba.enterForum.recommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.enterForum.recommend.b.c cVar) {
                if (cVar == null) {
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.b> c(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.b bVar = new com.baidu.tieba.enterForum.recommend.view.b(this.mPageContext);
        bVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.b> aVar) {
        if (cVar == null || aVar == null || aVar.csN() == null) {
            return null;
        }
        aVar.csN().a(cVar);
        aVar.csN().c(this.iyz);
        return aVar.getView();
    }
}
