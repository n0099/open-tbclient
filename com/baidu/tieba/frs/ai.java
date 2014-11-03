package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bu buVar;
        bu buVar2;
        buVar = this.aBu.aAF;
        if (buVar.EQ() != null) {
            buVar2 = this.aBu.aAF;
            buVar2.EQ().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
