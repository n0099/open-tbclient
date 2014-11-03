package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class at extends com.baidu.adp.base.h {
    final /* synthetic */ FacePurchaseRecordsActivity aum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.aum = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bb bbVar;
        bb bbVar2;
        this.aum.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            bbVar = this.aum.auk;
            if (bbVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0) {
                    bbVar2 = this.aum.auk;
                    bbVar2.c(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.aum.showToast(facePurchaseRecordsData.usermsg);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        this.aum.showToast(cb.neterror);
    }
}
