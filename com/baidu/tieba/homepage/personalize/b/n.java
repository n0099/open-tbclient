package com.baidu.tieba.homepage.personalize.b;

import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.c> {
    final /* synthetic */ m cxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.cxZ = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: abw */
    public com.baidu.tbadk.widget.layout.c fK() {
        TbPageContext tbPageContext;
        tbPageContext = this.cxZ.ajT;
        return new com.baidu.tbadk.widget.layout.c(tbPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public void o(com.baidu.tbadk.widget.layout.c cVar) {
        cVar.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public com.baidu.tbadk.widget.layout.c p(com.baidu.tbadk.widget.layout.c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public com.baidu.tbadk.widget.layout.c q(com.baidu.tbadk.widget.layout.c cVar) {
        return cVar;
    }
}
