package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.recommend.b.e;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.d>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.eUx);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.d> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.d dVar = new com.baidu.tieba.enterForum.recommend.view.d(this.mPageContext);
        dVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, com.baidu.tieba.card.a.a<com.baidu.tieba.enterForum.recommend.view.d> aVar) {
        if (eVar == null || aVar == null || aVar.aYs() == null) {
            return null;
        }
        aVar.aYs().a(eVar);
        aVar.aYs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }
}
