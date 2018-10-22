package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, com.baidu.tieba.card.a.a<c>> {
    private c cRj;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TYPE);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cRj = new c(this.mPageContext);
        return new com.baidu.tieba.card.a.a(this.cRj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.aoQ() == null) {
            return null;
        }
        aVar.aoQ().a(bVar);
        return aVar.getView();
    }
}
