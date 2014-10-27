package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bu buVar;
        bu buVar2;
        buVar = this.aBk.aAv;
        if (buVar.EO() != null) {
            buVar2 = this.aBk.aAv;
            buVar2.EO().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
