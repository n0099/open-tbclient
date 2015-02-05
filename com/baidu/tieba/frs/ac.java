package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        bp bpVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        bp bpVar2;
        bp bpVar3;
        if (UtilHelper.isNetOk()) {
            bpVar = this.aDT.aCV;
            if (bpVar.Fz() != null) {
                bpVar2 = this.aDT.aCV;
                bpVar2.Fz().setLocationInfoViewState(1);
                bpVar3 = this.aDT.aCV;
                bpVar3.Fz().setLocationViewVisibility(0);
            }
            dVar = this.aDT.aBC;
            dVar.aif();
        } else {
            iVar = this.aDT.aBN;
            iVar.Fr();
        }
        aVar.dismiss();
    }
}
