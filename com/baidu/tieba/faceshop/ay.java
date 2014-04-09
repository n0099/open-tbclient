package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class ay extends com.baidu.adp.a.h {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            bfVar = this.a.a;
            if (bfVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    bfVar3 = this.a.a;
                    bfVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    bfVar2 = this.a.a;
                    bfVar2.c();
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.a.k.neterror);
                    return;
                }
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.a.k.neterror);
    }
}
