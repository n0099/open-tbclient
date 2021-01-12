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
    private BdUniqueId fEN;
    private com.baidu.tieba.card.i kbn;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder<com.baidu.tieba.card.i> cardViewHolder) {
        return a2(i, view, viewGroup, bVar, (CardViewHolder) cardViewHolder);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.kdf);
        this.mPageContext = tbPageContext;
        this.kbn = new com.baidu.tieba.card.i(this.mPageContext);
        this.kbn.B("c10714", "c10739", "c10712", "c10738");
        this.kbn.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fEN = bdUniqueId;
        if (this.kbn != null) {
            this.kbn.l(this.fEN);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.crP() == null) {
            return null;
        }
        cardViewHolder.crP().a(bVar);
        com.baidu.tieba.card.s.crj().e(new aq("c10714").dW(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cra()));
        return cardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        if (this.kbn == null) {
            this.kbn = new com.baidu.tieba.card.i(this.mPageContext);
            this.kbn.l(this.fEN);
            this.kbn.B("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.kbn);
    }

    public void onChangeSkinType(int i) {
        if (this.kbn != null) {
            this.kbn.onChangeSkinType(this.mPageContext, i);
        }
    }
}
