package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cp implements com.baidu.tbadk.core.view.r {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        if (z) {
            this.a.t = null;
            this.a.c(1);
        }
    }
}
