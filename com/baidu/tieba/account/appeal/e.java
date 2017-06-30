package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ AppealActivity aVt;
    private final /* synthetic */ boolean aVv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.aVt = appealActivity;
        this.aVv = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.aVv) {
            this.aVt.finish();
        }
    }
}
