package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes16.dex */
public class ad extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.p, com.baidu.tieba.card.a.a<com.baidu.tieba.card.r>> {
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.r> aVar) {
        return a2(i, view, viewGroup, pVar, (com.baidu.tieba.card.a.a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.p.hnX);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        com.baidu.tieba.card.r rVar = new com.baidu.tieba.card.r(this.mPageContext);
        rVar.an("c10718", "c10719", "c10742");
        return new com.baidu.tieba.card.a.a(rVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.p pVar, com.baidu.tieba.card.a.a aVar) {
        aVar.ccF().a(pVar);
        aVar.ccF().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.s.cbY().e(new aq("c10718").dD("obj_id", String.valueOf(pVar.hnY)));
        return aVar.getView();
    }
}
