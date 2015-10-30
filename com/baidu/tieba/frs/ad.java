package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.b {
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ com.baidu.tbadk.core.data.b aUR;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aUK = frsActivity;
        this.aUR = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aUR.rn()) {
            this.aUK.a(this.aUR, "area_download");
            this.aUK.b(this.aUR, "download");
            this.aUK.b(this.aUR, this.val$position);
            aVar.dismiss();
        }
    }
}
