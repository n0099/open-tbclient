package com.baidu.tieba.im.chat;

import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bo bPH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.bPH = boVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String l;
        super.a((bp) aVar, str, i);
        if (aVar != null) {
            bo boVar = this.bPH;
            l = this.bPH.l(this.bPH.mUrl, aVar.mV());
            boVar.showToast(l);
            return;
        }
        this.bPH.showToast(this.bPH.bdK.getPageContext().getString(t.j.save_error));
    }
}
