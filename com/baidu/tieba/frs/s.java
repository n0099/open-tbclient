package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.view.br {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.view.br
    public void a(boolean z) {
        bk bkVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        if (z) {
            bkVar = this.a.n;
            if (!bkVar.m()) {
                akVar = this.a.w;
                if (akVar != null) {
                    akVar2 = this.a.w;
                    if (akVar2.c().size() != 0) {
                        return;
                    }
                }
                this.a.z();
            }
        }
    }
}
