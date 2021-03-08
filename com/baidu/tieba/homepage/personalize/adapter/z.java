package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class z extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, CardViewHolder<com.baidu.tieba.card.s>> {
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, CardViewHolder<com.baidu.tieba.card.s> cardViewHolder) {
        return a2(i, view, viewGroup, oVar, (CardViewHolder) cardViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.o.iDz);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.card.s sVar = new com.baidu.tieba.card.s(this.mPageContext);
        sVar.aC("c10718", "c10719", "c10742");
        return new CardViewHolder(sVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, CardViewHolder cardViewHolder) {
        cardViewHolder.cto().a(oVar);
        cardViewHolder.cto().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.csH().e(new ar("c10718").dR("obj_id", String.valueOf(oVar.iDA)));
        return cardViewHolder.getView();
    }
}
