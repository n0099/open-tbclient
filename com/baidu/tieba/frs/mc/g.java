package com.baidu.tieba.frs.mc;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.f {
    final /* synthetic */ d bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bSd = dVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.bSd.bFS != null) {
                this.bSd.bFS.dO(true);
                return;
            }
            return;
        }
        this.bSd.bLZ.refresh();
    }
}
