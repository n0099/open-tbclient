package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, com.baidu.tieba.card.a.a<com.baidu.tieba.card.q>> {
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.q> aVar) {
        return a2(i, view, viewGroup, oVar, (com.baidu.tieba.card.a.a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.o.gtC);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        com.baidu.tieba.card.q qVar = new com.baidu.tieba.card.q(this.mPageContext);
        qVar.ah("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(qVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.a.a aVar) {
        aVar.bFA().a(oVar);
        aVar.bFA().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.r.bEX().e(new an("c10718").cI("obj_id", String.valueOf(oVar.gtD)));
        return aVar.getView();
    }
}
