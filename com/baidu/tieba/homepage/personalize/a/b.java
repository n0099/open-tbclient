package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId ebA;
    private com.baidu.tieba.card.i hOC;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.hQn);
        this.mPageContext = tbPageContext;
        this.hOC = new com.baidu.tieba.card.i(this.mPageContext);
        this.hOC.w("c10714", "c10739", "c10712", "c10738");
        this.hOC.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebA = bdUniqueId;
        if (this.hOC != null) {
            this.hOC.j(this.ebA);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bFA() == null) {
            return null;
        }
        aVar.bFA().a(bVar);
        com.baidu.tieba.card.r.bEX().e(new an("c10714").cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEO()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.hOC == null) {
            this.hOC = new com.baidu.tieba.card.i(this.mPageContext);
            this.hOC.j(this.ebA);
            this.hOC.w("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.hOC);
    }

    public void onChangeSkinType(int i) {
        if (this.hOC != null) {
            this.hOC.onChangeSkinType(this.mPageContext, i);
        }
    }
}
