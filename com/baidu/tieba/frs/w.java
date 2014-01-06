package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.view.bf {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.view.bf
    public void a(boolean z) {
        bo boVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        if (z) {
            boVar = this.a.n;
            if (!boVar.m()) {
                akVar = this.a.w;
                if (akVar != null) {
                    akVar2 = this.a.w;
                    if (akVar2.b().size() != 0) {
                        return;
                    }
                }
                this.a.B();
            }
        }
    }
}
