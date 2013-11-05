package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.f1296a = frsActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        ba baVar;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        if (z) {
            baVar = this.f1296a.o;
            if (!baVar.g()) {
                akVar = this.f1296a.x;
                if (akVar != null) {
                    akVar2 = this.f1296a.x;
                    if (akVar2.b().size() != 0) {
                        return;
                    }
                }
                this.f1296a.C();
            }
        }
    }
}
