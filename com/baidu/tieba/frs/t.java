package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class t extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        com.baidu.tieba.frs.c.k kVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            kVar = this.aJG.aJm;
            kVar.bZ(true);
            return;
        }
        this.aJG.refresh();
    }
}
