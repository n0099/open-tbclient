package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId epM;
    private com.baidu.tieba.card.j idj;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.aa$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.ieS);
        this.mPageContext = tbPageContext;
        this.idj = new com.baidu.tieba.card.j(this.mPageContext);
        this.idj.x("c10714", "c10739", "c10712", "c10738");
        this.idj.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.epM = bdUniqueId;
        if (this.idj != null) {
            this.idj.l(this.epM);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bLU() == null) {
            return null;
        }
        aVar.bLU().a(bVar);
        com.baidu.tieba.card.s.bLq().e(new an("c10714").dh(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bLh()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.idj == null) {
            this.idj = new com.baidu.tieba.card.j(this.mPageContext);
            this.idj.l(this.epM);
            this.idj.x("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.idj);
    }

    public void onChangeSkinType(int i) {
        if (this.idj != null) {
            this.idj.onChangeSkinType(this.mPageContext, i);
        }
    }
}
