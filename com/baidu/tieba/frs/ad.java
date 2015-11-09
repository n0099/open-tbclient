package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.b {
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ com.baidu.tbadk.core.data.b aUZ;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aUS = frsActivity;
        this.aUZ = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aUZ.ro()) {
            this.aUS.a(this.aUZ, "area_download");
            this.aUS.b(this.aUZ, "download");
            this.aUS.b(this.aUZ, this.val$position);
            aVar.dismiss();
        }
    }
}
