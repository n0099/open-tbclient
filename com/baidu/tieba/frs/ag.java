package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.b {
    private final /* synthetic */ int WS;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aRN;
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ boolean blq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        this.blk = frsActivity;
        this.aRN = cVar;
        this.blq = z;
        this.WS = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aRN.rl()) {
            this.blk.a(this.aRN, this.blq ? "area_download" : "btn_download");
            this.blk.d(this.aRN, this.WS);
            aVar.dismiss();
        }
    }
}
