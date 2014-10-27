package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cb implements com.baidu.tieba.bubble.t {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bu buVar) {
        this.aDt = buVar;
    }

    @Override // com.baidu.tieba.bubble.t
    public void hz() {
        if (this.aDt.EO() != null) {
            this.aDt.EO().refresh();
        }
    }
}
