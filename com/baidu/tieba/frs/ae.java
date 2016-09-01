package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ae extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        com.baidu.tieba.frs.i.aa aaVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            aaVar = this.bQp.bPD;
            aaVar.eh(false);
        }
    }
}
