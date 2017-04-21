package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.util.s<Object> {
    final /* synthetic */ FrsModelController cav;
    private final /* synthetic */ String caw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsModelController frsModelController, String str) {
        this.cav = frsModelController;
        this.caw = str;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bhj = com.baidu.tieba.tbadkCore.c.bhj();
        str = this.cav.cas;
        bhj.bW(str, this.caw);
        return null;
    }
}
