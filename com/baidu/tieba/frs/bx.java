package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class bx implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ bp aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bp bpVar) {
        this.aGg = bpVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jq() {
        if (this.aGg.Fz() != null) {
            this.aGg.Fz().refresh();
        }
    }
}
