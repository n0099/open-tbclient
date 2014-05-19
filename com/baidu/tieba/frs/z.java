package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public void a(boolean z) {
        cs csVar;
        g gVar;
        g gVar2;
        if (z) {
            csVar = this.a.w;
            if (!csVar.u()) {
                gVar = this.a.I;
                if (gVar != null) {
                    gVar2 = this.a.I;
                    if (gVar2.h().size() != 0) {
                        return;
                    }
                }
                this.a.D();
            }
        }
    }
}
