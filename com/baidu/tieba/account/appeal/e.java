package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ AppealActivity aVN;
    private final /* synthetic */ boolean aVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.aVN = appealActivity;
        this.aVP = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.aVP) {
            this.aVN.finish();
        }
    }
}
