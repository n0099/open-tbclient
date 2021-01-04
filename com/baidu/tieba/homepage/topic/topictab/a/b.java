package com.baidu.tieba.homepage.topic.topictab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.homepage.topic.topictab.b.c;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, CardViewHolder<com.baidu.tieba.homepage.topic.topictab.view.b>> {
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.kmB);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.homepage.topic.topictab.view.b> e(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.topic.topictab.view.b bVar = new com.baidu.tieba.homepage.topic.topictab.view.b(this.mPageContext);
        bVar.setTag(this.mPageId);
        CardViewHolder<com.baidu.tieba.homepage.topic.topictab.view.b> cardViewHolder = new CardViewHolder<>(bVar);
        int dimens = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44);
        cardViewHolder.getView().setPadding(dimens, 0, dimens, 0);
        return cardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, CardViewHolder<com.baidu.tieba.homepage.topic.topictab.view.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.cvG() == null) {
            return null;
        }
        cardViewHolder.cvG().a(cVar);
        cardViewHolder.cvG().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.getView();
    }
}
