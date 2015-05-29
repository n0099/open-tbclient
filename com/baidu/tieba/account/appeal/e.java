package com.baidu.tieba.account.appeal;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ AppealActivity aya;
    private final /* synthetic */ boolean ayc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.aya = appealActivity;
        this.ayc = z;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.ayc) {
            this.aya.finish();
        }
    }
}
