package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int RY;
    final /* synthetic */ FrsActivity aLX;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aLX = frsActivity;
        this.aMe = cVar;
        this.RY = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aMe.qv()) {
            this.aLX.a(this.aMe, "area_download");
            this.aLX.b(this.aMe, "download");
            this.aLX.b(this.aMe, this.RY);
            aVar.dismiss();
        }
    }
}
