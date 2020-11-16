package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes20.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, com.baidu.tieba.card.a.a<f>> {
    private f idq;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, e eVar, com.baidu.tieba.card.a.a<f> aVar) {
        return a2(i, view, viewGroup, eVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), e.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a c(ViewGroup viewGroup) {
        this.idq = new f(this.mPageContext);
        return new com.baidu.tieba.card.a.a(this.idq);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, e eVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.coz() == null) {
            return null;
        }
        aVar.coz().a(eVar);
        return aVar.getView();
    }
}
