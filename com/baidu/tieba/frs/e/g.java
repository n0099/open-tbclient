package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.g {
    final /* synthetic */ d cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.cgf = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.cgf.bSj != null) {
                this.cgf.bSj.ex(true);
                return;
            }
            return;
        }
        this.cgf.bZY.refresh();
    }
}
