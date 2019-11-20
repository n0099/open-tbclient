package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId cJo;
    private com.baidu.tieba.card.i gkl;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.glN);
        this.mPageContext = tbPageContext;
        this.gkl = new com.baidu.tieba.card.i(this.mPageContext);
        this.gkl.r("c10714", "c10739", "c10712", "c10738");
        this.gkl.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cJo = bdUniqueId;
        if (this.gkl != null) {
            this.gkl.j(this.cJo);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        aVar.baX().a(bVar);
        com.baidu.tieba.card.t.bau().c(new an("c10714").bS(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.bal()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.gkl == null) {
            this.gkl = new com.baidu.tieba.card.i(this.mPageContext);
            this.gkl.j(this.cJo);
            this.gkl.r("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.gkl);
    }

    public void onChangeSkinType(int i) {
        if (this.gkl != null) {
            this.gkl.onChangeSkinType(this.mPageContext, i);
        }
    }
}
