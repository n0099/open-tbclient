package com.baidu.tieba.history;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ b aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aNV = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        com.baidu.tbadk.b.a aVar2;
        pbHistoryActivity = this.aNV.aNU;
        aVar2 = pbHistoryActivity.aNT;
        aVar2.xo();
        aVar.dismiss();
    }
}
