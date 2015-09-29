package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class w extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.k kVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            kVar = this.aUz.aUa;
            kVar.cl(true);
            return;
        }
        this.aUz.refresh();
    }
}
