package com.baidu.tieba.forumsearch.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.forumsearch.b.a, CardViewHolder<com.baidu.tieba.forumsearch.c.c>> {
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.forumsearch.c.c> e(ViewGroup viewGroup) {
        return new CardViewHolder<>(new com.baidu.tieba.forumsearch.c.c(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.forumsearch.b.a aVar, CardViewHolder<com.baidu.tieba.forumsearch.c.c> cardViewHolder) {
        return cardViewHolder.getView();
    }
}
