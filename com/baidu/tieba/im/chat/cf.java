package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ce aYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.aYb = ceVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String k;
        super.onLoaded((cf) aVar, str, i);
        if (aVar != null) {
            ce ceVar = this.aYb;
            k = this.aYb.k(this.aYb.mUrl, aVar.mC());
            ceVar.showToast(k);
            return;
        }
        this.aYb.showToast(this.aYb.mActivity.getPageContext().getString(com.baidu.tieba.y.save_error));
    }
}
