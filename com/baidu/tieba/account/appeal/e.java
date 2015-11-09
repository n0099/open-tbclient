package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ AppealActivity aEm;
    private final /* synthetic */ boolean aEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.aEm = appealActivity;
        this.aEo = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.aEo) {
            this.aEm.finish();
        }
    }
}
