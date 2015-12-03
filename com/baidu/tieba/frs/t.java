package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class t extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.l lVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            lVar = this.bag.aZG;
            lVar.cA(false);
        }
    }
}
