package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsImageActivity a;

    private bh(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bh(FrsImageActivity frsImageActivity, ao aoVar) {
        this(frsImageActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && qVar.w() == -124) {
            this.a.a(qVar);
        }
    }
}
