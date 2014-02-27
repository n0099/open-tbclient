package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class bp implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsImageActivity a;

    private bp(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(FrsImageActivity frsImageActivity, byte b) {
        this(frsImageActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == -124) {
            FrsImageActivity.a(this.a, sVar);
        }
    }
}
