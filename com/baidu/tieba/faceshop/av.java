package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class av extends com.baidu.adp.base.h {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            bcVar = this.a.a;
            if (bcVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    bcVar3 = this.a.a;
                    bcVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    bcVar2 = this.a.a;
                    bcVar2.c();
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.y.neterror);
    }
}
