package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.f1149a = frsActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        ba baVar;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        if (z) {
            baVar = this.f1149a.o;
            if (!baVar.f()) {
                acVar = this.f1149a.x;
                if (acVar != null) {
                    acVar2 = this.f1149a.x;
                    if (acVar2.b().size() != 0) {
                        return;
                    }
                }
                this.f1149a.D();
            }
        }
    }
}
