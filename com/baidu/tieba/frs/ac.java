package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        bp bpVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        bp bpVar2;
        bp bpVar3;
        if (UtilHelper.isNetOk()) {
            bpVar = this.aDW.aCY;
            if (bpVar.FF() != null) {
                bpVar2 = this.aDW.aCY;
                bpVar2.FF().setLocationInfoViewState(1);
                bpVar3 = this.aDW.aCY;
                bpVar3.FF().setLocationViewVisibility(0);
            }
            dVar = this.aDW.aBF;
            dVar.aik();
        } else {
            iVar = this.aDW.aBQ;
            iVar.Fx();
        }
        aVar.dismiss();
    }
}
