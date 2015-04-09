package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int Rz;
    final /* synthetic */ FrsActivity aJQ;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aJQ = frsActivity;
        this.aJX = cVar;
        this.Rz = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aJX.pP()) {
            this.aJQ.a(this.aJX, "area_download");
            this.aJQ.b(this.aJX, "download");
            this.aJQ.b(this.aJX, this.Rz);
            aVar.dismiss();
        }
    }
}
