package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    private final /* synthetic */ int Sg;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aOu;
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ boolean bhu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        this.bhl = frsActivity;
        this.aOu = cVar;
        this.bhu = z;
        this.Sg = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        if (this.aOu.oG()) {
            this.bhl.a(this.aOu, this.bhu ? "area_download" : "btn_download");
            this.bhl.d(this.aOu, this.Sg);
            aVar.dismiss();
        }
    }
}
