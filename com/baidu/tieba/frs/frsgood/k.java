package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.b bal;
    final /* synthetic */ FrsGoodActivity bgy;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.bgy = frsGoodActivity;
        this.bal = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.bal.rC()) {
            this.bgy.a(this.bal, "area_download");
            this.bgy.b(this.bal, "download");
            this.bgy.b(this.bal, this.val$position);
            aVar.dismiss();
        }
    }
}
