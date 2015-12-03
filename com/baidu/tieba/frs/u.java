package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.l lVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            lVar = this.bag.aZG;
            lVar.cA(true);
            return;
        }
        this.bag.refresh();
    }
}
