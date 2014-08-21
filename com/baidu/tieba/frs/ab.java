package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.core.view.r {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        cv cvVar;
        g gVar;
        g gVar2;
        if (z) {
            cvVar = this.a.B;
            if (!cvVar.u()) {
                gVar = this.a.N;
                if (gVar != null) {
                    gVar2 = this.a.N;
                    if (gVar2.j().size() != 0) {
                        return;
                    }
                }
                this.a.E();
            }
        }
    }
}
