package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bp bpVar;
        bp bpVar2;
        bpVar = this.aDT.aCV;
        if (bpVar.Fz() != null) {
            bpVar2 = this.aDT.aCV;
            bpVar2.Fz().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
