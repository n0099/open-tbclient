package com.baidu.tieba.forumsearch.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.forumsearch.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.forumsearch.c.d>> {
    private View.OnClickListener dhP;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
    }

    public void p(View.OnClickListener onClickListener) {
        this.dhP = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.forumsearch.c.d> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.forumsearch.c.d dVar = new com.baidu.tieba.forumsearch.c.d(this.mPageContext);
        dVar.p(this.dhP);
        return new com.baidu.tieba.card.a.a<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.forumsearch.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.forumsearch.c.d> aVar) {
        aVar.aja().a(bVar);
        return aVar.getView();
    }
}
