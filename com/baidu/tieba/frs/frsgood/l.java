package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    private final /* synthetic */ int YA;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aOX;
    private final /* synthetic */ boolean bgF;
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        this.bnm = frsGoodActivity;
        this.aOX = cVar;
        this.bgF = z;
        this.YA = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aOX.rN()) {
            this.bnm.a(this.aOX, this.bgF ? "area_download" : "btn_download");
            this.bnm.b(this.aOX, this.YA);
            aVar.dismiss();
        }
    }
}
