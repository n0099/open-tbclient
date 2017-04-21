package com.baidu.tieba.im.chat;

import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo cQI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.cQI = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.onLoaded((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.cQI;
            k = this.cQI.k(this.cQI.mUrl, aVar.kV());
            boVar.showToast(k);
            return;
        }
        this.cQI.showToast(this.cQI.bdG.getPageContext().getString(w.l.save_error));
    }
}
