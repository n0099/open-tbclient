package com.baidu.tieba.im.chat;

import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bp cVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.cVC = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((bq) aVar, str, i);
        if (aVar != null) {
            bp bpVar = this.cVC;
            k = this.cVC.k(this.cVC.mUrl, aVar.jY());
            bpVar.showToast(k);
            return;
        }
        this.cVC.showToast(this.cVC.aRd.getPageContext().getString(r.j.save_error));
    }
}
