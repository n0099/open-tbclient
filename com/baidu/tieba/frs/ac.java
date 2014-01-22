package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsActivity a;

    private ac(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(FrsActivity frsActivity, b bVar) {
        this(frsActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && qVar.w() == -124) {
            this.a.a(qVar);
        }
    }
}
