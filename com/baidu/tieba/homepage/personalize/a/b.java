package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId fzO;
    private com.baidu.tieba.card.j jSG;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.jUy);
        this.mPageContext = tbPageContext;
        this.jSG = new com.baidu.tieba.card.j(this.mPageContext);
        this.jSG.C("c10714", "c10739", "c10712", "c10738");
        this.jSG.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
        if (this.jSG != null) {
            this.jSG.l(this.fzO);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.csM() == null) {
            return null;
        }
        aVar.csM().a(bVar);
        com.baidu.tieba.card.t.csg().e(new ar("c10714").dY(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.crX()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a c(ViewGroup viewGroup) {
        if (this.jSG == null) {
            this.jSG = new com.baidu.tieba.card.j(this.mPageContext);
            this.jSG.l(this.fzO);
            this.jSG.C("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.jSG);
    }

    public void onChangeSkinType(int i) {
        if (this.jSG != null) {
            this.jSG.onChangeSkinType(this.mPageContext, i);
        }
    }
}
