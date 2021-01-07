package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, CardViewHolder<com.baidu.tieba.card.i>> {
    private BdUniqueId fJu;
    private com.baidu.tieba.card.i kfT;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder<com.baidu.tieba.card.i> cardViewHolder) {
        return a2(i, view, viewGroup, bVar, (CardViewHolder) cardViewHolder);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.khL);
        this.mPageContext = tbPageContext;
        this.kfT = new com.baidu.tieba.card.i(this.mPageContext);
        this.kfT.B("c10714", "c10739", "c10712", "c10738");
        this.kfT.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fJu = bdUniqueId;
        if (this.kfT != null) {
            this.kfT.l(this.fJu);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.cvH() == null) {
            return null;
        }
        cardViewHolder.cvH().a(bVar);
        com.baidu.tieba.card.s.cvb().e(new aq("c10714").dX(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cuS()));
        return cardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        if (this.kfT == null) {
            this.kfT = new com.baidu.tieba.card.i(this.mPageContext);
            this.kfT.l(this.fJu);
            this.kfT.B("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.kfT);
    }

    public void onChangeSkinType(int i) {
        if (this.kfT != null) {
            this.kfT.onChangeSkinType(this.mPageContext, i);
        }
    }
}
