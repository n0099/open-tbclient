package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class at extends com.baidu.adp.base.h {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            baVar = this.a.a;
            if (baVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    baVar3 = this.a.a;
                    baVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    baVar2 = this.a.a;
                    baVar2.c();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.x.neterror);
    }
}
