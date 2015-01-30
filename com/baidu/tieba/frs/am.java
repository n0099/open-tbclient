package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int FV;
    final /* synthetic */ FrsActivity aDW;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aDW = frsActivity;
        this.aEc = cVar;
        this.FV = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aEc.mv()) {
            this.aDW.a(this.aEc, "area_download");
            this.aDW.b(this.aEc, "download");
            this.aDW.b(this.aEc, this.FV);
            aVar.dismiss();
        }
    }
}
