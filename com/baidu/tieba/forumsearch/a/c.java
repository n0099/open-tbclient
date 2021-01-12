package com.baidu.tieba.forumsearch.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.forumsearch.b.b, CardViewHolder<com.baidu.tieba.forumsearch.c.d>> {
    private View.OnClickListener iYk;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
    }

    public void A(View.OnClickListener onClickListener) {
        this.iYk = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.forumsearch.c.d> e(ViewGroup viewGroup) {
        com.baidu.tieba.forumsearch.c.d dVar = new com.baidu.tieba.forumsearch.c.d(this.mPageContext);
        dVar.A(this.iYk);
        return new CardViewHolder<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.forumsearch.b.b bVar, CardViewHolder<com.baidu.tieba.forumsearch.c.d> cardViewHolder) {
        cardViewHolder.crP().a(bVar);
        return cardViewHolder.getView();
    }
}
