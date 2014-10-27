package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class at extends com.baidu.adp.base.h {
    final /* synthetic */ FacePurchaseRecordsActivity aud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.aud = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bb bbVar;
        bb bbVar2;
        this.aud.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            bbVar = this.aud.aub;
            if (bbVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0) {
                    bbVar2 = this.aud.aub;
                    bbVar2.c(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.aud.showToast(facePurchaseRecordsData.usermsg);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        this.aud.showToast(cb.neterror);
    }
}
