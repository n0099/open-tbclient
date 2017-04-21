package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.s<Object> {
    final /* synthetic */ FrsModelController cav;
    private final /* synthetic */ String cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsModelController frsModelController, String str) {
        this.cav = frsModelController;
        this.cax = str;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bhj = com.baidu.tieba.tbadkCore.c.bhj();
        str = this.cav.cas;
        bhj.bX(str, this.cax);
        return null;
    }
}
