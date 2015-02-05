package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int FS;
    final /* synthetic */ FrsActivity aDT;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aDT = frsActivity;
        this.aDZ = cVar;
        this.FS = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aDZ.mo()) {
            this.aDT.a(this.aDZ, "area_download");
            this.aDT.b(this.aDZ, "download");
            this.aDT.b(this.aDZ, this.FS);
            aVar.dismiss();
        }
    }
}
