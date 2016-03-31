package com.baidu.tieba.im.chat;

import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo bZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bZZ = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.bZZ;
            k = this.bZZ.k(this.bZZ.mUrl, aVar.mN());
            boVar.showToast(k);
            return;
        }
        this.bZZ.showToast(this.bZZ.bix.getPageContext().getString(t.j.save_error));
    }
}
