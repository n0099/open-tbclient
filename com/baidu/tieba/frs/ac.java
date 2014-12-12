package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        bq bqVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        bq bqVar2;
        bq bqVar3;
        if (UtilHelper.isNetOk()) {
            bqVar = this.aCV.aBX;
            if (bqVar.Fh() != null) {
                bqVar2 = this.aCV.aBX;
                bqVar2.Fh().setLocationInfoViewState(1);
                bqVar3 = this.aCV.aBX;
                bqVar3.Fh().setLocationViewVisibility(0);
            }
            dVar = this.aCV.aAD;
            dVar.ahG();
        } else {
            iVar = this.aCV.aAO;
            iVar.EZ();
        }
        aVar.dismiss();
    }
}
