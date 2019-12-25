package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId dwY;
    private com.baidu.tieba.card.i gXG;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.gZr);
        this.mPageContext = tbPageContext;
        this.gXG = new com.baidu.tieba.card.i(this.mPageContext);
        this.gXG.t("c10714", "c10739", "c10712", "c10738");
        this.gXG.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dwY = bdUniqueId;
        if (this.gXG != null) {
            this.gXG.j(this.dwY);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.btc() == null) {
            return null;
        }
        aVar.btc().a(bVar);
        com.baidu.tieba.card.r.bsy().c(new an("c10714").cp(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bsp()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.gXG == null) {
            this.gXG = new com.baidu.tieba.card.i(this.mPageContext);
            this.gXG.j(this.dwY);
            this.gXG.t("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.gXG);
    }

    public void onChangeSkinType(int i) {
        if (this.gXG != null) {
            this.gXG.onChangeSkinType(this.mPageContext, i);
        }
    }
}
