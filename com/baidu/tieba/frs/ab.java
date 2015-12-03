package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements a.b {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ com.baidu.tbadk.core.data.b bal;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.bag = frsActivity;
        this.bal = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.bal.rC()) {
            this.bag.a(this.bal, "area_download");
            this.bag.b(this.bal, "download");
            this.bag.b(this.bal, this.val$position);
            aVar.dismiss();
        }
    }
}
