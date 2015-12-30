package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.l lVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            lVar = this.bed.bdC;
            lVar.cB(false);
        }
    }
}
