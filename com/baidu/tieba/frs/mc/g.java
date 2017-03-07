package com.baidu.tieba.frs.mc;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.f {
    final /* synthetic */ d bZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bZl = dVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.bZl.bNa != null) {
                this.bZl.bNa.dO(true);
                return;
            }
            return;
        }
        this.bZl.bTf.refresh();
    }
}
