package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId ebv;
    private com.baidu.tieba.card.i hOw;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.hQh);
        this.mPageContext = tbPageContext;
        this.hOw = new com.baidu.tieba.card.i(this.mPageContext);
        this.hOw.w("c10714", "c10739", "c10712", "c10738");
        this.hOw.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebv = bdUniqueId;
        if (this.hOw != null) {
            this.hOw.j(this.ebv);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bFB() == null) {
            return null;
        }
        aVar.bFB().a(bVar);
        com.baidu.tieba.card.r.bEY().e(new an("c10714").cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEP()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.hOw == null) {
            this.hOw = new com.baidu.tieba.card.i(this.mPageContext);
            this.hOw.j(this.ebv);
            this.hOw.w("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.hOw);
    }

    public void onChangeSkinType(int i) {
        if (this.hOw != null) {
            this.hOw.onChangeSkinType(this.mPageContext, i);
        }
    }
}
