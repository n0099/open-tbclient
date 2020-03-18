package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private BdUniqueId dBK;
    private com.baidu.tieba.card.i heJ;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.hgx);
        this.mPageContext = tbPageContext;
        this.heJ = new com.baidu.tieba.card.i(this.mPageContext);
        this.heJ.w("c10714", "c10739", "c10712", "c10738");
        this.heJ.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dBK = bdUniqueId;
        if (this.heJ != null) {
            this.heJ.j(this.dBK);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bvQ() == null) {
            return null;
        }
        aVar.bvQ().a(bVar);
        com.baidu.tieba.card.r.bvm().e(new an("c10714").cx(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bvd()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.heJ == null) {
            this.heJ = new com.baidu.tieba.card.i(this.mPageContext);
            this.heJ.j(this.dBK);
            this.heJ.w("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.heJ);
    }

    public void onChangeSkinType(int i) {
        if (this.heJ != null) {
            this.heJ.onChangeSkinType(this.mPageContext, i);
        }
    }
}
