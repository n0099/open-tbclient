package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class y extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.c.l lVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            lVar = this.bgz.bfT;
            lVar.cB(false);
        }
    }
}
