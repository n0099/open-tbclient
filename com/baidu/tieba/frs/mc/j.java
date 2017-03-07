package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.util.s<Object> {
    final /* synthetic */ FrsModelController bZF;
    private final /* synthetic */ String bZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsModelController frsModelController, String str) {
        this.bZF = frsModelController;
        this.bZG = str;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bft = com.baidu.tieba.tbadkCore.c.bft();
        str = this.bZF.bZC;
        bft.bX(str, this.bZG);
        return null;
    }
}
