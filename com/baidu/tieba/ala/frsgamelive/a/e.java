package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.c.f;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.c, f.a> {
    private com.baidu.tieba.ala.d ful;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public f.a b(ViewGroup viewGroup) {
        return new f.a(new com.baidu.tieba.ala.frsgamelive.c.f(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.c cVar, f.a aVar) {
        aVar.fvT.a(cVar);
        aVar.fvT.c(this.ful);
        return aVar.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.ful = dVar;
    }
}
