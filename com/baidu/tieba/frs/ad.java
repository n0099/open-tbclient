package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bp bpVar;
        bp bpVar2;
        bpVar = this.aDW.aCY;
        if (bpVar.FF() != null) {
            bpVar2 = this.aDW.aCY;
            bpVar2.FF().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
