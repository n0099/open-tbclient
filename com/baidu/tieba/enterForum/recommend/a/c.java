package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.d, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c>> {
    private ab fcR;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, ab abVar) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.d.fdi);
        this.mPageContext = tbPageContext;
        this.fcR = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.c cVar = new com.baidu.tieba.enterForum.recommend.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.d dVar, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.c> aVar) {
        if (dVar == null || aVar == null || aVar.baX() == null) {
            return null;
        }
        aVar.baX().a(dVar);
        if (this.fcR != null) {
            aVar.baX().d(this.fcR);
        }
        return aVar.getView();
    }
}
