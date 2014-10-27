package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int BF;
    final /* synthetic */ FrsActivity aBk;
    private final /* synthetic */ com.baidu.tbadk.core.data.a aBo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity, com.baidu.tbadk.core.data.a aVar, int i) {
        this.aBk = frsActivity;
        this.aBo = aVar;
        this.BF = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (this.aBo.jG()) {
            this.aBk.a(this.aBo, "area_download");
            this.aBk.b(this.aBo, "download");
            this.aBk.b(this.aBo, this.BF);
            aVar.dismiss();
        }
    }
}
