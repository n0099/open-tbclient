package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes22.dex */
public class ae extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.p, com.baidu.tieba.card.a.a<com.baidu.tieba.card.s>> {
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.s> aVar) {
        return a2(i, view, viewGroup, pVar, (com.baidu.tieba.card.a.a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.p.hWt);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a c(ViewGroup viewGroup) {
        com.baidu.tieba.card.s sVar = new com.baidu.tieba.card.s(this.mPageContext);
        sVar.aw("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(sVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, com.baidu.tieba.card.a.a aVar) {
        aVar.cmx().a(pVar);
        aVar.cmx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.clQ().e(new aq("c10718").dR("obj_id", String.valueOf(pVar.hWu)));
        return aVar.getView();
    }
}
