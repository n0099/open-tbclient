package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aa extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.h.y yVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            yVar = this.bhl.bgF;
            yVar.dn(false);
        }
    }
}
