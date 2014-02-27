package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class p implements com.baidu.tieba.view.by {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.view.by
    public final void a(boolean z) {
        bs bsVar;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        if (z) {
            bsVar = this.a.p;
            if (!bsVar.l()) {
                zVar = this.a.A;
                if (zVar != null) {
                    zVar2 = this.a.A;
                    if (zVar2.g().size() != 0) {
                        return;
                    }
                }
                this.a.n();
            }
        }
    }
}
