package com.baidu.tieba;
/* loaded from: classes.dex */
class ag implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MainTabActivity a;

    private ag(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MainTabActivity mainTabActivity, ag agVar) {
        this(mainTabActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == -124) {
            MainTabActivity.a(this.a, sVar);
        }
    }
}
