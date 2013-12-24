package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.view.az {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        bn bnVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        if (z) {
            bnVar = this.a.n;
            if (!bnVar.l()) {
                akVar = this.a.w;
                if (akVar != null) {
                    akVar2 = this.a.w;
                    if (akVar2.b().size() != 0) {
                        return;
                    }
                }
                this.a.A();
            }
        }
    }
}
