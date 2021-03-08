package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.enterForum.recommend.b.e;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, CardViewHolder<com.baidu.tieba.enterForum.recommend.view.d>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), e.iOg);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.enterForum.recommend.view.d> e(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.d dVar = new com.baidu.tieba.enterForum.recommend.view.d(this.mPageContext);
        dVar.setTag(this.mPageId);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, CardViewHolder<com.baidu.tieba.enterForum.recommend.view.d> cardViewHolder) {
        if (eVar == null || cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        cardViewHolder.cto().a(eVar);
        cardViewHolder.cto().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.getView();
    }
}
