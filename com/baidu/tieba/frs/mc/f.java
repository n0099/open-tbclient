package com.baidu.tieba.frs.mc;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.f {
    final /* synthetic */ d bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bSd = dVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        if ((obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && this.bSd.bFS != null) {
            this.bSd.bFS.dO(false);
        }
    }
}
