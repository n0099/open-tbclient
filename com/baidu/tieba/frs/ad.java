package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ad extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.frs.j.aa aaVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            aaVar = this.bEL.bDZ;
            aaVar.dL(false);
        }
    }
}
