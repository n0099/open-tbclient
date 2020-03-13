package com.baidu.tieba.homepage.topic.topictab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.a>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.topic.topictab.b.a.hhI);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.a> b(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.topic.topictab.view.a aVar = new com.baidu.tieba.homepage.topic.topictab.view.a(this.mPageContext);
        aVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.a> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.bvL() == null) {
            return null;
        }
        aVar2.bvL().a(aVar);
        aVar2.bvL().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }
}
