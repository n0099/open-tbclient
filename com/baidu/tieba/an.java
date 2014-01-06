package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MainTabActivity a;

    private an(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(MainTabActivity mainTabActivity, am amVar) {
        this(mainTabActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && oVar.u() == -124) {
            this.a.a(oVar);
        }
    }
}
