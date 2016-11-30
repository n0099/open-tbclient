package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.g {
    final /* synthetic */ d cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.cgf = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        if ((obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && this.cgf.bSj != null) {
            this.cgf.bSj.ex(false);
        }
    }
}
