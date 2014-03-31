package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class aw extends com.baidu.adp.a.h {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            bdVar = this.a.a;
            if (bdVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    bdVar3 = this.a.a;
                    bdVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    bdVar2 = this.a.a;
                    bdVar2.c();
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
