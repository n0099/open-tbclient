package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ae extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.frs.j.aa aaVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            aaVar = this.bEL.bDZ;
            aaVar.dL(true);
            return;
        }
        this.bEL.refresh();
    }
}
