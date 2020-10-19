package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId fey;
    private com.baidu.tieba.card.j jlL;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.jnz);
        this.mPageContext = tbPageContext;
        this.jlL = new com.baidu.tieba.card.j(this.mPageContext);
        this.jlL.B("c10714", "c10739", "c10712", "c10738");
        this.jlL.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fey = bdUniqueId;
        if (this.jlL != null) {
            this.jlL.l(this.fey);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.cjq() == null) {
            return null;
        }
        aVar.cjq().a(bVar);
        com.baidu.tieba.card.s.ciJ().e(new aq("c10714").dK(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.ciA()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a c(ViewGroup viewGroup) {
        if (this.jlL == null) {
            this.jlL = new com.baidu.tieba.card.j(this.mPageContext);
            this.jlL.l(this.fey);
            this.jlL.B("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.jlL);
    }

    public void onChangeSkinType(int i) {
        if (this.jlL != null) {
            this.jlL.onChangeSkinType(this.mPageContext, i);
        }
    }
}
