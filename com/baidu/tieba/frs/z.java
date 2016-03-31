package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class z extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.c.l lVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            lVar = this.blk.bkE;
            lVar.cN(false);
        }
    }
}
