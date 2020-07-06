package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId eyE;
    private com.baidu.tieba.card.j itd;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.iuQ);
        this.mPageContext = tbPageContext;
        this.itd = new com.baidu.tieba.card.j(this.mPageContext);
        this.itd.x("c10714", "c10739", "c10712", "c10738");
        this.itd.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eyE = bdUniqueId;
        if (this.itd != null) {
            this.itd.l(this.eyE);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.bPh() == null) {
            return null;
        }
        aVar.bPh().a(bVar);
        com.baidu.tieba.card.s.bOB().e(new ao("c10714").dk(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bOs()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        if (this.itd == null) {
            this.itd = new com.baidu.tieba.card.j(this.mPageContext);
            this.itd.l(this.eyE);
            this.itd.x("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.itd);
    }

    public void onChangeSkinType(int i) {
        if (this.itd != null) {
            this.itd.onChangeSkinType(this.mPageContext, i);
        }
    }
}
