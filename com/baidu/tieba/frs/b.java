package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fy() {
        bp bpVar;
        bp bpVar2;
        bpVar = this.aDW.aCY;
        if (bpVar.FF() != null) {
            bpVar2 = this.aDW.aCY;
            bpVar2.FF().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fz(String str) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bpVar = this.aDW.aCY;
        if (bpVar.FF() != null) {
            bpVar2 = this.aDW.aCY;
            bpVar2.FF().setLocationViewVisibility(0);
            bpVar3 = this.aDW.aCY;
            bpVar3.FF().B(2, str);
        }
    }
}
