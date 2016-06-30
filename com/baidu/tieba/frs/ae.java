package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ae extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.i.aa aaVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            aaVar = this.bDB.bCS;
            aaVar.dL(true);
            return;
        }
        this.bDB.refresh();
    }
}
