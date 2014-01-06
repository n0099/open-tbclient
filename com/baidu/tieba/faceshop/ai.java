package com.baidu.tieba.faceshop;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ai extends com.baidu.adp.a.g {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        aq aqVar;
        aq aqVar2;
        aq aqVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
            aqVar = this.a.a;
            if (aqVar != null) {
                FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                if (facePurchaseRecordsData.errno == 0 && facePurchaseRecordsData.usermsg != null) {
                    aqVar3 = this.a.a;
                    aqVar3.a(facePurchaseRecordsData);
                    return;
                } else if (facePurchaseRecordsData.usermsg != null) {
                    this.a.showToast(facePurchaseRecordsData.usermsg);
                    aqVar2 = this.a.a;
                    aqVar2.c();
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
