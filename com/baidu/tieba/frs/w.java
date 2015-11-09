package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class w extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.l lVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            lVar = this.aUS.aUt;
            lVar.cn(true);
            return;
        }
        this.aUS.refresh();
    }
}
