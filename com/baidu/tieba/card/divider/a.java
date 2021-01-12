package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, CardViewHolder<c>> {
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, b bVar, CardViewHolder<c> cardViewHolder) {
        return a2(i, view, viewGroup, bVar, (CardViewHolder) cardViewHolder);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        return new CardViewHolder(new c(this.mPageContext));
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.crP() == null) {
            return null;
        }
        cardViewHolder.crP().a(bVar);
        return cardViewHolder.getView();
    }
}
