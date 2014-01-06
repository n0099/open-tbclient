package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsImageActivity a;

    private bl(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bl(FrsImageActivity frsImageActivity, as asVar) {
        this(frsImageActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && oVar.u() == -124) {
            this.a.a(oVar);
        }
    }
}
