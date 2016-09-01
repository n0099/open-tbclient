package com.baidu.tieba.im.chat;

import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bp cUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.cUi = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((bq) aVar, str, i);
        if (aVar != null) {
            bp bpVar = this.cUi;
            k = this.cUi.k(this.cUi.mUrl, aVar.jY());
            bpVar.showToast(k);
            return;
        }
        this.cUi.showToast(this.cUi.aPR.getPageContext().getString(t.j.save_error));
    }
}
