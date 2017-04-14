package com.baidu.tieba.frs.mc;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.f {
    final /* synthetic */ d bXK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bXK = dVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.bXK.bMQ != null) {
                this.bXK.bMQ.dQ(true);
                return;
            }
            return;
        }
        this.bXK.bST.refresh();
    }
}
