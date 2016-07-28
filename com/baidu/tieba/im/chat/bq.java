package com.baidu.tieba.im.chat;

import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bp cID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.cID = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((bq) aVar, str, i);
        if (aVar != null) {
            bp bpVar = this.cID;
            k = this.cID.k(this.cID.mUrl, aVar.jd());
            bpVar.showToast(k);
            return;
        }
        this.cID.showToast(this.cID.bem.getPageContext().getString(u.j.save_error));
    }
}
