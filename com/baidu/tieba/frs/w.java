package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class w extends com.baidu.adp.base.g {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.frs.c.k kVar;
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            kVar = this.this$0.aUN;
            kVar.cj(true);
            return;
        }
        this.this$0.refresh();
    }
}
