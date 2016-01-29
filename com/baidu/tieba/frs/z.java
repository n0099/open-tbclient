package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class z extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.c.l lVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            lVar = this.bgz.bfT;
            lVar.cB(true);
            return;
        }
        this.bgz.refresh();
    }
}
