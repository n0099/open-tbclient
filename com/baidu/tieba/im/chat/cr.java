package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ cq aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.aRU = cqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String j;
        super.onLoaded((cr) aVar, str, i);
        if (aVar != null) {
            cq cqVar = this.aRU;
            j = this.aRU.j(this.aRU.mUrl, aVar.jl());
            cqVar.showToast(j);
            return;
        }
        this.aRU.showToast(this.aRU.mActivity.getPageContext().getString(com.baidu.tieba.z.save_error));
    }
}
