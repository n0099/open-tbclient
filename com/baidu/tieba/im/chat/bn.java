package com.baidu.tieba.im.chat;

import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bm boT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.boT = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String l;
        super.a((bn) aVar, str, i);
        if (aVar != null) {
            bm bmVar = this.boT;
            l = this.boT.l(this.boT.mUrl, aVar.nf());
            bmVar.showToast(l);
            return;
        }
        this.boT.showToast(this.boT.aSJ.getPageContext().getString(i.C0057i.save_error));
    }
}
