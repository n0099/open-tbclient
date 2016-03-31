package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aa extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.c.l lVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            lVar = this.blk.bkE;
            lVar.cN(true);
            return;
        }
        this.blk.refresh();
    }
}
