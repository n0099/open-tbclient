package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class bn implements com.baidu.tieba.view.by {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.view.by
    public final void a(boolean z) {
        if (z) {
            this.a.q = null;
            this.a.b(1);
        }
    }
}
