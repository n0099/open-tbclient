package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, CardViewHolder<f>> {
    private f iDJ;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, e eVar, CardViewHolder<f> cardViewHolder) {
        return a2(i, view, viewGroup, eVar, (CardViewHolder) cardViewHolder);
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), e.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        this.iDJ = new f(this.mPageContext);
        return new CardViewHolder(this.iDJ);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, e eVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        cardViewHolder.cto().a(eVar);
        return cardViewHolder.getView();
    }
}
