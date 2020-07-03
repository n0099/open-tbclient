package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, com.baidu.tieba.card.a.a<c>> {
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.card.a.a<c> aVar) {
        return a2(i, view, viewGroup, bVar, (com.baidu.tieba.card.a.a) aVar);
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a(new c(this.mPageContext));
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.bPg() == null) {
            return null;
        }
        aVar.bPg().a(bVar);
        return aVar.getView();
    }
}
