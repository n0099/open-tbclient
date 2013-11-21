package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.f1373a = frsActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        bn bnVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        if (z) {
            bnVar = this.f1373a.n;
            if (!bnVar.k()) {
                akVar = this.f1373a.w;
                if (akVar != null) {
                    akVar2 = this.f1373a.w;
                    if (akVar2.b().size() != 0) {
                        return;
                    }
                }
                this.f1373a.A();
            }
        }
    }
}
