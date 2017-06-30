package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.w<Object> {
    final /* synthetic */ FrsModelController cmL;
    private final /* synthetic */ String cmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsModelController frsModelController, String str) {
        this.cmL = frsModelController;
        this.cmN = str;
    }

    @Override // com.baidu.tbadk.util.w
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bkt = com.baidu.tieba.tbadkCore.c.bkt();
        str = this.cmL.cmI;
        bkt.cb(str, this.cmN);
        return null;
    }
}
