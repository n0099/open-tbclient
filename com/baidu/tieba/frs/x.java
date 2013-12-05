package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.view.ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.f1424a = frsActivity;
    }

    @Override // com.baidu.tieba.view.ba
    public void a(boolean z) {
        bn bnVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        if (z) {
            bnVar = this.f1424a.n;
            if (!bnVar.l()) {
                akVar = this.f1424a.w;
                if (akVar != null) {
                    akVar2 = this.f1424a.w;
                    if (akVar2.b().size() != 0) {
                        return;
                    }
                }
                this.f1424a.A();
            }
        }
    }
}
