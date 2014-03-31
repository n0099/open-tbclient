package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class bp implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public final void a(boolean z) {
        if (z) {
            this.a.q = null;
            this.a.b(1);
        }
    }
}
