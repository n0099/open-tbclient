package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int RY;
    final /* synthetic */ FrsActivity aLY;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aMf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aLY = frsActivity;
        this.aMf = cVar;
        this.RY = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aMf.qv()) {
            this.aLY.a(this.aMf, "area_download");
            this.aLY.b(this.aMf, "download");
            this.aLY.b(this.aMf, this.RY);
            aVar.dismiss();
        }
    }
}
