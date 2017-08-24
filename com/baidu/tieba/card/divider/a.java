package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, com.baidu.tieba.card.a.a<c>> {
    private c bLk;
    private TbPageContext<?> oW;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TYPE);
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bLk = new c(this.oW);
        return new com.baidu.tieba.card.a.a(this.bLk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Xv() == null) {
            return null;
        }
        aVar.Xv().a((com.baidu.tieba.card.a) bVar);
        return aVar.getView();
    }
}
