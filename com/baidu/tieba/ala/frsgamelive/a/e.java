package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.c.f;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.frsgamelive.b.c, f.a> {
    private com.baidu.tieba.ala.f gCB;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public f.a c(ViewGroup viewGroup) {
        return new f.a(new com.baidu.tieba.ala.frsgamelive.c.f(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.frsgamelive.b.c cVar, f.a aVar) {
        aVar.gEj.a(cVar);
        aVar.gEj.c(this.gCB);
        return aVar.getView();
    }

    public void a(com.baidu.tieba.ala.f fVar) {
        this.gCB = fVar;
    }
}
