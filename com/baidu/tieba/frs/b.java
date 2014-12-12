package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fa() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.aCV.aBX;
        if (bqVar.Fh() != null) {
            bqVar2 = this.aCV.aBX;
            bqVar2.Fh().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fu(String str) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bqVar = this.aCV.aBX;
        if (bqVar.Fh() != null) {
            bqVar2 = this.aCV.aBX;
            bqVar2.Fh().setLocationViewVisibility(0);
            bqVar3 = this.aCV.aBX;
            bqVar3.Fh().B(2, str);
        }
    }
}
