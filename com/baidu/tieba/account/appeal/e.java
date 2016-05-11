package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ AppealActivity aIY;
    private final /* synthetic */ boolean aJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.aIY = appealActivity;
        this.aJa = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.aJa) {
            this.aIY.finish();
        }
    }
}
