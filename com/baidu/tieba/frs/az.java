package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.view.bf {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.bf
    public void a(boolean z) {
        if (z) {
            this.a.q = null;
            this.a.c(1);
        }
    }
}
