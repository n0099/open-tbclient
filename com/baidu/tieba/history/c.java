package com.baidu.tieba.history;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ b aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aPe = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        com.baidu.tbadk.b.a aVar2;
        pbHistoryActivity = this.aPe.aPd;
        aVar2 = pbHistoryActivity.aPc;
        aVar2.xE();
        aVar.dismiss();
    }
}
