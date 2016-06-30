package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ad extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.i.aa aaVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            aaVar = this.bDB.bCS;
            aaVar.dL(false);
        }
    }
}
