package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, CardViewHolder<com.baidu.tieba.card.i>> {
    private BdUniqueId fIy;
    private com.baidu.tieba.card.i klN;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder<com.baidu.tieba.card.i> cardViewHolder) {
        return a2(i, view, viewGroup, bVar, (CardViewHolder) cardViewHolder);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.knF);
        this.mPageContext = tbPageContext;
        this.klN = new com.baidu.tieba.card.i(this.mPageContext);
        this.klN.B("c10714", "c10739", "c10712", "c10738");
        this.klN.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fIy = bdUniqueId;
        if (this.klN != null) {
            this.klN.l(this.fIy);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.cto() == null) {
            return null;
        }
        cardViewHolder.cto().a(bVar);
        com.baidu.tieba.card.t.csH().e(new ar("c10714").dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csx()));
        return cardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        if (this.klN == null) {
            this.klN = new com.baidu.tieba.card.i(this.mPageContext);
            this.klN.l(this.fIy);
            this.klN.B("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.klN);
    }

    public void onChangeSkinType(int i) {
        if (this.klN != null) {
            this.klN.onChangeSkinType(this.mPageContext, i);
        }
    }
}
