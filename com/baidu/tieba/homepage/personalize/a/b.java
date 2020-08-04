package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId eEU;
    private com.baidu.tieba.card.j izj;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.iAW);
        this.mPageContext = tbPageContext;
        this.izj = new com.baidu.tieba.card.j(this.mPageContext);
        this.izj.x("c10714", "c10739", "c10712", "c10738");
        this.izj.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eEU = bdUniqueId;
        if (this.izj != null) {
            this.izj.m(this.eEU);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bSs() == null) {
            return null;
        }
        aVar.bSs().a(bVar);
        com.baidu.tieba.card.s.bRL().e(new ap("c10714").dn(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bRC()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.izj == null) {
            this.izj = new com.baidu.tieba.card.j(this.mPageContext);
            this.izj.m(this.eEU);
            this.izj.x("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.izj);
    }

    public void onChangeSkinType(int i) {
        if (this.izj != null) {
            this.izj.onChangeSkinType(this.mPageContext, i);
        }
    }
}
