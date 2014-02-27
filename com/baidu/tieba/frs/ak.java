package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class ak implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsActivity a;

    private ak(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(FrsActivity frsActivity, byte b) {
        this(frsActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (sVar.w() == -124) {
                FrsActivity.a(this.a, sVar);
            } else if (sVar.w() == -122) {
                FrsActivity.b(this.a, sVar);
            }
        }
    }
}
