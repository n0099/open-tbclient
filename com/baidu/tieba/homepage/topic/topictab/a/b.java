package com.baidu.tieba.homepage.topic.topictab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.c;
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b>> {
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.jLL);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> c(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.topic.topictab.view.b bVar = new com.baidu.tieba.homepage.topic.topictab.view.b(this.mPageContext);
        bVar.setTag(this.mPageId);
        com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> aVar = new com.baidu.tieba.card.a.a<>(bVar);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        aVar.getView().setPadding(dimens, 0, dimens, 0);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> aVar) {
        if (cVar == null || aVar == null || aVar.coz() == null) {
            return null;
        }
        aVar.coz().a(cVar);
        aVar.coz().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
