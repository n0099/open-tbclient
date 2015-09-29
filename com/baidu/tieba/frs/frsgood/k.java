package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.b aUG;
    final /* synthetic */ FrsGoodActivity aZB;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aZB = frsGoodActivity;
        this.aUG = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aUG.rq()) {
            this.aZB.a(this.aUG, "area_download");
            this.aZB.b(this.aUG, "download");
            this.aZB.b(this.aUG, this.val$position);
            aVar.dismiss();
        }
    }
}
