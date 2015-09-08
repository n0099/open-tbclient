package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.c aVG;
    final /* synthetic */ FrsActivity aVz;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aVz = frsActivity;
        this.aVG = cVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aVG.rv()) {
            this.aVz.a(this.aVG, "area_download");
            this.aVz.b(this.aVG, "download");
            this.aVz.b(this.aVG, this.val$position);
            aVar.dismiss();
        }
    }
}
