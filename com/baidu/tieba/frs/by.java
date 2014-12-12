package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class by implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jw() {
        if (this.aFg.Fh() != null) {
            this.aFg.Fh().refresh();
        }
    }
}
