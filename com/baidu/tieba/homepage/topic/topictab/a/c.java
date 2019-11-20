package com.baidu.tieba.homepage.topic.topictab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.c, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b>> {
    private TbPageContext<?> mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.topic.topictab.b.c.goE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> b(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.topic.topictab.view.b bVar = new com.baidu.tieba.homepage.topic.topictab.view.b(this.mPageContext);
        bVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> aVar) {
        if (cVar == null || aVar == null || aVar.baX() == null) {
            return null;
        }
        aVar.baX().a(cVar);
        aVar.baX().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
