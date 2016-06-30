package com.baidu.tieba.im.chat;

import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bp cFO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.cFO = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((bq) aVar, str, i);
        if (aVar != null) {
            bp bpVar = this.cFO;
            k = this.cFO.k(this.cFO.mUrl, aVar.je());
            bpVar.showToast(k);
            return;
        }
        this.cFO.showToast(this.cFO.bkc.getPageContext().getString(u.j.save_error));
    }
}
