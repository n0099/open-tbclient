package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.enterForum.recommend.b.c, CardViewHolder<com.baidu.tieba.enterForum.recommend.view.b>> {
    private ab<com.baidu.tieba.enterForum.recommend.b.c> iMc;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.enterForum.recommend.b.c.iMq);
        this.iMc = new ab<com.baidu.tieba.enterForum.recommend.b.c>() { // from class: com.baidu.tieba.enterForum.recommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.enterForum.recommend.b.c cVar) {
                if (cVar == null) {
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.enterForum.recommend.view.b> e(ViewGroup viewGroup) {
        com.baidu.tieba.enterForum.recommend.view.b bVar = new com.baidu.tieba.enterForum.recommend.view.b(this.mPageContext);
        bVar.setTag(this.mPageId);
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.enterForum.recommend.b.c cVar, CardViewHolder<com.baidu.tieba.enterForum.recommend.view.b> cardViewHolder) {
        if (cVar == null || cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        cardViewHolder.cti().a(cVar);
        cardViewHolder.cti().c(this.iMc);
        return cardViewHolder.getView();
    }
}
