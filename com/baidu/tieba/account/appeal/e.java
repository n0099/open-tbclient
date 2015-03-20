package com.baidu.tieba.account.appeal;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ AppealActivity awm;
    private final /* synthetic */ boolean awo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.awm = appealActivity;
        this.awo = z;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.awo) {
            this.awm.finish();
        }
    }
}
