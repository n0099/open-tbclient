package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ce baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.baZ = ceVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.a((cf) aVar, str, i);
        if (aVar != null) {
            ce ceVar = this.baZ;
            k = this.baZ.k(this.baZ.mUrl, aVar.mV());
            ceVar.showToast(k);
            return;
        }
        this.baZ.showToast(this.baZ.mActivity.getPageContext().getString(com.baidu.tieba.t.save_error));
    }
}
