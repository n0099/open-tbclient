package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int Rx;
    final /* synthetic */ FrsActivity aJG;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aJG = frsActivity;
        this.aJN = cVar;
        this.Rx = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aJN.pP()) {
            this.aJG.a(this.aJN, "area_download");
            this.aJG.b(this.aJN, "download");
            this.aJG.b(this.aJN, this.Rx);
            aVar.dismiss();
        }
    }
}
