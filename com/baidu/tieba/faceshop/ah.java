package com.baidu.tieba.faceshop;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class ah extends com.baidu.adp.a.g {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            aoVar = this.a.a;
            if (aoVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    aoVar3 = this.a.a;
                    aoVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    aoVar2 = this.a.a;
                    aoVar2.c();
                    return;
                } else {
                    this.a.showToast(R.string.neterror);
                    return;
                }
            }
            return;
        }
        this.a.showToast(R.string.neterror);
    }
}
