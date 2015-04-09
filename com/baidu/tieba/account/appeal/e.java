package com.baidu.tieba.account.appeal;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ AppealActivity awu;
    private final /* synthetic */ boolean aww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.awu = appealActivity;
        this.aww = z;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.aww) {
            this.awu.finish();
        }
    }
}
