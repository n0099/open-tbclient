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
    private BdUniqueId fGZ;
    private com.baidu.tieba.card.i kjx;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder<com.baidu.tieba.card.i> cardViewHolder) {
        return a2(i, view, viewGroup, bVar, (CardViewHolder) cardViewHolder);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.klp);
        this.mPageContext = tbPageContext;
        this.kjx = new com.baidu.tieba.card.i(this.mPageContext);
        this.kjx.B("c10714", "c10739", "c10712", "c10738");
        this.kjx.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fGZ = bdUniqueId;
        if (this.kjx != null) {
            this.kjx.l(this.fGZ);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.ctb() == null) {
            return null;
        }
        cardViewHolder.ctb().a(bVar);
        com.baidu.tieba.card.t.csu().e(new ar("c10714").dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csk()));
        return cardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder e(ViewGroup viewGroup) {
        if (this.kjx == null) {
            this.kjx = new com.baidu.tieba.card.i(this.mPageContext);
            this.kjx.l(this.fGZ);
            this.kjx.B("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.kjx);
    }

    public void onChangeSkinType(int i) {
        if (this.kjx != null) {
            this.kjx.onChangeSkinType(this.mPageContext, i);
        }
    }
}
