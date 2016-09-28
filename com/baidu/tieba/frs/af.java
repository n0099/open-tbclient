package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class af extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.frs.i.aa aaVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            aaVar = this.bQi.bPv;
            aaVar.ei(true);
            return;
        }
        this.bQi.refresh();
    }
}
