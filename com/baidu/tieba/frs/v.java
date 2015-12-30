package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class v extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.l lVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            lVar = this.bed.bdC;
            lVar.cB(true);
            return;
        }
        this.bed.refresh();
    }
}
