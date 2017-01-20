package com.baidu.tieba.im.chat;

import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo cNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.cNF = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.onLoaded((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.cNF;
            k = this.cNF.k(this.cNF.mUrl, aVar.jW());
            boVar.showToast(k);
            return;
        }
        this.cNF.showToast(this.cNF.aWr.getPageContext().getString(r.l.save_error));
    }
}
