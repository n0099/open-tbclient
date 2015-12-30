package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.data.b bej;
    private final /* synthetic */ boolean bek;
    final /* synthetic */ FrsGoodActivity bkp;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity, com.baidu.tbadk.core.data.b bVar, boolean z, int i) {
        this.bkp = frsGoodActivity;
        this.bej = bVar;
        this.bek = z;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.bej.rl()) {
            this.bkp.a(this.bej, this.bek ? "area_download" : "btn_download");
            this.bkp.a(this.bej, this.val$position);
            aVar.dismiss();
        }
    }
}
