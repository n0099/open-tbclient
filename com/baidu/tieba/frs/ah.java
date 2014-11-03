package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        bu buVar;
        com.baidu.tieba.location.d dVar;
        bu buVar2;
        bu buVar3;
        if (UtilHelper.isNetOk()) {
            buVar = this.aBu.aAF;
            if (buVar.EQ() != null) {
                buVar2 = this.aBu.aAF;
                buVar2.EQ().setLocationInfoViewState(1);
                buVar3 = this.aBu.aAF;
                buVar3.EQ().setLocationViewVisibility(0);
            }
            dVar = this.aBu.ayB;
            dVar.Sz();
        } else {
            iVar = this.aBu.ayM;
            iVar.EI();
        }
        aVar.dismiss();
    }
}
