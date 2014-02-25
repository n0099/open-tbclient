package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class bo implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsImageActivity a;

    private bo(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bo(FrsImageActivity frsImageActivity, bo boVar) {
        this(frsImageActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == -124) {
            FrsImageActivity.a(this.a, sVar);
        }
    }
}
