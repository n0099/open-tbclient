package com.baidu.tieba.faceshop;

import com.baidu.tieba.view.by;
/* loaded from: classes.dex */
class ai implements by {
    final /* synthetic */ FacePurchaseRecordsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.a = facePurchaseRecordsActivity;
    }

    @Override // com.baidu.tieba.view.by
    public void a(boolean z) {
        if (z) {
            this.a.a(true);
        }
    }
}
