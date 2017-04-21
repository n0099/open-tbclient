package com.baidu.tieba.frs.mc;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.f {
    final /* synthetic */ d cab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.cab = dVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        if ((obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && this.cab.bPh != null) {
            this.cab.bPh.ea(false);
        }
    }
}
