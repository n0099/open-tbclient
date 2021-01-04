package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.d, CardViewHolder<com.baidu.tieba.enterForum.recommend.view.c>> {
    private aa iKM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, aa aaVar) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.d.iLd);
        this.mPageContext = tbPageContext;
        this.iKM = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.enterForum.recommend.view.c> e(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.c cVar = new com.baidu.tieba.enterForum.recommend.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.d dVar, CardViewHolder<com.baidu.tieba.enterForum.recommend.view.c> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.cvG() == null) {
            return null;
        }
        if (viewGroup instanceof BdTypeRecyclerView) {
            cardViewHolder.cvG().pT(dVar.needTopMargin);
        }
        cardViewHolder.cvG().a(dVar);
        if (this.iKM != null) {
            cardViewHolder.cvG().c(this.iKM);
        }
        return cardViewHolder.getView();
    }
}
