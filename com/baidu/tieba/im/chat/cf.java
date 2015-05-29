package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ce baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.baY = ceVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((cf) aVar, str, i);
        if (aVar != null) {
            ce ceVar = this.baY;
            k = this.baY.k(this.baY.mUrl, aVar.mV());
            ceVar.showToast(k);
            return;
        }
        this.baY.showToast(this.baY.mActivity.getPageContext().getString(com.baidu.tieba.t.save_error));
    }
}
