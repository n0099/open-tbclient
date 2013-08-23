package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.view.ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.f1101a = frsActivity;
    }

    @Override // com.baidu.tieba.view.ax
    public void a(boolean z) {
        bb bbVar;
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        if (z) {
            bbVar = this.f1101a.l;
            if (!bbVar.h()) {
                aaVar = this.f1101a.v;
                if (aaVar != null) {
                    aaVar2 = this.f1101a.v;
                    if (aaVar2.b().size() != 0) {
                        return;
                    }
                }
                this.f1101a.A();
            }
        }
    }
}
