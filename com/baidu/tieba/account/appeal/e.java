package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ AppealActivity aMv;
    private final /* synthetic */ boolean aMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.aMv = appealActivity;
        this.aMx = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.aMx) {
            this.aMv.finish();
        }
    }
}
