package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MainTabActivity a;

    private aq(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(MainTabActivity mainTabActivity, ap apVar) {
        this(mainTabActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && qVar.w() == -124) {
            this.a.a(qVar);
        }
    }
}
