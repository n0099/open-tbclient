package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.location.j {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tieba.location.j
    public void EJ() {
        bu buVar;
        bu buVar2;
        buVar = this.aBu.aAF;
        if (buVar.EQ() != null) {
            buVar2 = this.aBu.aAF;
            buVar2.EQ().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.location.j
    public void eZ(String str) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        buVar = this.aBu.aAF;
        if (buVar.EQ() != null) {
            buVar2 = this.aBu.aAF;
            buVar2.EQ().setLocationViewVisibility(0);
            buVar3 = this.aBu.aAF;
            buVar3.EQ().j(2, str);
        }
    }
}
