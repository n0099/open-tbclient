package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int BG;
    final /* synthetic */ FrsActivity aBu;
    private final /* synthetic */ com.baidu.tbadk.core.data.a aBy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity, com.baidu.tbadk.core.data.a aVar, int i) {
        this.aBu = frsActivity;
        this.aBy = aVar;
        this.BG = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aBy.jG()) {
            this.aBu.a(this.aBy, "area_download");
            this.aBu.b(this.aBy, "download");
            this.aBu.b(this.aBy, this.BG);
            aVar.dismiss();
        }
    }
}
