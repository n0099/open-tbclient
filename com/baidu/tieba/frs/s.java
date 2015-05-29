package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class s extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        com.baidu.tieba.frs.c.k kVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            kVar = this.aLX.aLB;
            kVar.cg(false);
        }
    }
}
