package com.baidu.tieba.frs;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements a.b {
    private final /* synthetic */ int YA;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aOX;
    private final /* synthetic */ boolean bgF;
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        this.bgz = frsActivity;
        this.aOX = cVar;
        this.bgF = z;
        this.YA = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aOX.rN()) {
            this.bgz.a(this.aOX, this.bgF ? "area_download" : "btn_download");
            this.bgz.b(this.aOX, this.YA);
            aVar.dismiss();
        }
    }
}
