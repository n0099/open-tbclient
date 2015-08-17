package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.c aVr;
    final /* synthetic */ FrsGoodActivity aZp;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aZp = frsGoodActivity;
        this.aVr = cVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aVr.rw()) {
            this.aZp.a(this.aVr, "area_download");
            this.aZp.b(this.aVr, "download");
            this.aZp.b(this.aVr, this.val$position);
            aVar.dismiss();
        }
    }
}
