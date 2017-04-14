package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.util.s<Object> {
    final /* synthetic */ FrsModelController bYe;
    private final /* synthetic */ String bYf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsModelController frsModelController, String str) {
        this.bYe = frsModelController;
        this.bYf = str;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bgh = com.baidu.tieba.tbadkCore.c.bgh();
        str = this.bYe.bYb;
        bgh.bX(str, this.bYf);
        return null;
    }
}
