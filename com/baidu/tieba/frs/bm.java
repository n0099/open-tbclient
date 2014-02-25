package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class bm implements com.baidu.tieba.view.by {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.by
    public void a(boolean z) {
        if (z) {
            this.a.q = null;
            this.a.c(1);
        }
    }
}
