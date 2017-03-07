package com.baidu.tieba.im.chat;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo cPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.cPU = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.onLoaded((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.cPU;
            k = this.cPU.k(this.cPU.mUrl, aVar.kQ());
            boVar.showToast(k);
            return;
        }
        this.cPU.showToast(this.cPU.bcF.getPageContext().getString(w.l.save_error));
    }
}
