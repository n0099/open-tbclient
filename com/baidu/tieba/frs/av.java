package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class av implements com.baidu.tieba.view.br {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.br
    public void a(boolean z) {
        if (z) {
            this.a.q = null;
            this.a.c(1);
        }
    }
}
