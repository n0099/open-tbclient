package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, com.baidu.tieba.card.b.a<c>> {
    private TbPageContext<?> ajP;
    private c bFe;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TYPE);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bFe = new c(this.ajP);
        return new com.baidu.tieba.card.b.a(this.bFe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a((com.baidu.tieba.card.a) bVar);
        return aVar.getView();
    }
}
