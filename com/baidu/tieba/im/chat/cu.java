package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ct aTc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar) {
        this.aTc = ctVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String j;
        super.onLoaded((cu) aVar, str, i);
        if (aVar != null) {
            ct ctVar = this.aTc;
            j = this.aTc.j(this.aTc.mUrl, aVar.jf());
            ctVar.showToast(j);
            return;
        }
        this.aTc.showToast(this.aTc.mActivity.getPageContext().getString(com.baidu.tieba.z.save_error));
    }
}
