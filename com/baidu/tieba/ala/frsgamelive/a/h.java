package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.c.g;
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.c, g.a> {
    private com.baidu.tieba.ala.d ful;
    private TbPageContext fut;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fut = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public g.a b(ViewGroup viewGroup) {
        return new g.a(new com.baidu.tieba.ala.frsgamelive.c.g(this.fut));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.c cVar, g.a aVar) {
        aVar.fvV.a(cVar);
        aVar.fvV.c(this.ful);
        return aVar.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.ful = dVar;
    }
}
