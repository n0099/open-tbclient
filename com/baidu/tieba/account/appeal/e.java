package com.baidu.tieba.account.appeal;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ AppealActivity ayb;
    private final /* synthetic */ boolean ayd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.ayb = appealActivity;
        this.ayd = z;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.ayd) {
            this.ayb.finish();
        }
    }
}
