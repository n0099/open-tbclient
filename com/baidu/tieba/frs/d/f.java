package com.baidu.tieba.frs.d;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.g {
    final /* synthetic */ d bLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bLO = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        if ((obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && this.bLO.byt != null) {
            this.bLO.byt.eh(false);
        }
    }
}
