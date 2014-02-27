package com.baidu.tieba;
/* loaded from: classes.dex */
final class ag implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MainTabActivity a;

    private ag(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MainTabActivity mainTabActivity, byte b) {
        this(mainTabActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == -124) {
            MainTabActivity.a(this.a, sVar);
        }
    }
}
