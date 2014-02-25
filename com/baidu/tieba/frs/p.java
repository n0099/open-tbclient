package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.view.by {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.view.by
    public void a(boolean z) {
        br brVar;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        if (z) {
            brVar = this.a.p;
            if (!brVar.m()) {
                zVar = this.a.A;
                if (zVar != null) {
                    zVar2 = this.a.A;
                    if (zVar2.c().size() != 0) {
                        return;
                    }
                }
                this.a.C();
            }
        }
    }
}
