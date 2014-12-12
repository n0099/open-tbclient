package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ FrsActivity aCV;
    private final /* synthetic */ com.baidu.tbadk.core.data.c aDb;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tbadk.core.data.c cVar, int i) {
        this.aCV = frsActivity;
        this.aDb = cVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aDb.mv()) {
            this.aCV.a(this.aDb, "area_download");
            this.aCV.b(this.aDb, "download");
            this.aCV.b(this.aDb, this.val$position);
            aVar.dismiss();
        }
    }
}
