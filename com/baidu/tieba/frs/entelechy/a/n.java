package com.baidu.tieba.frs.entelechy.a;

import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.f.c<com.baidu.tbadk.widget.layout.c> {
    final /* synthetic */ l bpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bpa = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: SA */
    public com.baidu.tbadk.widget.layout.c dE() {
        TbPageContext tbPageContext;
        tbPageContext = this.bpa.DV;
        return new com.baidu.tbadk.widget.layout.c(tbPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public void l(com.baidu.tbadk.widget.layout.c cVar) {
        cVar.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.layout.c m(com.baidu.tbadk.widget.layout.c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public com.baidu.tbadk.widget.layout.c n(com.baidu.tbadk.widget.layout.c cVar) {
        return cVar;
    }
}
