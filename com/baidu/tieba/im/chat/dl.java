package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dk aPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(dk dkVar) {
        this.aPN = dkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String h;
        super.a((dl) aVar, str, i);
        if (aVar != null) {
            dk dkVar = this.aPN;
            h = this.aPN.h(this.aPN.mUrl, aVar.ho());
            dkVar.showToast(h);
            return;
        }
        this.aPN.showToast(this.aPN.mActivity.getString(com.baidu.tieba.y.save_error));
    }
}
