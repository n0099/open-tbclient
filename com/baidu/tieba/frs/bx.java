package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class bx implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jx() {
        if (this.aGj.FF() != null) {
            this.aGj.FF().refresh();
        }
    }
}
