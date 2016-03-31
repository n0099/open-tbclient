package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    private final /* synthetic */ int WS;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aRN;
    private final /* synthetic */ boolean blq;
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        this.bsj = frsGoodActivity;
        this.aRN = cVar;
        this.blq = z;
        this.WS = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aRN.rl()) {
            this.bsj.a(this.aRN, this.blq ? "area_download" : "btn_download");
            this.bsj.d(this.aRN, this.WS);
            aVar.dismiss();
        }
    }
}
