package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        bu buVar;
        com.baidu.tieba.location.d dVar;
        bu buVar2;
        bu buVar3;
        if (UtilHelper.isNetOk()) {
            buVar = this.aBk.aAv;
            if (buVar.EO() != null) {
                buVar2 = this.aBk.aAv;
                buVar2.EO().setLocationInfoViewState(1);
                buVar3 = this.aBk.aAv;
                buVar3.EO().setLocationViewVisibility(0);
            }
            dVar = this.aBk.ays;
            dVar.Sw();
        } else {
            iVar = this.aBk.ayD;
            iVar.EG();
        }
        aVar.dismiss();
    }
}
