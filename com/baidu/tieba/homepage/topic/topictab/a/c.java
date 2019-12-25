package com.baidu.tieba.homepage.topic.topictab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.c, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b>> {
    private TbPageContext<?> mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.homepage.topic.topictab.b.c.hcf);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> b(ViewGroup viewGroup) {
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.topic.topictab.view.b> aVar) {
        if (cVar == null || aVar == null || aVar.btc() == null) {
            return null;
        }
        aVar.btc().a(cVar);
        aVar.btc().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
