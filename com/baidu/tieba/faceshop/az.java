package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class az extends com.baidu.adp.base.e {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            bgVar = this.a.a;
            if (bgVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    bgVar3 = this.a.a;
                    bgVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    bgVar2 = this.a.a;
                    bgVar2.c();
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
