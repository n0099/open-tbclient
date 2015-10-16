package com.baidu.tieba.im.chat;

import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo bsC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bsC = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String l;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.bsC;
            l = this.bsC.l(this.bsC.mUrl, aVar.nd());
            boVar.showToast(l);
            return;
        }
        this.bsC.showToast(this.bsC.aSe.getPageContext().getString(i.h.save_error));
    }
}
