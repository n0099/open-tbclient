package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.c aVG;
    final /* synthetic */ FrsGoodActivity aZI;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aZI = frsGoodActivity;
        this.aVG = cVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aVG.rv()) {
            this.aZI.a(this.aVG, "area_download");
            this.aZI.b(this.aVG, "download");
            this.aZI.b(this.aVG, this.val$position);
            aVar.dismiss();
        }
    }
}
