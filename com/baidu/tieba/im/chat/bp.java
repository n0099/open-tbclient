package com.baidu.tieba.im.chat;

import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.caE = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.caE;
            k = this.caE.k(this.caE.mUrl, aVar.jb());
            boVar.showToast(k);
            return;
        }
        this.caE.showToast(this.caE.bek.getPageContext().getString(t.j.save_error));
    }
}
