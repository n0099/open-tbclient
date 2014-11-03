package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cb implements com.baidu.tieba.bubble.t {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bu buVar) {
        this.aDD = buVar;
    }

    @Override // com.baidu.tieba.bubble.t
    public void hz() {
        if (this.aDD.EQ() != null) {
            this.aDD.EQ().refresh();
        }
    }
}
