package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.v<Object> {
    private final /* synthetic */ String ceA;
    final /* synthetic */ FrsModelController cey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsModelController frsModelController, String str) {
        this.cey = frsModelController;
        this.ceA = str;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bgf = com.baidu.tieba.tbadkCore.c.bgf();
        str = this.cey.cev;
        bgf.bX(str, this.ceA);
        return null;
    }
}
