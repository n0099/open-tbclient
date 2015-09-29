package com.baidu.tieba.im.chat;

import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo bsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bsr = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String l;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.bsr;
            l = this.bsr.l(this.bsr.mUrl, aVar.nd());
            boVar.showToast(l);
            return;
        }
        this.bsr.showToast(this.bsr.aRT.getPageContext().getString(i.h.save_error));
    }
}
