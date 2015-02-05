package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fs() {
        bp bpVar;
        bp bpVar2;
        bpVar = this.aDT.aCV;
        if (bpVar.Fz() != null) {
            bpVar2 = this.aDT.aCV;
            bpVar2.Fz().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fw(String str) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bpVar = this.aDT.aCV;
        if (bpVar.Fz() != null) {
            bpVar2 = this.aDT.aCV;
            bpVar2.Fz().setLocationViewVisibility(0);
            bpVar3 = this.aDT.aCV;
            bpVar3.Fz().B(2, str);
        }
    }
}
