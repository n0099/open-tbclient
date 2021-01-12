package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.g;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.e, CardViewHolder<g>> {
    private g jtK;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.e.iyq);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<g> e(ViewGroup viewGroup) {
        this.jtK = new g(this.mPageContext);
        this.jtK.setForumId(this.mForumId);
        return new CardViewHolder<>(this.jtK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.e eVar, CardViewHolder<g> cardViewHolder) {
        if (cardViewHolder.crP() == null) {
            return null;
        }
        cardViewHolder.crP().a(eVar);
        cardViewHolder.crP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.crP().getView();
    }
}
