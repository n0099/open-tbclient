package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.b aUG;
    final /* synthetic */ FrsActivity aUz;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aUz = frsActivity;
        this.aUG = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aUG.rq()) {
            this.aUz.a(this.aUG, "area_download");
            this.aUz.b(this.aUG, "download");
            this.aUz.b(this.aUG, this.val$position);
            aVar.dismiss();
        }
    }
}
