package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.b aUZ;
    final /* synthetic */ FrsGoodActivity baf;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.baf = frsGoodActivity;
        this.aUZ = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aUZ.ro()) {
            this.baf.a(this.aUZ, "area_download");
            this.baf.b(this.aUZ, "download");
            this.baf.b(this.aUZ, this.val$position);
            aVar.dismiss();
        }
    }
}
