package com.baidu.tieba.frs.d;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.g {
    final /* synthetic */ d bLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bLO = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.bLO.byt != null) {
                this.bLO.byt.eh(true);
                return;
            }
            return;
        }
        this.bLO.bFI.refresh();
    }
}
