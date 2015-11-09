package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class v extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.b.l lVar;
        if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
            lVar = this.aUS.aUt;
            lVar.cn(false);
        }
    }
}
