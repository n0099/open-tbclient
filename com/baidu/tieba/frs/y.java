package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class y implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public void a(boolean z) {
        ct ctVar;
        g gVar;
        g gVar2;
        if (z) {
            ctVar = this.a.v;
            if (!ctVar.t()) {
                gVar = this.a.H;
                if (gVar != null) {
                    gVar2 = this.a.H;
                    if (gVar2.h().size() != 0) {
                        return;
                    }
                }
                this.a.E();
            }
        }
    }
}
