package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.homepage.topic.topicdetail.a.d;
import com.baidu.tieba.homepage.topic.topicdetail.view.e;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<d, CardViewHolder<e>> {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.kgx);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<e> e(ViewGroup viewGroup) {
        e eVar = new e(this.mPageContext);
        eVar.setTag(this.mPageId);
        return new CardViewHolder<>(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, CardViewHolder<e> cardViewHolder) {
        if (dVar == null || cardViewHolder == null || cardViewHolder.crP() == null) {
            return null;
        }
        cardViewHolder.crP().a(dVar);
        cardViewHolder.crP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return cardViewHolder.getView();
    }
}
