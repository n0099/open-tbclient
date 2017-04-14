package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.s<Object> {
    final /* synthetic */ FrsModelController bYe;
    private final /* synthetic */ String bYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsModelController frsModelController, String str) {
        this.bYe = frsModelController;
        this.bYg = str;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bgh = com.baidu.tieba.tbadkCore.c.bgh();
        str = this.bYe.bYb;
        bgh.bY(str, this.bYg);
        return null;
    }
}
