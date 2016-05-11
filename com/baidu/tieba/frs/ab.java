package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ab extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.h.y yVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            yVar = this.bhl.bgF;
            yVar.dn(true);
            return;
        }
        this.bhl.refresh();
    }
}
