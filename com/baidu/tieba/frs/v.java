package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class v extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.k kVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            kVar = this.aUK.aUl;
            kVar.cl(false);
        }
    }
}
