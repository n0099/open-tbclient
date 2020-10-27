package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.c.g;
/* loaded from: classes4.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.c, g.a> {
    private com.baidu.tieba.ala.f gwN;
    private TbPageContext gwV;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gwV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public g.a c(ViewGroup viewGroup) {
        return new g.a(new com.baidu.tieba.ala.frsgamelive.c.g(this.gwV));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.c cVar, g.a aVar) {
        aVar.gyx.a(cVar);
        aVar.gyx.c(this.gwN);
        return aVar.getView();
    }

    public void a(com.baidu.tieba.ala.f fVar) {
        this.gwN = fVar;
    }
}
