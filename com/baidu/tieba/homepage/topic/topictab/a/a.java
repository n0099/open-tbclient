package com.baidu.tieba.homepage.topic.topictab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.a>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.topic.topictab.b.a.gnR);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.topic.topictab.view.a aVar = new com.baidu.tieba.homepage.topic.topictab.view.a(this.mPageContext);
        aVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.a> aVar2) {
        if (aVar == null || aVar2 == null || aVar2.bat() == null) {
            return null;
        }
        aVar2.bat().a(aVar);
        aVar2.bat().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar2.getView();
    }
}
