package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.util.v<Object> {
    final /* synthetic */ FrsModelController bYn;
    private final /* synthetic */ String bYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsModelController frsModelController, String str) {
        this.bYn = frsModelController;
        this.bYo = str;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c beL = com.baidu.tieba.tbadkCore.c.beL();
        str = this.bYn.bYk;
        beL.bW(str, this.bYo);
        return null;
    }
}
