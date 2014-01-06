package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsActivity a;

    private ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(FrsActivity frsActivity, b bVar) {
        this(frsActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && oVar.u() == -124) {
            this.a.a(oVar);
        }
    }
}
