package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class z implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public final void a(boolean z) {
        cm cmVar;
        g gVar;
        g gVar2;
        if (z) {
            cmVar = this.a.r;
            if (!cmVar.t()) {
                gVar = this.a.D;
                if (gVar != null) {
                    gVar2 = this.a.D;
                    if (gVar2.g().size() != 0) {
                        return;
                    }
                }
                this.a.n();
            }
        }
    }
}
