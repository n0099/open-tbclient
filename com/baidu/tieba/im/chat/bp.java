package com.baidu.tieba.im.chat;

import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo bLT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bLT = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String l;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.bLT;
            l = this.bLT.l(this.bLT.mUrl, aVar.mH());
            boVar.showToast(l);
            return;
        }
        this.bLT.showToast(this.bLT.bbA.getPageContext().getString(n.j.save_error));
    }
}
