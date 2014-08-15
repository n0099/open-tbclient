package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.core.view.q {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.q
    public void a(boolean z) {
        cu cuVar;
        g gVar;
        g gVar2;
        if (z) {
            cuVar = this.a.z;
            if (!cuVar.u()) {
                gVar = this.a.L;
                if (gVar != null) {
                    gVar2 = this.a.L;
                    if (gVar2.j().size() != 0) {
                        return;
                    }
                }
                this.a.D();
            }
        }
    }
}
