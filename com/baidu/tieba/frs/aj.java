package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsActivity a;

    private aj(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(FrsActivity frsActivity, aj ajVar) {
        this(frsActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (sVar.w() == -124) {
                FrsActivity.a(this.a, sVar);
            } else if (sVar.w() == -122) {
                FrsActivity.b(this.a, sVar);
            }
        }
    }
}
