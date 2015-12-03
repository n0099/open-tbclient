package com.baidu.tieba.im.chat;

import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bIm = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String l;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.bIm;
            l = this.bIm.l(this.bIm.mUrl, aVar.nj());
            boVar.showToast(l);
            return;
        }
        this.bIm.showToast(this.bIm.aXA.getPageContext().getString(n.i.save_error));
    }
}
