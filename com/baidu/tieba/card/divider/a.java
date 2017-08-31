package com.baidu.tieba.card.divider;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, com.baidu.tieba.card.a.a<c>> {
    private c bOd;
    private TbPageContext<?> mF;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.TYPE);
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.bOd = new c(this.mF);
        return new com.baidu.tieba.card.a.a(this.bOd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        aVar.Yy().a((com.baidu.tieba.card.a) bVar);
        return aVar.getView();
    }
}
