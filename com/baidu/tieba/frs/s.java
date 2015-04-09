package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class s extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        com.baidu.tieba.frs.c.k kVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            kVar = this.aJQ.aJu;
            kVar.bX(false);
        }
    }
}
