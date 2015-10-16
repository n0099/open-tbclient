package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class w extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.k kVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            kVar = this.aUK.aUl;
            kVar.cl(true);
            return;
        }
        this.aUK.refresh();
    }
}
