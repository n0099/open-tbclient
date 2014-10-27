package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.location.j {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tieba.location.j
    public void EH() {
        bu buVar;
        bu buVar2;
        buVar = this.aBk.aAv;
        if (buVar.EO() != null) {
            buVar2 = this.aBk.aAv;
            buVar2.EO().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.location.j
    public void eZ(String str) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.aBk.aAv;
        if (buVar.EO() != null) {
            buVar2 = this.aBk.aAv;
            buVar2.EO().setLocationViewVisibility(0);
            buVar3 = this.aBk.aAv;
            buVar3.EO().j(2, str);
        }
    }
}
