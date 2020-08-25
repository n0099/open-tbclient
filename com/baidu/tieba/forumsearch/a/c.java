package com.baidu.tieba.forumsearch.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes18.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.forumsearch.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.forumsearch.c.d>> {
    private View.OnClickListener hQx;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mPageContext = tbPageContext;
    }

    public void y(View.OnClickListener onClickListener) {
        this.hQx = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.forumsearch.c.d> b(ViewGroup viewGroup) {
        com.baidu.tieba.forumsearch.c.d dVar = new com.baidu.tieba.forumsearch.c.d(this.mPageContext);
        dVar.y(this.hQx);
        return new com.baidu.tieba.card.a.a<>(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.forumsearch.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.forumsearch.c.d> aVar) {
        aVar.ccE().a(bVar);
        return aVar.getView();
    }
}
