package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.b aUR;
    final /* synthetic */ FrsGoodActivity aZM;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.b bVar, int i) {
        this.aZM = frsGoodActivity;
        this.aUR = bVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aUR.rn()) {
            this.aZM.a(this.aUR, "area_download");
            this.aZM.b(this.aUR, "download");
            this.aZM.b(this.aUR, this.val$position);
            aVar.dismiss();
        }
    }
}
