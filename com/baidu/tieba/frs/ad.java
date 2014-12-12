package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.aCV.aBX;
        if (bqVar.Fh() != null) {
            bqVar2 = this.aCV.aBX;
            bqVar2.Fh().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
